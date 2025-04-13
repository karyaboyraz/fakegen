package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameProviderTest {
    private NameProvider nameProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        nameProvider = new NameProvider(new RandomService());
    }

    @Test
    void firstName_ShouldReturnValidName() {
        String firstName = nameProvider.firstName();
        assertNotNull(firstName);
        assertFalse(firstName.isEmpty());
    }

    @Test
    void lastName_ShouldReturnValidName() {
        String lastName = nameProvider.lastName();
        assertNotNull(lastName);
        assertFalse(lastName.isEmpty());
    }

    @Test
    void fullName_ShouldReturnValidFormat() {
        String fullName = nameProvider.fullName();
        assertNotNull(fullName);
        assertFalse(fullName.isEmpty());
        assertTrue(fullName.contains(" "));
    }

    @Test
    void prefix_ShouldReturnValidPrefix() {
        String prefix = nameProvider.prefix();
        assertNotNull(prefix);
        assertFalse(prefix.isEmpty());
    }

    @Test
    void suffix_ShouldReturnValidSuffix() {
        String suffix = nameProvider.suffix();
        assertNotNull(suffix);
        assertFalse(suffix.isEmpty());
    }

    @Test
    void title_ShouldReturnValidTitle() {
        String title = nameProvider.title();
        assertNotNull(title);
        assertFalse(title.isEmpty());
    }

    @Test
    void username_ShouldReturnValidFormat() {
        String username = nameProvider.username();
        assertNotNull(username);
        assertFalse(username.isEmpty());
        assertTrue(username.matches("[a-zA-Z0-9._-]+"));
    }

    @Test
    void jobTitle_ShouldReturnValidTitle() {
        String jobTitle = nameProvider.jobTitle();
        assertNotNull(jobTitle);
        assertFalse(jobTitle.isEmpty());
    }
} 