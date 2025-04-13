package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class ArtistProvider {
    private final RandomService random;

    public ArtistProvider(RandomService random) {
        this.random = random;
    }

    public String name() {
        return random.randomElement(DataLoader.getListData("artist", "names"));
    }

    public String genre() {
        return random.randomElement(DataLoader.getListData("artist", "genres"));
    }

    public String nationality() {
        return random.randomElement(DataLoader.getListData("artist", "nationalities"));
    }

    public String artwork() {
        return random.randomElement(DataLoader.getListData("artist", "artworks"));
    }

    public static void main(String[] args) {
        ArtistProvider artistProvider = new ArtistProvider(new RandomService());
        System.out.println("Random Artist Name: " + artistProvider.name());
        System.out.println("Random Artist Genre: " + artistProvider.genre());
        System.out.println("Random Artist Nationality: " + artistProvider.nationality());
        System.out.println("Random Artwork: " + artistProvider.artwork());
    }
}