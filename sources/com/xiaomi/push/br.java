package com.xiaomi.push;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class br extends JSONObject implements bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f17099a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f17100b = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final LinkedHashMap<String, Integer> f149a = new LinkedHashMap<>();

    @Override // com.xiaomi.push.bp
    public int a() {
        int iIntValue = f17099a;
        Iterator<Integer> it = this.f149a.values().iterator();
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return (length() - 1) + iIntValue;
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, int i9) {
        if (!TextUtils.isEmpty(str)) {
            this.f149a.put(str, Integer.valueOf(String.valueOf(i9).length() + str.length() + f17100b));
        }
        return super.put(str, i9);
    }

    @Override // org.json.JSONObject
    public Object remove(String str) {
        this.f149a.remove(str);
        return super.remove(str);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.f149a.put(str, Integer.valueOf(String.valueOf(j).length() + str.length() + f17100b));
        }
        return super.put(str, j);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, double d9) {
        if (!TextUtils.isEmpty(str)) {
            this.f149a.put(str, Integer.valueOf(String.valueOf(d9).length() + str.length() + f17100b));
        }
        return super.put(str, d9);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, Object obj) throws JSONException {
        JSONObject jSONObjectPut = super.put(str, obj);
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (obj instanceof bp) {
                this.f149a.put(str, Integer.valueOf(((bp) obj).a() + str.length() + f17100b));
                return jSONObjectPut;
            }
            this.f149a.put(str, Integer.valueOf(str.length() + String.valueOf(obj).getBytes(StandardCharsets.UTF_8).length + f17100b + f17099a));
        }
        return jSONObjectPut;
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, boolean z8) {
        if (!TextUtils.isEmpty(str)) {
            this.f149a.put(str, Integer.valueOf(String.valueOf(z8).length() + str.length() + f17100b));
        }
        return super.put(str, z8);
    }
}
