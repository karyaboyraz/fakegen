package com.fakegen.locale;

public enum FakerLocale {
    EN_US("en-US"),
    TR_TR("tr-TR"),
    FR_FR("fr-FR"),
    DE_DE("de-DE"),
    ES_ES("es-ES");

    private final String code;

    FakerLocale(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static FakerLocale fromCode(String code) {
        for (FakerLocale locale : values()) {
            if (locale.getCode().equalsIgnoreCase(code)) {
                return locale;
            }
        }
        throw new IllegalArgumentException("Unsupported locale: " + code);
    }
}
