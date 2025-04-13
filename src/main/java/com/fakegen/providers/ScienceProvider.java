package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ScienceProvider {
    private final RandomService random;
    private final Map<String, List<String>> scienceData;

    public ScienceProvider(RandomService random) {
        this.random = random;
        this.scienceData = new HashMap<>();
    }

    private String get(String category) {
        if (!scienceData.containsKey(category)) {
            scienceData.put(category, LazyLoader.load("science" + category, () -> DataLoader.getListData("science", category)));
        }
        return random.randomElement(scienceData.get(category));
    }

    public String chemicalElement() {
        return get("elements");
    }

    public String chemicalSymbol() {
        return get("symbols");
    }

    public String chemicalFormula() {
        StringBuilder formula = new StringBuilder();
        String element = chemicalElement();
        String symbol = chemicalSymbol();
        
        // İlk harf büyük, sonraki harfler küçük
        formula.append(Character.toUpperCase(symbol.charAt(0)));
        if (symbol.length() > 1) {
            formula.append(Character.toLowerCase(symbol.charAt(1)));
        }
        
        // Rastgele sayı ekle (0-9 arası)
        if (random.nextBoolean()) {
            formula.append(random.nextInt(1, 9));
        }
        
        return formula.toString();
    }

    public String unit() {
        return get("units");
    }

    public String unitSymbol() {
        return get("unit_symbols");
    }

    public String unitPrefix() {
        return get("unit_prefixes");
    }

    public String unitPrefixSymbol() {
        return get("unit_prefix_symbols");
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