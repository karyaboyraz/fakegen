package com.fakegen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomServiceTest {
    private RandomService randomService;

    @BeforeEach
    void setUp() {
        randomService = new RandomService();
    }

    @Test
    void nextInt_ShouldReturnNumberWithinBound() {
        int bound = 10;
        int result = randomService.nextInt(bound);
        assertTrue(result >= 0 && result < bound);
    }

    @Test
    void nextBoolean_ShouldReturnBoolean() {
        boolean result = randomService.nextBoolean();
        assertTrue(result == true || result == false);
    }

    @Test
    void randomElement_ShouldReturnElementFromList() {
        List<String> list = Arrays.asList("a", "b", "c");
        String result = randomService.randomElement(list);
        assertTrue(list.contains(result));
    }

    @Test
    void randomElement_ShouldThrowExceptionForNullList() {
        assertThrows(IllegalArgumentException.class, () -> randomService.randomElement(null));
    }

    @Test
    void randomElement_ShouldThrowExceptionForEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> randomService.randomElement(Collections.emptyList()));
    }

    @Test
    void nextElement_ShouldReturnElementFromArray() {
        String[] array = {"a", "b", "c"};
        String result = randomService.nextElement(array);
        assertTrue(Arrays.asList(array).contains(result));
    }

    @Test
    void nextElement_ShouldThrowExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class, () -> randomService.nextElement((String[]) null));
    }

    @Test
    void nextElement_ShouldThrowExceptionForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> randomService.nextElement(new String[0]));
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "##", "###", "####"})
    void numerify_ShouldReplaceAllHashWithNumbers(String pattern) {
        String result = randomService.numerify(pattern);
        assertTrue(result.matches("\\d{" + pattern.length() + "}"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"?", "??", "???", "????"})
    void letterify_ShouldReplaceAllQuestionMarksWithLetters(String pattern) {
        String result = randomService.letterify(pattern);
        assertTrue(result.matches("[a-z]{" + pattern.length() + "}"));
    }

    @Test
    void bothify_ShouldReplaceBothHashAndQuestionMarks() {
        String pattern = "#?#?#?";
        String result = randomService.bothify(pattern);
        assertTrue(result.matches("\\d[a-z]\\d[a-z]\\d[a-z]"));
    }

    @Test
    void formatPhoneNumber_ShouldFormatCorrectly() {
        String format = "(###) ###-####";
        String result = randomService.formatPhoneNumber(format);
        assertTrue(result.matches("\\(\\d{3}\\) \\d{3}-\\d{4}"));
    }

    @Test
    void formatPhoneNumber_ShouldThrowExceptionForNullFormat() {
        assertThrows(IllegalArgumentException.class, () -> randomService.formatPhoneNumber(null));
    }

    @Test
    void formatPhoneNumber_ShouldThrowExceptionForEmptyFormat() {
        assertThrows(IllegalArgumentException.class, () -> randomService.formatPhoneNumber(""));
    }
} 