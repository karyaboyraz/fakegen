package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class CommerceProvider {
    private final RandomService random;

    public CommerceProvider(RandomService random) {
        this.random = random;
    }

    public String productName() {
        return random.randomElement(DataLoader.getListData("commerce", "product_names"));
    }

    public String department() {
        return random.randomElement(DataLoader.getListData("commerce", "departments"));
    }

    public String material() {
        return random.randomElement(DataLoader.getListData("commerce", "materials"));
    }

    public String promotionCode() {
        return random.bothify("PROMO-????-####");
    }

    public static void main(String[] args) {
        CommerceProvider commerceProvider = new CommerceProvider(new RandomService());
        System.out.println("Product Name: " + commerceProvider.productName());
        System.out.println("Department: " + commerceProvider.department());
        System.out.println("Material: " + commerceProvider.material());
        System.out.println("Promotion Code: " + commerceProvider.promotionCode());
    }
} 