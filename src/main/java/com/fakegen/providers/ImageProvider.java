package com.fakegen.providers;

public class ImageProvider {

    public String imageUrl(int width, int height) {
        return String.format("https://picsum.photos/%d/%d", width, height);
    }

    public String imageUrl(int width, int height, String category) {
        return String.format("https://source.unsplash.com/%dx%d/?%s", width, height, category);
    }

    public String imageUrl(int width, int height, String category, String search) {
        return String.format("https://source.unsplash.com/%dx%d/?%s,%s", width, height, category, search);
    }

    public String imageUrl(int width, int height, String category, String search, String seed) {
        return String.format("https://source.unsplash.com/%dx%d/?%s,%s,%s", width, height, category, search, seed);
    }
} 