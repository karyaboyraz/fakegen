package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;
import com.fakegen.util.LazyLoader;
import java.util.List;

public class FoodProvider {
    private final RandomService random;
    private List<String> ingredients;
    private List<String> spices;
    private List<String> measurements;
    private List<String> dishes;

    public FoodProvider(RandomService random) {
        this.random = random;
    }

    public String ingredient() {
        ingredients = LazyLoader.load("foodIngredients", () -> DataLoader.getListData("food", "ingredients"));
        return random.randomElement(ingredients);
    }

    public String spice() {
        spices = LazyLoader.load("foodSpices", () -> DataLoader.getListData("food", "spices"));
        return random.randomElement(spices);
    }

    public String measurement() {
        measurements = LazyLoader.load("foodMeasurements", () -> DataLoader.getListData("food", "measurements"));
        return random.randomElement(measurements);
    }

    public String dish() {
        dishes = LazyLoader.load("foodDishes", () -> DataLoader.getListData("food", "dishes"));
        return random.randomElement(dishes);
    }

    public static void main(String[] args) {
        FoodProvider foodProvider = new FoodProvider(new RandomService());
        System.out.println("Random Ingredient: " + foodProvider.ingredient());
        System.out.println("Random Spice: " + foodProvider.spice());
        System.out.println("Random Measurement: " + foodProvider.measurement());
        System.out.println("Random Dish: " + foodProvider.dish());
    }
} 