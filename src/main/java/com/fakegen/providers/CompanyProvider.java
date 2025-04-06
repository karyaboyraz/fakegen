package com.fakegen.providers;

import com.fakegen.RandomService;
import com.fakegen.util.DataLoader;
import java.util.List;

public class CompanyProvider {
    private final RandomService random;
    private final List<String> companyPrefixes;
    private final List<String> companySuffixes;
    private final List<String> industryTypes;
    private final List<String> busCompany;
    private final List<String> airlineCompany;
    private final List<String> ferryCompany;
    private final List<String> carRental;
    private final List<String> hotels;

    public CompanyProvider(RandomService random) {
        this.random = random;
        this.companyPrefixes = DataLoader.loadData("company", "prefixes");
        this.companySuffixes = DataLoader.loadData("company", "suffixes");
        this.industryTypes = DataLoader.loadData("company", "industry_types");
        this.busCompany = DataLoader.loadData("company", "bus_company");
        this.airlineCompany = DataLoader.loadData("company", "airline_company");
        this.ferryCompany = DataLoader.loadData("company", "ferry_company");
        this.carRental = DataLoader.loadData("company", "car_rental");
        this.hotels = DataLoader.loadData("company", "hotels");
    }

    public String companyName() {
        return random.nextElement(companyPrefixes) + " " +
               random.nextElement(industryTypes) + " " +
               random.nextElement(companySuffixes);
    }

    public String industry() {
        return random.nextElement(industryTypes);
    }

    public String catchPhrase() {
        return "Innovating " + industry() + " solutions for tomorrow";
    }

    public String ein() {
        return random.numerify("##-#######");
    }

    public String busCompany() {
        return random.nextElement(busCompany);
    }

    public String airlineCompany() {
        return random.nextElement(airlineCompany);
    }

    public String ferryCompany() {
        return random.nextElement(ferryCompany);
    }

    public String carRental() {
        return random.nextElement(carRental);
    }

    public String hotel() {
        return random.nextElement(hotels);
    }
}
