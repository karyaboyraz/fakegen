package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import com.fakegen.util.RandomService;

import java.util.List;

public class AnimalProvider {
    private final RandomService random;
    private List<String> animals;
    private List<String> animalTypes;
    private List<String> animalScientificName;
    private List<String> animalFamilies;
    private List<String> animalKingdoms;
    private List<String> animalPhyla;
    private List<String> animalClasses;
    private List<String> animalOrders;
    private List<String> animalGenera;
    private List<String> animalSpecies;

    public AnimalProvider(RandomService random) {
        this.random = random;
    }

    public String animal() {
        animals = LazyLoader.load("animalNames", () -> DataLoader.getListData("animal", "animal_names"));
        return random.randomElement(animals);
    }

    public String animalType() {
        animalTypes = LazyLoader.load("animalTypes", () -> DataLoader.getListData("animal", "types"));
        return random.randomElement(animalTypes);
    }

    public String animalScientificName() {
        animalScientificName = LazyLoader.load("animalScienceName", () -> DataLoader.getListData("animal", "scientific_names"));
        return random.randomElement(animalScientificName);
    }

    public String animalFamily() {
        animalFamilies = LazyLoader.load("animalFamilies", () -> DataLoader.getListData("animal", "families"));
        return random.randomElement(animalFamilies);
    }

    public String animalKingdom() {
        animalKingdoms = LazyLoader.load("animalKingdoms", () -> DataLoader.getListData("animal", "kingdoms"));
        return random.randomElement(animalKingdoms);
    }

    public String animalPhylum() {
        animalPhyla = LazyLoader.load("animalPhyla", () -> DataLoader.getListData("animal", "phyla"));
        return random.randomElement(animalPhyla);
    }

    public String animalClass() {
        animalClasses = LazyLoader.load("animalClasses", () -> DataLoader.getListData("animal", "classes"));
        return random.randomElement(animalClasses);
    }

    public String animalOrder() {
        animalOrders = LazyLoader.load("animalOrders", () -> DataLoader.getListData("animal", "orders"));
        return random.randomElement(animalOrders);
    }

    public String animalGenus() {
        animalGenera = LazyLoader.load("animalGenera", () -> DataLoader.getListData("animal", "genera"));
        return random.randomElement(animalGenera);
    }

    public String animalSpecies() {
        animalSpecies = LazyLoader.load("animalSpecies", () -> DataLoader.getListData("animal", "species"));
        return random.randomElement(animalSpecies);
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