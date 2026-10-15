package cn.jiguang.commons.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10416c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<Long> f10418e = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<Integer> f10417d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f10419f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<Long> f10420g = new ArrayList();

    public final JSONObject a(int i9) {
        try {
            if (this.f10415b == 0 && this.f10418e.isEmpty() && this.f10419f.isEmpty()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            String str = this.f10414a;
            int length = str.length();
            String strSubSequence = str;
            if (128 < length) {
                strSubSequence = str.subSequence(0, 128);
            }
            JSONObject jSONObjectPut = jSONObject.put("pkg", strSubSequence);
            long j = this.f10415b;
            if (j > 0) {
                jSONObjectPut.put("active_duration", j);
            }
            if (this.f10418e.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<Long> it = this.f10418e.iterator();
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    if (jLongValue > 0) {
                        jSONArray.put(jLongValue);
                    }
                }
                jSONObjectPut.put("active_time", jSONArray);
            }
            if (this.f10417d.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (Integer num : this.f10417d) {
                    if (num.intValue() > 0) {
                        jSONArray2.put(num);
                    }
                }
                jSONObjectPut.put("source", jSONArray2);
            }
            if (this.f10419f.size() > 0) {
                JSONArray jSONArray3 = new JSONArray();
                for (String str2 : this.f10419f) {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONArray3.put(str2);
                    }
                }
                jSONObjectPut.put("page_name", jSONArray3);
            }
            jSONObjectPut.put("launch_count", this.f10416c);
            return jSONObjectPut;
        } catch (Throwable unused) {
            return null;
        }
    }
}
