package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;


public class VehicleProvider {
    private final RandomService random;

    public VehicleProvider(RandomService random) {
        this.random = random;
    }

    public String vehicle() {
        return random.randomElement(DataLoader.getListData("vehicle", "vehicles"));
    }

    public String manufacturer() {
        return random.randomElement(DataLoader.getListData("vehicle", "manufacturers"));
    }

    public String model() {
        return random.randomElement(DataLoader.getListData("vehicle", "models"));
    }

    public String type() {
        return random.randomElement(DataLoader.getListData("vehicle", "types"));
    }

    public String fuel() {
        return random.randomElement(DataLoader.getListData("vehicle", "fuels"));
    }

    public String vin() {
        StringBuilder vin = new StringBuilder();
        String vinChars = DataLoader.getAlphabet().toUpperCase() + DataLoader.getNumeric();
        for (int i = 0; i < 17; i++) {
            vin.append(vinChars.charAt(random.nextInt(0, vinChars.length() - 1)));
        }
        return vin.toString();
    }

    public String color() {
        return random.randomElement(DataLoader.getListData("color", "names"));
    }

    public String licensePlate() {
        return random.randomElement(DataLoader.getListData("vehicle", "license_plate_formats"));
    }

    public String licensePlateWithFormat() {
        String format = licensePlate();
        String alphabet = DataLoader.getAlphabet().toUpperCase();
        String numeric = DataLoader.getNumeric();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < format.length(); i++) {
            char c = format.charAt(i);
            if (c == '!') {
                result.append(alphabet.charAt(random.nextInt(0, alphabet.length() - 1)));
            } else if (c == '#') {
                result.append(numeric.charAt(random.nextInt(0, numeric.length() - 1)));
            } else {
                result.append(c);
            }
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