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
    return random.randomElement(DataLoader.getListData("company", "catch_phrases"));
    }

    public String fullName() {
        return name() + " " + suffix();
    }

    public static void main(String[] args) {
        CompanyProvider companyProvider = new CompanyProvider(new RandomService());
        System.out.println("Company Name: " + companyProvider.name());
        System.out.println("Company Suffix: " + companyProvider.suffix());
        System.out.println("Company Industry: " + companyProvider.industry());
        System.out.println("Company Catch Phrase: " + companyProvider.catchPhrase());
        System.out.println("Full Company Name: " + companyProvider.fullName());
    }
}
