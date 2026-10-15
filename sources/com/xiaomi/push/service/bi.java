package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.util.Base64;
import com.xiaomi.push.cv;
import com.xiaomi.push.ee;
import com.xiaomi.push.ef;
import com.xiaomi.push.hn;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class bi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static bi f18336a = new bi();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f1080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.ai.b f1081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ee.a f1082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<a> f1083a = new ArrayList();

    public static abstract class a {
        public void a(ee.a aVar) {
        }

        public void a(ef.b bVar) {
        }
    }

    private bi() {
    }

    private void b() throws Throwable {
        if (this.f1082a == null) {
            d();
        }
    }

    private void c() {
        if (this.f1081a != null) {
            return;
        }
        com.xiaomi.push.ai.b bVar = new com.xiaomi.push.ai.b() { // from class: com.xiaomi.push.service.bi.1

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            boolean f1084a = false;

            @Override // com.xiaomi.push.ai.b
            public void b() {
                try {
                    ee.a aVarA = ee.a.a(Base64.decode(cv.a(com.xiaomi.push.t.m835a(), "https://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.aw>) null), 10));
                    if (aVarA != null) {
                        bi.this.f1082a = aVarA;
                        this.f1084a = true;
                        bi.this.e();
                    }
                } catch (Exception e9) {
                    com.xiaomi.channel.commonutils.logger.c.m9a("fetch config failure: " + e9.getMessage());
                }
            }

            @Override // com.xiaomi.push.ai.b
            /* JADX INFO: renamed from: c */
            public void mo250c() {
                a[] aVarArr;
                bi.this.f1081a = null;
                if (this.f1084a) {
                    synchronized (bi.this) {
                        aVarArr = (a[]) bi.this.f1083a.toArray(new a[bi.this.f1083a.size()]);
                    }
                    for (a aVar : aVarArr) {
                        aVar.a(bi.this.f1082a);
                    }
                }
            }
        };
        this.f1081a = bVar;
        hn.a(bVar);
    }

    private void d() throws Throwable {
        BufferedInputStream bufferedInputStream;
        Exception e9;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(com.xiaomi.push.t.m835a().openFileInput("XMCloudCfg"));
                try {
                    this.f1082a = ee.a.b(com.xiaomi.push.c.a(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Exception e10) {
                    e9 = e10;
                    com.xiaomi.channel.commonutils.logger.c.m9a("load config failure: " + e9.getMessage());
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                com.xiaomi.push.y.a((Closeable) bufferedInputStream2);
                throw th;
            }
        } catch (Exception e11) {
            bufferedInputStream = null;
            e9 = e11;
        } catch (Throwable th2) {
            th = th2;
            com.xiaomi.push.y.a((Closeable) bufferedInputStream2);
            throw th;
        }
        com.xiaomi.push.y.a((Closeable) bufferedInputStream);
        if (this.f1082a == null) {
            this.f1082a = new ee.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f1082a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.t.m835a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.d dVarA = com.xiaomi.push.d.a(bufferedOutputStream);
                this.f1082a.a(dVarA);
                dVarA.m199a();
                bufferedOutputStream.close();
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a("save config failure: " + e9.getMessage());
        }
    }

    public static bi a() {
        return f18336a;
    }

    public synchronized void a(a aVar) {
        this.f1083a.add(aVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m779a() {
        this.f1083a.clear();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m777a() throws Throwable {
        b();
        ee.a aVar = this.f1082a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ee.a m778a() throws Throwable {
        b();
        return this.f1082a;
    }

    public void a(ef.b bVar) {
        a[] aVarArr;
        if (bVar.m285d() && bVar.d() > m777a()) {
            c();
        }
        synchronized (this) {
            List<a> list = this.f1083a;
            aVarArr = (a[]) list.toArray(new a[list.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized String m774a() {
        try {
            if (f1080a == null) {
                SharedPreferences sharedPreferences = com.xiaomi.push.t.m835a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f1080a = string;
                if (string == null) {
                    String strA = com.xiaomi.push.j.a(com.xiaomi.push.t.m835a(), false);
                    f1080a = strA;
                    if (strA != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f1080a).commit();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1080a;
    }
}
