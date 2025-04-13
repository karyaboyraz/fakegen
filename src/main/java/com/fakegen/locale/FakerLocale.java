package com.fakegen.locale;

/**
 * An enum representing supported locales for fake data generation.
 * Each locale corresponds to a specific language and country combination,
 * and is used to load locale-specific data for generating fake information.
 */
public enum FakerLocale {
    /** Turkish (Turkey) locale */
    TR_TR("tr_TR"),
    /** English (United States) locale */
    EN_US("en_US"),
    /** English (United Kingdom) locale */
    EN_GB("en_GB"),
    /** German (Germany) locale */
    DE_DE("de_DE"),
    /** French (France) locale */
    FR_FR("fr_FR"),
    /** Spanish (Spain) locale */
    ES_ES("es_ES"),
    /** Italian (Italy) locale */
    IT_IT("it_IT"),
    /** Portuguese (Brazil) locale */
    PT_BR("pt_BR"),
    /** Russian (Russia) locale */
    RU_RU("ru_RU"),
    /** Japanese (Japan) locale */
    JA_JP("ja_JP"),
    /** Korean (South Korea) locale */
    KO_KR("ko_KR"),
    /** Chinese (Simplified) locale */
    ZH_CN("zh_CN"),
    /** Chinese (Traditional) locale */
    ZH_TW("zh_TW");

    private final String code;

    /**
     * Constructs a new FakerLocale with the specified locale code.
     *
     * @param code The locale code in the format "language_COUNTRY"
     */
    FakerLocale(String code) {
        this.code = code;
    }

    /**
     * Returns the locale code for this FakerLocale.
     *
     * @return The locale code in the format "language_COUNTRY"
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the locale code as a string representation.
     *
     * @return The locale code in the format "language_COUNTRY"
     */
    @Override
    public String toString() {
        return code;
    }

    /**
     * Returns the FakerLocale enum constant corresponding to the specified locale code.
     *
     * @param code The locale code to look up
     * @return The corresponding FakerLocale enum constant
     * @throws IllegalArgumentException if the specified locale code is not supported
     */
    public static FakerLocale fromCode(String code) {
        for (FakerLocale locale : values()) {
            if (locale.getCode().equalsIgnoreCase(code)) {
                return locale;
            }
        }
        throw new IllegalArgumentException("Unsupported locale: " + code);
    }
}
