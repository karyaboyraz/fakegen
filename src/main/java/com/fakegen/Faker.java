package com.fakegen;

import com.fakegen.providers.*;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;

public class Faker {
    private static final RandomService random = new RandomService();
    
    private NameProvider nameProvider;
    private AddressProvider addressProvider;
    private CompanyProvider companyProvider;
    private InternetProvider internetProvider;

    public Faker() {
        this(FakerLocale.EN_US);
    }

    public Faker(FakerLocale locale) {
        DataLoader.setLocale(locale);
        this.nameProvider = new NameProvider(random);
        this.addressProvider = new AddressProvider(random);
        this.companyProvider = new CompanyProvider(random);
        this.internetProvider = new InternetProvider(random);
    }

    public void setLocale(FakerLocale locale) {
        DataLoader.setLocale(locale);
        // Recreate providers with new locale
        this.nameProvider = new NameProvider(random);
        this.addressProvider = new AddressProvider(random);
        this.companyProvider = new CompanyProvider(random);
        this.internetProvider = new InternetProvider(random);
    }

    public FakerLocale getCurrentLocale() {
        return DataLoader.getCurrentLocale();
    }

    public NameProvider name() {
        return nameProvider;
    }

    public AddressProvider address() {
        return addressProvider;
    }

    public CompanyProvider company() {
        return companyProvider;
    }

    public InternetProvider internet() {
        return internetProvider;
    }
}
