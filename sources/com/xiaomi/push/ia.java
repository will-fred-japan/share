package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public enum ia {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);


    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int f597a;

    ia(int i9) {
        this.f597a = i9;
    }

    public int a() {
        return this.f597a;
    }

    public static ia a(int i9) {
        if (i9 == 1) {
            return MISC_CONFIG;
        }
        if (i9 != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }
}
