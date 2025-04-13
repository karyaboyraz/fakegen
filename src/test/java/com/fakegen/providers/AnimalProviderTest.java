package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalProviderTest {
    private AnimalProvider animalProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        animalProvider = new AnimalProvider(new RandomService());
    }

    @Test
    void animal_ShouldReturnValidAnimal() {
        String animal = animalProvider.animal();
        assertNotNull(animal);
        assertFalse(animal.isEmpty());
    }

    @Test
    void animalType_ShouldReturnValidType() {
        String type = animalProvider.animalType();
        assertNotNull(type);
        assertFalse(type.isEmpty());
    }

    @Test
    void animalScientificName_ShouldReturnValidName() {
        String name = animalProvider.animalScientificName();
        assertNotNull(name);
        assertFalse(name.isEmpty());
    }

    @Test
    void animalFamily_ShouldReturnValidFamily() {
        String family = animalProvider.animalFamily();
        assertNotNull(family);
        assertFalse(family.isEmpty());
    }

    @Test
    void animalKingdom_ShouldReturnValidKingdom() {
        String kingdom = animalProvider.animalKingdom();
        assertNotNull(kingdom);
        assertFalse(kingdom.isEmpty());
    }

    @Test
    void animalPhylum_ShouldReturnValidPhylum() {
        String phylum = animalProvider.animalPhylum();
        assertNotNull(phylum);
        assertFalse(phylum.isEmpty());
    }

    @Test
    void animalClass_ShouldReturnValidClass() {
        String animalClass = animalProvider.animalClass();
        assertNotNull(animalClass);
        assertFalse(animalClass.isEmpty());
    }

    @Test
    void animalOrder_ShouldReturnValidOrder() {
        String order = animalProvider.animalOrder();
        assertNotNull(order);
        assertFalse(order.isEmpty());
    }

    @Test
    void animalGenus_ShouldReturnValidGenus() {
        String genus = animalProvider.animalGenus();
        assertNotNull(genus);
        assertFalse(genus.isEmpty());
    }

    @Test
    void animalSpecies_ShouldReturnValidSpecies() {
        String species = animalProvider.animalSpecies();
        assertNotNull(species);
        assertFalse(species.isEmpty());
    }
} 