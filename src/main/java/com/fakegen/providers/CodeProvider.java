package com.fakegen.providers;

import com.fakegen.RandomService;

import java.util.Random;

public class CodeProvider {
    private static final Random RAND = new Random();

    public CodeProvider(RandomService random) {

    }

    private String generateWithCheckDigit(int length, int[] weights) {
        int[] digits = new int[length];
        for (int i = 0; i < length - 1; i++) {
            digits[i] = RAND.nextInt(10);
        }
        int sum = 0;
        for (int i = 0; i < length - 1; i++) {
            sum += digits[i] * weights[i];
        }
        int check = (10 - (sum % 10)) % 10;
        digits[length - 1] = check;
        StringBuilder sb = new StringBuilder(length);
        for (int d : digits) sb.append(d);
        return sb.toString();
    }

    public String isbn() {
        return generateWithCheckDigit(13, new int[] {1,3,1,3,1,3,1,3,1,3,1,3,0});
    }

    public String ean() {
        return generateWithCheckDigit(13, new int[] {1,3,1,3,1,3,1,3,1,3,1,3,0});
    }

    public String asin() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return RAND.ints(10, 0, chars.length())
                   .mapToObj(chars::charAt)
                   .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                   .toString();
    }

    public String issn() {
        int[] digits = new int[8];
        for (int i = 0; i < 7; i++) {
            digits[i] = RAND.nextInt(10);
        }
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            sum += digits[i] * (8 - i);
        }
        int rem = sum % 11;
        digits[7] = rem == 0 ? 0 : rem == 1 ? 'X' : 11 - rem;
        StringBuilder sb = new StringBuilder(9);
        for (int i = 0; i < 7; i++) sb.append(digits[i]);
        sb.append('-').append(digits[7] == 'X' ? 'X' : digits[7]);
        return sb.toString();
    }
}