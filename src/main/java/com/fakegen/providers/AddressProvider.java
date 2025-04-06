package com.fakegen.providers;

import com.fakegen.RandomService;
import com.fakegen.util.DataLoader;
import java.util.List;
import java.util.Map;

public class AddressProvider {
    private final RandomService random;
    private final List<String> cities;
    private final List<String> countries;
    private final List<String> streetSuffixes;
    private final Map<String, List<String>> districts;

    public AddressProvider(RandomService random) {
        this.random = random;
        this.cities = DataLoader.loadData("address", "cities");
        this.countries = DataLoader.loadData("address", "countries");
        this.streetSuffixes = DataLoader.loadData("address", "street_suffixes");
        this.districts = DataLoader.loadDataAsMap("address", "districts");
    }

    public String streetAddress() {
        return random.numerify("####") + " " + 
               random.letterify("?????") + " " + 
               random.nextElement(streetSuffixes);
    }

    public String city() {
        return random.nextElement(cities);
    }

    public String country() {
        return random.nextElement(countries);
    }

    public String zipCode() {
        return random.numerify("#####");
    }

    public String district() {
        String selectedCity = city();
        return districtOfCity(selectedCity);
    }

    public String districtOfCity(String city) {
        List<String> cityDistricts = districts.get(city);
        if (cityDistricts == null || cityDistricts.isEmpty()) {
            throw new IllegalArgumentException("No districts found for city: " + city);
        }
        return random.nextElement(cityDistricts);
    }

    public Map<String, List<String>> loadDataAsMap(String category, String subCategory) {
        return DataLoader.loadDataAsMap(category, subCategory);
    }

    public List<String> loadDataAsList(String category, String subCategory) {
        return DataLoader.loadData(category, subCategory);
    }

    public String fullAddress() {
        String selectedCity = city();
        return String.format("%s\n%s/%s, %s %s",
            streetAddress(),
            selectedCity,
            districtOfCity(selectedCity),
            "Türkiye",
            zipCode()
        );
    }
}
