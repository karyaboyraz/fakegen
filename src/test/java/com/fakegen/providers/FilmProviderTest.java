package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmProviderTest {
    private FilmProvider filmProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        filmProvider = new FilmProvider(new RandomService());
    }

    @Test
    void title_ShouldReturnValidTitle() {
        String title = filmProvider.title();
        assertNotNull(title);
        assertFalse(title.isEmpty());
    }

    @Test
    void genre_ShouldReturnValidGenre() {
        String genre = filmProvider.genre();
        assertNotNull(genre);
        assertFalse(genre.isEmpty());
    }

    @Test
    void director_ShouldReturnValidDirector() {
        String director = filmProvider.director();
        assertNotNull(director);
        assertFalse(director.isEmpty());
    }

    @Test
    void actor_ShouldReturnValidActor() {
        String actor = filmProvider.actor();
        assertNotNull(actor);
        assertFalse(actor.isEmpty());
    }

    @Test
    void character_ShouldReturnValidCharacter() {
        String character = filmProvider.character();
        assertNotNull(character);
        assertFalse(character.isEmpty());
    }
} 