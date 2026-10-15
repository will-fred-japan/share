package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<b1> f15253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f15254e;

    public l0(String str, String str2, String str3, List<b1> list, String str4) {
        this.f15250a = str;
        this.f15251b = str2;
        this.f15252c = str3;
        this.f15253d = list;
        this.f15254e = str4;
    }

    private String a(String str, String str2) {
        String str3;
        String strF = a1.f(str, str2);
        if (TextUtils.isEmpty(strF)) {
            v.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else {
            if (!"diffprivacy".equals(str2)) {
                return "";
            }
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", strF);
    }

    private void b() {
        if (c0.a(q0.i(), "backup_event", 5242880)) {
            v.d("hmsSdk", "backup file reach max limited size, delete it");
            d.a(q0.i(), "backup_event", new String[0]);
            return;
        }
        JSONArray jSONArrayC = c();
        String strA = n1.a(this.f15250a, this.f15251b, this.f15254e);
        v.c("hmsSdk", "Update data cached into backup,spKey: " + strA);
        d.b(q0.i(), "backup_event", strA, jSONArrayC.toString());
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        Iterator<b1> it = this.f15253d.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next().d());
            } catch (JSONException unused) {
                v.c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    private h1 d() {
        return k.a(this.f15253d, this.f15250a, this.f15251b, this.f15254e, this.f15252c);
    }

    public void a() {
        String strA = a(this.f15250a, this.f15251b);
        if (TextUtils.isEmpty(strA) && !"preins".equals(this.f15251b)) {
            v.e("hmsSdk", "collectUrl is empty");
            return;
        }
        if (!"_hms_config_tag".equals(this.f15250a) && !"_openness_config_tag".equals(this.f15250a)) {
            b();
        }
        h1 h1VarD = d();
        if (h1VarD == null) {
            b0.c().a(new d1(this.f15253d, this.f15250a, this.f15254e, this.f15251b));
            return;
        }
        byte[] bArrA = a(h1VarD);
        if (bArrA.length == 0) {
            v.e("hmsSdk", "request body is empty");
        } else {
            b0.b().a(new f(bArrA, strA, this.f15250a, this.f15251b, this.f15254e, this.f15253d));
        }
    }

    private byte[] a(h1 h1Var) {
        String str;
        try {
            JSONObject jSONObjectA = h1Var.a();
            if (jSONObjectA != null) {
                return k1.a(jSONObjectA.toString().getBytes("UTF-8"));
            }
            v.e("hmsSdk", "uploadEvents is null");
            return new byte[0];
        } catch (UnsupportedEncodingException unused) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            v.e("hmsSdk", str);
            return new byte[0];
        } catch (JSONException unused2) {
            str = "uploadEvents to json error";
            v.e("hmsSdk", str);
            return new byte[0];
        }
    }
}
