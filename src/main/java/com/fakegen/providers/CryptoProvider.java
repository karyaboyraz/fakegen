package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;
import java.util.Map;

public class CryptoProvider {
    private final RandomService random;

    public CryptoProvider(RandomService random) {
        this.random = random;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> getCryptoData() {
        Map<String, Object> currencyData = DataLoader.loadYamlData("currency");
        return (Map<String, Object>) currencyData.get("crypto");
    }

    @SuppressWarnings("unchecked")
    public String coinName() {
        return random.randomElement((java.util.List<String>) getCryptoData().get("coins"));
    }

    @SuppressWarnings("unchecked")
    public String coinSymbol() {
        return random.randomElement((java.util.List<String>) getCryptoData().get("symbols"));
    }

    @SuppressWarnings("unchecked")
    public String blockchain() {
        return random.randomElement((java.util.List<String>) getCryptoData().get("blockchains"));
    }

    public String walletAddress() {
        // Generate a random 34-character alphanumeric address
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(34);
        for (int i = 0; i < 34; i++) {
            sb.append(chars.charAt(random.nextInt(0, chars.length())));
        }
        return sb.toString();
    }

    public String transactionHash() {
        // Generate a random 64-character hexadecimal hash
        String hex = "0123456789abcdef";
        StringBuilder sb = new StringBuilder(64);
        for (int i = 0; i < 64; i++) {
            sb.append(hex.charAt(random.nextInt(0, hex.length())));
        }
        return sb.toString();
    }
}