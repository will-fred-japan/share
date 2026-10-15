package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Android.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0510d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f7209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f7210b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f7209a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f7210b = cls2 != null;
    }

    public static boolean a() {
        return (f7209a == null || f7210b) ? false : true;
    }
}
