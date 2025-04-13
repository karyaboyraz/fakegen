package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
import java.util.List;

public class GitProvider {
    private final RandomService random;
    private List<String> gitBranches;
    private List<String> commitShas;
    private List<String> commitMessages;
    private List<String> gitAuthors;
    private List<String> gitEmails;

    public GitProvider(RandomService random) {
        this.random = random;
    }

    public String branch() {
        StringBuilder result = new StringBuilder();
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789-";
        
        // Branch adı en az 3 karakter olmalı
        int length = random.nextInt(3, 20);
        
        for (int i = 0; i < length; i++) {
            result.append(chars.charAt(random.nextInt(0, chars.length() - 1)));
        }
        
        return result.toString();
    }

    public String commitSha() {
        StringBuilder sha = new StringBuilder();
        String hexChars = "0123456789abcdef";
        
        for (int i = 0; i < 40; i++) {
            sha.append(hexChars.charAt(random.nextInt(0, hexChars.length() - 1)));
        }
        
        return sha.toString();
    }

    public String commitMessage() {
        commitMessages = LazyLoader.load("gitCommitMessages", () -> DataLoader.getListData("git", "commit_messages"));
        return random.randomElement(commitMessages);
    }

    public String commitDate() {
        ZonedDateTime now = ZonedDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss yyyy Z"));
    }

    public String commitEntry() {
        String sha = commitSha();
        gitAuthors = LazyLoader.load("gitAuthors", () -> DataLoader.getListData("git", "git_authors"));
        String author = random.randomElement(gitAuthors);
        gitEmails = LazyLoader.load("gitEmails", () -> DataLoader.getListData("git", "git_emails"));
        String email = random.randomElement(gitEmails);
        String date = commitDate();
        String message = commitMessage();

        return String.format("commit %s | Author: %s <%s> | Date: %s | %s",
            sha,
            author,
            email,
            date,
            message
        );
    }

    public static void main(String[] args) {
        GitProvider gitProvider = new GitProvider(new RandomService());
        System.out.println("Branch: " + gitProvider.branch());
        System.out.println("Commit SHA: " + gitProvider.commitSha());
        System.out.println("Commit Message: " + gitProvider.commitMessage());
        System.out.println("Commit Date: " + gitProvider.commitDate());
        System.out.println("Commit Entry: " + gitProvider.commitEntry());
    }
}