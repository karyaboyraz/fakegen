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

    public String quote() {
        return random.randomElement(DataLoader.getListData("film", "quotes"));
    }

    public String character() {
        return random.randomElement(DataLoader.getListData("film", "characters"));
    }
} 