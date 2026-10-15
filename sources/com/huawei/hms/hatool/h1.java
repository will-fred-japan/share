package com.huawei.hms.hatool;

import android.text.TextUtils;
import cn.jpush.android.api.InAppSlotParams;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h1 implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b1> f15210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k0 f15211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private t0 f15212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private o1 f15213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f15214e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15215f;

    public h1(String str) {
        this.f15215f = str;
    }

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        String str;
        List<b1> list = this.f15210a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f15211b == null || this.f15212c == null || this.f15213d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f15211b.a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObjectA = this.f15213d.a();
            jSONObjectA.put("properties", this.f15212c.a());
            try {
                jSONObjectA.put("events_global_properties", new JSONObject(this.f15214e));
            } catch (JSONException unused) {
                jSONObjectA.put("events_global_properties", this.f15214e);
            }
            jSONObject2.put("events_common", jSONObjectA);
            JSONArray jSONArray = new JSONArray();
            Iterator<b1> it = this.f15210a.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectA2 = it.next().a();
                if (jSONObjectA2 != null) {
                    jSONArray.put(jSONObjectA2);
                } else {
                    v.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put("events", jSONArray);
            try {
                String strA = n.a(k1.a(jSONObject2.toString().getBytes("UTF-8")), this.f15215f);
                if (TextUtils.isEmpty(strA)) {
                    v.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put(InAppSlotParams.SLOT_KEY.EVENT, strA);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        v.e("hmsSdk", str);
        return null;
    }

    public void a(k0 k0Var) {
        this.f15211b = k0Var;
    }

    public void a(l lVar) {
        this.f15213d = lVar;
    }

    public void a(t0 t0Var) {
        this.f15212c = t0Var;
    }

    public void a(String str) {
        if (str != null) {
            this.f15214e = str;
        }
    }

    public void a(List<b1> list) {
        this.f15210a = list;
    }
}
