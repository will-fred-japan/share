package com.huawei.agconnect.config.impl;

import android.util.Log;
import com.huawei.agconnect.config.ConfigReader;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i implements ConfigReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f14616a;

    public i(InputStream inputStream, String str) {
        this.f14616a = a(inputStream);
        a(str);
    }

    private JSONObject a(InputStream inputStream) {
        String str;
        if (inputStream != null) {
            try {
                return new JSONObject(Utils.toString(inputStream, "UTF-8"));
            } catch (IOException unused) {
                str = "IOException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            } catch (JSONException unused2) {
                str = "JSONException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    private JSONObject b(String str) throws JSONException {
        JSONArray jSONArray = this.f14616a.getJSONArray("appInfos");
        for (int i9 = 0; i9 < jSONArray.length(); i9++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i9);
            if (jSONObject.getString(Constants.PACKAGE_NAME).equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String str, String str2) {
        if (!str.endsWith("/")) {
            String[] strArrSplit = str.split("/");
            try {
                JSONObject jSONObject = this.f14616a;
                for (int i9 = 1; i9 < strArrSplit.length; i9++) {
                    if (i9 == strArrSplit.length - 1) {
                        str = jSONObject.get(strArrSplit[i9]).toString();
                        return str;
                    }
                    jSONObject = jSONObject.getJSONObject(strArrSplit[i9]);
                }
            } catch (JSONException unused) {
                Log.w("InputStreamReader", "JSONException when reading 'path': ".concat(str));
            }
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.f14616a.toString().hashCode() + '}';
    }

    private void a(String str) {
        try {
            JSONObject jSONObjectB = b(str);
            if (jSONObjectB == null) {
                return;
            }
            String string = getString("/configuration_version", "");
            BigDecimal bigDecimal = new BigDecimal("0.0");
            try {
                bigDecimal = BigDecimal.valueOf(Double.parseDouble(string));
            } catch (NumberFormatException unused) {
                Log.d("InputStreamReader", "configuration_version to double error");
            }
            if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                this.f14616a.getJSONObject("client").put("app_id", jSONObjectB.getString("app_id"));
                return;
            }
            if (bigDecimal.compareTo(new BigDecimal("3.0")) >= 0) {
                Iterator<String> itKeys = jSONObjectB.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!Constants.PACKAGE_NAME.equals(next)) {
                        a(next, jSONObjectB.get(next), this.f14616a);
                    }
                }
            }
        } catch (JSONException unused2) {
            Log.d("InputStreamReader", "JSONException when reading the 'appInfos' from InputStream.");
        }
    }

    private void a(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            a(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
        }
    }
}
