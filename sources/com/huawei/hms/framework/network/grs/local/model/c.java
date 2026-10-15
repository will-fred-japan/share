package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, d> f15138c = new ConcurrentHashMap(16);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<b> f15139d = new ArrayList(16);

    public d a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f15138c.get(str);
        }
        Logger.w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
        return null;
    }

    public String b() {
        return this.f15137b;
    }

    public JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MTCommonConstants.Network.KEY_NAME, this.f15136a);
        jSONObject.put("routeBy", this.f15137b);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f15138c.keySet().iterator();
        while (it.hasNext()) {
            d dVar = this.f15138c.get(it.next());
            if (dVar != null) {
                jSONArray.put(dVar.c());
            }
        }
        jSONObject.put("servings", jSONArray);
        if (this.f15139d != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<b> it2 = this.f15139d.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().c());
            }
            jSONObject.put("countryGroups", jSONArray2);
        }
        return jSONObject;
    }

    public List<b> a() {
        return this.f15139d;
    }

    public void b(String str) {
        this.f15136a = str;
    }

    public void c(String str) {
        this.f15137b = str;
    }

    public void a(String str, d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        this.f15138c.put(str, dVar);
    }

    public void a(List<b> list) {
        this.f15139d = list;
    }
}
