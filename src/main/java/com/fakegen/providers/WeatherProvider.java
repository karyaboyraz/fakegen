package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class WeatherProvider {
    private static final int DEFAULT_MIN_TEMP_C = -30;
    private static final int DEFAULT_MAX_TEMP_C = 60;
    private static final int DEFAULT_MIN_TEMP_F = -22;
    private static final int DEFAULT_MAX_TEMP_F = 100;
    private static final int DEFAULT_MIN_WIND_SPEED_KM = 0;
    private static final int DEFAULT_MAX_WIND_SPEED_KM = 100;
    private static final int DEFAULT_MIN_WIND_SPEED_MPH = 0;
    private static final int DEFAULT_MAX_WIND_SPEED_MPH = 70;

    private static final String CELCIUS_PARAM = " °C";
    private static final String FAHRENHEIT_PARAM = " °F";
    private static final String KM_PARAM = " km/h";
    private static final String MPH_PARAM = " mph";

    private final RandomService random;

    public WeatherProvider(RandomService random) {
        this.random = random;
    }

    public String getDescription() {
        return random.randomElement(DataLoader.getListData("weather", "descriptions"));
    }

    public String temperatureCelsius() {
        return temperature(DEFAULT_MIN_TEMP_C, DEFAULT_MAX_TEMP_C, CELCIUS_PARAM);
    }

    public String temperatureCelsius(int minTemperature, int maxTemperature) {
        return temperature(minTemperature, maxTemperature, CELCIUS_PARAM);
    }

    public String temperatureFahrenheit() {
        return temperature(DEFAULT_MIN_TEMP_F, DEFAULT_MAX_TEMP_F, FAHRENHEIT_PARAM);
    }

    public String temperatureFahrenheit(int minTemperature, int maxTemperature) {
        return temperature(minTemperature, maxTemperature, FAHRENHEIT_PARAM);
    }

    private String temperature(int minTemperature, int maxTemperature, String degreeKey) {
        return random.nextInt(minTemperature, maxTemperature) + degreeKey;
    }

    public String getWindDirection() {
        return random.randomElement(DataLoader.getListData("weather", "wind_directions"));
    }

    public String windSpeedKm() {
        return windSpeed(DEFAULT_MIN_WIND_SPEED_KM, DEFAULT_MAX_WIND_SPEED_KM, KM_PARAM);
    }

    public String windSpeedKm(int minSpeed, int maxSpeed) {
        return windSpeed(minSpeed, maxSpeed, KM_PARAM);
    }

    public String windSpeedMph() {
        return windSpeed(DEFAULT_MIN_WIND_SPEED_MPH, DEFAULT_MAX_WIND_SPEED_MPH, MPH_PARAM);
    }

    public String windSpeedMph(int minSpeed, int maxSpeed) {
        return windSpeed(minSpeed, maxSpeed, MPH_PARAM);
    }

    private String windSpeed(int minTemperature, int maxTemperature, String degreeKey) {
        return random.nextInt(minTemperature, maxTemperature) + degreeKey;
    }

    public String getRelativeHumidity() {
        return random.nextInt(0, 100) + "%";
    }

    public String getAbsoluteHumidity() {
        return random.nextInt(0, 600) + " g/m³";
    }

    public static void main(String[] args) {
        WeatherProvider weatherProvider = new WeatherProvider(new RandomService());
        System.out.println("Description: " + weatherProvider.getDescription());
        System.out.println("Temperature Celsius: " + weatherProvider.temperatureCelsius());
        System.out.println("Temperature Fahrenheit: " + weatherProvider.temperatureFahrenheit());
        System.out.println("Wind Direction: " + weatherProvider.getWindDirection());
        System.out.println("Wind Speed Km: " + weatherProvider.windSpeedKm());
        System.out.println("Wind Speed Mph: " + weatherProvider.windSpeedMph());
        System.out.println("Relative Humidity: " + weatherProvider.getRelativeHumidity());
        System.out.println("Absolute Humidity: " + weatherProvider.getAbsoluteHumidity());
    }
}