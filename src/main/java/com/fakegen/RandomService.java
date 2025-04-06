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
}
