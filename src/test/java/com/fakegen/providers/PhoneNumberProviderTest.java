package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberProviderTest {
    private PhoneNumberProvider phoneNumberProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        phoneNumberProvider = new PhoneNumberProvider(new RandomService());
    }

    @Test
    void phoneNumber_ShouldReturnValidFormat() {
        String phoneNumber = phoneNumberProvider.phoneNumber();
        assertNotNull(phoneNumber);
        assertFalse(phoneNumber.isEmpty());
        assertTrue(phoneNumber.matches("^\\+?[0-9\\s-()]+$"));
    }

    @Test
    void cellPhone_ShouldReturnValidFormat() {
        String cellPhone = phoneNumberProvider.cellPhone();
        assertNotNull(cellPhone);
        assertFalse(cellPhone.isEmpty());
        assertTrue(cellPhone.matches("^\\+?[0-9\\s-()]+$"));
    }

    @Test
    void landline_ShouldReturnValidFormat() {
        String landline = phoneNumberProvider.landline();
        assertNotNull(landline);
        assertFalse(landline.isEmpty());
        assertTrue(landline.matches("^\\+?[0-9\\s-()]+$"));
    }

    @Test
    void internationalPhoneFormat_ShouldReturnValidFormat() {
        String internationalPhone = phoneNumberProvider.internationalPhoneFormat();
        assertNotNull(internationalPhone);
        assertFalse(internationalPhone.isEmpty());
        assertTrue(internationalPhone.matches("^\\+[0-9]{1,3}[0-9\\s-()]+$"));
    }
} 