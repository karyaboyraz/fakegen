package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import com.fakegen.util.RandomService;

import java.util.List;

public class CoinProvider {
    private final RandomService random;
    private List<String> sides;

    public CoinProvider(RandomService random) {
        this.random = random;
    }

    public String toss() {
        sides = LazyLoader.load("coinSides", () -> DataLoader.getListData("coin", "sides"));
        return random.randomElement(sides);
    }

    public String toss(int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(toss()).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        CoinProvider coinProvider = new CoinProvider(new RandomService());
        System.out.println("Single toss: " + coinProvider.toss());
        System.out.println("Multiple tosses: " + coinProvider.toss(5));
    }
}