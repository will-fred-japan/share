package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ExtensionRegistryLite.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0576o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile C0576o f14137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0576o f14138c = new C0576o(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<a, AbstractC0583w.e<?, ?>> f14139a;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.o$a */
    /* JADX INFO: compiled from: ExtensionRegistryLite.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Q f14140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14141b;

        public a(Q q8, int i9) {
            this.f14140a = q8;
            this.f14141b = i9;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f14140a == aVar.f14140a && this.f14141b == aVar.f14141b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f14140a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f14141b;
        }
    }

    public C0576o() {
        this.f14139a = new HashMap();
    }

    public static C0576o a() {
        C0576o c0576o;
        b0 b0Var = b0.f14041c;
        C0576o c0576o2 = f14137b;
        if (c0576o2 != null) {
            return c0576o2;
        }
        synchronized (C0576o.class) {
            try {
                c0576o = f14137b;
                if (c0576o == null) {
                    Class<?> cls = C0575n.f14128a;
                    C0576o c0576o3 = null;
                    if (cls != null) {
                        try {
                            c0576o3 = (C0576o) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    c0576o = c0576o3 != null ? c0576o3 : f14138c;
                    f14137b = c0576o;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0576o;
    }

    public C0576o(int i9) {
        this.f14139a = Collections.EMPTY_MAP;
    }
}
