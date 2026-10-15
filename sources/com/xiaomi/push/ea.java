package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* JADX INFO: loaded from: classes2.dex */
public class ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ea f17288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f303a;

    public interface a {
        void a();
    }

    private ea(Context context) {
        this.f302a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        ah ahVarA = ah.a(this.f302a);
        com.xiaomi.push.service.aq aqVarA = com.xiaomi.push.service.aq.a(this.f302a);
        SharedPreferences sharedPreferences = this.f302a.getSharedPreferences("mipush_extra", 0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", jCurrentTimeMillis);
        if (j == jCurrentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", jCurrentTimeMillis).commit();
        }
        if (Math.abs(jCurrentTimeMillis - j) < 172800000) {
            return;
        }
        a(aqVarA, ahVarA, false);
        if (aqVarA.a(hz.StorageCollectionSwitch.a(), true)) {
            int iA = a(aqVarA.a(hz.StorageCollectionFrequency.a(), RemoteMessageConst.DEFAULT_TTL));
            ahVarA.a(new ec(this.f302a, iA), iA, 0);
        }
        if (k.m649a(this.f302a) && (aVar = this.f303a) != null) {
            aVar.a();
        }
        if (aqVarA.a(hz.ActivityTSSwitch.a(), false)) {
            a();
        }
        a(aqVarA, ahVarA, true);
    }

    public static ea a(Context context) {
        if (f17288a == null) {
            synchronized (ea.class) {
                try {
                    if (f17288a == null) {
                        f17288a = new ea(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17288a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m255a() {
        ah.a(this.f302a).a(new Runnable() { // from class: com.xiaomi.push.ea.1
            @Override // java.lang.Runnable
            public void run() {
                ea.this.b();
            }
        });
    }

    private void a(com.xiaomi.push.service.aq aqVar, ah ahVar, boolean z8) {
        if (aqVar.a(hz.UploadSwitch.a(), true)) {
            ed edVar = new ed(this.f302a);
            if (z8) {
                ahVar.a((ah.a) edVar, a(aqVar.a(hz.UploadFrequency.a(), RemoteMessageConst.DEFAULT_TTL)));
            } else {
                ahVar.m89a((ah.a) edVar);
            }
        }
    }

    public static int a(int i9) {
        return Math.max(60, i9);
    }

    private boolean a() {
        Application application;
        try {
            Context context = this.f302a;
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new du(this.f302a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
            return false;
        }
    }
}
