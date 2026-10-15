package cn.jpush.android.f;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<b, cn.jpush.android.e.a> f11375a = new ConcurrentHashMap();

    public static cn.jpush.android.e.a a(b bVar) {
        return f11375a.get(bVar);
    }

    public static void b(b bVar) {
        f11375a.remove(bVar);
    }

    public static void a(b bVar, cn.jpush.android.e.a aVar) {
        if (aVar != null) {
            f11375a.put(bVar, aVar);
        }
    }
}
