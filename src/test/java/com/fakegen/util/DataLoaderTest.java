package com.fakegen.util;

import com.fakegen.locale.FakerLocale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataLoaderTest {

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
    }

    @Test
    void loadYamlData_ShouldLoadAddressData() {
        Map<String, Object> data = DataLoader.loadYamlData("address");
        assertNotNull(data);
        assertTrue(data.containsKey("cities"));
        assertTrue(data.containsKey("districts"));
        assertTrue(data.containsKey("streets"));
    }

    @Test
    void getListData_ShouldReturnCities() {
        List<String> cities = DataLoader.getListData("address", "cities");
        assertNotNull(cities);
        assertFalse(cities.isEmpty());
        assertTrue(cities.contains("İstanbul"));
    }

    @Test
    void getListData_ShouldReturnDistricts() {
        List<String> districts = DataLoader.getListData("address", "districts");
        assertNotNull(districts);
        assertFalse(districts.isEmpty());
        assertTrue(districts.contains("Kadıköy"));
    }

    @Test
    void getListData_ShouldReturnStreets() {
        List<String> streets = DataLoader.getListData("address", "streets");
        assertNotNull(streets);
        assertFalse(streets.isEmpty());
        assertTrue(streets.contains("Atatürk"));
    }

    @Test
    void getListData_ShouldThrowExceptionForInvalidCategory() {
        assertThrows(RuntimeException.class, () -> DataLoader.getListData("invalid", "cities"));
    }

    @Test
    void getListData_ShouldThrowExceptionForInvalidField() {
        assertThrows(RuntimeException.class, () -> DataLoader.getListData("address", "invalid"));
    }

    @Test
    void setLocale_ShouldChangeLocale() {
        DataLoader.setLocale(FakerLocale.EN_US);
        assertEquals(FakerLocale.EN_US, DataLoader.getCurrentLocale());
    }

    @Test
    void getAlphabet_ShouldReturnAlphabet() {
        String alphabet = DataLoader.getAlphabet();
        assertNotNull(alphabet);
        assertEquals(26, alphabet.length());
        assertTrue(alphabet.contains("A"));
        assertTrue(alphabet.contains("Z"));
    }

    @Test
    void getNumeric_ShouldReturnNumeric() {
        String numeric = DataLoader.getNumeric();
        assertNotNull(numeric);
        assertEquals(10, numeric.length());
        assertTrue(numeric.contains("0"));
        assertTrue(numeric.contains("9"));
    }

    @Test
    void getSampleCharacters_ShouldReturnSampleCharacters() {
        String sampleCharacters = DataLoader.getSampleCharacters();
        assertNotNull(sampleCharacters);
        assertTrue(sampleCharacters.contains("!"));
        assertTrue(sampleCharacters.contains("@"));
        assertTrue(sampleCharacters.contains("#"));
    }
} 