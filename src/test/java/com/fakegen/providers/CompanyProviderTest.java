package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyProviderTest {
    private CompanyProvider companyProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        companyProvider = new CompanyProvider(new RandomService());
    }

    @Test
    void name_ShouldReturnValidName() {
        String name = companyProvider.name();
        assertNotNull(name);
        assertFalse(name.isEmpty());
    }

    @Test
    void suffix_ShouldReturnValidSuffix() {
        String suffix = companyProvider.suffix();
        assertNotNull(suffix);
        assertFalse(suffix.isEmpty());
    }

    @Test
    void catchPhrase_ShouldReturnValidPhrase() {
        String catchPhrase = companyProvider.catchPhrase();
        assertNotNull(catchPhrase);
        assertFalse(catchPhrase.isEmpty());
    }

    @Test
    void industry_ShouldReturnValidIndustry() {
        String industry = companyProvider.industry();
        assertNotNull(industry);
        assertFalse(industry.isEmpty());
    }
} 