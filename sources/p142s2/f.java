package p142s2;

import X2.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Apm.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements b {
    @Override // X2.b
    public final JSONObject a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                for (int i9 = 0; i9 < length; i9++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i9);
                    JSONArray jSONArray2 = jSONObjectOptJSONObject.getJSONArray("data");
                    JSONArray jSONArray3 = new JSONArray();
                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                        int length2 = jSONArray2.length();
                        for (int i10 = 0; i10 < length2; i10++) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArray2.optJSONObject(i10);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("payload", jSONObjectOptJSONObject2);
                            jSONObject2.put("log_type", jSONObjectOptJSONObject2.opt("service"));
                            jSONArray3.put(jSONObject2);
                        }
                    }
                    jSONObjectOptJSONObject.put("data", jSONArray3);
                }
            }
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
        return jSONObject;
    }
}
