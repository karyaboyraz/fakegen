package com.fakegen.providers;

import com.fakegen.util.RandomService;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberProvider {
    private final RandomService random;

    public NumberProvider(RandomService random) {
        this.random = random;
    }

    public int number(int min, int max) {
        return random.nextInt(min, max);
    }

    public double decimal(double min, double max) {
        return random.nextDouble(min, max);
    }

    public double decimal(double min, double max, int scale) {
        return BigDecimal.valueOf(random.nextDouble(min, max))
            .setScale(scale, RoundingMode.HALF_UP)
            .doubleValue();
    }

    public String digit() {
        return String.valueOf(random.nextInt(0, 9));
    }

    public String digits(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(digit());
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

    public static void main(String[] args) {
        NumberProvider numberProvider = new NumberProvider(new RandomService());
        System.out.println("Random Number: " + numberProvider.number(1, 100));
        System.out.println("Random Decimal: " + numberProvider.decimal(1.0, 100.0));
        System.out.println("Random Decimal with Scale: " + numberProvider.decimal(1.0, 100.0, 2));
        System.out.println("Random Digit: " + numberProvider.digit());
        System.out.println("Random Digits: " + numberProvider.digits(5));
        System.out.println("Random Hex: " + numberProvider.hex(5));
        System.out.println("Random Binary: " + numberProvider.binary(5));
        System.out.println("Random Octal: " + numberProvider.octal(5));
    }
} 