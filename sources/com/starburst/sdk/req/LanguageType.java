package com.starburst.sdk.req;

/* JADX INFO: loaded from: classes.dex */
public enum LanguageType {
    AUTO(""),
    ZH_CN("zh-CN"),
    CANT("cant"),
    SICHUAN("sc"),
    EN_US("en-US"),
    JA_JP("ja-JP"),
    KO_KR("ko-KR"),
    FR_FR("fr-FR"),
    ES_MX("es-MX"),
    PT_BR("pt-BR"),
    ID_ID("id-ID"),
    MS_MY("ms-MY"),
    DE_DE("de-DE"),
    FIL_PH("fil-PH"),
    TH_TH("th-TH"),
    AR_SA("ar-SA"),
    VI("vi"),
    RU_RU("ru-RU"),
    RU("ru"),
    DA("da"),
    EL("el"),
    FI("fi"),
    HE("he"),
    HI("hi"),
    IT("it"),
    NL("nl"),
    NO("no"),
    PL("pl"),
    SV("sv"),
    SW("sw"),
    TR("tr"),
    AUTO_ALL("auto");

    private final String mLanguage;

    LanguageType(String str) {
        this.mLanguage = str;
    }

    public static LanguageType fromString(String str) {
        if (str == null) {
            str = "";
        }
        for (LanguageType languageType : values()) {
            if (languageType.mLanguage.equals(str)) {
                return languageType;
            }
        }
        return null;
    }

    public String getLanguage() {
        return this.mLanguage;
    }
}
