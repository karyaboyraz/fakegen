package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class ColorProviderTest {
    private ColorProvider colorProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        colorProvider = new ColorProvider(new RandomService());
    }

    @RepeatedTest(20)
    void name_ShouldReturnValidName() {
        String name = colorProvider.name();
        assertNotNull(name);
        assertFalse(name.isEmpty());
    }

    @RepeatedTest(20)
    void hex_ShouldReturnValidHex() {
        String hex = colorProvider.hex();
        assertNotNull(hex);
        assertFalse(hex.isEmpty());
        assertTrue(hex.matches("^#[0-9a-fA-F]{6}$"));
    }

    @RepeatedTest(20)
    void rgb_ShouldReturnValidRgb() {
        String rgb = colorProvider.rgb();
        assertNotNull(rgb);
        assertFalse(rgb.isEmpty());
        assertTrue(rgb.matches("^rgb\\(\\d{1,3}, \\d{1,3}, \\d{1,3}\\)$"));
    }

    @RepeatedTest(20)
    void rgba_ShouldReturnValidRgba() {
        String rgba = colorProvider.rgba();
        assertNotNull(rgba);
        assertFalse(rgba.isEmpty());
        assertTrue(rgba.matches("^rgba\\(\\d{1,3}, \\d{1,3}, \\d{1,3}, 0\\.\\d+\\)$"));
    }

    @RepeatedTest(20)
    void hsl_ShouldReturnValidHsl() {
        String hsl = colorProvider.hsl();
        assertNotNull(hsl);
        assertFalse(hsl.isEmpty());
        assertTrue(hsl.matches("^hsl\\(\\d{1,3}, \\d{1,3}%, \\d{1,3}%\\)$"));
    }
} 