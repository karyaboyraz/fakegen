package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import com.fakegen.util.RandomService;

import java.util.List;

public class AddressProvider {
    private final RandomService random;
    private List<String> city;
    private List<String> countries;
    private List<String> streetSuffixes;
    private List<String> district;
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
        return random.randomize(postCodeFormat);
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
        List<String> states = LazyLoader.load("addressStates", () -> DataLoader.getListData("address", "states"));
        return random.randomElement(states);
    }

    public String country() {
        countries = LazyLoader.load("addressCountries", () -> DataLoader.getListData("address", "countries"));
        return random.randomElement(countries);
    }

    public String zipCode() {
        return random.randomize("#####");
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
        List<String> timeZones = LazyLoader.load("addressTimeZones", () -> DataLoader.getListData("address", "time_zones"));
        return random.randomElement(timeZones);
    }

    public String countryCode() {
        List<String> countryCodes = LazyLoader.load("addressCountryCodes", () -> DataLoader.getListData("address", "country_codes"));
        return random.randomElement(countryCodes);
    }


}
