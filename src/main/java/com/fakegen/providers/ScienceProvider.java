package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;

public class ScienceProvider {
    private final RandomService random;

    public ScienceProvider(RandomService random) {
        this.random = random;
    }

    public String chemicalElement() {
        return random.randomElement(DataLoader.getListData("science", "elements"));
    }

    public String chemicalSymbol() {
        return random.randomElement(DataLoader.getListData("science", "symbols"));
    }

    public String chemicalFormula() {
        return random.randomElement(DataLoader.getListData("science", "formulas"));
    }

    public String unit() {
        return random.randomElement(DataLoader.getListData("science", "units"));
    }

    public String unitSymbol() {
        return random.randomElement(DataLoader.getListData("science", "unit_symbols"));
    }

    public String unitPrefix() {
        return random.randomElement(DataLoader.getListData("science", "unit_prefixes"));
    }

    public String unitPrefixSymbol() {
        return random.randomElement(DataLoader.getListData("science", "unit_prefix_symbols"));
    }

    public String unitWithPrefix() {
        return String.format("%s%s",
            unitPrefix(),
            unit()
        );
    }

    public String unitSymbolWithPrefix() {
        return String.format("%s%s",
            unitPrefixSymbol(),
            unitSymbol()
        );
    }

    public static void main(String[] args) {
        ScienceProvider scienceProvider = new ScienceProvider(new RandomService());
        System.out.println("Chemical Element: " + scienceProvider.chemicalElement());
        System.out.println("Chemical Symbol: " + scienceProvider.chemicalSymbol());
        System.out.println("Chemical Formula: " + scienceProvider.chemicalFormula());
        System.out.println("Unit: " + scienceProvider.unit());
        System.out.println("Unit Symbol: " + scienceProvider.unitSymbol());
        System.out.println("Unit Prefix: " + scienceProvider.unitPrefix());
        System.out.println("Unit Prefix Symbol: " + scienceProvider.unitPrefixSymbol());
        System.out.println("Unit with Prefix: " + scienceProvider.unitWithPrefix());
        System.out.println("Unit Symbol with Prefix: " + scienceProvider.unitSymbolWithPrefix());
        
    }
} 