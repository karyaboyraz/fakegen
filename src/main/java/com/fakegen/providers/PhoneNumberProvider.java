package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;
import com.fakegen.util.LazyLoader;
import java.util.List;

public class PhoneNumberProvider {
    private final RandomService random;
    private List<String> landlineFormats;
    private List<String> cellPhoneFormats;
    private List<String> internationalFormats;

    public PhoneNumberProvider(RandomService random) {
        this.random = random;
    }

    public String phoneNumber() {
        return random.nextBoolean() ? cellPhone() : landline();
    }

    public String landline() {
        landlineFormats = LazyLoader.load("phoneLandlineFormats", () -> DataLoader.getListData("phone", "landlineFormats"));
        String format = random.randomElement(landlineFormats);
        return random.randomize(format);
    }

    public String cellPhone() {
        cellPhoneFormats = LazyLoader.load("phoneCellPhoneFormats", () -> DataLoader.getListData("phone", "cellPhoneFormats"));
        String format = random.randomElement(cellPhoneFormats);
        return random.randomize(format);
    }

    public String internationalPhoneFormat() {
        internationalFormats = LazyLoader.load("phoneInternationalFormats", () -> DataLoader.getListData("phone", "internationalFormats"));
        String format = random.randomElement(internationalFormats);
        return random.randomize(format);
    }

    public static void main(String[] args) {
        PhoneNumberProvider phoneNumberProvider = new PhoneNumberProvider(new RandomService());
        System.out.println("Phone Number: " + phoneNumberProvider.cellPhone());
        System.out.println("Landline: " + phoneNumberProvider.landline());
        System.out.println("Phone Number: " + phoneNumberProvider.phoneNumber());
        System.out.println("International Phone Format: " + phoneNumberProvider.internationalPhoneFormat());
    }

}