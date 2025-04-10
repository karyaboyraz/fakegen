package com.fakegen.providers;

import com.fakegen.util.RandomService;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class HelpersProvider {
    private final RandomService random;

    public HelpersProvider(RandomService random) {
        this.random = random;
    }

    public <T> T randomElement(List<T> list) {
        return random.randomElement(list);
    }

    public <T> T randomElement(T[] array) {
        return random.randomElement(array);
    }

    public <K, V> K randomKey(Map<K, V> map) {
        return random.randomElement(new ArrayList<>(map.keySet()));
    }

    public <K, V> V randomValue(Map<K, V> map) {
        return random.randomElement(new ArrayList<>(map.values()));
    }

    public String randomize(String pattern) {
        return random.randomize(pattern);
    }

    public String numerify(String pattern) {
        return random.numerify(pattern);
    }

    public String letterify(String pattern) {
        return random.letterify(pattern);
    }

    public String bothify(String pattern) {
        return random.bothify(pattern);
    }
} 