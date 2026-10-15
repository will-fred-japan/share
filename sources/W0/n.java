package W0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OaidSp.java */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f5023a;

    public n(Context context) {
        this.f5023a = context.getSharedPreferences("device_register_oaid_refine", 0);
    }

    public final m a() {
        String string = this.f5023a.getString("oaid", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            return new m(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has(CrashHianalyticsData.TIME) ? Long.valueOf(jSONObject.optLong(CrashHianalyticsData.TIME, -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e9) {
            e9.printStackTrace();
            return null;
        }
    }
}
