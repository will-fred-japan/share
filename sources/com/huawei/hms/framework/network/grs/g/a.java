package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected d f15056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f15058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f15060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f15061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final GrsBaseInfo f15062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.c f15063h;

    public a(String str, int i9, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.f15057b = str;
        this.f15058c = cVar;
        this.f15059d = i9;
        this.f15060e = context;
        this.f15061f = str2;
        this.f15062g = grsBaseInfo;
        this.f15063h = cVar2;
    }

    public Context a() {
        return this.f15060e;
    }

    public c b() {
        return this.f15058c;
    }

    public String c() {
        return this.f15057b;
    }

    public int d() {
        return this.f15059d;
    }

    public String e() {
        return this.f15061f;
    }

    public com.huawei.hms.framework.network.grs.e.c f() {
        return this.f15063h;
    }

    public Callable<d> g() {
        return new f(this.f15057b, this.f15059d, this.f15058c, this.f15060e, this.f15061f, this.f15062g, this.f15063h);
    }
}
