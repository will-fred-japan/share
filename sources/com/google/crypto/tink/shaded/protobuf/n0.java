package com.google.crypto.tink.shaded.protobuf;

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
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f14129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f14130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f14131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f14132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f14133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f14134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f14135g;

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
        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final boolean c(long j, Object obj) {
            if (n0.f14135g) {
                return n0.h(j, obj) != 0;
            }
            return n0.i(j, obj) != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final byte d(long j, Object obj) {
            return n0.f14135g ? n0.h(j, obj) : n0.i(j, obj);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final double e(long j, Object obj) {
            return Double.longBitsToDouble(h(j, obj));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final float f(long j, Object obj) {
            return Float.intBitsToFloat(g(j, obj));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final void k(Object obj, long j, boolean z8) {
            if (n0.f14135g) {
                n0.l(obj, j, z8 ? (byte) 1 : (byte) 0);
            } else {
                n0.m(obj, j, z8 ? (byte) 1 : (byte) 0);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final void l(Object obj, long j, byte b9) {
            if (n0.f14135g) {
                n0.l(obj, j, b9);
            } else {
                n0.m(obj, j, b9);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final void m(Object obj, long j, double d9) {
            p(obj, j, Double.doubleToLongBits(d9));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final void n(Object obj, long j, float f6) {
            o(obj, j, Float.floatToIntBits(f6));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final boolean s() {
            return false;
        }
    }

    /* JADX INFO: compiled from: UnsafeUtil.java */
    public static final class c extends e {
        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final boolean c(long j, Object obj) {
            if (n0.f14135g) {
                return n0.h(j, obj) != 0;
            }
            return n0.i(j, obj) != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final byte d(long j, Object obj) {
            return n0.f14135g ? n0.h(j, obj) : n0.i(j, obj);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final double e(long j, Object obj) {
            return Double.longBitsToDouble(h(j, obj));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final float f(long j, Object obj) {
            return Float.intBitsToFloat(g(j, obj));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final void k(Object obj, long j, boolean z8) {
            if (n0.f14135g) {
                n0.l(obj, j, z8 ? (byte) 1 : (byte) 0);
            } else {
                n0.m(obj, j, z8 ? (byte) 1 : (byte) 0);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final void l(Object obj, long j, byte b9) {
            if (n0.f14135g) {
                n0.l(obj, j, b9);
            } else {
                n0.m(obj, j, b9);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final void m(Object obj, long j, double d9) {
            p(obj, j, Double.doubleToLongBits(d9));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final void n(Object obj, long j, float f6) {
            o(obj, j, Float.floatToIntBits(f6));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final boolean s() {
            return false;
        }
    }

    /* JADX INFO: compiled from: UnsafeUtil.java */
    public static final class d extends e {
        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final boolean c(long j, Object obj) {
            return this.f14136a.getBoolean(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final byte d(long j, Object obj) {
            return this.f14136a.getByte(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final double e(long j, Object obj) {
            return this.f14136a.getDouble(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final float f(long j, Object obj) {
            return this.f14136a.getFloat(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final void k(Object obj, long j, boolean z8) {
            this.f14136a.putBoolean(obj, j, z8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final void l(Object obj, long j, byte b9) {
            this.f14136a.putByte(obj, j, b9);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final void m(Object obj, long j, double d9) {
            this.f14136a.putDouble(obj, j, d9);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final void n(Object obj, long j, float f6) {
            this.f14136a.putFloat(obj, j, f6);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final boolean r() {
            if (!super.r()) {
                return false;
            }
            try {
                Class<?> cls = this.f14136a.getClass();
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
                n0.a(th);
                return false;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.n0.e
        public final boolean s() {
            Unsafe unsafe = this.f14136a;
            if (unsafe != null) {
                try {
                    Class<?> cls = unsafe.getClass();
                    cls.getMethod("objectFieldOffset", Field.class);
                    Class cls2 = Long.TYPE;
                    cls.getMethod("getLong", Object.class, cls2);
                    if (n0.e() != null) {
                        try {
                            Class<?> cls3 = this.f14136a.getClass();
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
                            n0.a(th);
                            return false;
                        }
                    }
                } catch (Throwable th2) {
                    n0.a(th2);
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: UnsafeUtil.java */
    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Unsafe f14136a;

        public e(Unsafe unsafe) {
            this.f14136a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f14136a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f14136a.arrayIndexScale(cls);
        }

        public abstract boolean c(long j, Object obj);

        public abstract byte d(long j, Object obj);

        public abstract double e(long j, Object obj);

        public abstract float f(long j, Object obj);

        public final int g(long j, Object obj) {
            return this.f14136a.getInt(obj, j);
        }

        public final long h(long j, Object obj) {
            return this.f14136a.getLong(obj, j);
        }

        public final Object i(long j, Object obj) {
            return this.f14136a.getObject(obj, j);
        }

        public final long j(Field field) {
            return this.f14136a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j, boolean z8);

        public abstract void l(Object obj, long j, byte b9);

        public abstract void m(Object obj, long j, double d9);

        public abstract void n(Object obj, long j, float f6);

        public final void o(Object obj, long j, int i9) {
            this.f14136a.putInt(obj, j, i9);
        }

        public final void p(Object obj, long j, long j8) {
            this.f14136a.putLong(obj, j, j8);
        }

        public final void q(long j, Object obj, Object obj2) {
            this.f14136a.putObject(obj, j, obj2);
        }

        public boolean r() {
            Unsafe unsafe = this.f14136a;
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
                n0.a(th);
                return false;
            }
        }

        public abstract boolean s();
    }

    static {
        Unsafe unsafeJ = j();
        f14129a = unsafeJ;
        f14130b = C0565d.f14049a;
        boolean zF = f(Long.TYPE);
        boolean zF2 = f(Integer.TYPE);
        e dVar = null;
        if (unsafeJ != null) {
            if (!C0565d.a()) {
                dVar = new d(unsafeJ);
            } else if (zF) {
                dVar = new c(unsafeJ);
            } else if (zF2) {
                dVar = new b(unsafeJ);
            }
        }
        f14131c = dVar;
        f14132d = dVar == null ? false : dVar.s();
        f14133e = dVar == null ? false : dVar.r();
        f14134f = c(byte[].class);
        c(boolean[].class);
        d(boolean[].class);
        c(int[].class);
        d(int[].class);
        c(long[].class);
        d(long[].class);
        c(float[].class);
        d(float[].class);
        c(double[].class);
        d(double[].class);
        c(Object[].class);
        d(Object[].class);
        Field fieldE = e();
        if (fieldE != null && dVar != null) {
            dVar.j(fieldE);
        }
        f14135g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(n0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static <T> T b(Class<T> cls) {
        try {
            return (T) f14129a.allocateInstance(cls);
        } catch (InstantiationException e9) {
            throw new IllegalStateException(e9);
        }
    }

    public static int c(Class<?> cls) {
        if (f14133e) {
            return f14131c.a(cls);
        }
        return -1;
    }

    public static void d(Class cls) {
        if (f14133e) {
            f14131c.b(cls);
        }
    }

    public static Field e() {
        Field declaredField;
        Field declaredField2;
        if (C0565d.a()) {
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

    public static boolean f(Class<?> cls) {
        if (!C0565d.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f14130b;
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

    public static byte g(byte[] bArr, long j) {
        return f14131c.d(f14134f + j, bArr);
    }

    public static byte h(long j, Object obj) {
        return (byte) ((f14131c.g((-4) & j, obj) >>> ((int) (((~j) & 3) << 3))) & 255);
    }

    public static byte i(long j, Object obj) {
        return (byte) ((f14131c.g((-4) & j, obj) >>> ((int) ((j & 3) << 3))) & 255);
    }

    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void k(byte[] bArr, long j, byte b9) {
        f14131c.l(bArr, f14134f + j, b9);
    }

    public static void l(Object obj, long j, byte b9) {
        long j8 = (-4) & j;
        int iG = f14131c.g(j8, obj);
        int i9 = ((~((int) j)) & 3) << 3;
        n(obj, j8, ((255 & b9) << i9) | (iG & (~(255 << i9))));
    }

    public static void m(Object obj, long j, byte b9) {
        long j8 = (-4) & j;
        int i9 = (((int) j) & 3) << 3;
        n(obj, j8, ((255 & b9) << i9) | (f14131c.g(j8, obj) & (~(255 << i9))));
    }

    public static void n(Object obj, long j, int i9) {
        f14131c.o(obj, j, i9);
    }

    public static void o(Object obj, long j, long j8) {
        f14131c.p(obj, j, j8);
    }

    public static void p(long j, Object obj, Object obj2) {
        f14131c.q(j, obj, obj2);
    }
}
