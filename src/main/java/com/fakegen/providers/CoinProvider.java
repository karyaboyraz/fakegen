package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class CoinProvider {
    private final RandomService random;

    public CoinProvider(RandomService random) {
        this.random = random;
    }

    public String toss() {
        return random.randomElement(DataLoader.getListData("coin", "sides"));
    }

    public String toss(int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(toss()).append(" ");
        }
        return result.toString().trim();
    }
} 