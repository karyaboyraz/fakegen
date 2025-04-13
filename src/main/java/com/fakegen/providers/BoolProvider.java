package com.fakegen.providers;

import com.fakegen.util.RandomService;

public class BoolProvider {
    private final RandomService random;

    public BoolProvider(RandomService random) {
        this.random = random;
    }

    public boolean bool() {
        return random.nextBoolean();
    }

    public boolean bool(double probability) {
        return random.nextDouble(0.0, 1.0) < probability;
    }

    public static void main(String[] args) {
        BoolProvider boolProvider = new BoolProvider(new RandomService());
        System.out.println("Random boolean: " + boolProvider.bool());
        System.out.println("Boolean with 30% probability: " + boolProvider.bool(0.3));
    }
} 