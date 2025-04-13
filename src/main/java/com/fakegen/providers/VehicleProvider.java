package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;
import com.fakegen.util.LazyLoader;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class VehicleProvider {
    private final RandomService random;
    private final Map<String, List<String>> vehicleData;

    public VehicleProvider(RandomService random) {
        this.random = random;
        this.vehicleData = new HashMap<>();
    }

    private String get(String category) {
        if (!vehicleData.containsKey(category)) {
            vehicleData.put(category, LazyLoader.load("vehicle" + category, () -> DataLoader.getListData("vehicle", category)));
        }
        return random.randomElement(vehicleData.get(category));
    }

    public String vehicle() {
        return get("vehicles");
    }

    public String manufacturer() {
        return get("manufacturers");
    }

    public String model() {
        return get("models");
    }

    public String type() {
        return get("types");
    }

    public String fuel() {
        return get("fuels");
    }

    public String vin() {
        StringBuilder vin = new StringBuilder();
        String vinChars = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        
        for (int i = 0; i < 17; i++) {
            vin.append(vinChars.charAt(random.nextInt(0, vinChars.length() - 1)));
        }
        
        return vin.toString();
    }

    public String color() {
        return get("colors");
    }

    public String licensePlate() {
        return get("license_plate_formats");
    }

    public String licensePlateWithFormat() {
        StringBuilder result = new StringBuilder();
        String alphabet = DataLoader.getAlphabet().toUpperCase();
        String numeric = DataLoader.getNumeric();
        
        // İlk iki karakter harf
        for (int i = 0; i < 2; i++) {
            result.append(alphabet.charAt(random.nextInt(0, alphabet.length() - 1)));
        }
        
        // Tire işareti
        result.append('-');
        
        // 3 rakam
        for (int i = 0; i < 3; i++) {
            result.append(numeric.charAt(random.nextInt(0, numeric.length() - 1)));
        }
        
        // Tire işareti
        result.append('-');
        
        // Son iki karakter harf
        for (int i = 0; i < 2; i++) {
            result.append(alphabet.charAt(random.nextInt(0, alphabet.length() - 1)));
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        VehicleProvider vehicleProvider = new VehicleProvider(new RandomService());
        System.out.println("Vehicle: " + vehicleProvider.vehicle());
        System.out.println("Manufacturer: " + vehicleProvider.manufacturer());
        System.out.println("Model: " + vehicleProvider.model());
        System.out.println("Type: " + vehicleProvider.type());
        System.out.println("Fuel: " + vehicleProvider.fuel());
        System.out.println("VIN: " + vehicleProvider.vin());
        System.out.println("Color: " + vehicleProvider.color());
        System.out.println("License Plate with Format: " + vehicleProvider.licensePlateWithFormat());
    }
} 