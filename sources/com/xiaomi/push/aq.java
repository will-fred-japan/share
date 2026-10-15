package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class aq implements al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile aq f17046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f120a = ap.f17045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private al f122a;

    private aq(Context context) {
        this.f121a = context.getApplicationContext();
        this.f122a = ap.a(context);
        com.xiaomi.channel.commonutils.logger.c.m9a("create id manager is: " + this.f120a);
    }

    public void a() {
    }

    public String b() {
        return null;
    }

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }

    public static aq a(Context context) {
        if (f17046a == null) {
            synchronized (aq.class) {
                try {
                    if (f17046a == null) {
                        f17046a = new aq(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17046a;
    }

    @Override // com.xiaomi.push.al
    /* JADX INFO: renamed from: a */
    public boolean mo96a() {
        return this.f122a.mo96a();
    }

    @Override // com.xiaomi.push.al
    /* JADX INFO: renamed from: a */
    public String mo95a() {
        if (k.m649a(this.f121a)) {
            return a(this.f122a.mo95a());
        }
        return "";
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String strB = b();
        if (!TextUtils.isEmpty(strB)) {
            map.put("udid", strB);
        }
        String strMo95a = mo95a();
        if (!TextUtils.isEmpty(strMo95a)) {
            map.put("oaid", strMo95a);
        }
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            map.put("vaid", strC);
        }
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            map.put("aaid", strD);
        }
        map.put("oaid_type", String.valueOf(this.f120a));
    }

    private String a(String str) {
        return str == null ? "" : str;
    }
}
