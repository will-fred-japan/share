package cn.jiguang.commons.a;

import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: renamed from: cn.jiguang.commons.a.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0552a {
    private b a(String str, boolean z8, JSONObject jSONObject) {
        return new b(this, str, jSONObject, z8);
    }

    public static long b(String str) {
        try {
            return kq.a().b(str + "_blt", 0L);
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("get last biz time failed: "), "JCommon");
            return 0L;
        }
    }

    public static void c(String str) {
        try {
            kq.a().a(str + "_rlt", System.currentTimeMillis());
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("set last report time failed: "), "JCommon");
        }
    }

    public static long d(String str) {
        try {
            return kq.a().b(str + "_rlt", 0L);
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("get last report time failed: "), "JCommon");
            return 0L;
        }
    }

    public abstract String a();

    public abstract void a(boolean z8);

    public final void a(fl flVar) {
        a(flVar, false, (JSONObject) null);
    }

    public final void a(fl flVar, JSONObject jSONObject) {
        a(flVar, true, jSONObject);
    }

    private void a(fl flVar, boolean z8, JSONObject jSONObject) {
        try {
            String strA = a();
            a(strA, flVar, a(strA, z8, jSONObject));
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("schedule collect failed, err:"), "JCommon");
        }
    }

    public final void b(fl flVar) {
        a(flVar, true, (JSONObject) null);
    }

    public static void a(String str) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            kq.a().a(str + "_blt", jCurrentTimeMillis);
        } catch (Throwable th) {
            W5.f.o(th, new StringBuilder("record biz time failed: "), "JCommon");
        }
    }

    private void a(String str, fl flVar, Runnable runnable) {
        try {
            bq.a();
            int iA = bq.a(str);
            bq.a();
            long jA = bq.a().a(str, iA, bq.b(str));
            if (jA <= 0) {
                fe.a().a(runnable, flVar);
            } else {
                fe.a().a(new c(this, runnable, flVar), jA, TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            W5.f.o(th, defpackage.f.i("schedule task failed, tag:", str, ", err:"), "JCommon");
        }
    }

    public void a(boolean z8, JSONObject jSONObject) {
    }
}
