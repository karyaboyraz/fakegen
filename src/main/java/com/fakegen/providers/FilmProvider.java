package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;
import com.fakegen.util.LazyLoader;
import java.util.List;

public class FilmProvider {
    private final RandomService random;
    private List<String> filmTitles;
    private List<String> filmDirectors;
    private List<String> filmActors;
    private List<String> filmGenres;
    private List<String> firstNames;

    public FilmProvider(RandomService random) {
        this.random = random;
    }

    public String title() {
        filmTitles = LazyLoader.load("filmTitles", () -> DataLoader.getListData("film", "titles"));
        return random.randomElement(filmTitles);
    }

    public String director() {
        filmDirectors = LazyLoader.load("filmDirectors", () -> DataLoader.getListData("film", "directors"));
        return random.randomElement(filmDirectors);
    }

    public String actor() {
        filmActors = LazyLoader.load("filmActors", () -> DataLoader.getListData("film", "actors"));
        return random.randomElement(filmActors);
    }

    public String genre() {
        filmGenres = LazyLoader.load("filmGenres", () -> DataLoader.getListData("film", "genres"));
        return random.randomElement(filmGenres);
    }

    public String character() {
        firstNames = LazyLoader.load("nameFirstNames", () -> DataLoader.getListData("name", "first_names"));
        return random.randomElement(firstNames);
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