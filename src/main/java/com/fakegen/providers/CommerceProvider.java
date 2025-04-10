package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class CommerceProvider {
    private final RandomService random;
    private static final double MIN_PRICE = 0.0;
    private static final double MAX_PRICE = 1000.0;

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

    public String price() {
        return String.format("%.2f", random.nextDouble(MIN_PRICE, MAX_PRICE));
    }

    public String promotionCode() {
        return random.bothify("PROMO-????-####");
    }

    public static void main(String[] args) {
        RandomService randomService = new RandomService();
        CommerceProvider commerceProvider = new CommerceProvider(randomService);

        System.out.println("Product Name: " + commerceProvider.productName());
        System.out.println("Department: " + commerceProvider.department());
        System.out.println("Material: " + commerceProvider.material());
        System.out.println("Price: " + commerceProvider.price());
        System.out.println("Promotion Code: " + commerceProvider.promotionCode());
    }
} 