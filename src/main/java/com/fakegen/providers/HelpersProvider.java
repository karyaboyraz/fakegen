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

    public static void main(String[] args) {
        HelpersProvider helpersProvider = new HelpersProvider(new RandomService());
        List<String> list = List.of("apple", "banana", "cherry");
        System.out.println("Random element from list: " + helpersProvider.randomElement(list));

        String[] array = {"dog", "cat", "mouse"};
        System.out.println("Random element from array: " + helpersProvider.randomElement(array));

        Map<String, Integer> map = Map.of("one", 1, "two", 2, "three", 3);
        System.out.println("Random key from map: " + helpersProvider.randomKey(map));
        System.out.println("Random value from map: " + helpersProvider.randomValue(map));

        String pattern = "##-##-##";
        System.out.println("Randomized pattern: " + helpersProvider.randomize(pattern));
        System.out.println("Numerified pattern: " + helpersProvider.numerify(pattern));
        System.out.println("Letterified pattern: " + helpersProvider.letterify(pattern));
        System.out.println("Bothified pattern: " + helpersProvider.bothify(pattern));

    }
} 