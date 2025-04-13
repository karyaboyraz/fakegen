package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import com.fakegen.util.RandomService;

import java.util.List;

@SuppressWarnings("ALL")
public class BookProvider {
    private final RandomService random;
    private List<String> titles;
    private List<String> authors;
    private List<String> publishers;
    private List<String> genres;

    public BookProvider(RandomService random) {
        this.random = random;
    }

    public String title() {
        titles = LazyLoader.load("bookTitles", () -> DataLoader.getListData("book", "titles"));
        return random.randomElement(titles);
    }

    public String author() {
        authors = LazyLoader.load("bookAuthors", () -> DataLoader.getListData("book", "authors"));
        return random.randomElement(authors);
    }

    public String publisher() {
        publishers = LazyLoader.load("bookPublishers", () -> DataLoader.getListData("book", "publishers"));
        return random.randomElement(publishers);
    }

    public String genre() {
        genres = LazyLoader.load("bookGenre", () -> DataLoader.getListData("book", "genres"));
        return random.randomElement(genres);
    }

    public String isbn() {
        NumberProvider numberProvider = new NumberProvider(random);
        return numberProvider.digits(13);
    }

    public static void main(String[] args) {
        BookProvider bookProvider = new BookProvider(new RandomService());
        System.out.println("Random Book Title: " + bookProvider.title());
        System.out.println("Random Book Author: " + bookProvider.author());
        System.out.println("Random Book Publisher: " + bookProvider.publisher());
        System.out.println("Random Book Genre: " + bookProvider.genre());
        System.out.println("Random Book ISBN: " + bookProvider.isbn());
    }
}