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
} 