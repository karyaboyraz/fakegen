package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;
import com.fakegen.util.LazyLoader;
import java.util.List;

public class CompanyProvider {
    private final RandomService random;
    private List<String> companyNames;
    private List<String> companySuffixes;
    private List<String> companyIndustries;
    private List<String> companyCatchPhrases;

    public CompanyProvider(RandomService random) {
        this.random = random;
    }

    public String name() {
        companyNames = LazyLoader.load("companyNames", () -> DataLoader.getListData("company", "names"));
        return random.randomElement(companyNames);
    }

    public String suffix() {
        companySuffixes = LazyLoader.load("companySuffixes", () -> DataLoader.getListData("company", "suffixes"));
        return random.randomElement(companySuffixes);
    }

    public String industry() {
        companyIndustries = LazyLoader.load("companyIndustries", () -> DataLoader.getListData("company", "industries"));
        return random.randomElement(companyIndustries);
    }

    public String catchPhrase() {
        companyCatchPhrases = LazyLoader.load("companyCatchPhrases", () -> DataLoader.getListData("company", "catch_phrases"));
        return random.randomElement(companyCatchPhrases);
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
