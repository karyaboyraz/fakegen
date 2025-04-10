package com.fakegen;

import java.util.List;
import java.util.Random;

public class RandomService {
    private final Random random;

    public RandomService() {
        this.random = new Random();
    }

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    public boolean nextBoolean() {
        return random.nextBoolean();
    }

    public <T> T randomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        return list.get(nextInt(list.size()));
    }

    public <T> T nextElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        return list.get(nextInt(list.size()));
    }

    public <T> T nextElement(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        return array[nextInt(array.length)];
    }

    public String numerify(String numberPattern) {
        return numberPattern.replaceAll("#", String.valueOf(nextInt(10)));
    }

    public String letterify(String letterPattern) {
        return letterPattern.replaceAll("\\?", String.valueOf((char) (97 + nextInt(26))));
    }

    public String bothify(String pattern) {
        return letterify(numerify(pattern));
    }

    public String formatPhoneNumber(String phoneFormat) {
        if (phoneFormat == null || phoneFormat.isEmpty()) {
            throw new IllegalArgumentException("Phone format cannot be null or empty");
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < phoneFormat.length(); i++) {
            char c = phoneFormat.charAt(i);
            if (c == '#') {
                result.append(nextInt(10));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
