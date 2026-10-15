package com.huawei.hms.framework.network.grs.local.model;

import com.engagelab.privates.common.constants.MTCommonConstants;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f15134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15135d;

    public Set<String> a() {
        return this.f15134c;
    }

    public String b() {
        return this.f15132a;
    }

    public JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f15132a);
        jSONObject.put(MTCommonConstants.Network.KEY_NAME, this.f15133b);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f15134c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("countries", jSONArray);
        jSONObject.put(com.heytap.mcssdk.constant.b.f14292i, this.f15135d);
        return jSONObject;
    }

    public void a(String str) {
        this.f15135d = str;
    }

    public void b(String str) {
        this.f15132a = str;
    }

    public void c(String str) {
        this.f15133b = str;
    }

    public void a(Set<String> set) {
        this.f15134c = set;
    }
}
