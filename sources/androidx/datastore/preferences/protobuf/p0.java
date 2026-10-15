package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: UnsafeUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f7292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f7293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f7294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f7295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f7296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f7297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f7298g;

    /* JADX INFO: compiled from: UnsafeUtil.java */
    public class a implements PrivilegedExceptionAction<Unsafe> {
        public static Unsafe a() throws IllegalAccessException {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }

        @Override // java.security.PrivilegedExceptionAction
        public final /* bridge */ /* synthetic */ Unsafe run() {
            return a();
        }
    }

    /* JADX INFO: compiled from: UnsafeUtil.java */
    public static final class b extends e {
        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final boolean c(long j, Object obj) {
            return p0.f7298g ? p0.b(j, obj) : p0.c(j, obj);
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final double d(long j, Object obj) {
            return Double.longBitsToDouble(g(j, obj));
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final float e(long j, Object obj) {
            return Float.intBitsToFloat(f(j, obj));
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final void j(Object obj, long j, boolean z8) {
            if (p0.f7298g) {
                p0.k(obj, j, z8 ? (byte) 1 : (byte) 0);
            } else {
                p0.l(obj, j, z8 ? (byte) 1 : (byte) 0);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final void k(Object obj, long j, byte b9) {
            if (p0.f7298g) {
                p0.k(obj, j, b9);
            } else {
                p0.l(obj, j, b9);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final void l(Object obj, long j, double d9) {
            o(obj, j, Double.doubleToLongBits(d9));
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final void m(Object obj, long j, float f6) {
            n(obj, j, Float.floatToIntBits(f6));
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final boolean r() {
            return false;
        }
    }

    /* JADX INFO: compiled from: UnsafeUtil.java */
    public static final class c extends e {
        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final boolean c(long j, Object obj) {
            return p0.f7298g ? p0.b(j, obj) : p0.c(j, obj);
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final double d(long j, Object obj) {
            return Double.longBitsToDouble(g(j, obj));
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final float e(long j, Object obj) {
            return Float.intBitsToFloat(f(j, obj));
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final void j(Object obj, long j, boolean z8) {
            if (p0.f7298g) {
                p0.k(obj, j, z8 ? (byte) 1 : (byte) 0);
            } else {
                p0.l(obj, j, z8 ? (byte) 1 : (byte) 0);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final void k(Object obj, long j, byte b9) {
            if (p0.f7298g) {
                p0.k(obj, j, b9);
            } else {
                p0.l(obj, j, b9);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final void l(Object obj, long j, double d9) {
            o(obj, j, Double.doubleToLongBits(d9));
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final void m(Object obj, long j, float f6) {
            n(obj, j, Float.floatToIntBits(f6));
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final boolean r() {
            return false;
        }
    }

    /* JADX INFO: compiled from: UnsafeUtil.java */
    public static final class d extends e {
        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final boolean c(long j, Object obj) {
            return this.f7299a.getBoolean(obj, j);
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final double d(long j, Object obj) {
            return this.f7299a.getDouble(obj, j);
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final float e(long j, Object obj) {
            return this.f7299a.getFloat(obj, j);
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final void j(Object obj, long j, boolean z8) {
            this.f7299a.putBoolean(obj, j, z8);
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final void k(Object obj, long j, byte b9) {
            this.f7299a.putByte(obj, j, b9);
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final void l(Object obj, long j, double d9) {
            this.f7299a.putDouble(obj, j, d9);
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final void m(Object obj, long j, float f6) {
            this.f7299a.putFloat(obj, j, f6);
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final boolean q() {
            if (!super.q()) {
                return false;
            }
            try {
                Class<?> cls = this.f7299a.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                p0.a(th);
                return false;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.p0.e
        public final boolean r() {
            Unsafe unsafe = this.f7299a;
            if (unsafe != null) {
                try {
                    Class<?> cls = unsafe.getClass();
                    cls.getMethod("objectFieldOffset", Field.class);
                    Class cls2 = Long.TYPE;
                    cls.getMethod("getLong", Object.class, cls2);
                    if (p0.g() != null) {
                        try {
                            Class<?> cls3 = this.f7299a.getClass();
                            cls3.getMethod("getByte", cls2);
                            cls3.getMethod("putByte", cls2, Byte.TYPE);
                            cls3.getMethod("getInt", cls2);
                            cls3.getMethod("putInt", cls2, Integer.TYPE);
                            cls3.getMethod("getLong", cls2);
                            cls3.getMethod("putLong", cls2, cls2);
                            cls3.getMethod("copyMemory", cls2, cls2, cls2);
                            cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                            return true;
                        } catch (Throwable th) {
                            p0.a(th);
                            return false;
                        }
                    }
                } catch (Throwable th2) {
                    p0.a(th2);
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: UnsafeUtil.java */
    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Unsafe f7299a;

        public e(Unsafe unsafe) {
            this.f7299a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f7299a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f7299a.arrayIndexScale(cls);
        }

        public abstract boolean c(long j, Object obj);

        public abstract double d(long j, Object obj);

        public abstract float e(long j, Object obj);

        public final int f(long j, Object obj) {
            return this.f7299a.getInt(obj, j);
        }

        public final long g(long j, Object obj) {
            return this.f7299a.getLong(obj, j);
        }

        public final Object h(long j, Object obj) {
            return this.f7299a.getObject(obj, j);
        }

        public final long i(Field field) {
            return this.f7299a.objectFieldOffset(field);
        }

        public abstract void j(Object obj, long j, boolean z8);

        public abstract void k(Object obj, long j, byte b9);

        public abstract void l(Object obj, long j, double d9);

        public abstract void m(Object obj, long j, float f6);

        public final void n(Object obj, long j, int i9) {
            this.f7299a.putInt(obj, j, i9);
        }

        public final void o(Object obj, long j, long j8) {
            this.f7299a.putLong(obj, j, j8);
        }

        public final void p(long j, Object obj, Object obj2) {
            this.f7299a.putObject(obj, j, obj2);
        }

        public boolean q() {
            Unsafe unsafe = this.f7299a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                p0.a(th);
                return false;
            }
        }

        public abstract boolean r();
    }

    static {
        Unsafe unsafeI = i();
        f7292a = unsafeI;
        f7293b = C0510d.f7209a;
        boolean zH = h(Long.TYPE);
        boolean zH2 = h(Integer.TYPE);
        e dVar = null;
        if (unsafeI != null) {
            if (!C0510d.a()) {
                dVar = new d(unsafeI);
            } else if (zH) {
                dVar = new c(unsafeI);
            } else if (zH2) {
                dVar = new b(unsafeI);
            }
        }
        f7294c = dVar;
        f7295d = dVar == null ? false : dVar.r();
        f7296e = dVar == null ? false : dVar.q();
        f7297f = e(byte[].class);
        e(boolean[].class);
        f(boolean[].class);
        e(int[].class);
        f(int[].class);
        e(long[].class);
        f(long[].class);
        e(float[].class);
        f(float[].class);
        e(double[].class);
        f(double[].class);
        e(Object[].class);
        f(Object[].class);
        Field fieldG = g();
        if (fieldG != null && dVar != null) {
            dVar.i(fieldG);
        }
        f7298g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(p0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static boolean b(long j, Object obj) {
        return ((byte) ((f7294c.f((-4) & j, obj) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static boolean c(long j, Object obj) {
        return ((byte) ((f7294c.f((-4) & j, obj) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    public static <T> T d(Class<T> cls) {
        try {
            return (T) f7292a.allocateInstance(cls);
        } catch (InstantiationException e9) {
            throw new IllegalStateException(e9);
        }
    }

    public static int e(Class<?> cls) {
        if (f7296e) {
            return f7294c.a(cls);
        }
        return -1;
    }

    public static void f(Class cls) {
        if (f7296e) {
            f7294c.b(cls);
        }
    }

    public static Field g() {
        Field declaredField;
        Field declaredField2;
        if (C0510d.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    public static boolean h(Class<?> cls) {
        if (!C0510d.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f7293b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Unsafe i() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(byte[] bArr, long j, byte b9) {
        f7294c.k(bArr, f7297f + j, b9);
    }

    public static void k(Object obj, long j, byte b9) {
        long j8 = (-4) & j;
        int iF = f7294c.f(j8, obj);
        int i9 = ((~((int) j)) & 3) << 3;
        m(obj, j8, ((255 & b9) << i9) | (iF & (~(255 << i9))));
    }

    public static void l(Object obj, long j, byte b9) {
        long j8 = (-4) & j;
        int i9 = (((int) j) & 3) << 3;
        m(obj, j8, ((255 & b9) << i9) | (f7294c.f(j8, obj) & (~(255 << i9))));
    }

    public static void m(Object obj, long j, int i9) {
        f7294c.n(obj, j, i9);
    }

    public static void n(Object obj, long j, long j8) {
        f7294c.o(obj, j, j8);
    }

    public static void o(long j, Object obj, Object obj2) {
        f7294c.p(j, obj, obj2);
    }
}
