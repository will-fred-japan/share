package com.huawei.agconnect.config.impl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f14602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14603g;

    public d(String str, String str2, String str3, String str4, String str5, int i9) {
        this.f14603g = 0;
        this.f14597a = str;
        this.f14598b = str2;
        this.f14599c = str3;
        this.f14600d = str4;
        this.f14601e = str5;
        this.f14602f = i9;
        if (str != null) {
            this.f14603g = str.length() / 2;
        }
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f14597a) || TextUtils.isEmpty(this.f14598b) || TextUtils.isEmpty(this.f14599c) || TextUtils.isEmpty(this.f14600d) || this.f14597a.length() != this.f14598b.length() || this.f14598b.length() != this.f14599c.length() || this.f14599c.length() != this.f14603g * 2 || this.f14602f < 0 || TextUtils.isEmpty(this.f14601e)) ? false : true;
    }

    public String b() {
        return this.f14597a;
    }

    public String c() {
        return this.f14598b;
    }

    public String d() {
        return this.f14599c;
    }

    public String e() {
        return this.f14600d;
    }

    public String f() {
        return this.f14601e;
    }

    public int g() {
        return this.f14602f;
    }

    public int h() {
        return this.f14603g;
    }
}
