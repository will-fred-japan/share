package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ExtensionRegistryLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0520n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile C0520n f7281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0520n f7282c = new C0520n(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<a, AbstractC0528w.e<?, ?>> f7283a;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.n$a */
    /* JADX INFO: compiled from: ExtensionRegistryLite.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Q f7284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7285b;

        public a(int i9, Q q8) {
            this.f7284a = q8;
            this.f7285b = i9;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7284a == aVar.f7284a && this.f7285b == aVar.f7285b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f7284a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f7285b;
        }
    }

    public C0520n() {
        this.f7283a = new HashMap();
    }

    public static C0520n a() {
        C0520n c0520n;
        c0 c0Var = c0.f7206c;
        C0520n c0520n2 = f7281b;
        if (c0520n2 != null) {
            return c0520n2;
        }
        synchronized (C0520n.class) {
            try {
                c0520n = f7281b;
                if (c0520n == null) {
                    Class<?> cls = C0519m.f7280a;
                    C0520n c0520n3 = null;
                    if (cls != null) {
                        try {
                            c0520n3 = (C0520n) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    c0520n = c0520n3 != null ? c0520n3 : f7282c;
                    f7281b = c0520n;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0520n;
    }

    public C0520n(int i9) {
        this.f7283a = Collections.EMPTY_MAP;
    }
}
