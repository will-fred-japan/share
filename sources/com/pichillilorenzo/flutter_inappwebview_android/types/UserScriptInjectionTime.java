package com.pichillilorenzo.flutter_inappwebview_android.types;

import W5.e;

/* JADX INFO: loaded from: classes.dex */
public enum UserScriptInjectionTime {
    AT_DOCUMENT_START(0),
    AT_DOCUMENT_END(1);

    private final int value;

    UserScriptInjectionTime(int i9) {
        this.value = i9;
    }

    public static UserScriptInjectionTime fromValue(int i9) {
        for (UserScriptInjectionTime userScriptInjectionTime : values()) {
            if (i9 == userScriptInjectionTime.toValue()) {
                return userScriptInjectionTime;
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
