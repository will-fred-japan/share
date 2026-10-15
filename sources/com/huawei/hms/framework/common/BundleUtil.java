package com.huawei.hms.framework.common;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BundleUtil {
    public static final String TAG = "BundleUtil";
    public static final String UNDERLINE_TAG = "_";

    public static String bundleToJson(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null) {
            return jSONObject.toString();
        }
        try {
            for (String str : bundle.keySet()) {
                jSONObject.put(str, String.valueOf(bundle.get(str)));
            }
        } catch (JSONException unused) {
            Logger.e(TAG, "bundleToJson meet error");
        }
        return jSONObject.toString();
    }

    public static Bundle jsonToBundle(String str) {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle.putString(next, jSONObject.optString(next));
                }
            } catch (JSONException unused) {
                Logger.e(TAG, "jsonToBundle meet error");
            }
        }
        return bundle;
    }

    public static String transPkgPrefix(String str) {
        StringBuilder sb = new StringBuilder();
        if (str != null && str.contains(".")) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length > 0) {
                for (String str2 : strArrSplit) {
                    sb.append(str2);
                }
            }
            sb.append(UNDERLINE_TAG);
        }
        return sb.toString();
    }
}
