package com.fakegen;

import com.fakegen.locale.FakerLocale;
import com.fakegen.providers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class FakeGenTest {
    private FakeGen fakeGen;

    @BeforeEach
    void setUp() {
        fakeGen = new FakeGen(FakerLocale.TR_TR);
    }

    @RepeatedTest(20)
    void constructor_ShouldInitializeWithDefaultLocale() {
        FakeGen defaultFakeGen = new FakeGen();
        assertNotNull(defaultFakeGen);
    }

    @RepeatedTest(20)
    void constructor_ShouldInitializeWithSpecifiedLocale() {
        FakeGen customFakeGen = new FakeGen(FakerLocale.EN_US);
        assertNotNull(customFakeGen);
    }

    @RepeatedTest(20)
    void address_ShouldReturnAddressProvider() {
        AddressProvider provider = fakeGen.address();
        assertNotNull(provider);
        assertTrue(provider instanceof AddressProvider);
    }

    @RepeatedTest(20)
    void name_ShouldReturnNameProvider() {
        NameProvider provider = fakeGen.name();
        assertNotNull(provider);
        assertTrue(provider instanceof NameProvider);
    }

    @RepeatedTest(20)
    void company_ShouldReturnCompanyProvider() {
        CompanyProvider provider = fakeGen.company();
        assertNotNull(provider);
        assertTrue(provider instanceof CompanyProvider);
    }

    @RepeatedTest(20)
    void internet_ShouldReturnInternetProvider() {
        InternetProvider provider = fakeGen.internet();
        assertNotNull(provider);
        assertTrue(provider instanceof InternetProvider);
    }

    @RepeatedTest(20)
    void book_ShouldReturnBookProvider() {
        BookProvider provider = fakeGen.book();
        assertNotNull(provider);
        assertTrue(provider instanceof BookProvider);
    }

    @RepeatedTest(20)
    void color_ShouldReturnColorProvider() {
        ColorProvider provider = fakeGen.color();
        assertNotNull(provider);
        assertTrue(provider instanceof ColorProvider);
    }

    @RepeatedTest(20)
    void food_ShouldReturnFoodProvider() {
        FoodProvider provider = fakeGen.food();
        assertNotNull(provider);
        assertTrue(provider instanceof FoodProvider);
    }

    @RepeatedTest(20)
    void music_ShouldReturnMusicProvider() {
        MusicProvider provider = fakeGen.music();
        assertNotNull(provider);
        assertTrue(provider instanceof MusicProvider);
    }

    @RepeatedTest(20)
    void phoneNumber_ShouldReturnPhoneNumberProvider() {
        PhoneNumberProvider provider = fakeGen.phoneNumber();
        assertNotNull(provider);
        assertTrue(provider instanceof PhoneNumberProvider);
    }

    @RepeatedTest(20)
    void weather_ShouldReturnWeatherProvider() {
        WeatherProvider provider = fakeGen.weather();
        assertNotNull(provider);
        assertTrue(provider instanceof WeatherProvider);
    }

    @RepeatedTest(20)
    void film_ShouldReturnFilmProvider() {
        FilmProvider provider = fakeGen.film();
        assertNotNull(provider);
        assertTrue(provider instanceof FilmProvider);
    }

    @RepeatedTest(20)
    void animal_ShouldReturnAnimalProvider() {
        AnimalProvider provider = fakeGen.animal();
        assertNotNull(provider);
        assertTrue(provider instanceof AnimalProvider);
    }

    @RepeatedTest(20)
    void vehicle_ShouldReturnVehicleProvider() {
        VehicleProvider provider = fakeGen.vehicle();
        assertNotNull(provider);
        assertTrue(provider instanceof VehicleProvider);
    }
} 