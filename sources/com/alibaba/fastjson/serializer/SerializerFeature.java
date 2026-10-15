package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public enum SerializerFeature {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure,
    IgnoreNonFieldGetter,
    WriteNonStringValueAsString,
    IgnoreErrorGetter,
    WriteBigDecimalAsPlain,
    MapSortField;

    public static final SerializerFeature[] EMPTY;
    public static final int WRITE_MAP_NULL_FEATURES;
    public final int mask = 1 << ordinal();

    static {
        SerializerFeature serializerFeature = WriteMapNullValue;
        SerializerFeature serializerFeature2 = WriteNullListAsEmpty;
        SerializerFeature serializerFeature3 = WriteNullStringAsEmpty;
        SerializerFeature serializerFeature4 = WriteNullNumberAsZero;
        SerializerFeature serializerFeature5 = WriteNullBooleanAsFalse;
        EMPTY = new SerializerFeature[0];
        WRITE_MAP_NULL_FEATURES = serializerFeature.getMask() | serializerFeature5.getMask() | serializerFeature2.getMask() | serializerFeature4.getMask() | serializerFeature3.getMask();
    }

    SerializerFeature() {
    }

    public static int config(int i9, SerializerFeature serializerFeature, boolean z8) {
        return z8 ? i9 | serializerFeature.mask : i9 & (~serializerFeature.mask);
    }

    public static boolean isEnabled(int i9, SerializerFeature serializerFeature) {
        return (i9 & serializerFeature.mask) != 0;
    }

    public static int of(SerializerFeature[] serializerFeatureArr) {
        if (serializerFeatureArr == null) {
            return 0;
        }
        int i9 = 0;
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i9 |= serializerFeature.mask;
        }
        return i9;
    }

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i9, int i10, SerializerFeature serializerFeature) {
        int i11 = serializerFeature.mask;
        return ((i9 & i11) == 0 && (i10 & i11) == 0) ? false : true;
    }
}
