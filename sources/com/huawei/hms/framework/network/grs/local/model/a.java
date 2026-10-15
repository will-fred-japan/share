package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.huawei.hms.framework.common.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, c> f15131c = new ConcurrentHashMap(16);

    public c a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f15131c.get(str);
        }
        Logger.w("ApplicationBean", "In getServing(String serviceName), the serviceName is Empty or null");
        return null;
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MTCommonConstants.Network.KEY_NAME, TextUtils.isEmpty(this.f15129a) ? "" : this.f15129a);
        jSONObject.put("cacheControl", this.f15130b);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f15131c.keySet().iterator();
        while (it.hasNext()) {
            c cVar = this.f15131c.get(it.next());
            if (cVar != null) {
                jSONArray.put(cVar.c());
            }
        }
        Logger.i("ApplicationBean", "local config save to sp, services count:" + jSONArray.length());
        jSONObject.put("services", jSONArray);
        return jSONObject;
    }

    public String a() {
        return this.f15129a;
    }

    public void b(String str) {
        this.f15129a = str;
    }

    public void a(long j) {
        this.f15130b = j;
    }

    public void a(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        this.f15131c.put(str, cVar);
    }
}
