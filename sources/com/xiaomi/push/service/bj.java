package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class bj implements ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bj f18338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f1085a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Context f1086a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f1087a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f1089a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, a> f1088a = new ConcurrentHashMap<>();

    public static abstract class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f18340a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f1090a;

        public a(String str, long j) {
            this.f1090a = str;
            this.f18340a = j;
        }

        public abstract void a(bj bjVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bj.f18338a != null) {
                Context context = bj.f18338a.f1086a;
                if (com.xiaomi.push.ax.c(context)) {
                    if (System.currentTimeMillis() - bj.f18338a.f1087a.getLong(":ts-" + this.f1090a, 0L) > this.f18340a || com.xiaomi.push.ae.a(context)) {
                        com.xiaomi.push.q.a(bj.f18338a.f1087a.edit().putLong(":ts-" + this.f1090a, System.currentTimeMillis()));
                        a(bj.f18338a);
                    }
                }
            }
        }
    }

    private bj(Context context) {
        this.f1086a = context.getApplicationContext();
        this.f1087a = context.getSharedPreferences("sync", 0);
    }

    public static bj a(Context context) {
        if (f18338a == null) {
            synchronized (bj.class) {
                try {
                    if (f18338a == null) {
                        f18338a = new bj(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18338a;
    }

    @Override // com.xiaomi.push.service.ag
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo781a() {
        if (this.f1089a) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f1085a < 3600000) {
            return;
        }
        this.f1085a = jCurrentTimeMillis;
        this.f1089a = true;
        com.xiaomi.push.ah.a(this.f1086a).a(new Runnable() { // from class: com.xiaomi.push.service.bj.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator it = bj.this.f1088a.values().iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).run();
                    }
                } catch (Exception e9) {
                    com.xiaomi.channel.commonutils.logger.c.m9a("Sync job exception :" + e9.getMessage());
                }
                bj.this.f1089a = false;
            }
        }, (int) (Math.random() * 10.0d));
    }

    public String a(String str, String str2) {
        return this.f1087a.getString(str + Constants.COLON_SEPARATOR + str2, "");
    }

    public void a(String str, String str2, String str3) {
        com.xiaomi.push.q.a(f18338a.f1087a.edit().putString(str + Constants.COLON_SEPARATOR + str2, str3));
    }

    public void a(a aVar) {
        if (this.f1088a.putIfAbsent(aVar.f1090a, aVar) == null) {
            com.xiaomi.push.ah.a(this.f1086a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }
}
