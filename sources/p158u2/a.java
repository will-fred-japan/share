package p158u2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PerfFilterManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f21669b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f21670a;

    public a() {
        new CopyOnWriteArraySet();
        this.f21670a = new ConcurrentHashMap<>();
    }

    public static a a() {
        if (f21669b == null) {
            synchronized (a.class) {
                try {
                    if (f21669b == null) {
                        f21669b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21669b;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.f21670a.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
