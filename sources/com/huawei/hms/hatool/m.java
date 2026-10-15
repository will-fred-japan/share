package com.huawei.hms.hatool;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static m f15259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f15260c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15261a;

    private m() {
    }

    public static m a() {
        if (f15259b == null) {
            b();
        }
        return f15259b;
    }

    private static synchronized void b() {
        if (f15259b == null) {
            f15259b = new m();
        }
    }

    public void a(Context context) {
        synchronized (f15260c) {
            try {
                if (this.f15261a != null) {
                    v.f("hmsSdk", "DataManager already initialized.");
                    return;
                }
                this.f15261a = context;
                s.c().b().a(this.f15261a);
                s.c().b().j(context.getPackageName());
                j.a().a(context);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(String str) {
        v.a("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f15261a;
        if (context == null) {
            v.e("hmsSdk", "sdk is not init");
        } else {
            s.c().b().i(e1.a(com.heytap.mcssdk.constant.b.f14302u, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
        }
    }
}
