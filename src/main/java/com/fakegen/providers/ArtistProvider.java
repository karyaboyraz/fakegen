package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import com.fakegen.util.RandomService;

import java.util.List;

public class ArtistProvider {
    private final RandomService random;
    private List<String> artistName;
    private List<String> artistGenre;
    private List<String> artistNationality;
    private List<String> artistArtwork;

    public ArtistProvider(RandomService random) {
        this.random = random;
    }

    public String name() {
        artistName = LazyLoader.load("artistName", () -> DataLoader.getListData("artist", "names"));
        return random.randomElement(artistName);
    }

    public String genre() {
        artistGenre = LazyLoader.load("artistGenre", () -> DataLoader.getListData("artist", "genres"));
        return random.randomElement(artistGenre);
    }

    public String nationality() {
        artistNationality = LazyLoader.load("artistNationality", () -> DataLoader.getListData("artist", "nationalities"));
        return random.randomElement(artistNationality);
    }

    public String artwork() {
        artistArtwork = LazyLoader.load("artistArtwork", () -> DataLoader.getListData("artist", "artworks"));
        return random.randomElement(artistArtwork);
    }

    public static void main(String[] args) {
        ArtistProvider artistProvider = new ArtistProvider(new RandomService());
        System.out.println("Random Artist Name: " + artistProvider.name());
        System.out.println("Random Artist Genre: " + artistProvider.genre());
        System.out.println("Random Artist Nationality: " + artistProvider.nationality());
        System.out.println("Random Artwork: " + artistProvider.artwork());
    }
}