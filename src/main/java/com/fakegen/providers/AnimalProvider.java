package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;

public class AnimalProvider {
    private final RandomService random;
    private final List<String> animals;
    private final List<String> animalTypes;
    private final List<String> animalNames;
    private final Map<String, List<String>> animalSounds;
    private final Map<String, List<String>> animalHabitats;

    public AnimalProvider(RandomService random) {
        this.random = random;
        this.animals = DataLoader.getListData("animal", "animals");
        this.animalTypes = DataLoader.getListData("animal", "types");
        this.animalNames = DataLoader.getListData("animal", "names");
        this.animalSounds = DataLoader.getMapData("animal", "sounds", new TypeReference<Map<String, List<String>>>() {});
        this.animalHabitats = DataLoader.getMapData("animal", "habitats", new TypeReference<Map<String, List<String>>>() {});
    }

    public String animal() {
        return random.randomElement(animals);
    }

    public String animalType() {
        return random.randomElement(animalTypes);
    }

    public String animalName() {
        return random.randomElement(animalNames);
    }

    public String animalSound(String animal) {
        List<String> sounds = animalSounds.get(animal);
        if (sounds == null || sounds.isEmpty()) {
            throw new IllegalArgumentException("No sounds found for animal: " + animal);
        }
        return random.randomElement(sounds);
    }

    public String animalHabitat(String animal) {
        List<String> habitats = animalHabitats.get(animal);
        if (habitats == null || habitats.isEmpty()) {
            throw new IllegalArgumentException("No habitats found for animal: " + animal);
        }
        return random.randomElement(habitats);
    }

    public String animalScientificName(String animal) {
        return random.randomElement(DataLoader.getListData("animal", "scientific_names"));
    }

    public String animalFamily(String animal) {
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
        System.out.println(animalProvider.animalScientificName("Dog"));
        System.out.println(animalProvider.animalFamily("Dog"));
        System.out.println(animalProvider.animalKingdom());
        System.out.println(animalProvider.animalPhylum());


    }
}