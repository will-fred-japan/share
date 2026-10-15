package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class ao implements al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Class<?> f117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Method f119a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Method f17042b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Method f17043c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Method f17044d = null;

    public ao(Context context) {
        this.f17041a = context;
        a(context);
    }

    private void a(Context context) {
        try {
            Class<?> clsA = t.a(context, "com.android.id.impl.IdProviderImpl");
            this.f117a = clsA;
            this.f118a = clsA.newInstance();
            this.f17042b = this.f117a.getMethod("getOAID", Context.class);
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.a("miui load class error", e9);
        }
    }

    @Override // com.xiaomi.push.al
    /* JADX INFO: renamed from: a */
    public boolean mo96a() {
        return (this.f117a == null || this.f118a == null) ? false : true;
    }

    @Override // com.xiaomi.push.al
    /* JADX INFO: renamed from: a */
    public String mo95a() {
        return a(this.f17041a, this.f17042b);
    }

    private String a(Context context, Method method) {
        Object obj = this.f118a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.a("miui invoke error", e9);
            return null;
        }
    }
}
