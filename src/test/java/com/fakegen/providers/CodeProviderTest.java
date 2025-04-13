package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeProviderTest {
    private CodeProvider codeProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        codeProvider = new CodeProvider(new RandomService());
    }

    @Test
    void isbn_ShouldReturnValidIsbn() {
        String isbn = codeProvider.isbn();
        assertNotNull(isbn);
        assertFalse(isbn.isEmpty());
        assertTrue(isbn.matches("^\\d{13}$"));
    }

    @Test
    void ean_ShouldReturnValidEan() {
        String ean = codeProvider.ean();
        assertNotNull(ean);
        assertFalse(ean.isEmpty());
        assertTrue(ean.matches("^\\d{13}$"));
    }

    @Test
    void asin_ShouldReturnValidAsin() {
        String asin = codeProvider.asin();
        assertNotNull(asin);
        assertFalse(asin.isEmpty());
        assertTrue(asin.matches("^[A-Z0-9]{10}$"));
    }

    @Test
    void issn_ShouldReturnValidIssn() {
        String issn = codeProvider.issn();
        assertNotNull(issn);
        assertFalse(issn.isEmpty());
        assertTrue(issn.matches("^\\d{4}-\\d{3}[0-9X]$"));
    }
} 