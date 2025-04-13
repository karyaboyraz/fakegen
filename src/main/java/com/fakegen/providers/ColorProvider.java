package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;
import com.fakegen.util.LazyLoader;
import java.util.List;

public class ColorProvider {
    private final RandomService random;
    private List<String> colorNames;

    public ColorProvider(RandomService random) {
        this.random = random;
    }

    public String name() {
        colorNames = LazyLoader.load("colorNames", () -> DataLoader.getListData("color", "names"));
        return random.randomElement(colorNames);
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

    public static void main(String[] args) {
        ColorProvider colorProvider = new ColorProvider(new RandomService());
        System.out.println("Color Name: " + colorProvider.name());
        System.out.println("Hex: " + colorProvider.hex());
        System.out.println("RGB: " + colorProvider.rgb());
        System.out.println("RGBA: " + colorProvider.rgba());
        System.out.println("HSL: " + colorProvider.hsl());
    }
} 