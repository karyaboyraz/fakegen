package com.fakegen.providers;

import com.fakegen.RandomService;
import com.fakegen.util.DataLoader;
import java.util.List;

public class InternetProvider {
    private final RandomService random;
    private final List<String> emailDomains;
    private final List<String> topLevelDomains;

    public InternetProvider(RandomService random) {
        this.random = random;
        this.emailDomains = DataLoader.loadData("internet", "email_domains");
        this.topLevelDomains = DataLoader.loadData("internet", "top_level_domains");
    }

    public String email() {
        return random.letterify("????") +
               random.numerify("###") +
               "@" +
               random.nextElement(emailDomains);
    }

    public String domainName() {
        return random.letterify("??????") + "." + 
               random.nextElement(topLevelDomains);
    }

    public String ipV4() {
        return random.nextInt(256) + "." +
               random.nextInt(256) + "." +
               random.nextInt(256) + "." +
               random.nextInt(256);
    }

    public String password() {
        return random.bothify("????####!@");
    }

    public String url() {
        return "https://www." + domainName();
    }
}
