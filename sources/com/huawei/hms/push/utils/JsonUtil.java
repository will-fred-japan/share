package com.huawei.hms.push.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsonUtil {
    private JsonUtil() {
    }

    private static void a(JSONObject jSONObject, String str, Object obj, Bundle bundle) {
        if (obj == null) {
            HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, defaultValue is null.");
            return;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            bundle.putString(str, getString(jSONObject, str, TextUtils.isEmpty(str2) ? null : str2));
            return;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, getInt(jSONObject, str, ((Integer) obj).intValue()));
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            bundle.putIntArray(str, getIntArray(jSONObject, str, iArr.length != 0 ? iArr : null));
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            bundle.putLongArray(str, getLongArray(jSONObject, str, jArr.length != 0 ? jArr : null));
        } else if (!(obj instanceof String[])) {
            HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, invalid data type.");
        } else {
            String[] strArr = (String[]) obj;
            bundle.putStringArray(str, getStringArray(jSONObject, str, strArr.length != 0 ? strArr : null));
        }
    }

    public static int getInt(JSONObject jSONObject, String str, int i9) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    return jSONObject.getInt(str);
                }
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return i9;
    }

    public static int[] getIntArray(JSONObject jSONObject, String str, int[] iArr) {
        int[] iArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    iArr2 = new int[jSONArray.length()];
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        iArr2[i9] = ((Integer) jSONArray.get(i9)).intValue();
                    }
                }
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return iArr2 == null ? iArr : iArr2;
    }

    public static JSONArray getIntJsonArray(int[] iArr) {
        JSONArray jSONArray = new JSONArray();
        if (iArr != null && iArr.length != 0) {
            for (int i9 : iArr) {
                jSONArray.put(i9);
            }
        }
        return jSONArray;
    }

    public static long[] getLongArray(JSONObject jSONObject, String str, long[] jArr) {
        long[] jArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    jArr2 = new long[jSONArray.length()];
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        jArr2[i9] = jSONArray.getLong(i9);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return jArr2 == null ? jArr : jArr2;
    }

    public static JSONArray getLongJsonArray(long[] jArr) {
        JSONArray jSONArray = new JSONArray();
        if (jArr != null && jArr.length != 0) {
            for (long j : jArr) {
                jSONArray.put(j);
            }
        }
        return jSONArray;
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str) && jSONObject.get(str) != null) {
                    return String.valueOf(jSONObject.get(str));
                }
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return str2;
    }

    public static String[] getStringArray(JSONObject jSONObject, String str, String[] strArr) {
        String[] strArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    strArr2 = new String[jSONArray.length()];
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        strArr2[i9] = (String) jSONArray.get(i9);
                    }
                    return strArr2;
                }
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return strArr2;
    }

    public static JSONArray getStringJsonArray(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                jSONArray.put(str);
            }
        }
        return jSONArray;
    }

    public static void transferJsonObjectToBundle(JSONObject jSONObject, Bundle bundle, HashMap<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            a(jSONObject, entry.getKey(), entry.getValue(), bundle);
        }
    }
}
