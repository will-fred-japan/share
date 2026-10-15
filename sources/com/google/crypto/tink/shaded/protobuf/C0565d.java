package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Android.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0565d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f14049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f14050b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f14049a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f14050b = cls2 != null;
    }

    public static boolean a() {
        return (f14049a == null || f14050b) ? false : true;
    }
}
