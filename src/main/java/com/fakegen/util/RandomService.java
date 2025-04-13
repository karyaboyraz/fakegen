package com.fakegen.util;

import java.util.List;
import java.util.Random;

public class RandomService {
    private final Random random;

    public RandomService() {
        this.random = new Random();
    }

    public RandomService(long seed) {
        this.random = new Random(seed);
    }

    public Random getRandom() {
        return random;
    }

    public int nextInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public double nextDouble(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    public boolean nextBoolean() {
        return random.nextBoolean();
    }

    public <T> T randomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        return list.get(random.nextInt(list.size()));
    }

    public <T> T randomElement(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[random.nextInt(array.length)];
    }

    public String randomize(String pattern) {
        if (pattern == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == '?') {
                result.append(random.nextBoolean() ? '1' : '0');
            } else if (c == '#') {
                result.append(random.nextInt(10));
            } else if (c == '*') {
                result.append(random.nextBoolean() ? random.nextInt(10) : (char) (random.nextInt(26) + 'a'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String numerify(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }

        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == '#') {
                result.append(random.nextInt(10));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String letterify(String pattern) {
        if (pattern == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == '?') {
                result.append((char) (random.nextInt(26) + 'a'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String bothify(String pattern) {
        return letterify(numerify(pattern));
    }
}