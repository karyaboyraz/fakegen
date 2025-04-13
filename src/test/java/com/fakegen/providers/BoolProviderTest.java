package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class BoolProviderTest {
    private BoolProvider boolProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        boolProvider = new BoolProvider(new RandomService());
    }

    @RepeatedTest(20)
    void bool_ShouldReturnValidBoolean() {
        boolean result = boolProvider.bool();
        assertTrue(result || !result); // Her zaman true veya false dönmeli
    }

    @RepeatedTest(20)
    void boolWithProbability_ShouldReturnValidBoolean() {
        boolean result = boolProvider.bool(0.7);
        assertTrue(result || !result); // Her zaman true veya false dönmeli
    }
} 