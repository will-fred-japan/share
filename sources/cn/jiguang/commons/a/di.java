package cn.jiguang.commons.a;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class di {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9885a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f9886b;

    public di(Context context) {
        this.f9886b = context;
    }

    public final String a() {
        String strA = dg.a(this.f9886b).a();
        return strA == null ? "" : strA;
    }
}
