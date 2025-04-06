package com.fakegen.providers;

import com.fakegen.RandomService;
import com.fakegen.util.DataLoader;
import java.util.List;

public class NameProvider {
    private final RandomService random;
    private final List<String> firstNames;
    private final List<String> lastNames;

    public NameProvider(RandomService random) {
        this.random = random;
        this.firstNames = DataLoader.loadData("name", "first_names");
        this.lastNames = DataLoader.loadData("name", "last_names");
    }

    public String firstName() {
        return random.nextElement(firstNames);
    }

    public String lastName() {
        return random.nextElement(lastNames);
    }

    public String fullName() {
        return firstName() + " " + lastName();
    }

    public String username() {
        return (firstName().toLowerCase() + random.numerify("###")).replace(" ", "");
    }
}
