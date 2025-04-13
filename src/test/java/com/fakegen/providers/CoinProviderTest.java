package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinProviderTest {
    private CoinProvider coinProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        coinProvider = new CoinProvider(new RandomService());
    }

    @Test
    void toss_ShouldReturnValidToss() {
        String toss = coinProvider.toss();
        assertNotNull(toss);
        assertFalse(toss.isEmpty());
        assertTrue(toss.equals("Yazı") || toss.equals("Tura"));
    }

    @Test
    void tossWithTimes_ShouldReturnValidTosses() {
        String tosses = coinProvider.toss(3);
        assertNotNull(tosses);
        assertFalse(tosses.isEmpty());
        String[] tossArray = tosses.split(" ");
        assertEquals(3, tossArray.length);
        for (String toss : tossArray) {
            assertTrue(toss.equals("Yazı") || toss.equals("Tura"));
        }
    }
} 