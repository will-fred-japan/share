package R0;

import android.annotation.SuppressLint;
import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BuildLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends c {
    @Override // R0.c
    @SuppressLint({"MissingPermission"})
    public final boolean a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("os", "Android");
        jSONObject.put("platform", "Android");
        jSONObject.put("sdk_lib", "Android");
        if (Y3.a.f5235q) {
            String strConcat = Build.VERSION.RELEASE;
            if (strConcat != null && !strConcat.contains(".")) {
                strConcat = strConcat.concat(".0");
            }
            jSONObject.put("os_version", strConcat);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
        }
        if (Y3.a.f5232n) {
            jSONObject.put("device_model", Build.MODEL);
        }
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("sdk_target_version", 29);
        jSONObject.put("git_hash", "895e5b5");
        return true;
    }
}
