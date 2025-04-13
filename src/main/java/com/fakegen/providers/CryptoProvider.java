package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;

public class CryptoProvider {
    private final RandomService random;

    public CryptoProvider(RandomService random) {
        this.random = random;
    }

    public String coinName() {
        return random.randomElement(DataLoader.getListData("crypto", "coin_names"));
    }

    public String coinSymbol() {
        return random.randomElement(DataLoader.getListData("crypto", "coin_symbols"));
    }

    public String blockchain() {
        return random.randomElement(DataLoader.getListData("crypto", "blockchains"));
    }

    public String walletAddress() {
        String chars = DataLoader.getAlphabet() + DataLoader.getAlphabet().toLowerCase() + DataLoader.getNumeric();
        StringBuilder sb = new StringBuilder(34);
        for (int i = 0; i < 34; i++) {
            sb.append(chars.charAt(random.nextInt(0, chars.length())));
        }
        return sb.toString();
    }

    public String transactionHash() {
        String hex = DataLoader.getNumeric() + "abcdef";
        StringBuilder sb = new StringBuilder(64);
        for (int i = 0; i < 64; i++) {
            sb.append(hex.charAt(random.nextInt(0, hex.length() - 1)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CryptoProvider cryptoProvider = new CryptoProvider(new RandomService());
        System.out.println("Coin Name: " + cryptoProvider.coinName());
        System.out.println("Coin Symbol: " + cryptoProvider.coinSymbol());
        System.out.println("Blockchain: " + cryptoProvider.blockchain());
        System.out.println("Wallet Address: " + cryptoProvider.walletAddress());
        System.out.println("Transaction Hash: " + cryptoProvider.transactionHash());
    }
}