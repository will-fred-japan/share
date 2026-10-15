package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile p f16987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f67a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<n> f68a = new ArrayList();

    private p(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f67a = applicationContext;
        if (applicationContext == null) {
            this.f67a = context;
        }
    }

    public static p a(Context context) {
        if (f16987a == null) {
            synchronized (p.class) {
                try {
                    if (f16987a == null) {
                        f16987a = new p(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f16987a;
    }

    public void b(String str) {
        synchronized (this.f68a) {
            try {
                n nVar = new n();
                nVar.f65a = str;
                if (this.f68a.contains(nVar)) {
                    for (n nVar2 : this.f68a) {
                        if (nVar.equals(nVar2)) {
                            nVar = nVar2;
                            break;
                        }
                    }
                }
                nVar.f16985a++;
                this.f68a.remove(nVar);
                this.f68a.add(nVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(String str) {
        synchronized (this.f68a) {
            try {
                n nVar = new n();
                nVar.f65a = str;
                if (this.f68a.contains(nVar)) {
                    this.f68a.remove(nVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m64a(String str) {
        synchronized (this.f68a) {
            try {
                n nVar = new n();
                nVar.f16985a = 0;
                nVar.f65a = str;
                if (this.f68a.contains(nVar)) {
                    this.f68a.remove(nVar);
                }
                this.f68a.add(nVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int a(String str) {
        synchronized (this.f68a) {
            try {
                n nVar = new n();
                nVar.f65a = str;
                if (this.f68a.contains(nVar)) {
                    for (n nVar2 : this.f68a) {
                        if (nVar2.equals(nVar)) {
                            return nVar2.f16985a;
                        }
                    }
                }
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m65a(String str) {
        synchronized (this.f68a) {
            try {
                n nVar = new n();
                nVar.f65a = str;
                return this.f68a.contains(nVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized String a(v vVar) {
        return this.f67a.getSharedPreferences("mipush_extra", 0).getString(vVar.name(), "");
    }

    public synchronized void a(v vVar, String str) {
        SharedPreferences sharedPreferences = this.f67a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(vVar.name(), str).apply();
    }
}
