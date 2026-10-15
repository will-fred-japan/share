package cn.jiguang.commons.b;

import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import com.jieli.jl_bt_ota.constant.GattError;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void c(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("sm", 3);
            bundle.putString("ds", str);
            JCoreManager.onEvent(null, null, GattError.GATT_ERROR, null, bundle, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static String ct(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                return jSONObject.toString();
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static Object h(String str, String str2, Map<String, String> map, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putString("m", str);
        bundle.putString("u", str2);
        bundle.putString("h", map != null ? ct(map).toString() : null);
        bundle.putByteArray("b", bArr);
        bundle.putInt("sm", 2);
        return JCoreManager.onEvent(null, null, GattError.GATT_ERROR, null, bundle, new Object[0]);
    }

    public static void r(int i9) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("sm", 4);
            bundle.putInt("dc", i9);
            JCoreManager.onEvent(null, null, GattError.GATT_ERROR, null, bundle, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static void u(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("sm", 1);
            bundle.putString("ds", str);
            JCoreManager.onEvent(null, null, GattError.GATT_ERROR, null, bundle, new Object[0]);
        } catch (Throwable unused) {
        }
    }
}
