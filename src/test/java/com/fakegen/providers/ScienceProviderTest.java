package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScienceProviderTest {
    private ScienceProvider scienceProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        scienceProvider = new ScienceProvider(new RandomService());
    }

    @Test
    void unit_ShouldReturnValidUnit() {
        String unit = scienceProvider.unit();
        assertNotNull(unit);
        assertFalse(unit.isEmpty());
    }

    @Test
    void chemicalFormula_ShouldReturnValidFormula() {
        String formula = scienceProvider.chemicalFormula();
        assertNotNull(formula);
        assertFalse(formula.isEmpty());
        assertTrue(formula.matches("^[A-Z][a-z]?\\d*$"));
    }
} 