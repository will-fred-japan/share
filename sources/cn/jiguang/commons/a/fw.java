package cn.jiguang.commons.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class fw extends AbstractC0552a {
    public static fw b() {
        return fx.f10080a;
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final String a() {
        return "JAppListFile";
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final void a(boolean z8) {
        String str;
        try {
            List listC = bu.a().c(1110, z8);
            if (listC == null || listC.isEmpty()) {
                str = "app list file empty";
            } else {
                JSONArray jSONArray = new JSONArray();
                Iterator it = listC.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectB = ((w) it.next()).b(128);
                    if (jSONObjectB != null) {
                        jSONArray.put(jSONObjectB);
                    }
                }
                if (jSONArray.length() == 0) {
                    str = "app list file json array empty";
                } else {
                    ArrayList<JSONArray> arrayListA = ks.a(jSONArray);
                    if (!arrayListA.isEmpty()) {
                        int size = arrayListA.size();
                        int i9 = 0;
                        while (i9 < size) {
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray2 = arrayListA.get(i9);
                            i9++;
                            jSONObject.put("slice_index", i9);
                            jSONObject.put("slice_count", size);
                            jSONObject.put("data", jSONArray2);
                            ca.a().a(jSONObject, "package_list");
                        }
                        AbstractC0552a.a("JAppListFile");
                        ee.a("JAppListFile", "app list file report ok");
                        return;
                    }
                    str = "app list file partition empty";
                }
            }
            ee.d("JAppListFile", str);
        } catch (Throwable th) {
            ee.d("JAppListFile", "app list file err:" + th.getMessage());
        }
    }
}
