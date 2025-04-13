package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberProviderTest {
    private NumberProvider numberProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        numberProvider = new NumberProvider(new RandomService());
    }

    @Test
    void number_ShouldReturnValidNumber() {
        int number = numberProvider.number(0, 100);
        assertTrue(number >= 0 && number <= 100);
    }

    @Test
    void decimal_ShouldReturnValidDecimal() {
        double decimal = numberProvider.decimal(0.0, 1.0);
        assertTrue(decimal >= 0.0 && decimal <= 1.0);
    }

    @Test
    void decimalWithScale_ShouldReturnValidDecimal() {
        double decimal = numberProvider.decimal(0.0, 1.0, 2);
        assertTrue(decimal >= 0.0 && decimal <= 1.0);
        String decimalStr = String.valueOf(decimal);
        assertTrue(decimalStr.matches("^\\d+\\.\\d{2}$"));
    }

    @Test
    void digit_ShouldReturnValidDigit() {
        String digit = numberProvider.digit();
        assertNotNull(digit);
        assertFalse(digit.isEmpty());
        assertTrue(digit.matches("^\\d$"));
    }

    @Test
    void digits_ShouldReturnValidDigits() {
        String digits = numberProvider.digits(5);
        assertNotNull(digits);
        assertFalse(digits.isEmpty());
        assertTrue(digits.matches("^\\d{5}$"));
    }

    @Test
    void hex_ShouldReturnValidHex() {
        String hex = numberProvider.hex(8);
        assertNotNull(hex);
        assertFalse(hex.isEmpty());
        assertTrue(hex.matches("^[0-9a-f]{8}$"));
    }

    @Test
    void binary_ShouldReturnValidBinary() {
        String binary = numberProvider.binary(8);
        assertNotNull(binary);
        assertFalse(binary.isEmpty());
        assertTrue(binary.matches("^[01]{8}$"));
    }

    @Test
    void octal_ShouldReturnValidOctal() {
        String octal = numberProvider.octal(8);
        assertNotNull(octal);
        assertFalse(octal.isEmpty());
        assertTrue(octal.matches("^[0-7]{8}$"));
    }
} 