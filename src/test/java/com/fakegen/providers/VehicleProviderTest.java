package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleProviderTest {
    private VehicleProvider vehicleProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        vehicleProvider = new VehicleProvider(new RandomService());
    }

    @Test
    void vehicle_ShouldReturnValidVehicle() {
        String vehicle = vehicleProvider.vehicle();
        assertNotNull(vehicle);
        assertFalse(vehicle.isEmpty());
    }

    @Test
    void manufacturer_ShouldReturnValidManufacturer() {
        String manufacturer = vehicleProvider.manufacturer();
        assertNotNull(manufacturer);
        assertFalse(manufacturer.isEmpty());
    }

    @Test
    void model_ShouldReturnValidModel() {
        String model = vehicleProvider.model();
        assertNotNull(model);
        assertFalse(model.isEmpty());
    }

    @Test
    void type_ShouldReturnValidType() {
        String type = vehicleProvider.type();
        assertNotNull(type);
        assertFalse(type.isEmpty());
    }

    @Test
    void fuel_ShouldReturnValidFuel() {
        String fuel = vehicleProvider.fuel();
        assertNotNull(fuel);
        assertFalse(fuel.isEmpty());
    }

    @Test
    void color_ShouldReturnValidColor() {
        String color = vehicleProvider.color();
        assertNotNull(color);
        assertFalse(color.isEmpty());
    }

    @Test
    void vin_ShouldReturnValidVin() {
        String vin = vehicleProvider.vin();
        assertNotNull(vin);
        assertFalse(vin.isEmpty());
        assertTrue(vin.matches("^[A-HJ-NPR-Z0-9]{17}$"));
    }

    @Test
    void licensePlate_ShouldReturnValidFormat() {
        String licensePlate = vehicleProvider.licensePlate();
        assertNotNull(licensePlate);
        assertFalse(licensePlate.isEmpty());
    }

    @Test
    void licensePlateWithFormat_ShouldReturnValidFormat() {
        String licensePlate = vehicleProvider.licensePlateWithFormat();
        assertNotNull(licensePlate);
        assertFalse(licensePlate.isEmpty());
        assertTrue(licensePlate.matches("^[A-Z0-9-]+$"));
    }
} 