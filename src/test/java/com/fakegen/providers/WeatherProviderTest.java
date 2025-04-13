package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherProviderTest {
    private WeatherProvider weatherProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        weatherProvider = new WeatherProvider(new RandomService());
    }

    @Test
    void getDescription_ShouldReturnValidDescription() {
        String description = weatherProvider.getDescription();
        assertNotNull(description);
        assertFalse(description.isEmpty());
    }

    @Test
    void temperatureCelsius_ShouldReturnValidTemperature() {
        String temperature = weatherProvider.temperatureCelsius();
        assertNotNull(temperature);
        assertFalse(temperature.isEmpty());
        assertTrue(temperature.matches("^-?\\d+ °C$"));
        
        int temp = Integer.parseInt(temperature.split(" ")[0]);
        assertTrue(temp >= -30 && temp <= 60);
    }

    @Test
    void temperatureCelsiusWithRange_ShouldReturnValidTemperature() {
        String temperature = weatherProvider.temperatureCelsius(-10, 30);
        assertNotNull(temperature);
        assertFalse(temperature.isEmpty());
        assertTrue(temperature.matches("^-?\\d+ °C$"));
        
        int temp = Integer.parseInt(temperature.split(" ")[0]);
        assertTrue(temp >= -10 && temp <= 30);
    }

    @Test
    void temperatureFahrenheit_ShouldReturnValidTemperature() {
        String temperature = weatherProvider.temperatureFahrenheit();
        assertNotNull(temperature);
        assertFalse(temperature.isEmpty());
        assertTrue(temperature.matches("^-?\\d+ °F$"));
        
        int temp = Integer.parseInt(temperature.split(" ")[0]);
        assertTrue(temp >= -22 && temp <= 100);
    }

    @Test
    void temperatureFahrenheitWithRange_ShouldReturnValidTemperature() {
        String temperature = weatherProvider.temperatureFahrenheit(0, 100);
        assertNotNull(temperature);
        assertFalse(temperature.isEmpty());
        assertTrue(temperature.matches("^-?\\d+ °F$"));
        
        int temp = Integer.parseInt(temperature.split(" ")[0]);
        assertTrue(temp >= 0 && temp <= 100);
    }

    @Test
    void getWindDirection_ShouldReturnValidDirection() {
        String direction = weatherProvider.getWindDirection();
        assertNotNull(direction);
        assertFalse(direction.isEmpty());
    }

    @Test
    void windSpeedKm_ShouldReturnValidSpeed() {
        String speed = weatherProvider.windSpeedKm();
        assertNotNull(speed);
        assertFalse(speed.isEmpty());
        assertTrue(speed.matches("^\\d+ km/h$"));
        
        int windSpeed = Integer.parseInt(speed.split(" ")[0]);
        assertTrue(windSpeed >= 0 && windSpeed <= 100);
    }

    @Test
    void windSpeedKmWithRange_ShouldReturnValidSpeed() {
        String speed = weatherProvider.windSpeedKm(0, 50);
        assertNotNull(speed);
        assertFalse(speed.isEmpty());
        assertTrue(speed.matches("^\\d+ km/h$"));
        
        int windSpeed = Integer.parseInt(speed.split(" ")[0]);
        assertTrue(windSpeed >= 0 && windSpeed <= 50);
    }

    @Test
    void windSpeedMph_ShouldReturnValidSpeed() {
        String speed = weatherProvider.windSpeedMph();
        assertNotNull(speed);
        assertFalse(speed.isEmpty());
        assertTrue(speed.matches("^\\d+ mph$"));
        
        int windSpeed = Integer.parseInt(speed.split(" ")[0]);
        assertTrue(windSpeed >= 0 && windSpeed <= 70);
    }

    @Test
    void windSpeedMphWithRange_ShouldReturnValidSpeed() {
        String speed = weatherProvider.windSpeedMph(0, 30);
        assertNotNull(speed);
        assertFalse(speed.isEmpty());
        assertTrue(speed.matches("^\\d+ mph$"));
        
        int windSpeed = Integer.parseInt(speed.split(" ")[0]);
        assertTrue(windSpeed >= 0 && windSpeed <= 30);
    }

    @Test
    void getRelativeHumidity_ShouldReturnValidHumidity() {
        String humidity = weatherProvider.getRelativeHumidity();
        assertNotNull(humidity);
        assertFalse(humidity.isEmpty());
        assertTrue(humidity.matches("^\\d+%$"));
        
        int humidityValue = Integer.parseInt(humidity.replace("%", ""));
        assertTrue(humidityValue >= 0 && humidityValue <= 100);
    }

    @Test
    void getAbsoluteHumidity_ShouldReturnValidHumidity() {
        String humidity = weatherProvider.getAbsoluteHumidity();
        assertNotNull(humidity);
        assertFalse(humidity.isEmpty());
        assertTrue(humidity.matches("^\\d+ g/m³$"));
        
        int humidityValue = Integer.parseInt(humidity.split(" ")[0]);
        assertTrue(humidityValue >= 0 && humidityValue <= 600);
    }
} 