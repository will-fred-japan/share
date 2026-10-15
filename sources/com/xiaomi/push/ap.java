package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f17045a;

    public static al a(Context context) {
        if (k.m648a()) {
            f17045a = 1;
            return new ao(context);
        }
        if (ak.a(context)) {
            f17045a = 2;
            return new ak(context);
        }
        if (ar.a(context)) {
            f17045a = 4;
            return new ar(context);
        }
        if (at.a(context)) {
            f17045a = 5;
            return new at(context);
        }
        if (an.a(context)) {
            f17045a = 3;
            return new am(context);
        }
        f17045a = 0;
        return new as();
    }
}
