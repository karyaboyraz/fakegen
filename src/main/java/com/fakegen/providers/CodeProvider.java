package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class CodeProvider {
    private final RandomService random;
    private static final int[] ISBN_EAN_WEIGHTS = {1,3,1,3,1,3,1,3,1,3,1,3,0};

    public CodeProvider(RandomService random) {
        this.random = random;
    }

    private String generateWithCheckDigit(int length, int[] weights) {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        
        for (int i = 0; i < length - 1; i++) {
            int digit = random.nextInt(0, 9);
            result.append(digit);
            sum += digit * weights[i];
        }
        
        int checkDigit = (10 - (sum % 10)) % 10;
        result.append(checkDigit);
        
        return result.toString();
    }

    public String isbn() {
        return generateWithCheckDigit(13, ISBN_EAN_WEIGHTS);
    }

    public String ean() {
        return generateWithCheckDigit(13, ISBN_EAN_WEIGHTS);
    }

    public String asin() {
        String chars = DataLoader.getAlphabet().toUpperCase() + DataLoader.getNumeric();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < 10; i++) {
            result.append(chars.charAt(random.nextInt(0, chars.length() - 1)));
        }
        
        return result.toString();
    }

    public String issn() {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        
        for (int i = 0; i < 7; i++) {
            int digit = random.nextInt(0, 9);
            result.append(digit);
            sum += digit * (8 - i);
        }
        
        int rem = sum % 11;
        char checkDigit = rem == 0 ? '0' : rem == 1 ? 'X' : (char) ('0' + (11 - rem));
        
        return result.append('-').append(checkDigit).toString();
    }

    public static void main(String[] args) {
        CodeProvider codeProvider = new CodeProvider(new RandomService());
        System.out.println("ISBN: " + codeProvider.isbn());
        System.out.println("EAN: " + codeProvider.ean());
        System.out.println("ASIN: " + codeProvider.asin());
        System.out.println("ISSN: " + codeProvider.issn());
    }
}