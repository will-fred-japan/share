package com.huawei.hms.framework.network.grs.g.j;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f15115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f15117c = new HashSet();

    public c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f15115a = grsBaseInfo;
        this.f15116b = context;
    }

    private String e() {
        Set<String> setB = com.huawei.hms.framework.network.grs.f.b.a(this.f15116b.getPackageName()).b();
        if (setB.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = setB.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.d("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private String f() {
        Logger.v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f15117c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public Context a() {
        return this.f15116b;
    }

    public GrsBaseInfo b() {
        return this.f15115a;
    }

    public String c() {
        return this.f15117c.size() == 0 ? e() : f();
    }

    public Set<String> d() {
        return this.f15117c;
    }

    public void a(String str) {
        this.f15117c.add(str);
    }
}
