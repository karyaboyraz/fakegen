package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressProviderTest {
    private AddressProvider addressProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        addressProvider = new AddressProvider(new RandomService());
    }

    @Test
    void streetName_ShouldReturnValidStreetName() {
        String streetName = addressProvider.streetName();
        assertNotNull(streetName);
        assertFalse(streetName.isEmpty());
    }

    @Test
    void buildingNumber_ShouldReturnValidNumber() {
        String buildingNumber = addressProvider.buildingNumber();
        assertNotNull(buildingNumber);
        assertTrue(buildingNumber.matches("\\d+"));
        int number = Integer.parseInt(buildingNumber);
        assertTrue(number >= 1 && number <= 50);
    }

    @Test
    void postalCode_ShouldReturnValidPostalCode() {
        String postalCode = addressProvider.postalCode();
        assertNotNull(postalCode);
        assertTrue(postalCode.matches("\\d{5}"));
    }

    @Test
    void city_ShouldReturnValidCity() {
        String city = addressProvider.city();
        assertNotNull(city);
        assertFalse(city.isEmpty());
    }

    @Test
    void district_ShouldReturnValidDistrict() {
        String district = addressProvider.district();
        assertNotNull(district);
        assertFalse(district.isEmpty());
    }

    @Test
    void streetSuffix_ShouldReturnValidSuffix() {
        String suffix = addressProvider.streetSuffix();
        assertNotNull(suffix);
        assertFalse(suffix.isEmpty());
    }

    @Test
    void fullAddress_ShouldReturnValidFormat() {
        String fullAddress = addressProvider.fullAddress();
        assertNotNull(fullAddress);
        assertFalse(fullAddress.isEmpty());
        assertTrue(fullAddress.contains(","));
        assertTrue(fullAddress.contains("/"));
    }

    @Test
    void streetAddress_ShouldReturnValidFormat() {
        String streetAddress = addressProvider.streetAddress();
        assertNotNull(streetAddress);
        assertFalse(streetAddress.isEmpty());
        assertTrue(streetAddress.matches("\\d+ .+"));
    }

    @Test
    void streetNumber_ShouldReturnValidNumber() {
        String streetNumber = addressProvider.streetNumber();
        assertNotNull(streetNumber);
        assertTrue(streetNumber.matches("\\d+"));
        int number = Integer.parseInt(streetNumber);
        assertTrue(number >= 1 && number <= 999);
    }

    @Test
    void state_ShouldReturnValidState() {
        String state = addressProvider.state();
        assertNotNull(state);
        assertFalse(state.isEmpty());
    }

    @Test
    void country_ShouldReturnValidCountry() {
        String country = addressProvider.country();
        assertNotNull(country);
        assertFalse(country.isEmpty());
    }

    @Test
    void zipCode_ShouldReturnValidFormat() {
        String zipCode = addressProvider.zipCode();
        assertNotNull(zipCode);
        assertTrue(zipCode.matches("\\d{5}"));
    }

    @Test
    void latitude_ShouldReturnValidFormat() {
        String latitude = addressProvider.latitude();
        assertNotNull(latitude);
        assertTrue(latitude.matches("-?\\d+\\.\\d{6}"));
        double lat = Double.parseDouble(latitude);
        assertTrue(lat >= -90 && lat <= 90);
    }

    @Test
    void longitude_ShouldReturnValidFormat() {
        String longitude = addressProvider.longitude();
        assertNotNull(longitude);
        assertTrue(longitude.matches("-?\\d+\\.\\d{6}"));
        double lon = Double.parseDouble(longitude);
        assertTrue(lon >= -180 && lon <= 180);
    }

    @Test
    void coordinates_ShouldReturnValidFormat() {
        String coordinates = addressProvider.coordinates();
        assertNotNull(coordinates);
        assertTrue(coordinates.matches("-?\\d+\\.\\d{6}, -?\\d+\\.\\d{6}"));
    }
} 