package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;
import java.util.List;
import java.util.stream.Collectors;

public class StringProvider {
    private final RandomService random;

    public StringProvider(RandomService random) {
        this.random = random;
    }

    public String alpha(int count) {
        StringBuilder result = new StringBuilder();
        List<Character> alphabet = DataLoader.getAlphabet().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        for (int i = 0; i < count; i++) {
            result.append(random.randomElement(alphabet));
        }
        return result.toString();
    }

    public String alphaNumeric(int count) {
        StringBuilder result = new StringBuilder();
        List<Character> alphabet = DataLoader.getAlphabet().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        for (int i = 0; i < count; i++) {
            if (random.nextBoolean()) {
                result.append(random.randomElement(alphabet));
            } else {
                result.append(random.nextInt(0, 9));
            }
        }
        return result.toString();
    }

    public String numeric(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(random.nextInt(0, 9));
        }
        return result.toString();
    }

    public String hex(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(Integer.toHexString(random.nextInt(0, 15)));
        }
        return result.toString();
    }

    public String binary(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(random.nextInt(0, 1));
        }
        return result.toString();
    }

    public String octal(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(random.nextInt(0, 7));
        }
        return result.toString();
    }

    public String sample(int count) {
        StringBuilder result = new StringBuilder();
        List<Character> sampleChars = DataLoader.getSampleCharacters().chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.toList());
        for (int i = 0; i < count; i++) {
            result.append(random.randomElement(sampleChars));
        }
        return result.toString();
    }

    public String uuid() {
        return String.format("%s-%s-%s-%s-%s",
            hex(8),
            hex(4),
            hex(4),
            hex(4),
            hex(12)
        );
    }

    public static void main(String[] args) {
        StringProvider stringProvider = new StringProvider(new RandomService());
        System.out.println(stringProvider.alpha(10));
        System.out.println(stringProvider.alphaNumeric(10));
        System.out.println(stringProvider.numeric(10));
        System.out.println(stringProvider.hex(10));
        System.out.println(stringProvider.binary(10));
        System.out.println(stringProvider.octal(10));
        System.out.println(stringProvider.sample(10));
        System.out.println(stringProvider.uuid());
    }
} 