package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GitProviderTest {
    private GitProvider gitProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        gitProvider = new GitProvider(new RandomService());
    }

    @Test
    void branch_ShouldReturnValidBranch() {
        String branch = gitProvider.branch();
        assertNotNull(branch);
        assertFalse(branch.isEmpty());
        assertTrue(branch.matches("^[a-z0-9-]+$"));
    }

    @Test
    void commitMessage_ShouldReturnValidMessage() {
        String message = gitProvider.commitMessage();
        assertNotNull(message);
        assertFalse(message.isEmpty());
    }

    @Test
    void commitSha_ShouldReturnValidSha() {
        String sha = gitProvider.commitSha();
        assertNotNull(sha);
        assertFalse(sha.isEmpty());
        assertTrue(sha.matches("^[a-f0-9]{40}$"));
    }

    @Test
    void commitDate_ShouldReturnValidDate() {
        String date = gitProvider.commitDate();
        assertNotNull(date);
        assertFalse(date.isEmpty());
        assertTrue(date.matches("^[A-Za-z]{3} [A-Za-z]{3} \\d{1,2} \\d{2}:\\d{2}:\\d{2} \\d{4} [+-]\\d{4}$"));
    }

    @Test
    void commitEntry_ShouldReturnValidEntry() {
        String entry = gitProvider.commitEntry();
        assertNotNull(entry);
        assertFalse(entry.isEmpty());
        assertTrue(entry.matches("^commit [a-f0-9]{40} \\| Author: .+ <.+@.+> \\| Date: [A-Za-z]{3} [A-Za-z]{3} \\d{1,2} \\d{2}:\\d{2}:\\d{2} \\d{4} [+-]\\d{4} \\| .+$"));
    }
} 