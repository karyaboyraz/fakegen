package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicProviderTest {
    private MusicProvider musicProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        musicProvider = new MusicProvider(new RandomService());
    }

    @Test
    void genre_ShouldReturnValidGenre() {
        String genre = musicProvider.genre();
        assertNotNull(genre);
        assertFalse(genre.isEmpty());
    }

    @Test
    void instrument_ShouldReturnValidInstrument() {
        String instrument = musicProvider.instrument();
        assertNotNull(instrument);
        assertFalse(instrument.isEmpty());
    }

    @Test
    void key_ShouldReturnValidKey() {
        String key = musicProvider.key();
        assertNotNull(key);
        assertFalse(key.isEmpty());
        assertTrue(key.contains(" "));
    }

    @Test
    void chord_ShouldReturnValidChord() {
        String chord = musicProvider.chord();
        assertNotNull(chord);
        assertFalse(chord.isEmpty());
        assertTrue(chord.contains(" "));
    }

    @Test
    void note_ShouldReturnValidNote() {
        String note = musicProvider.note();
        assertNotNull(note);
        assertFalse(note.isEmpty());
    }

    @Test
    void scale_ShouldReturnValidScale() {
        String scale = musicProvider.scale();
        assertNotNull(scale);
        assertFalse(scale.isEmpty());
        assertTrue(scale.contains(" "));
    }

    @Test
    void tempo_ShouldReturnValidTempo() {
        String tempo = musicProvider.tempo();
        assertNotNull(tempo);
        assertFalse(tempo.isEmpty());
    }

    @Test
    void dynamic_ShouldReturnValidDynamic() {
        String dynamic = musicProvider.dynamic();
        assertNotNull(dynamic);
        assertFalse(dynamic.isEmpty());
    }

    @Test
    void timeSignature_ShouldReturnValidTimeSignature() {
        String timeSignature = musicProvider.timeSignature();
        assertNotNull(timeSignature);
        assertFalse(timeSignature.isEmpty());
    }

    @Test
    void album_ShouldReturnValidAlbum() {
        String album = musicProvider.album();
        assertNotNull(album);
        assertFalse(album.isEmpty());
    }

    @Test
    void artist_ShouldReturnValidArtist() {
        String artist = musicProvider.artist();
        assertNotNull(artist);
        assertFalse(artist.isEmpty());
    }

    @Test
    void song_ShouldReturnValidSong() {
        String song = musicProvider.song();
        assertNotNull(song);
        assertFalse(song.isEmpty());
    }
} 