package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: LogAdaptor.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14866b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14865a = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f14867c = new c();

    public void a(Context context, int i9, String str) {
        this.f14865a = i9;
        this.f14866b = str;
        this.f14867c.a(context, "HMSCore");
    }

    public void b(int i9, String str, String str2, Throwable th) {
        try {
            if (a(i9)) {
                e eVarA = a(i9, str, str2, th);
                String str3 = eVarA.c() + eVarA.a();
                this.f14867c.a(str3, i9, str, str2 + '\n' + Log.getStackTraceString(th));
            }
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    public d a() {
        return this.f14867c;
    }

    public void a(d dVar) {
        this.f14867c = dVar;
    }

    private void b() {
        try {
            Log.e("HMSSDK_LogAdaptor", "log happened OOM error.");
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i9) {
        return i9 >= this.f14865a;
    }

    public void a(int i9, String str, String str2) {
        try {
            if (a(i9)) {
                e eVarA = a(i9, str, str2, null);
                this.f14867c.a(eVarA.c() + eVarA.a(), i9, str, str2);
            }
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    public void a(String str, String str2) {
        try {
            e eVarA = a(4, str, str2, null);
            this.f14867c.a(eVarA.c() + '\n' + eVarA.a(), 4, str, str2);
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    private e a(int i9, String str, String str2, Throwable th) {
        e eVar = new e(8, this.f14866b, i9, str);
        eVar.a(str2);
        eVar.a(th);
        return eVar;
    }
}
