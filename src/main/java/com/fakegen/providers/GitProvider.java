package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GitProvider {
    private final RandomService random;

    public GitProvider(RandomService random) {
        this.random = random;
    }

    public String branch() {
        return random.randomElement(DataLoader.getListData("git", "branches"));
    }

    public String commitSha() {
        return random.randomElement(DataLoader.getListData("git", "commit_shas"));
    }

    public String commitMessage() {
        return random.randomElement(DataLoader.getListData("git", "commit_messages"));
    }

    public String commitDate() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss yyyy Z"));
    }

    public String commitEntry() {
        return String.format("commit %s%nAuthor: %s <%s>%nDate: %s%n%n    %s",
            commitSha(),
            random.randomElement(DataLoader.getListData("git", "authors")),
            random.randomElement(DataLoader.getListData("git", "emails")),
            commitDate(),
            commitMessage()
        );
    }
} 