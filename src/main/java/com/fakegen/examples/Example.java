package com.fakegen.examples;

import com.fakegen.FakeGen;
import com.fakegen.locale.FakerLocale;

public class Example {
    public static void main(String[] args) {
        // English data
        System.out.println("=== English Data ===");
        FakeGen fakeGen = new FakeGen(FakerLocale.EN_US);
        printFakeData(fakeGen);
        
        // Turkish data
        System.out.println("\n=== Turkish Data ===");
        fakeGen.setLocale(FakerLocale.TR_TR);
        printFakeData(fakeGen);
    }
    
    private static void printFakeData(FakeGen fakeGen) {
        System.out.println("Full Name: " + fakeGen.name().fullName());
        System.out.println("Username: " + fakeGen.name().username());
        
        System.out.println("\nAddress:");
        System.out.println(fakeGen.address().fullAddress());
        
        System.out.println("\nCompany: " + fakeGen.company().companyName());
        System.out.println("Industry: " + fakeGen.company().industry());
        System.out.println("Catch Phrase: " + fakeGen.company().catchPhrase());
        
        System.out.println("\nEmail: " + fakeGen.internet().email());
        System.out.println("Website: " + fakeGen.internet().url());
        System.out.println("IP Address: " + fakeGen.internet().ipV4());
    }
}
