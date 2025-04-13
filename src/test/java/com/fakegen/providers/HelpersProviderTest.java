package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HelpersProviderTest {
    private HelpersProvider helpersProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        helpersProvider = new HelpersProvider(new RandomService());
    }

    @Test
    void randomElement_ShouldReturnValidElementFromList() {
        List<String> list = Arrays.asList("a", "b", "c");
        String result = helpersProvider.randomElement(list);
        assertNotNull(result);
        assertTrue(list.contains(result));
    }

    @Test
    void randomElement_ShouldReturnValidElementFromArray() {
        String[] array = {"a", "b", "c"};
        String result = helpersProvider.randomElement(array);
        assertNotNull(result);
        assertTrue(Arrays.asList(array).contains(result));
    }

    @Test
    void randomKey_ShouldReturnValidKey() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        String result = helpersProvider.randomKey(map);
        assertNotNull(result);
        assertTrue(map.containsKey(result));
    }

    @Test
    void randomValue_ShouldReturnValidValue() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        Integer result = helpersProvider.randomValue(map);
        assertNotNull(result);
        assertTrue(map.containsValue(result));
    }

    @Test
    void randomize_ShouldReturnValidString() {
        String input = "###???";
        String result = helpersProvider.randomize(input);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.matches("^\\d{3}[A-Z]{3}$"));
    }

    @Test
    void numerify_ShouldReturnValidNumericString() {
        String input = "###-###-####";
        String result = helpersProvider.numerify(input);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.matches("^\\d{3}-\\d{3}-\\d{4}$"));
    }

    @Test
    void letterify_ShouldReturnValidLetterString() {
        String input = "???-???-????";
        String result = helpersProvider.letterify(input);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.matches("^[A-Z]{3}-[A-Z]{3}-[A-Z]{4}$"));
    }

    @Test
    void bothify_ShouldReturnValidString() {
        String input = "##??-??##-????";
        String result = helpersProvider.bothify(input);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.matches("^\\d{2}[A-Z]{2}-[A-Z]{2}\\d{2}-[A-Z]{4}$"));
    }
} 