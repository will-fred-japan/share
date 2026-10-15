package p140s0;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import cn.ikaile.ruoshui.client.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AppInitializer.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f21179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f21180e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f21183c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f21182b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f21181a = new HashMap();

    public a(Context context) {
        this.f21183c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f21179d == null) {
            synchronized (f21180e) {
                try {
                    if (f21179d == null) {
                        f21179d = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21179d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f21183c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = this.f21182b;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e9) {
                throw new c(e9);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object objB;
        if (p156u0.a.b()) {
            try {
                Trace.beginSection(p156u0.a.c(cls.getSimpleName()));
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        HashMap map = this.f21181a;
        if (map.containsKey(cls)) {
            objB = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends b<?>>> listA = bVar.a();
                if (!listA.isEmpty()) {
                    for (Class<? extends b<?>> cls2 : listA) {
                        if (!map.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                objB = bVar.b(this.f21183c);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th2) {
                throw new c(th2);
            }
        }
        Trace.endSection();
        return objB;
    }
}
