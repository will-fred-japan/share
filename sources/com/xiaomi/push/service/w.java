package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static w f18413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f1158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<String> f1159a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f18414b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f18415c = new ArrayList();

    private w(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f1158a = applicationContext;
        if (applicationContext == null) {
            this.f1158a = context;
        }
        SharedPreferences sharedPreferences = this.f1158a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (TextUtils.isEmpty(str)) {
                this.f1159a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f18414b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str3)) {
                this.f18415c.add(str3);
            }
        }
    }

    public static w a(Context context) {
        if (f18413a == null) {
            f18413a = new w(context);
        }
        return f18413a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m831b(String str) {
        boolean zContains;
        synchronized (this.f18414b) {
            zContains = this.f18414b.contains(str);
        }
        return zContains;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m832c(String str) {
        boolean zContains;
        synchronized (this.f18415c) {
            zContains = this.f18415c.contains(str);
        }
        return zContains;
    }

    public void d(String str) {
        synchronized (this.f1159a) {
            try {
                if (this.f1159a.contains(str)) {
                    this.f1159a.remove(str);
                    this.f1158a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bm.a(this.f1159a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(String str) {
        synchronized (this.f18414b) {
            try {
                if (this.f18414b.contains(str)) {
                    this.f18414b.remove(str);
                    this.f1158a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bm.a(this.f18414b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(String str) {
        synchronized (this.f18415c) {
            try {
                if (this.f18415c.contains(str)) {
                    this.f18415c.remove(str);
                    this.f1158a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bm.a(this.f18415c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m830a(String str) {
        boolean zContains;
        synchronized (this.f1159a) {
            zContains = this.f1159a.contains(str);
        }
        return zContains;
    }

    public void b(String str) {
        synchronized (this.f18414b) {
            try {
                if (!this.f18414b.contains(str)) {
                    this.f18414b.add(str);
                    this.f1158a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bm.a(this.f18414b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(String str) {
        synchronized (this.f18415c) {
            try {
                if (!this.f18415c.contains(str)) {
                    this.f18415c.add(str);
                    this.f1158a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bm.a(this.f18415c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(String str) {
        synchronized (this.f1159a) {
            try {
                if (!this.f1159a.contains(str)) {
                    this.f1159a.add(str);
                    this.f1158a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bm.a(this.f1159a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
