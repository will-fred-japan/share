package p096m7;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: MethodCall.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20497b;

    public j(Object obj, String str) {
        this.f20496a = str;
        this.f20497b = obj;
    }

    public final <T> T a(String str) {
        Object obj = this.f20497b;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return (T) ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return (T) ((JSONObject) obj).opt(str);
        }
        throw new ClassCastException();
    }

    public final <T> T b() {
        return (T) this.f20497b;
    }

    public final boolean c(String str) {
        Object obj = this.f20497b;
        if (obj == null) {
            return false;
        }
        if (obj instanceof Map) {
            return ((Map) obj).containsKey(str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).has(str);
        }
        throw new ClassCastException();
    }
}
