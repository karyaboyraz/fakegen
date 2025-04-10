package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;


public class InternetProvider {
    private final RandomService random;

    public InternetProvider(RandomService random) {
        this.random = random;
    }

    public String email() {
        String username = random.randomElement(DataLoader.getListData("internet", "usernames"));
        String domain = random.randomElement(DataLoader.getListData("internet", "domainNames"));
        return username + "@" + domain;
    }

    public String username() {
        return random.randomElement(DataLoader.getListData("internet", "usernames"));
    }

    public String domainName() {
        return random.randomElement(DataLoader.getListData("internet", "domainNames"));
    }

    public String url() {
        String protocol = random.nextBoolean() ? "https" : "http";
        String domain = domainName();
        return protocol + "://www." + domain;
    }

    public String ipv4() {
        return random.nextInt(0, 255) + "." +
               random.nextInt(0, 255) + "." +
               random.nextInt(0, 255) + "." +
               random.nextInt(0, 255);
    }

    public String ipv6() {
        StringBuilder ipv6 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if (i > 0) {
                ipv6.append(":");
            }
            ipv6.append(String.format("%04x", random.nextInt(0, 65535)));
        }
        return ipv6.toString();
    }

    public String macAddress() {
        StringBuilder mac = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (i > 0) {
                mac.append(":");
            }
            mac.append(String.format("%02x", random.nextInt(0, 255)));
        }
        return mac.toString();
    }

    public String password() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            password.append(chars.charAt(random.nextInt(0, chars.length() - 1)));
        }
        return password.toString();
    }
}
