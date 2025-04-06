package com.fakegen.providers;

import com.fakegen.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AddressProviderTest {
    private AddressProvider addressProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        addressProvider = new AddressProvider(new RandomService());
    }

    @Test
    void testDistrict() {
        String district = addressProvider.district();
        assertNotNull(district);
        assertFalse(district.isEmpty());
    }

    @Test
    void testDistrictOfCity() {
        String district = addressProvider.districtOfCity("İstanbul");
        assertNotNull(district);
        List<String> validDistricts = addressProvider.loadDataAsMap("address", "districts").get("İstanbul");
        assertTrue(validDistricts.contains(district), 
                String.format("District '%s' is not a valid district of İstanbul", district));
    }

    @Test
    void testDistrictOfCityInvalidCity() {
        assertThrows(IllegalArgumentException.class, () -> {
            addressProvider.districtOfCity("InvalidCity");
        });
    }

    @Test
    void testFullAddress() {
        String fullAddress = addressProvider.fullAddress();
        assertNotNull(fullAddress);
        
        // Adres formatını kontrol et
        String[] lines = fullAddress.split("\n");
        assertEquals(2, lines.length);
        
        // İlk satır: Sokak adresi
        assertTrue(lines[0].matches("\\d{4} [a-zA-Z]{5} (Sokak|Caddesi|Bulvarı|Yolu|Meydanı|Mahallesi|Çıkmazı|Geçidi|Köprüsü|Kavşağı)"));
        
        // İkinci satır: İl/İlçe, Ülke Posta Kodu
        String[] addressParts = lines[1].split(", ");
        assertEquals(2, addressParts.length);
        
        // İl/İlçe kontrolü
        String cityDistrict = addressParts[0];
        String[] parts = cityDistrict.split("/");
        assertEquals(2, parts.length, "City and district should be separated by '/'");
        
        // İl kontrolü
        String city = parts[0];
        List<String> validCities = addressProvider.loadDataAsList("address", "cities");
        assertTrue(validCities.contains(city), "Invalid city: " + city);
        
        // İlçe kontrolü - İlin ilçelerinden biri olmalı
        String district = parts[1];
        List<String> validDistricts = addressProvider.loadDataAsMap("address", "districts").get(city);
        assertTrue(validDistricts.contains(district),
                String.format("District '%s' is not a valid district of city '%s'", district, city));
        
        // Ülke ve posta kodu kontrolü
        assertTrue(addressParts[1].matches("Türkiye \\d{5}"));
    }

    @Test
    void testMultipleDistrictsForDifferentCities() {
        String ankaraDistrict = addressProvider.districtOfCity("Ankara");
        List<String> ankaraValidDistricts = addressProvider.loadDataAsMap("address", "districts").get("Ankara");
        assertTrue(ankaraValidDistricts.contains(ankaraDistrict),
                String.format("District '%s' is not a valid district of Ankara", ankaraDistrict));

        String izmirDistrict = addressProvider.districtOfCity("İzmir");
        List<String> izmirValidDistricts = addressProvider.loadDataAsMap("address", "districts").get("İzmir");
        assertTrue(izmirValidDistricts.contains(izmirDistrict),
                String.format("District '%s' is not a valid district of İzmir", izmirDistrict));
    }
}
