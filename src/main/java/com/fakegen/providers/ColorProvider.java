package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class ColorProvider {
    private final RandomService random;

    public ColorProvider(RandomService random) {
        this.random = random;
    }

    public String name() {
        return random.randomElement(DataLoader.getListData("color", "names"));
    }

    public String hex() {
        return String.format("#%06x", random.nextInt(0, 0xFFFFFF));
    }

    public String rgb() {
        return String.format("rgb(%d, %d, %d)",
            random.nextInt(0, 255),
            random.nextInt(0, 255),
            random.nextInt(0, 255)
        );
    }

    public String rgba() {
        return String.format("rgba(%d, %d, %d, %.2f)",
            random.nextInt(0, 255),
            random.nextInt(0, 255),
            random.nextInt(0, 255),
            random.nextDouble(0, 1)
        );
    }

    public String hsl() {
        return String.format("hsl(%d, %d%%, %d%%)",
            random.nextInt(0, 360),
            random.nextInt(0, 100),
            random.nextInt(0, 100)
        );
    }
} 