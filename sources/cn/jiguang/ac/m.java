package cn.jiguang.ac;

import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f8913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f8914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f8916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f8918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f8919i;
    public long j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8920k;

    public static m a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                m mVar = new m();
                mVar.f8911a = jSONObject.optString("appkey");
                mVar.f8912b = jSONObject.getInt("type");
                mVar.f8913c = g.a(jSONObject.getString("addr"));
                mVar.f8915e = jSONObject.getLong("rtime");
                mVar.f8916f = jSONObject.getLong(MTPushConstants.Geofence.KEY_INTERVAL);
                mVar.f8917g = jSONObject.getInt("net");
                mVar.f8920k = jSONObject.getInt("code");
                mVar.f8914d = jSONObject.optLong("uid");
                mVar.f8918h = jSONObject.optDouble("lat");
                mVar.f8919i = jSONObject.optDouble("lng");
                mVar.j = jSONObject.optLong("ltime");
                return mVar;
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static LinkedList<m> a(String str) {
        LinkedList<m> linkedList = new LinkedList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                    linkedList.add(a(jSONArray.getJSONObject(i9)));
                }
            } catch (JSONException unused) {
            }
        }
        return linkedList;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f8911a)) {
                jSONObject.put("appkey", this.f8911a);
            }
            jSONObject.put("type", this.f8912b);
            jSONObject.put("addr", this.f8913c.toString());
            jSONObject.put("rtime", this.f8915e);
            jSONObject.put(MTPushConstants.Geofence.KEY_INTERVAL, this.f8916f);
            jSONObject.put("net", this.f8917g);
            jSONObject.put("code", this.f8920k);
            long j = this.f8914d;
            if (j != 0) {
                jSONObject.put("uid", j);
            }
            if (a(this.f8918h, this.f8919i)) {
                jSONObject.put("lat", this.f8918h);
                jSONObject.put("lng", this.f8919i);
                jSONObject.put("ltime", this.j);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static boolean a(double d9, double d10) {
        return d9 > -90.0d && d9 < 90.0d && d10 > -180.0d && d10 < 180.0d;
    }
}
