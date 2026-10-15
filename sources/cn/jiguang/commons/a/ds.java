package cn.jiguang.commons.a;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class ds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9910a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f9911b;

    public ds(Context context) {
        this.f9911b = context;
    }

    public final String a() {
        String strA = dq.a(this.f9911b).a();
        return strA == null ? "" : strA;
    }

    public final void a(String str) {
        this.f9910a = str;
    }
}
