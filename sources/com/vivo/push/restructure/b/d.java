package com.vivo.push.restructure.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.PushConfig;
import com.vivo.push.util.ac;
import com.vivo.push.util.ad;
import com.vivo.push.util.ak;
import com.vivo.push.util.i;
import com.vivo.push.util.w;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PushRelyImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, c> f16761a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ac f16764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile PushConfig f16765e;

    public d(ac acVar) {
        this.f16764d = acVar;
    }

    @Override // com.vivo.push.restructure.b.a
    public final String a(Context context, String str) {
        if (!TextUtils.isEmpty(this.f16762b)) {
            return this.f16762b;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            w.a("PushRelyImpl", "getReceiverClassName() params error, context = " + context + ", action = " + str);
            return "";
        }
        String packageName = context.getPackageName();
        String strA = a(context, packageName, str);
        this.f16762b = strA;
        if (TextUtils.isEmpty(strA)) {
            w.d("PushRelyImpl", " reflectReceiver error: receiver for: " + str + " not found, package: " + packageName);
        }
        return this.f16762b;
    }

    @Override // com.vivo.push.restructure.b.a
    public final String b(Context context, String str) {
        if (!TextUtils.isEmpty(this.f16763c)) {
            return this.f16763c;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        String strB = b(context, context.getPackageName(), str);
        this.f16763c = strB;
        if (TextUtils.isEmpty(strB)) {
            w.d("PushRelyImpl", "getExtensionServiceClassName is empty");
        }
        return this.f16763c;
    }

    @Override // com.vivo.push.restructure.b.a
    public final String c() {
        c cVar = f16761a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar != null) {
            String strB = cVar.b();
            if (!TextUtils.isEmpty(strB)) {
                return strB;
            }
        }
        String strD = this.f16764d.d();
        if (!TextUtils.isEmpty(strD)) {
            if (cVar == null) {
                cVar = new c();
            }
            cVar.b(strD);
            f16761a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
        }
        return strD;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void d() {
        b("");
    }

    @Override // com.vivo.push.restructure.b.a
    public final void e() {
        this.f16764d.b();
        f16761a.clear();
    }

    @Override // com.vivo.push.restructure.b.a
    public final String f() {
        return this.f16764d.b("APP_TOKEN", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final String g() {
        return this.f16764d.b("APP_TAGS", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void h() {
        this.f16764d.c("APP_TAGS");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String i() {
        return this.f16764d.b("APP_ALIAS", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void j() {
        this.f16764d.c("APP_ALIAS");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String k() {
        com.vivo.push.model.a aVarA = ad.a(com.vivo.push.restructure.a.a().b(), com.vivo.push.restructure.a.a().f());
        if (aVarA == null || aVarA.c()) {
            return null;
        }
        return aVarA.a();
    }

    @Override // com.vivo.push.restructure.b.a
    public final int l() {
        return 127;
    }

    @Override // com.vivo.push.restructure.b.a
    public final PushConfig m() {
        if (this.f16765e != null) {
            return this.f16765e;
        }
        int iB = this.f16764d.b("PUSH_CLIENT_CONFIG", 1);
        return new PushConfig.Builder().agreePrivacyStatement((iB & 1) != 0).openMultiUserMode((iB & 2) != 0).build();
    }

    @Override // com.vivo.push.restructure.b.a
    public final void d(String str) {
        this.f16764d.a("APP_TAGS", str);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void e(String str) {
        this.f16764d.a("APP_ALIAS", str);
    }

    private static String b(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return null;
                }
                List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 64);
                if (!ak.a(listQueryIntentServices)) {
                    return listQueryIntentServices.get(0).serviceInfo.name;
                }
            } catch (Exception e9) {
                A.f.m(e9, new StringBuilder("getServiceClassName error  "), "PushRelyImpl");
            }
        }
        return null;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void c(String str) {
        this.f16764d.a("APP_TOKEN", str);
    }

    private static String a(Context context, String str, String str2) {
        List<ResolveInfo> listQueryBroadcastReceivers;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) != null && listQueryBroadcastReceivers.size() > 0) {
                    return listQueryBroadcastReceivers.get(0).activityInfo.name;
                }
            } catch (Exception e9) {
                A.f.m(e9, new StringBuilder("error  "), "PushRelyImpl");
            }
        }
        return null;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void b() {
        a("");
    }

    @Override // com.vivo.push.restructure.b.a
    public final void b(String str) {
        this.f16764d.a("APP_APIKEY", str);
        c cVar = f16761a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar == null) {
            cVar = new c();
        }
        cVar.b(str);
        f16761a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
    }

    @Override // com.vivo.push.restructure.b.a
    public final String a() {
        c cVar = f16761a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar != null) {
            String strA = cVar.a();
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        String strC = this.f16764d.c();
        if (!TextUtils.isEmpty(strC)) {
            if (cVar == null) {
                cVar = new c();
            }
            cVar.a(strC);
            f16761a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
        }
        return strC;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void a(String str) {
        this.f16764d.a("APP_APPID", str);
        c cVar = f16761a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar == null) {
            cVar = new c();
        }
        cVar.a(str);
        f16761a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void a(PushConfig pushConfig) {
        if (pushConfig == null) {
            return;
        }
        this.f16765e = pushConfig;
        Context contextB = com.vivo.push.restructure.a.a().b();
        this.f16764d.a("PUSH_CLIENT_CONFIG", (pushConfig.isAgreePrivacyStatement() ? 1 : 0) | (pushConfig.isOpenMultiUser() ? 2 : 0));
        i.a().execute(new e(this, contextB, pushConfig));
    }
}
