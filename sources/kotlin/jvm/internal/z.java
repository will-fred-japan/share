package kotlin.jvm.internal;

/* JADX INFO: compiled from: Reflection.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final A f20009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final P7.c[] f20010b;

    static {
        A a3 = null;
        try {
            a3 = (A) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (a3 == null) {
            a3 = new A();
        }
        f20009a = a3;
        f20010b = new P7.c[0];
    }

    public static d a(Class cls) {
        f20009a.getClass();
        return new d(cls);
    }
}
