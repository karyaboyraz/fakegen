package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;

import javax.xml.crypto.Data;


public class InternetProvider {
    private final RandomService random;

    public InternetProvider(RandomService random) {
        this.random = random;
    }

    private String sanitizeAscii(String input) {
        String normalized = java.text.Normalizer.normalize(input, java.text.Normalizer.Form.NFD);
        String ascii = normalized.replaceAll("\\p{M}", "");
        ascii = ascii.replace("ı", "i")
                     .replace("İ", "I")
                     .replace("ş", "s")
                     .replace("Ş", "S")
                     .replace("ğ", "g")
                     .replace("Ğ", "G")
                     .replace("ü", "u")
                     .replace("Ü", "U")
                     .replace("ö", "o")
                     .replace("Ö", "O")
                     .replace("ç", "c")
                     .replace("Ç", "C");
        return ascii;
    }

    public String email() {
        return username() + "@" + domainName();
    }

    public String username() {
        String firstName = random.randomElement(DataLoader.getListData("name", "first_names"));
        String lastName = random.randomElement(DataLoader.getListData("name", "last_names"));
        String username = sanitizeAscii(firstName).toLowerCase() + "." + sanitizeAscii(lastName).toLowerCase();
        return sanitizeAscii(username);
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
        String chars = DataLoader.getAlphabet() + DataLoader.getAlphabet().toLowerCase() + DataLoader.getSampleCharacters() + DataLoader.getNumeric();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            password.append(chars.charAt(random.nextInt(0, chars.length() - 1)));
        }
        return password.toString();
    }

    public String password(int length) {
        String chars = DataLoader.getAlphabet() + DataLoader.getAlphabet().toLowerCase() + DataLoader.getSampleCharacters() + DataLoader.getNumeric();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(0, chars.length() - 1)));
        }
        return password.toString();
    }

    public String passwordWithRules(int length, boolean includeUpper, boolean includeDigits, boolean includeSymbols) {
        StringBuilder charPool = new StringBuilder(DataLoader.getAlphabet().toLowerCase());
        if (includeUpper) {
            charPool.append(DataLoader.getAlphabet());
        }
        if (includeDigits) {
            charPool.append(DataLoader.getNumeric());
        }
        if (includeSymbols) {
            charPool.append(DataLoader.getSampleCharacters());
        }
        System.out.println("Character Pool: " + charPool);
        String pool = charPool.toString();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(pool.charAt(random.nextInt(0, pool.length())));
        }
        return password.toString();
    }

    public int randomPort() {
        return random.nextInt(1, 65536);
    }

    public String randomEmoji() {
        String[] emojis = {
            "😀","😂","🥰","😎","🤖","🎉","🚀","🍕","🌟","🔥",
            "🐱","🐶","🦄","🍀","🎶","⚽","🏀","🏆","🎲","🧩"
        };
        return emojis[random.nextInt(0, emojis.length - 1)];
    }

    public static void main(String[] args) {
        InternetProvider internetProvider = new InternetProvider(new RandomService());
        System.out.println("Email: " + internetProvider.email());
        System.out.println("Username: " + internetProvider.username());
        System.out.println("Domain Name: " + internetProvider.domainName());
        System.out.println("URL: " + internetProvider.url());
        System.out.println("IPv4: " + internetProvider.ipv4());
        System.out.println("IPv6: " + internetProvider.ipv6());
        System.out.println("MAC Address: " + internetProvider.macAddress());
        System.out.println("Password: " + internetProvider.password());
        System.out.println("Password (custom length): " + internetProvider.password(16));
        System.out.println("Password with rules: " + internetProvider.passwordWithRules(11, false, true, false));
        System.out.println("Random Port: " + internetProvider.randomPort());
        System.out.println("Random Emoji: " + internetProvider.randomEmoji());
    }
}
