package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import com.fakegen.util.RandomService;

import java.util.List;

public class AppProvider {
    private final RandomService random;
    private List<String> appName;
    private List<String> appPlatform;
    private List<String> appCategory;

    public AppProvider(RandomService random) {
        this.random = random;
    }

    public String name() {
        appName = LazyLoader.load("appNames", () -> DataLoader.getListData("app", "app_names"));
        return random.randomElement(appName);
    }

    public String platform() {
        appPlatform = LazyLoader.load("appPlatform", () -> DataLoader.getListData("app", "platforms"));
        return random.randomElement(appPlatform);
    }

    public String category() {
        appCategory = LazyLoader.load("appCategory", () -> DataLoader.getListData("app", "categories"));
        return random.randomElement(appCategory);
    }

    public String version() {
        return String.format("%d.%d.%d",
                random.nextInt(1, 10),
                random.nextInt(0, 9),
                random.nextInt(0, 99));
    }

    public static void main(String[] args) {
        AppProvider appProvider = new AppProvider(new RandomService());
        System.out.println("Random App Name: " + appProvider.name());
        System.out.println("Random App Version: " + appProvider.version());
        System.out.println("Random App Platform: " + appProvider.platform());
        System.out.println("Random App Category: " + appProvider.category());
    }
}