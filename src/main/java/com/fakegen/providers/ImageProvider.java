package com.fakegen.providers;

public class ImageProvider {

    public String imageUrl(int width, int height) {
        return String.format("https://picsum.photos/%d/%d", width, height);
    }

    public String imageUrl(int width, int height, String category) {
        return String.format("https://picsum.photos/%d/%d?category=%s", width, height, category);
    }

    public String imageUrl(int width, int height, String category, String search) {
        return String.format("https://picsum.photos/%d/%d?category=%s&search=%s", width, height, category, search);
    }

    public String imageUrl(int width, int height, String category, String search, String seed) {
        return String.format("https://picsum.photos/seed/%s/%d/%d?category=%s&search=%s", seed, width, height, category, search);
    }

    public static void main(String[] args) {
        ImageProvider imageProvider = new ImageProvider();
        System.out.println(imageProvider.imageUrl(800, 600));
        System.out.println(imageProvider.imageUrl(800, 600, "nature"));
        System.out.println(imageProvider.imageUrl(800, 600, "nature", "mountain"));
        System.out.println(imageProvider.imageUrl(800, 600, "nature", "mountain", "sunset"));
    }
}