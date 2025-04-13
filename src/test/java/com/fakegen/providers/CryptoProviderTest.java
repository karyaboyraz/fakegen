package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptoProviderTest {
    private CryptoProvider cryptoProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        cryptoProvider = new CryptoProvider(new RandomService());
    }

    @Test
    void coinName_ShouldReturnValidName() {
        String name = cryptoProvider.coinName();
        assertNotNull(name);
        assertFalse(name.isEmpty());
    }

    @Test
    void coinSymbol_ShouldReturnValidSymbol() {
        String symbol = cryptoProvider.coinSymbol();
        assertNotNull(symbol);
        assertFalse(symbol.isEmpty());
    }

    @Test
    void blockchain_ShouldReturnValidBlockchain() {
        String blockchain = cryptoProvider.blockchain();
        assertNotNull(blockchain);
        assertFalse(blockchain.isEmpty());
    }

    @Test
    void walletAddress_ShouldReturnValidAddress() {
        String address = cryptoProvider.walletAddress();
        assertNotNull(address);
        assertFalse(address.isEmpty());
        assertEquals(34, address.length());
    }

    @Test
    void transactionHash_ShouldReturnValidHash() {
        String hash = cryptoProvider.transactionHash();
        assertNotNull(hash);
        assertFalse(hash.isEmpty());
        assertEquals(64, hash.length());
    }
} 