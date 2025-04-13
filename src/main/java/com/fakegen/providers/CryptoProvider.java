package com.fakegen.providers;

import com.fakegen.util.DataLoader;
import com.fakegen.util.RandomService;
import com.fakegen.util.LazyLoader;
import java.util.List;

public class CryptoProvider {
    private final RandomService random;
    private List<String> coinNames;
    private List<String> coinSymbols;
    private List<String> blockchains;

    public CryptoProvider(RandomService random) {
        this.random = random;
    }

    public String coinName() {
        coinNames = LazyLoader.load("cryptoCoinNames", () -> DataLoader.getListData("crypto", "coin_names"));
        return random.randomElement(coinNames);
    }

    public String coinSymbol() {
        coinSymbols = LazyLoader.load("cryptoCoinSymbols", () -> DataLoader.getListData("crypto", "coin_symbols"));
        return random.randomElement(coinSymbols);
    }

    public String blockchain() {
        blockchains = LazyLoader.load("cryptoBlockchains", () -> DataLoader.getListData("crypto", "blockchains"));
        return random.randomElement(blockchains);
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