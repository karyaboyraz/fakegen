package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import com.fakegen.util.RandomService;
import com.fasterxml.jackson.core.type.TypeReference;

import java.text.Normalizer;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressProvider {
    private final RandomService random;
    private List<String> city;
    private List<String> countries;
    private List<String> streetSuffixes;
    private List<String> district;
    private List<String> plateCode;
    private List<String> postalCode;
    private List<String> streets;

    public AddressProvider(RandomService random) {
        this.random = random;
    }

    public String streetName() {
        streets = LazyLoader.load("addressStreets", () -> DataLoader.getListData("address", "streets"));
        return random.randomElement(streets);
    }

    public String buildingNumber() {
        return String.valueOf(random.nextInt(1, 50));
    }

    public String postalCode() {
        postalCode = LazyLoader.load("addressPostalCode", () -> DataLoader.getListData("address", "postal_codes"));
        String postCodeFormat = random.randomElement(postalCode);
        return random.formatNumber(postCodeFormat);
    }

    public String city() {
        city = LazyLoader.load("addressCities", () -> DataLoader.getListData("address", "cities"));
        return random.randomElement(city);
    }

    public String district() {
        district = LazyLoader.load("addressDistrict", () -> DataLoader.getListData("address", "districts"));
        return random.randomElement(district);
    }

    public String streetSuffix() {
        streetSuffixes = LazyLoader.load("addressStreetSuffix", () -> DataLoader.getListData("address", "street_suffixes"));
        return random.randomElement(streetSuffixes);
    }

    public String fullAddress() {
        return String.format("%s %s %s, %s/%s %s",
                streetName(),
                streetSuffix(),
                buildingNumber(),
                district(),
                city(),
                postalCode()
        );
    }

    public static void main(String[] args) {
        AddressProvider addressProvider = new AddressProvider(new RandomService());
        System.out.println(addressProvider.fullAddress());
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
}
