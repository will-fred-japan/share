package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static g0 f15189c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f15191b = new Object();

    private g0() {
    }

    public static g0 a() {
        if (f15189c == null) {
            b();
        }
        return f15189c;
    }

    private static synchronized void b() {
        if (f15189c == null) {
            f15189c = new g0();
        }
    }

    private JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                v.b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    public void b(String str, int i9, String str2, LinkedHashMap<String, String> linkedHashMap) {
        e.a().a(str, i9, str2, a(linkedHashMap), System.currentTimeMillis());
    }

    public void a(Context context) {
        synchronized (this.f15191b) {
            try {
                if (this.f15190a == null) {
                    this.f15190a = context;
                    e.a().a(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(String str, int i9) {
        e.a().a(str, i9);
    }

    public void a(String str, int i9, String str2, LinkedHashMap<String, String> linkedHashMap) {
        e.a().a(str, i9, str2, a(linkedHashMap));
    }

    public void a(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            e.a().a(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            v.f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }
}
