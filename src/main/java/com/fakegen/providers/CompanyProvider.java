package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class CompanyProvider {
    private final RandomService random;

    public CompanyProvider(RandomService random) {
        this.random = random;
    }

    public String name() {
        return random.randomElement(DataLoader.getListData("company", "names"));
    }

    public String suffix() {
        return random.randomElement(DataLoader.getListData("company", "suffixes"));
    }

    public String industry() {
        return random.randomElement(DataLoader.getListData("company", "industries"));
    }

    public String catchPhrase() {
    return random.randomElement(DataLoader.getListData("company", "catchPhrases"));
    }

    public String fullName() {
        return name() + " " + suffix();
    }
}
