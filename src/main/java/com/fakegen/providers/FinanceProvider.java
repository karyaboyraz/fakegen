package com.fakegen.providers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class FinanceProvider {
    private final Random random;

    public FinanceProvider() {
        this.random = new Random();
    }

    /**
     * Generates a valid credit card number using Luhn algorithm
     * @param prefix Card prefix (e.g., "4" for Visa, "5" for MasterCard)
     * @param length Total length of the card number
     * @return Valid credit card number
     */
    public String creditCardNumber(String prefix, int length) {
        StringBuilder number = new StringBuilder(prefix);
        while (number.length() < length - 1) {
            number.append(random.nextInt(10));
        }
        
        int sum = 0;
        boolean alternate = false;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = number.charAt(i) - '0';
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
            alternate = !alternate;
        }
        int checkDigit = (10 - (sum % 10)) % 10;
        number.append(checkDigit);
        
        return number.toString();
    }

    /**
     * Generates a random Visa card number
     * @return Valid Visa card number
     */
    public String visaCardNumber() {
        return creditCardNumber("4", 16);
    }

    /**
     * Generates a random MasterCard number
     * @return Valid MasterCard number
     */
    public String masterCardNumber() {
        return creditCardNumber("5", 16);
    }

    /**
     * Generates a random American Express card number
     * @return Valid American Express card number
     */
    public String amexCardNumber() {
        return creditCardNumber("34", 15);
    }

    /**
     * Generates a valid future expiry date for a credit card
     * @return Expiry date in MM/YY format
     */
    public String creditCardExpiryDate() {
        LocalDate now = LocalDate.now();
        int monthsToAdd = random.nextInt(48) + 1; // 1 to 48 months from now
        LocalDate expiryDate = now.plusMonths(monthsToAdd);
        return DateTimeFormatter.ofPattern("MM/yy").format(expiryDate);
    }

    /**
     * Generates a random CVV number
     * @param digits Number of digits (3 for Visa/MC, 4 for Amex)
     * @return CVV number
     */
    public String cvv(int digits) {
        StringBuilder cvv = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            cvv.append(random.nextInt(10));
        }
        return cvv.toString();
    }

    /**
     * Generates a random bank account number
     * @return Bank account number
     */
    public String bankAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }

    /**
     * Generates a random IBAN for Turkey
     * @return Turkish IBAN
     */
    public String turkishIBAN() {
        StringBuilder iban = new StringBuilder("TR");
        for (int i = 0; i < 24; i++) {
            iban.append(random.nextInt(10));
        }
        return iban.toString();
    }

    /**
     * Generates a random amount between min and max with 2 decimal places
     * @param min Minimum amount
     * @param max Maximum amount
     * @return Formatted amount string
     */
    public String amount(double min, double max) {
        double amount = min + (random.nextDouble() * (max - min));
        return String.format("%.2f", amount);
    }
}
