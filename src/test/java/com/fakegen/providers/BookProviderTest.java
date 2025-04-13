package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class BookProviderTest {
    private BookProvider bookProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        bookProvider = new BookProvider(new RandomService());
    }

    @RepeatedTest(20)
    void title_ShouldReturnValidTitle() {
        String title = bookProvider.title();
        assertNotNull(title);
        assertFalse(title.isEmpty());
    }

    @RepeatedTest(20)
    void author_ShouldReturnValidAuthor() {
        String author = bookProvider.author();
        assertNotNull(author);
        assertFalse(author.isEmpty());
    }

    @RepeatedTest(20)
    void publisher_ShouldReturnValidPublisher() {
        String publisher = bookProvider.publisher();
        assertNotNull(publisher);
        assertFalse(publisher.isEmpty());
    }

    @RepeatedTest(20)
    void genre_ShouldReturnValidGenre() {
        String genre = bookProvider.genre();
        assertNotNull(genre);
        assertFalse(genre.isEmpty());
    }

    @RepeatedTest(20)
    void isbn_ShouldReturnValidIsbn() {
        String isbn = bookProvider.isbn();
        assertNotNull(isbn);
        assertFalse(isbn.isEmpty());
        assertTrue(isbn.matches("^\\d{13}$"));
    }
} 