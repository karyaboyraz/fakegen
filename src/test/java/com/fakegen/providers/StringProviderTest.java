package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringProviderTest {
    private StringProvider stringProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        stringProvider = new StringProvider(new RandomService());
    }

    @Test
    void alpha_ShouldReturnValidAlphaString() {
        int count = 10;
        String alpha = stringProvider.alpha(count);
        assertNotNull(alpha);
        assertFalse(alpha.isEmpty());
        assertEquals(count, alpha.length());
        assertTrue(alpha.matches("^[a-zA-Z]+$"));
    }

    @Test
    void alphaNumeric_ShouldReturnValidAlphaNumericString() {
        int count = 10;
        String alphaNumeric = stringProvider.alphaNumeric(count);
        assertNotNull(alphaNumeric);
        assertFalse(alphaNumeric.isEmpty());
        assertEquals(count, alphaNumeric.length());
        assertTrue(alphaNumeric.matches("^[a-zA-Z0-9]+$"));
    }

    @Test
    void numeric_ShouldReturnValidNumericString() {
        int count = 10;
        String numeric = stringProvider.numeric(count);
        assertNotNull(numeric);
        assertFalse(numeric.isEmpty());
        assertEquals(count, numeric.length());
        assertTrue(numeric.matches("^\\d+$"));
    }

    @Test
    void hex_ShouldReturnValidHexString() {
        int count = 10;
        String hex = stringProvider.hex(count);
        assertNotNull(hex);
        assertFalse(hex.isEmpty());
        assertEquals(count, hex.length());
        assertTrue(hex.matches("^[0-9a-f]+$"));
    }

    @Test
    void binary_ShouldReturnValidBinaryString() {
        int count = 10;
        String binary = stringProvider.binary(count);
        assertNotNull(binary);
        assertFalse(binary.isEmpty());
        assertEquals(count, binary.length());
        assertTrue(binary.matches("^[01]+$"));
    }
} 