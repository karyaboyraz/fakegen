package com.fakegen.locale;

public enum FakerLocale {
    TR_TR("tr_TR"),
    EN_US("en_US"),
    EN_GB("en_GB"),
    DE_DE("de_DE"),
    FR_FR("fr_FR"),
    ES_ES("es_ES"),
    IT_IT("it_IT"),
    PT_BR("pt_BR"),
    RU_RU("ru_RU"),
    JA_JP("ja_JP"),
    KO_KR("ko_KR"),
    ZH_CN("zh_CN"),
    ZH_TW("zh_TW");

    private final String code;

    FakerLocale(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
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
