package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import com.fakegen.util.RandomService;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;

public class AnimalProvider {
    private final RandomService random;
    private final List<String> animals;
    private final List<String> animalTypes;
    private List<String> animalScientificName;

    public AnimalProvider(RandomService random) {
        this.random = random;
        this.animals = DataLoader.getListData("animal", "animal_names");
        this.animalTypes = DataLoader.getListData("animal", "types");
  }

    public String animal() {
        return random.randomElement(animals);
    }

    public String animalType() {
        return random.randomElement(animalTypes);
    }

    public String animalScientificName() {
        animalScientificName = LazyLoader.load("animalScienceName", () -> DataLoader.getListData("animal", "scientific_names"));
        return random.randomElement(animalScientificName);
    }

    public String animalFamily() {
        return random.randomElement(DataLoader.getListData("animal", "families"));
    }

    public String animalKingdom() {
        return random.randomElement(DataLoader.getListData("animal", "kingdoms"));
    }

    public String animalPhylum() {
        return random.randomElement(DataLoader.getListData("animal", "phyla"));
    }

    public String animalClass() {
        return random.randomElement(DataLoader.getListData("animal", "classes"));
    }

    public String animalOrder() {
        return random.randomElement(DataLoader.getListData("animal", "orders"));
    }

    public String animalGenus() {
        return random.randomElement(DataLoader.getListData("animal", "genera"));
    }

    public String animalSpecies() {
        return random.randomElement(DataLoader.getListData("animal", "species"));
    }

    public static void main(String[] args) {
        AnimalProvider animalProvider = new AnimalProvider(new RandomService());
        System.out.println(animalProvider.animal());
        System.out.println(animalProvider.animalType());
        System.out.println(animalProvider.animalScientificName());
        System.out.println(animalProvider.animalFamily());
        System.out.println(animalProvider.animalKingdom());
        System.out.println(animalProvider.animalPhylum());
        System.out.println(animalProvider.animalClass());
        System.out.println(animalProvider.animalOrder());
        System.out.println(animalProvider.animalGenus());
        System.out.println(animalProvider.animalSpecies());
    }

}