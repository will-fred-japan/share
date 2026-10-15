package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public enum ib {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);


    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int f599a;

    ib(int i9) {
        this.f599a = i9;
    }

    public static ib a(int i9) {
        if (i9 == 1) {
            return INT;
        }
        if (i9 == 2) {
            return LONG;
        }
        if (i9 == 3) {
            return STRING;
        }
        if (i9 != 4) {
            return null;
        }
        return BOOLEAN;
    }
}
