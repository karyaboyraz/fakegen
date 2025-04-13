package com.fakegen.util;

import com.fakegen.locale.FakerLocale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataLoaderTest {
    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
    }

    @RepeatedTest(20)
    void getListData_ShouldReturnCities() {
        List<String> cities = DataLoader.getListData("address", "cities");
        assertNotNull(cities);
        assertFalse(cities.isEmpty());
        assertTrue(cities.contains("İstanbul"));
    }

    @RepeatedTest(20)
    void getListData_ShouldReturnDistricts() {
        List<String> districts = DataLoader.getListData("address", "districts");
        assertNotNull(districts);
        assertFalse(districts.isEmpty());
        assertTrue(districts.contains("Kadıköy"));
    }

    @RepeatedTest(20)
    void getListData_ShouldReturnStreets() {
        List<String> streets = DataLoader.getListData("address", "streets");
        assertNotNull(streets);
        assertFalse(streets.isEmpty());
        assertTrue(streets.contains("Atatürk"));
    }

    @RepeatedTest(20)
    void getListData_ShouldThrowExceptionForInvalidCategory() {
        assertThrows(RuntimeException.class, () -> DataLoader.getListData("invalid", "cities"));
    }

    @RepeatedTest(20)
    void getListData_ShouldThrowExceptionForInvalidField() {
        assertThrows(RuntimeException.class, () -> DataLoader.getListData("address", "invalid"));
    }

    @RepeatedTest(20)
    void setLocale_ShouldChangeLocale() {
        DataLoader.setLocale(FakerLocale.EN_US);
        assertEquals(FakerLocale.EN_US, DataLoader.getCurrentLocale());
    }
} 