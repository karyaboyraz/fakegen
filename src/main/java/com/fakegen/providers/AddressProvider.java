package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import com.fakegen.util.RandomService;

import java.util.List;

/**
 * A provider class for generating fake address-related data.
 * This class provides methods to generate various components of addresses,
 * including street names, building numbers, postal codes, cities, and more.
 */
public class AddressProvider {
    private final RandomService random;
    private List<String> city;
    private List<String> countries;
    private List<String> streetSuffixes;
    private List<String> district;
    private List<String> streets;

    /**
     * Constructs a new AddressProvider with the specified RandomService.
     *
     * @param random The RandomService instance to use for generating random values
     */
    public AddressProvider(RandomService random) {
        this.random = random;
    }

    /**
     * Generates a random street name.
     *
     * @return A randomly selected street name
     */
    public String streetName() {
        streets = LazyLoader.load("addressStreets", () -> DataLoader.getListData("address", "streets"));
        return random.randomElement(streets);
    }

    /**
     * Generates a random building number between 1 and 50.
     *
     * @return A string representation of a building number
     */
    public String buildingNumber() {
        return String.valueOf(random.nextInt(1, 50));
    }

    /**
     * Generates a random 5-digit postal code.
     *
     * @return A string representation of a postal code
     */
    public String postalCode() {
        return String.format("%05d", random.nextInt(10000, 99999));
    }

    /**
     * Generates a random city name.
     *
     * @return A randomly selected city name
     */
    public String city() {
        city = LazyLoader.load("addressCities", () -> DataLoader.getListData("address", "cities"));
        return random.randomElement(city);
    }

    /**
     * Generates a random district name.
     *
     * @return A randomly selected district name
     */
    public String district() {
        district = LazyLoader.load("addressDistrict", () -> DataLoader.getListData("address", "districts"));
        return random.randomElement(district);
    }

    /**
     * Generates a random street suffix.
     *
     * @return A randomly selected street suffix
     */
    public String streetSuffix() {
        streetSuffixes = LazyLoader.load("addressStreetSuffix", () -> DataLoader.getListData("address", "street_suffixes"));
        return random.randomElement(streetSuffixes);
    }

    /**
     * Generates a complete address string including street, building number,
     * district, city, and postal code.
     *
     * @return A formatted string containing a complete address
     */
    public String fullAddress() {
        String buildingNo = buildingNumber();
        String street = streetName();
        String suffix = streetSuffix();
        String dist = district();
        String cityName = city();
        String postal = postalCode();
        
        return String.format("%s %s No:%s, %s/%s %s",
                street,
                suffix,
                buildingNo,
                dist,
                cityName,
                postal
        );
    }

    /**
     * Generates a street address consisting of a street number and street name.
     *
     * @return A string containing a street address
     */
    public String streetAddress() {
        return streetNumber() + " " + streetName();
    }

    /**
     * Generates a random street number between 1 and 999.
     *
     * @return A string representation of a street number
     */
    public String streetNumber() {
        return String.valueOf(random.nextInt(1, 999));
    }

    /**
     * Generates a random state name.
     *
     * @return A randomly selected state name
     */
    public String state() {
        List<String> states = LazyLoader.load("addressStates", () -> DataLoader.getListData("address", "states"));
        return random.randomElement(states);
    }

    /**
     * Generates a random country name.
     *
     * @return A randomly selected country name
     */
    public String country() {
        countries = LazyLoader.load("addressCountries", () -> DataLoader.getListData("address", "countries"));
        return random.randomElement(countries);
    }

    /**
     * Generates a random 5-digit ZIP code.
     *
     * @return A string representation of a ZIP code
     */
    public String zipCode() {
        return random.randomize("#####");
    }

    /**
     * Generates a random latitude value between -90 and 90 degrees.
     *
     * @return A string representation of a latitude value with 6 decimal places
     */
    public String latitude() {
        return String.format("%.6f", random.nextDouble(-90, 90));
    }

    /**
     * Generates a random longitude value between -180 and 180 degrees.
     *
     * @return A string representation of a longitude value with 6 decimal places
     */
    public String longitude() {
        return String.format("%.6f", random.nextDouble(-180, 180));
    }

    /**
     * Generates a pair of coordinates in the format "latitude, longitude".
     *
     * @return A string containing both latitude and longitude values
     */
    public String coordinates() {
        return String.format("%s, %s", latitude(), longitude());
    }

    /**
     * Generates a random time zone identifier.
     *
     * @return A randomly selected time zone identifier
     */
    public String timeZone() {
        List<String> timeZones = LazyLoader.load("addressTimeZones", () -> DataLoader.getListData("address", "time_zones"));
        return random.randomElement(timeZones);
    }

    /**
     * Generates a random country code.
     *
     * @return A randomly selected country code
     */
    public String countryCode() {
        List<String> countryCodes = LazyLoader.load("addressCountryCodes", () -> DataLoader.getListData("address", "country_codes"));
        return random.randomElement(countryCodes);
    }
}
