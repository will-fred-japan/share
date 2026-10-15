package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC0583w;
import com.google.crypto.tink.shaded.protobuf.AbstractC0583w.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0583w<MessageType extends AbstractC0583w<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractC0562a<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Class<?>, AbstractC0583w<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected l0 unknownFields = l0.f14119f;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.w$a */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class a<MessageType extends AbstractC0583w<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractC0562a.AbstractC0158a<MessageType, BuilderType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageType f14170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MessageType f14171b;

        public a(MessageType messagetype) {
            this.f14170a = messagetype;
            if (messagetype.s()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f14171b = (MessageType) messagetype.w();
        }

        public static <MessageType> void k(MessageType messagetype, MessageType messagetype2) {
            b0 b0Var = b0.f14041c;
            b0Var.getClass();
            b0Var.a(messagetype.getClass()).a(messagetype, messagetype2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.S
        public AbstractC0583w e() {
            return this.f14170a;
        }

        public final MessageType f() {
            MessageType messagetype = (MessageType) G();
            messagetype.getClass();
            if (AbstractC0583w.r(messagetype, true)) {
                return messagetype;
            }
            throw new j0();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Q.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public final MessageType G() {
            if (!this.f14171b.s()) {
                return this.f14171b;
            }
            this.f14171b.t();
            return this.f14171b;
        }

        @Override // 
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final BuilderType clone() {
            BuilderType buildertype = (BuilderType) this.f14170a.b();
            buildertype.f14171b = (MessageType) G();
            return buildertype;
        }

        public final void i() {
            if (this.f14171b.s()) {
                return;
            }
            MessageType messagetype = (MessageType) this.f14170a.w();
            k(messagetype, this.f14171b);
            this.f14171b = messagetype;
        }

        public final void j(AbstractC0583w abstractC0583w) {
            if (this.f14170a.equals(abstractC0583w)) {
                return;
            }
            i();
            k(this.f14171b, abstractC0583w);
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.w$b */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static class b<T extends AbstractC0583w<T, ?>> extends AbstractC0563b<T> {
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.w$c */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends AbstractC0583w<MessageType, BuilderType> implements S {
        protected C0579s<d> extensions = C0579s.f14157d;

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0583w, com.google.crypto.tink.shaded.protobuf.Q
        public final /* bridge */ /* synthetic */ a b() {
            return b();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0583w, com.google.crypto.tink.shaded.protobuf.S
        public final /* bridge */ /* synthetic */ AbstractC0583w e() {
            return e();
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.w$d */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static final class d implements C0579s.a<d> {
        @Override // com.google.crypto.tink.shaded.protobuf.C0579s.a
        public final q0 F() {
            throw null;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            ((d) obj).getClass();
            return 0;
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.w$e */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static class e<ContainingType extends Q, Type> extends A0.h {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.w$f */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f14172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f14173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f14174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final f f14175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final f f14176e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f14177f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final f f14178g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ f[] f14179h;

        static {
            f fVar = new f("GET_MEMOIZED_IS_INITIALIZED", 0);
            f14172a = fVar;
            f fVar2 = new f("SET_MEMOIZED_IS_INITIALIZED", 1);
            f14173b = fVar2;
            f fVar3 = new f("BUILD_MESSAGE_INFO", 2);
            f14174c = fVar3;
            f fVar4 = new f("NEW_MUTABLE_INSTANCE", 3);
            f14175d = fVar4;
            f fVar5 = new f("NEW_BUILDER", 4);
            f14176e = fVar5;
            f fVar6 = new f("GET_DEFAULT_INSTANCE", 5);
            f14177f = fVar6;
            f fVar7 = new f("GET_PARSER", 6);
            f14178g = fVar7;
            f14179h = new f[]{fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7};
        }

        public f() {
            throw null;
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) f14179h.clone();
        }
    }

    public static <T extends AbstractC0583w<?, ?>> void A(Class<T> cls, T t) {
        t.u();
        defaultInstanceMap.put(cls, t);
    }

    public static void k(AbstractC0583w abstractC0583w) throws C0586z {
        if (abstractC0583w != null && !r(abstractC0583w, true)) {
            throw new C0586z(new j0().getMessage());
        }
    }

    public static <T extends AbstractC0583w<?, ?>> T n(Class<T> cls) {
        T t = (T) defaultInstanceMap.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e9) {
                throw new IllegalStateException("Class initialization cannot fail.", e9);
            }
        }
        if (t != null) {
            return t;
        }
        T t6 = (T) ((AbstractC0583w) n0.b(cls)).e();
        if (t6 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put((Class<?>) cls, t6);
        return t6;
    }

    public static Object q(Method method, Q q8, Object... objArr) {
        try {
            return method.invoke(q8, objArr);
        } catch (IllegalAccessException e9) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e9);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final <T extends AbstractC0583w<T, ?>> boolean r(T t, boolean z8) {
        byte bByteValue = ((Byte) t.m(f.f14172a)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        b0 b0Var = b0.f14041c;
        b0Var.getClass();
        boolean zC = b0Var.a(t.getClass()).c(t);
        if (z8) {
            t.m(f.f14173b);
        }
        return zC;
    }

    public static <T extends AbstractC0583w<T, ?>> T x(T t, AbstractC0569h abstractC0569h, C0576o c0576o) throws C0586z {
        AbstractC0570i.a aVarL = abstractC0569h.l();
        T t6 = (T) z(t, aVarL, c0576o);
        aVarL.a(0);
        k(t6);
        return t6;
    }

    public static <T extends AbstractC0583w<T, ?>> T y(T t, byte[] bArr, C0576o c0576o) throws C0586z {
        int length = bArr.length;
        if (length != 0) {
            AbstractC0583w abstractC0583wW = t.w();
            try {
                b0 b0Var = b0.f14041c;
                b0Var.getClass();
                e0 e0VarA = b0Var.a(abstractC0583wW.getClass());
                e0VarA.d(abstractC0583wW, bArr, 0, length, new C0566e.a(c0576o));
                e0VarA.b(abstractC0583wW);
                t = (T) abstractC0583wW;
            } catch (j0 e9) {
                throw new C0586z(e9.getMessage());
            } catch (C0586z e10) {
                if (e10.f14185a) {
                    throw new C0586z(e10.getMessage(), e10);
                }
                throw e10;
            } catch (IOException e11) {
                if (e11.getCause() instanceof C0586z) {
                    throw ((C0586z) e11.getCause());
                }
                throw new C0586z(e11.getMessage(), e11);
            } catch (IndexOutOfBoundsException unused) {
                throw C0586z.g();
            }
        }
        k(t);
        return t;
    }

    public static <T extends AbstractC0583w<T, ?>> T z(T t, AbstractC0570i abstractC0570i, C0576o c0576o) throws C0586z {
        T t6 = (T) t.w();
        try {
            b0 b0Var = b0.f14041c;
            b0Var.getClass();
            e0 e0VarA = b0Var.a(t6.getClass());
            C0571j c0571j = abstractC0570i.f14094e;
            if (c0571j == null) {
                c0571j = new C0571j(abstractC0570i);
            }
            e0VarA.g(t6, c0571j, c0576o);
            e0VarA.b(t6);
            return t6;
        } catch (j0 e9) {
            throw new C0586z(e9.getMessage());
        } catch (C0586z e10) {
            if (e10.f14185a) {
                throw new C0586z(e10.getMessage(), e10);
            }
            throw e10;
        } catch (IOException e11) {
            if (e11.getCause() instanceof C0586z) {
                throw ((C0586z) e11.getCause());
            }
            throw new C0586z(e11.getMessage(), e11);
        } catch (RuntimeException e12) {
            if (e12.getCause() instanceof C0586z) {
                throw ((C0586z) e12.getCause());
            }
            throw e12;
        }
    }

    public final BuilderType B() {
        BuilderType buildertype = (BuilderType) m(f.f14176e);
        buildertype.j(this);
        return buildertype;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q
    public final int a() {
        return g(null);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q
    public final void d(AbstractC0572k.a aVar) {
        b0 b0Var = b0.f14041c;
        b0Var.getClass();
        e0 e0VarA = b0Var.a(getClass());
        C0573l c0573l = aVar.f14114b;
        if (c0573l == null) {
            c0573l = new C0573l(aVar);
        }
        e0VarA.e(this, c0573l);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b0 b0Var = b0.f14041c;
        b0Var.getClass();
        return b0Var.a(getClass()).h(this, (AbstractC0583w) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0562a
    public final int f() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0562a
    public final int g(e0 e0Var) {
        int iF;
        int iF2;
        if (s()) {
            if (e0Var == null) {
                b0 b0Var = b0.f14041c;
                b0Var.getClass();
                iF2 = b0Var.a(getClass()).f(this);
            } else {
                iF2 = e0Var.f(this);
            }
            if (iF2 >= 0) {
                return iF2;
            }
            throw new IllegalStateException(W5.e.i(iF2, "serialized size must be non-negative, was "));
        }
        if (f() != Integer.MAX_VALUE) {
            return f();
        }
        if (e0Var == null) {
            b0 b0Var2 = b0.f14041c;
            b0Var2.getClass();
            iF = b0Var2.a(getClass()).f(this);
        } else {
            iF = e0Var.f(this);
        }
        i(iF);
        return iF;
    }

    public final int hashCode() {
        if (s()) {
            b0 b0Var = b0.f14041c;
            b0Var.getClass();
            return b0Var.a(getClass()).i(this);
        }
        if (this.memoizedHashCode == 0) {
            b0 b0Var2 = b0.f14041c;
            b0Var2.getClass();
            this.memoizedHashCode = b0Var2.a(getClass()).i(this);
        }
        return this.memoizedHashCode;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0562a
    public final void i(int i9) {
        if (i9 < 0) {
            throw new IllegalStateException(W5.e.i(i9, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i9 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
    }

    public final <MessageType2 extends AbstractC0583w<MessageType2, BuilderType2>, BuilderType2 extends a<MessageType2, BuilderType2>> BuilderType2 l() {
        return (BuilderType2) m(f.f14176e);
    }

    public abstract Object m(f fVar);

    @Override // com.google.crypto.tink.shaded.protobuf.S
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final MessageType e() {
        return (MessageType) m(f.f14177f);
    }

    public final Z<MessageType> p() {
        return (Z) m(f.f14178g);
    }

    public final boolean s() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void t() {
        b0 b0Var = b0.f14041c;
        b0Var.getClass();
        b0Var.a(getClass()).b(this);
        u();
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = T.f14014a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        T.c(this, sb, 0);
        return sb.toString();
    }

    public final void u() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public final BuilderType b() {
        return (BuilderType) m(f.f14176e);
    }

    public final MessageType w() {
        return (MessageType) m(f.f14175d);
    }
}
