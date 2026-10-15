package S1;

import android.text.TextUtils;
import com.bytedance.retrofit2.mime.TypedOutput;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MonitorAdditionalPart.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements TypedOutput {
    public b(String str) {
        if (TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("defaultData", "none commonParams");
            } catch (JSONException unused) {
            }
            jSONObject.toString();
        }
    }
}
