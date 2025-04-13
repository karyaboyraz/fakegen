package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodProviderTest {
    private FoodProvider foodProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        foodProvider = new FoodProvider(new RandomService());
    }

    @Test
    void ingredient_ShouldReturnValidIngredient() {
        String ingredient = foodProvider.ingredient();
        assertNotNull(ingredient);
        assertFalse(ingredient.isEmpty());
    }

    @Test
    void spice_ShouldReturnValidSpice() {
        String spice = foodProvider.spice();
        assertNotNull(spice);
        assertFalse(spice.isEmpty());
    }

    @Test
    void measurement_ShouldReturnValidMeasurement() {
        String measurement = foodProvider.measurement();
        assertNotNull(measurement);
        assertFalse(measurement.isEmpty());
    }

    @Test
    void dish_ShouldReturnValidDish() {
        String dish = foodProvider.dish();
        assertNotNull(dish);
        assertFalse(dish.isEmpty());
    }
} 