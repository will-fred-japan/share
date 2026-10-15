package cn.jiguang.commons.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class fr extends AbstractC0552a {
    private static JSONObject a(int i9, int i10, JSONArray jSONArray) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slice_index", i9);
            jSONObject.put("slice_count", i10);
            jSONObject.put("data", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public final void a(List<v> list) {
        JSONArray jSONArray;
        JSONObject jSONObjectA;
        String strA;
        String str;
        if (list == null || list.isEmpty()) {
            ee.a(a(), "no active info to report");
            return;
        }
        try {
            if (list.isEmpty()) {
                jSONArray = new JSONArray();
            } else {
                JSONArray jSONArray2 = new JSONArray();
                for (v vVar : list) {
                    if (vVar != null && (jSONObjectA = vVar.a(128)) != null) {
                        jSONArray2.put(jSONObjectA);
                    }
                }
                jSONArray = jSONArray2;
            }
            if (jSONArray.length() == 0) {
                strA = a();
                str = "no active data to report";
            } else {
                ArrayList<JSONArray> arrayListA = ks.a(jSONArray);
                if (arrayListA == null || arrayListA.isEmpty()) {
                    strA = a();
                    str = "no active data after partitioning";
                } else {
                    int size = arrayListA.size();
                    int i9 = 0;
                    while (i9 < size) {
                        int i10 = i9 + 1;
                        ca.a().a(a(i10, size, arrayListA.get(i9)), "app_active");
                        i9 = i10;
                    }
                    AbstractC0552a.a(a());
                    strA = a();
                    str = "all active data slices reported";
                }
            }
            ee.a(strA, str);
        } catch (Throwable unused) {
        }
    }
}
