package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ec extends eb {
    public ec(Context context, int i9) {
        super(context, i9);
    }

    @Override // com.xiaomi.push.eb
    public hw a() {
        return hw.Storage;
    }

    @Override // com.xiaomi.push.eb
    public String b() {
        return "ram:" + j.m607a() + ",rom:" + j.m612b() + "|ramOriginal:" + j.c() + ",romOriginal:" + j.d();
    }

    @Override // com.xiaomi.push.ah.a
    /* JADX INFO: renamed from: a */
    public String mo133a() {
        return "23";
    }
}
