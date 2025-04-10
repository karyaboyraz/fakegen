package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class PhoneNumberProvider {
    private final RandomService random;

    public PhoneNumberProvider(RandomService random) {
        this.random = random;
    }

    public String phoneNumber() {
        return random.nextBoolean() ? cellPhone() : landline();
    }

    public String landline() {
        String format = random.randomElement(DataLoader.getListData("phone", "landlineFormats"));
        return random.formatNumber(format);
    }

    public String cellPhone() {
        String format = random.randomElement(DataLoader.getListData("phone", "cellPhoneFormats"));
        return random.formatNumber(format);
    }

    public String internationalPhoneFormat() {
        String format = random.randomElement(DataLoader.getListData("phone", "internationalFormats"));
        return random.formatNumber(format);
    }

    public static void main(String[] args) {
        PhoneNumberProvider phoneNumberProvider = new PhoneNumberProvider(new RandomService());
        System.out.println("Phone Number: " + phoneNumberProvider.cellPhone());
        System.out.println("Landline: " + phoneNumberProvider.landline());
        System.out.println("Phone Number: " + phoneNumberProvider.phoneNumber());
        System.out.println("International Phone Format: " + phoneNumberProvider.internationalPhoneFormat());
    }

}