package com.huawei.hms.framework.network.grs.e;

import W5.e;
import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15043b = "c";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, PLSharedPreferences> f15044c = new ConcurrentHashMap(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PLSharedPreferences f15045a;

    public c(Context context, String str) {
        String packageName = context.getPackageName();
        Logger.d(f15043b, "get pkgname from context is{%s}", packageName);
        Map<String, PLSharedPreferences> map = f15044c;
        if (map.containsKey(str + packageName)) {
            this.f15045a = map.get(str + packageName);
        } else {
            PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(context, e.u(str, packageName));
            this.f15045a = pLSharedPreferences;
            map.put(str + packageName, pLSharedPreferences);
        }
        a(context);
    }

    public String a(String str, String str2) {
        String string;
        PLSharedPreferences pLSharedPreferences = this.f15045a;
        if (pLSharedPreferences == null) {
            return str2;
        }
        synchronized (pLSharedPreferences) {
            string = this.f15045a.getString(str, str2);
        }
        return string;
    }

    public void b() {
        PLSharedPreferences pLSharedPreferences = this.f15045a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f15045a.clear();
        }
    }

    public Map<String, ?> a() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = this.f15045a;
        if (pLSharedPreferences == null) {
            return new HashMap();
        }
        synchronized (pLSharedPreferences) {
            all = this.f15045a.getAll();
        }
        return all;
    }

    public void b(String str, String str2) {
        PLSharedPreferences pLSharedPreferences = this.f15045a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f15045a.putString(str, str2);
        }
    }

    private void a(Context context) {
        String str = f15043b;
        Logger.i(str, "ContextHolder.getAppContext() from GRS is:" + ContextHolder.getAppContext());
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            String string = Long.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), Http2.INITIAL_MAX_FRAME_SIZE).versionCode);
            String strA = a("version", "");
            if (string.equals(strA)) {
                return;
            }
            Logger.i(str, "app version changed! old version{%s} and new version{%s}", strA, string);
            b();
            b("version", string);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.w(f15043b, "get app version failed and catch NameNotFoundException");
        }
    }

    public void a(String str) {
        PLSharedPreferences pLSharedPreferences = this.f15045a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f15045a.remove(str);
        }
    }
}
