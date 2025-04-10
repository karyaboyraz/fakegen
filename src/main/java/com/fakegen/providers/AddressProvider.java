package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;
import java.text.Normalizer;

public class AddressProvider {
    private final RandomService random;
    private final List<String> cities;
    private final List<String> countries;
    private final List<String> streetSuffixes;
    private final Map<String, List<String>> districts;
    private final Map<String, List<String>> plateCode;

    public AddressProvider(RandomService random) {
        this.random = random;
        this.cities = DataLoader.getListData("address", "cities");
        this.countries = DataLoader.getListData("address", "countries");
        this.streetSuffixes = DataLoader.getListData("address", "street_suffixes");
        this.districts = DataLoader.getMapData("address", "districts", new TypeReference<Map<String, List<String>>>() {});
        this.plateCode = DataLoader.getMapData("address", "plate_codes", new TypeReference<Map<String, List<String>>>() {});
    }

    public String streetName() {
        return random.randomElement(DataLoader.getListData("address", "streets"));
    }

    public String buildingNumber() {
        return String.valueOf(random.nextInt(1, 50));
    }

    public String postalCode() {
        return random.randomElement(DataLoader.getListData("address", "postal_codes"));
    }

    public String city() {
        return random.randomElement(cities);
    }

    public String district() {
        return random.randomElement(DataLoader.getListData("address", "districts"));
    }

    public String streetSuffix() {
        return random.randomElement(streetSuffixes);
    }

    public String fullAddress() {
        return String.format("%s %s %s, %s %s %s",
            streetName(),
            streetSuffix(),
            buildingNumber(),
            district(),
            city(),
            postalCode()
        );
    }

    public String streetAddress() {
        return streetNumber() + " " + streetName();
    }

    public String streetNumber() {
        return String.valueOf(random.nextInt(1, 999));
    }

    public String state() {
        return random.randomElement(DataLoader.getListData("address", "states"));
    }

    public String country() {
        return random.randomElement(countries);
    }

    public String zipCode() {
        return random.numerify("#####");
    }

    public String plateCode(String city) {
        String normalizedCity = Normalizer.normalize(city, Normalizer.Form.NFD)
                                    .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                                    .toLowerCase();

        for (Map.Entry<String, List<String>> entry : plateCode.entrySet()) {
            String keyNormalized = Normalizer.normalize(entry.getKey(), Normalizer.Form.NFD)
                                    .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                                    .toLowerCase();
            if (keyNormalized.equals(normalizedCity)) {
                List<String> cityPlateCode = entry.getValue();
                if (cityPlateCode != null && !cityPlateCode.isEmpty()) {
                    return random.randomElement(cityPlateCode);
                }
            }
        }

        throw new IllegalArgumentException("No plate codes found for city: " + city);
    }

    public String districtOfCity(String city) {
        List<String> cityDistricts = districts.get(city);
        if (cityDistricts == null || cityDistricts.isEmpty()) {
            throw new IllegalArgumentException("No districts found for city: " + city);
        }
        return random.randomElement(cityDistricts);
    }

    public String latitude() {
        return String.format("%.6f", random.nextDouble(-90, 90));
    }

    public String longitude() {
        return String.format("%.6f", random.nextDouble(-180, 180));
    }

    public String coordinates() {
        return String.format("%s, %s", latitude(), longitude());
    }

    public String timeZone() {
        return random.randomElement(DataLoader.getListData("address", "time_zones"));
    }

    public String countryCode() {
        return random.randomElement(DataLoader.getListData("address", "country_codes"));
    }

    public Map<String, List<String>> loadDataAsMap(String path) {
        return DataLoader.getMapData("address", path, new TypeReference<Map<String, List<String>>>() {});
    }

    public List<String> loadDataAsList(String path) {
        return DataLoader.getListData("address", path);
    }
}
