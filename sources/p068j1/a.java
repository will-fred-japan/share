package p068j1;

import R1.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AutoTraceStats.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, e> f19838a = new ConcurrentHashMap<>(4);

    public static void a(JSONArray jSONArray) {
        ConcurrentHashMap<String, e> concurrentHashMap = f19838a;
        try {
            if (concurrentHashMap != null) {
                try {
                    if (!concurrentHashMap.isEmpty()) {
                        for (Map.Entry<String, e> entry : concurrentHashMap.entrySet()) {
                            String key = entry.getKey();
                            e value = entry.getValue();
                            JSONObject jSONObject = new JSONObject();
                            String[] strArrSplit = key.split("#");
                            if (strArrSplit.length == 2) {
                                jSONObject.put("module_name", strArrSplit[0]);
                                jSONObject.put("span_name", strArrSplit[1]);
                            } else if (strArrSplit.length == 1) {
                                jSONObject.put("span_name", strArrSplit[0]);
                            }
                            jSONObject.put("start", value.f3982a);
                            jSONObject.put("end", value.f3983b);
                            jSONObject.put("thread", value.f3984c);
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException e9) {
                    e9.printStackTrace();
                }
            }
        } finally {
            concurrentHashMap.clear();
        }
    }
}
