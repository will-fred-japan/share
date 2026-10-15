package p017c2;

import R2.c;
import V2.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: PerfFilterManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f8713b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, JSONObject> f8714a = new ConcurrentHashMap<>();

    public static f a() {
        if (f8713b == null) {
            synchronized (f.class) {
                try {
                    if (f8713b == null) {
                        f8713b = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8713b;
    }

    public static String c() {
        a aVar = (a) c.a(a.class);
        return aVar != null ? aVar.a() : "";
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final JSONObject b(String str) {
        JSONObject jSONObject = this.f8714a.get(str);
        if (jSONObject == null) {
            jSONObject = null;
        } else {
            LinkedList linkedList = new LinkedList();
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys == null) {
                jSONObject = null;
            } else {
                while (itKeys.hasNext()) {
                    linkedList.add(itKeys.next());
                }
                try {
                    jSONObject = new JSONObject(jSONObject, (String[]) linkedList.toArray(new String[0]));
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            }
        }
        return jSONObject == null ? new JSONObject() : jSONObject;
    }
}
