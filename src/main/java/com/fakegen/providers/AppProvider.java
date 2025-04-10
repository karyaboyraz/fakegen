package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class AppProvider {
    private final RandomService random;

    public AppProvider(RandomService random) {
        this.random = random;
    }

    public String name() {
        return random.randomElement(DataLoader.getListData("app", "names"));
    }

    public String version() {
        return String.format("%d.%d.%d",
            random.nextInt(1, 10),
            random.nextInt(0, 9),
            random.nextInt(0, 99));
    }

    public String platform() {
        return random.randomElement(DataLoader.getListData("app", "platforms"));
    }

    public String category() {
        return random.randomElement(DataLoader.getListData("app", "categories"));
    }
}