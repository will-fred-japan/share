package com.pichillilorenzo.flutter_inappwebview_android.types;

import W5.e;

/* JADX INFO: loaded from: classes.dex */
public enum NavigationActionPolicy {
    CANCEL(0),
    ALLOW(1);

    private final int value;

    NavigationActionPolicy(int i9) {
        this.value = i9;
    }

    public static NavigationActionPolicy fromValue(int i9) {
        for (NavigationActionPolicy navigationActionPolicy : values()) {
            if (i9 == navigationActionPolicy.value) {
                return navigationActionPolicy;
            }
        }
        throw new IllegalArgumentException(e.i(i9, "No enum constant: "));
    }

    public boolean equalsValue(int i9) {
        return this.value == i9;
    }

    public int rawValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.value);
    }
}
