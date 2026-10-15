package cn.jiguang.commons.a;

import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class is {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f10215d = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONArray f10213b = new JSONArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONArray f10214c = new JSONArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f10212a = new JSONArray();

    public final int a(int i9) {
        return this.f10215d.addAndGet(i9);
    }

    public final void b(String str) {
        if (str != null) {
            this.f10214c.put(str);
        }
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.f10213b.length() > 0) {
            jSONObject.put("g", this.f10213b);
        }
        if (this.f10214c.length() > 0) {
            jSONObject.put("w", this.f10214c);
        }
        if (this.f10212a.length() > 0) {
            jSONObject.put("c", this.f10212a);
        }
        return jSONObject;
    }

    public final void a(String str) {
        if (str != null) {
            this.f10213b.put(str);
        }
    }
}
