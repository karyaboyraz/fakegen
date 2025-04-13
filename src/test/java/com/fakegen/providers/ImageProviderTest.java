package com.fakegen.providers;

import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageProviderTest {
    private ImageProvider imageProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        imageProvider = new ImageProvider();
    }

    @Test
    void imageUrl_ShouldReturnValidUrl() {
        String url = imageProvider.imageUrl(800, 600);
        assertNotNull(url);
        assertFalse(url.isEmpty());
        assertTrue(url.matches("^https://picsum\\.photos/800/600$"));
    }

    @Test
    void imageUrlWithCategory_ShouldReturnValidUrl() {
        String url = imageProvider.imageUrl(800, 600, "nature");
        assertNotNull(url);
        assertFalse(url.isEmpty());
        assertTrue(url.matches("^https://picsum\\.photos/800/600\\?category=nature$"));
    }

    @Test
    void imageUrlWithCategoryAndSearch_ShouldReturnValidUrl() {
        String url = imageProvider.imageUrl(800, 600, "nature", "mountain");
        assertNotNull(url);
        assertFalse(url.isEmpty());
        assertTrue(url.matches("^https://picsum\\.photos/800/600\\?category=nature&search=mountain$"));
    }

    @Test
    void imageUrlWithCategorySearchAndSeed_ShouldReturnValidUrl() {
        String url = imageProvider.imageUrl(800, 600, "nature", "mountain", "sunset");
        assertNotNull(url);
        assertFalse(url.isEmpty());
        assertTrue(url.matches("^https://picsum\\.photos/seed/sunset/800/600\\?category=nature&search=mountain$"));
    }
} 