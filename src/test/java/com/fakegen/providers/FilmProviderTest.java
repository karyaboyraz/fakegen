package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class FilmProviderTest {
    private FilmProvider filmProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        filmProvider = new FilmProvider(new RandomService());
    }

    @RepeatedTest(20)
    void title_ShouldReturnValidTitle() {
        String title = filmProvider.title();
        assertNotNull(title);
        assertFalse(title.isEmpty());
    }

    @RepeatedTest(20)
    void genre_ShouldReturnValidGenre() {
        String genre = filmProvider.genre();
        assertNotNull(genre);
        assertFalse(genre.isEmpty());
    }

    @RepeatedTest(20)
    void director_ShouldReturnValidDirector() {
        String director = filmProvider.director();
        assertNotNull(director);
        assertFalse(director.isEmpty());
    }

    @RepeatedTest(20)
    void actor_ShouldReturnValidActor() {
        String actor = filmProvider.actor();
        assertNotNull(actor);
        assertFalse(actor.isEmpty());
    }

    @RepeatedTest(20)
    void character_ShouldReturnValidCharacter() {
        String character = filmProvider.character();
        assertNotNull(character);
        assertFalse(character.isEmpty());
    }
} 