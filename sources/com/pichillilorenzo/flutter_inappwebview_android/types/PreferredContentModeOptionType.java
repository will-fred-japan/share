package com.pichillilorenzo.flutter_inappwebview_android.types;

import W5.e;

/* JADX INFO: loaded from: classes.dex */
public enum PreferredContentModeOptionType {
    RECOMMENDED(0),
    MOBILE(1),
    DESKTOP(2);

    private final int value;

    PreferredContentModeOptionType(int i9) {
        this.value = i9;
    }

    public static PreferredContentModeOptionType fromValue(int i9) {
        for (PreferredContentModeOptionType preferredContentModeOptionType : values()) {
            if (i9 == preferredContentModeOptionType.toValue()) {
                return preferredContentModeOptionType;
            }
        }
        throw new IllegalArgumentException(e.i(i9, "No enum constant: "));
    }

    public boolean equalsValue(int i9) {
        return this.value == i9;
    }

    public int toValue() {
        return this.value;
    }
}
