package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;
import com.fakegen.util.LazyLoader;
import java.util.List;

public class CommerceProvider {
    private final RandomService random;
    private List<String> productNames;
    private List<String> departments;
    private List<String> materials;

    public CommerceProvider(RandomService random) {
        this.random = random;
    }

    public String productName() {
        productNames = LazyLoader.load("commerceProductNames", () -> DataLoader.getListData("commerce", "product_names"));
        return random.randomElement(productNames);
    }

    public String department() {
        departments = LazyLoader.load("commerceDepartments", () -> DataLoader.getListData("commerce", "departments"));
        return random.randomElement(departments);
    }

    public String material() {
        materials = LazyLoader.load("commerceMaterials", () -> DataLoader.getListData("commerce", "materials"));
        return random.randomElement(materials);
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