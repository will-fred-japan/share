package com.alibaba.fastjson.parser;

/* JADX INFO: loaded from: classes.dex */
public enum Feature {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect,
    UseObjectArray,
    SupportNonPublicField,
    IgnoreAutoType,
    DisableFieldSmartMatch,
    SupportAutoType,
    NonStringKeyAsString,
    CustomMapDeserializer,
    ErrorOnEnumNotMatch,
    SafeMode,
    TrimStringFieldValue,
    UseNativeJavaObject;

    public final int mask = 1 << ordinal();

    Feature() {
    }

    public static int config(int i9, Feature feature, boolean z8) {
        return z8 ? i9 | feature.mask : i9 & (~feature.mask);
    }

    public static boolean isEnabled(int i9, Feature feature) {
        return (i9 & feature.mask) != 0;
    }

    public static int of(Feature[] featureArr) {
        if (featureArr == null) {
            return 0;
        }
        int i9 = 0;
        for (Feature feature : featureArr) {
            i9 |= feature.mask;
        }
        return i9;
    }

    public final int getMask() {
        return this.mask;
    }
}
