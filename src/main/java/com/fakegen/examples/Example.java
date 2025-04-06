package com.fakegen.examples;

import com.fakegen.Faker;
import com.fakegen.locale.FakerLocale;

public class Example {
    public static void main(String[] args) {
        // English data
        System.out.println("=== English Data ===");
        Faker faker = new Faker(FakerLocale.EN_US);
        printFakeData(faker);
        
        // Turkish data
        System.out.println("\n=== Turkish Data ===");
        faker.setLocale(FakerLocale.TR_TR);
        printFakeData(faker);
    }
    
    private static void printFakeData(Faker faker) {
        System.out.println("Full Name: " + faker.name().fullName());
        System.out.println("Username: " + faker.name().username());
        
        System.out.println("\nAddress:");
        System.out.println(faker.address().fullAddress());
        
        System.out.println("\nCompany: " + faker.company().companyName());
        System.out.println("Industry: " + faker.company().industry());
        System.out.println("Catch Phrase: " + faker.company().catchPhrase());
        
        System.out.println("\nEmail: " + faker.internet().email());
        System.out.println("Website: " + faker.internet().url());
        System.out.println("IP Address: " + faker.internet().ipV4());
    }
}
