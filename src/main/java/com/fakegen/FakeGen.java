package com.fakegen;

import com.fakegen.locale.FakerLocale;
import com.fakegen.providers.*;
import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class FakeGen {
    private final RandomService random;
    private final AddressProvider addressProvider;
    private final NameProvider nameProvider;
    private final CompanyProvider companyProvider;
    private final InternetProvider internetProvider;
    private final BookProvider bookProvider;
    private final ColorProvider colorProvider;
    private final FoodProvider foodProvider;
    private final MusicProvider musicProvider;
    private final PhoneNumberProvider phoneNumberProvider;
    private final WeatherProvider weatherProvider;
    private final FilmProvider filmProvider;
    private final AnimalProvider animalProvider;
    private final VehicleProvider vehicleProvider;

    public FakeGen() {
        this(FakerLocale.TR_TR);
    }

    public FakeGen(FakerLocale locale) {
        this.random = new RandomService();
        this.addressProvider = new AddressProvider(random);
        this.nameProvider = new NameProvider(random);
        this.companyProvider = new CompanyProvider(random);
        this.internetProvider = new InternetProvider(random);
        this.bookProvider = new BookProvider(random);
        this.colorProvider = new ColorProvider(random);
        this.foodProvider = new FoodProvider(random);
        this.musicProvider = new MusicProvider(random);
        this.phoneNumberProvider = new PhoneNumberProvider(random);
        this.weatherProvider = new WeatherProvider(random);
        this.filmProvider = new FilmProvider(random);
        this.animalProvider = new AnimalProvider(random);
        this.vehicleProvider = new VehicleProvider(random);


        DataLoader.setLocale(locale);
    }

    public AddressProvider address() {
        return addressProvider;
    }

    public NameProvider name() {
        return nameProvider;
    }

    public CompanyProvider company() {
        return companyProvider;
    }

    public InternetProvider internet() {
        return internetProvider;
    }

    public BookProvider book() {
        return bookProvider;
    }

    public ColorProvider color() {
        return colorProvider;
    }

    public FoodProvider food() {
        return foodProvider;
    }

    public MusicProvider music() {
        return musicProvider;
    }

    public PhoneNumberProvider phoneNumber() {
        return phoneNumberProvider;
    }

    public WeatherProvider weather() {
        return weatherProvider;
    }

    public FilmProvider film() {
        return filmProvider;
    }

    public AnimalProvider animal() {
        return animalProvider;
    }

    public VehicleProvider vehicle() {
        return vehicleProvider;
    }
}
