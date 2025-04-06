package com.fakegen.providers;

import com.fakegen.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.Test;

public class AddressProviderDebugTest {
    @Test
    void debugFullAddress() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        AddressProvider addressProvider = new AddressProvider(new RandomService());
        
        // Tam adresi yazdır
        String fullAddress = addressProvider.fullAddress();
        System.out.println("Full Address:");
        System.out.println(fullAddress);
        
        // Adres bileşenlerini yazdır
        String[] lines = fullAddress.split("\n");
        System.out.println("\nAddress Components:");
        System.out.println("Street Line: " + lines[0]);
        String[] addressParts = lines[1].split(", ");
        System.out.println("City/District: " + addressParts[0]);
        System.out.println("Country and Postal Code: " + addressParts[1]);
    }
}
