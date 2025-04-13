package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;

public class GitProvider {
    private final RandomService random;

    public GitProvider(RandomService random) {
        this.random = random;
    }

    public String branch() {
        return random.randomElement(DataLoader.getListData("git", "git_branches"));
    }

    public String commitSha() {
        return random.randomElement(DataLoader.getListData("git", "commit_shas"));
    }

    public String commitMessage() {
        return random.randomElement(DataLoader.getListData("git", "commit_messages"));
    }

    public String commitDate() {
        ZonedDateTime now = ZonedDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss yyyy Z"));
    }

    public String commitEntry() {
        String sha = commitSha();
        String author = random.randomElement(DataLoader.getListData("git", "git_authors"));
        String email = random.randomElement(DataLoader.getListData("git", "git_emails"));
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