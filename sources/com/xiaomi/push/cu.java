package com.xiaomi.push;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class cu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17167a;

    public cu(int i9) {
        this.f17167a = i9;
    }

    public abstract String a(Context context, String str, List<aw> list);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m182a(Context context, String str, List<aw> list) {
        return true;
    }

    public int a() {
        return this.f17167a;
    }
}
