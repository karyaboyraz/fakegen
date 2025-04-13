package com.fakegen;

import com.fakegen.locale.FakerLocale;
import com.fakegen.providers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FakeGenTest {
    private FakeGen fakeGen;

    @BeforeEach
    void setUp() {
        fakeGen = new FakeGen(FakerLocale.TR_TR);
    }

    @Test
    void constructor_ShouldInitializeWithDefaultLocale() {
        FakeGen defaultFakeGen = new FakeGen();
        assertNotNull(defaultFakeGen);
    }

    @Test
    void constructor_ShouldInitializeWithSpecifiedLocale() {
        FakeGen customFakeGen = new FakeGen(FakerLocale.EN_US);
        assertNotNull(customFakeGen);
    }

    @Test
    void address_ShouldReturnAddressProvider() {
        AddressProvider provider = fakeGen.address();
        assertNotNull(provider);
        assertTrue(provider instanceof AddressProvider);
    }

    @Test
    void name_ShouldReturnNameProvider() {
        NameProvider provider = fakeGen.name();
        assertNotNull(provider);
        assertTrue(provider instanceof NameProvider);
    }

    @Test
    void company_ShouldReturnCompanyProvider() {
        CompanyProvider provider = fakeGen.company();
        assertNotNull(provider);
        assertTrue(provider instanceof CompanyProvider);
    }

    @Test
    void internet_ShouldReturnInternetProvider() {
        InternetProvider provider = fakeGen.internet();
        assertNotNull(provider);
        assertTrue(provider instanceof InternetProvider);
    }

    @Test
    void book_ShouldReturnBookProvider() {
        BookProvider provider = fakeGen.book();
        assertNotNull(provider);
        assertTrue(provider instanceof BookProvider);
    }

    @Test
    void color_ShouldReturnColorProvider() {
        ColorProvider provider = fakeGen.color();
        assertNotNull(provider);
        assertTrue(provider instanceof ColorProvider);
    }

    @Test
    void food_ShouldReturnFoodProvider() {
        FoodProvider provider = fakeGen.food();
        assertNotNull(provider);
        assertTrue(provider instanceof FoodProvider);
    }

    @Test
    void music_ShouldReturnMusicProvider() {
        MusicProvider provider = fakeGen.music();
        assertNotNull(provider);
        assertTrue(provider instanceof MusicProvider);
    }

    @Test
    void phoneNumber_ShouldReturnPhoneNumberProvider() {
        PhoneNumberProvider provider = fakeGen.phoneNumber();
        assertNotNull(provider);
        assertTrue(provider instanceof PhoneNumberProvider);
    }

    @Test
    void weather_ShouldReturnWeatherProvider() {
        WeatherProvider provider = fakeGen.weather();
        assertNotNull(provider);
        assertTrue(provider instanceof WeatherProvider);
    }

    @Test
    void film_ShouldReturnFilmProvider() {
        FilmProvider provider = fakeGen.film();
        assertNotNull(provider);
        assertTrue(provider instanceof FilmProvider);
    }

    @Test
    void animal_ShouldReturnAnimalProvider() {
        AnimalProvider provider = fakeGen.animal();
        assertNotNull(provider);
        assertTrue(provider instanceof AnimalProvider);
    }

    @Test
    void vehicle_ShouldReturnVehicleProvider() {
        VehicleProvider provider = fakeGen.vehicle();
        assertNotNull(provider);
        assertTrue(provider instanceof VehicleProvider);
    }
} 