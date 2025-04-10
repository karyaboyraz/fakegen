package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class BookProvider {
    private final RandomService random;

    public BookProvider(RandomService random) {
        this.random = random;
    }

    public String title() {
        return random.randomElement(DataLoader.getListData("book", "titles"));
    }

    public String author() {
        return random.randomElement(DataLoader.getListData("book", "authors"));
    }

    public String publisher() {
        return random.randomElement(DataLoader.getListData("book", "publishers"));

    }

    public String genre() {
        return random.randomElement(DataLoader.getListData("book", "genres"));
    }

    public String isbn() {
        StringBuilder isbn = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            isbn.append(random.nextInt(0, 9));
        }
        return isbn.toString();
    }
} 