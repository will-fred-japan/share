package cn.jpush.android.c;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f11266c;

    public a(String str, int i9) {
        this.f11264a = str;
        this.f11265b = i9;
    }

    public int a() {
        return this.f11265b;
    }

    public String toString() {
        return "CmdMessage{cmd='" + this.f11264a + "', errorCode=" + this.f11265b + ", extra=" + this.f11266c + '}';
    }

    public void a(Bundle bundle) {
        this.f11266c = bundle;
    }
}
