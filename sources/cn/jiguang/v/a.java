package cn.jiguang.v;

import android.content.Context;
import cn.jiguang.internal.JConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static JSONObject a(Context context) {
        try {
            Object objA = f.a(context, JConstants.SDK_TYPE, 101, null, null, new Object[0]);
            if (objA instanceof JSONObject) {
                return (JSONObject) objA;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.u.b.e("JDeviceHelper", "getDInfo exception: " + th.getMessage());
            return null;
        }
    }
}
