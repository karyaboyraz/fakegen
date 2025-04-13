package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class FoodProvider {
    private final RandomService random;

    public FoodProvider(RandomService random) {
        this.random = random;
    }

    public String ingredient() {
        return random.randomElement(DataLoader.getListData("food", "ingredients"));
    }

    public String spice() {
        return random.randomElement(DataLoader.getListData("food", "spices"));
    }

    public String measurement() {
        return random.randomElement(DataLoader.getListData("food", "measurements"));
    }

    public String dish() {
        return random.randomElement(DataLoader.getListData("food", "dishes"));
    }

    public static void main(String[] args) {
        FoodProvider foodProvider = new FoodProvider(new RandomService());
        System.out.println("Random Ingredient: " + foodProvider.ingredient());
        System.out.println("Random Spice: " + foodProvider.spice());
        System.out.println("Random Measurement: " + foodProvider.measurement());
        System.out.println("Random Dish: " + foodProvider.dish());
    }
} 