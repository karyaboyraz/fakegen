package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class AddressProviderTest {
    private AddressProvider addressProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        addressProvider = new AddressProvider(new RandomService());
    }

    @RepeatedTest(20)
    void streetName_ShouldReturnValidStreetName() {
        String streetName = addressProvider.streetName();
        assertNotNull(streetName);
        assertFalse(streetName.isEmpty());
    }

    @RepeatedTest(20)
    void buildingNumber_ShouldReturnValidNumber() {
        String buildingNumber = addressProvider.buildingNumber();
        assertNotNull(buildingNumber);
        assertTrue(buildingNumber.matches("\\d+"));
        int number = Integer.parseInt(buildingNumber);
        assertTrue(number >= 1 && number <= 50);
    }

    @RepeatedTest(20)
    void postalCode_ShouldReturnValidPostalCode() {
        String postalCode = addressProvider.postalCode();
        assertNotNull(postalCode);
        assertTrue(postalCode.matches("\\d{5}"));
    }

    @RepeatedTest(20)
    void city_ShouldReturnValidCity() {
        String city = addressProvider.city();
        assertNotNull(city);
        assertFalse(city.isEmpty());
    }

    @RepeatedTest(20)
    void district_ShouldReturnValidDistrict() {
        String district = addressProvider.district();
        assertNotNull(district);
        assertFalse(district.isEmpty());
    }

    @RepeatedTest(20)
    void streetSuffix_ShouldReturnValidSuffix() {
        String suffix = addressProvider.streetSuffix();
        assertNotNull(suffix);
        assertFalse(suffix.isEmpty());
    }

    @RepeatedTest(20)
    void fullAddress_ShouldReturnValidFormat() {
        String fullAddress = addressProvider.fullAddress();
        assertNotNull(fullAddress);
        assertFalse(fullAddress.isEmpty());
        assertTrue(fullAddress.contains(","));
        assertTrue(fullAddress.contains("/"));
    }

    @RepeatedTest(20)
    void streetAddress_ShouldReturnValidFormat() {
        String streetAddress = addressProvider.streetAddress();
        assertNotNull(streetAddress);
        assertFalse(streetAddress.isEmpty());
        assertTrue(streetAddress.matches("\\d+ .+"));
    }

    @RepeatedTest(20)
    void streetNumber_ShouldReturnValidNumber() {
        String streetNumber = addressProvider.streetNumber();
        assertNotNull(streetNumber);
        assertTrue(streetNumber.matches("\\d+"));
        int number = Integer.parseInt(streetNumber);
        assertTrue(number >= 1 && number <= 999);
    }

    @RepeatedTest(20)
    void state_ShouldReturnValidState() {
        String state = addressProvider.state();
        assertNotNull(state);
        assertFalse(state.isEmpty());
    }

    @RepeatedTest(20)
    void country_ShouldReturnValidCountry() {
        String country = addressProvider.country();
        assertNotNull(country);
        assertFalse(country.isEmpty());
    }

    @RepeatedTest(20)
    void zipCode_ShouldReturnValidFormat() {
        String zipCode = addressProvider.zipCode();
        assertNotNull(zipCode);
        assertTrue(zipCode.matches("\\d{5}"));
    }

    @RepeatedTest(20)
    void latitude_ShouldReturnValidFormat() {
        String latitude = addressProvider.latitude();
        assertNotNull(latitude);
        assertTrue(latitude.matches("-?\\d+\\.\\d{6}"));
        double lat = Double.parseDouble(latitude);
        assertTrue(lat >= -90 && lat <= 90);
    }

    @RepeatedTest(20)
    void longitude_ShouldReturnValidFormat() {
        String longitude = addressProvider.longitude();
        assertNotNull(longitude);
        assertTrue(longitude.matches("-?\\d+\\.\\d{6}"));
        double lon = Double.parseDouble(longitude);
        assertTrue(lon >= -180 && lon <= 180);
    }

    @RepeatedTest(20)
    void coordinates_ShouldReturnValidFormat() {
        String coordinates = addressProvider.coordinates();
        assertNotNull(coordinates);
        assertTrue(coordinates.matches("-?\\d+\\.\\d{6}, -?\\d+\\.\\d{6}"));
    }
} 