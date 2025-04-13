package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class FilmProvider {
    private final RandomService random;

    public FilmProvider(RandomService random) {
        this.random = random;
    }

    public String title() {
        return random.randomElement(DataLoader.getListData("film", "titles"));
    }

    public String director() {
        return random.randomElement(DataLoader.getListData("film", "directors"));
    }

    public String actor() {
        return random.randomElement(DataLoader.getListData("film", "actors"));
    }

    public String genre() {
        return random.randomElement(DataLoader.getListData("film", "genres"));
    }

    public String character() {
        return random.randomElement(DataLoader.getListData("name", "first_names"));
    }

    public static void main(String[] args) {
        FilmProvider filmProvider = new FilmProvider(new RandomService());
        System.out.println("Title: " + filmProvider.title());
        System.out.println("Director: " + filmProvider.director());
        System.out.println("Actor: " + filmProvider.actor());
        System.out.println("Genre: " + filmProvider.genre());
        System.out.println("Character: " + filmProvider.character());
    }
} 