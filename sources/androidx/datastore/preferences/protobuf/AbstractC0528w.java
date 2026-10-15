package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0528w;
import androidx.datastore.preferences.protobuf.AbstractC0528w.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0528w<MessageType extends AbstractC0528w<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractC0507a<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC0528w<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected n0 unknownFields = n0.f7286f;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.w$a */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class a<MessageType extends AbstractC0528w<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractC0507a.AbstractC0100a<MessageType, BuilderType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageType f7332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MessageType f7333b;

        public a(MessageType messagetype) {
            this.f7332a = messagetype;
            if (messagetype.m()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f7333b = (MessageType) messagetype.o();
        }

        public final Object clone() {
            a aVar = (a) this.f7332a.i(f.f7338e);
            aVar.f7333b = (MessageType) g();
            return aVar;
        }

        public final MessageType f() {
            MessageType messagetype = (MessageType) g();
            messagetype.getClass();
            if (AbstractC0528w.l(messagetype, true)) {
                return messagetype;
            }
            throw new l0();
        }

        public final MessageType g() {
            if (!this.f7333b.m()) {
                return this.f7333b;
            }
            MessageType messagetype = this.f7333b;
            messagetype.getClass();
            c0 c0Var = c0.f7206c;
            c0Var.getClass();
            c0Var.a(messagetype.getClass()).b(messagetype);
            messagetype.n();
            return this.f7333b;
        }

        public final void h() {
            if (this.f7333b.m()) {
                return;
            }
            MessageType messagetype = (MessageType) this.f7332a.o();
            MessageType messagetype2 = this.f7333b;
            c0 c0Var = c0.f7206c;
            c0Var.getClass();
            c0Var.a(messagetype.getClass()).a(messagetype, messagetype2);
            this.f7333b = messagetype;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.w$b */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static class b<T extends AbstractC0528w<T, ?>> extends AbstractC0508b<T> {
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.w$c */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends AbstractC0528w<MessageType, BuilderType> implements S {
        protected r<d> extensions = r.f7303d;

        @Override // androidx.datastore.preferences.protobuf.AbstractC0528w, androidx.datastore.preferences.protobuf.Q
        public final a b() {
            return (a) i(f.f7338e);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0528w, androidx.datastore.preferences.protobuf.S
        public final AbstractC0528w e() {
            return (AbstractC0528w) i(f.f7339f);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.w$d */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static final class d implements r.a<d> {
        @Override // androidx.datastore.preferences.protobuf.r.a
        public final s0 F() {
            throw null;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            ((d) obj).getClass();
            return 0;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.w$e */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static class e<ContainingType extends Q, Type> extends A0.h {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.w$f */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f7334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f7335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f7336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final f f7337d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final f f7338e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f7339f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ f[] f7340g;

        static {
            f fVar = new f("GET_MEMOIZED_IS_INITIALIZED", 0);
            f7334a = fVar;
            f fVar2 = new f("SET_MEMOIZED_IS_INITIALIZED", 1);
            f7335b = fVar2;
            f fVar3 = new f("BUILD_MESSAGE_INFO", 2);
            f7336c = fVar3;
            f fVar4 = new f("NEW_MUTABLE_INSTANCE", 3);
            f7337d = fVar4;
            f fVar5 = new f("NEW_BUILDER", 4);
            f7338e = fVar5;
            f fVar6 = new f("GET_DEFAULT_INSTANCE", 5);
            f7339f = fVar6;
            f7340g = new f[]{fVar, fVar2, fVar3, fVar4, fVar5, fVar6, new f("GET_PARSER", 6)};
        }

        public f() {
            throw null;
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) f7340g.clone();
        }
    }

    public static <T extends AbstractC0528w<?, ?>> T j(Class<T> cls) {
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
        T t6 = (T) ((AbstractC0528w) p0.d(cls)).i(f.f7339f);
        if (t6 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, t6);
        return t6;
    }

    public static Object k(Method method, Q q8, Object... objArr) {
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

    public static final <T extends AbstractC0528w<T, ?>> boolean l(T t, boolean z8) {
        byte bByteValue = ((Byte) t.i(f.f7334a)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        c0 c0Var = c0.f7206c;
        c0Var.getClass();
        boolean zC = c0Var.a(t.getClass()).c(t);
        if (z8) {
            t.i(f.f7335b);
        }
        return zC;
    }

    public static <T extends AbstractC0528w<?, ?>> void p(Class<T> cls, T t) {
        t.n();
        defaultInstanceMap.put(cls, t);
    }

    @Override // androidx.datastore.preferences.protobuf.Q
    public final int a() {
        return g(null);
    }

    @Override // androidx.datastore.preferences.protobuf.Q
    public a b() {
        return (a) i(f.f7338e);
    }

    @Override // androidx.datastore.preferences.protobuf.Q
    public final void d(AbstractC0516j abstractC0516j) {
        c0 c0Var = c0.f7206c;
        c0Var.getClass();
        f0 f0VarA = c0Var.a(getClass());
        C0517k c0517k = abstractC0516j.f7269b;
        if (c0517k == null) {
            c0517k = new C0517k(abstractC0516j);
        }
        f0VarA.e(this, c0517k);
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public AbstractC0528w e() {
        return (AbstractC0528w) i(f.f7339f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c0 c0Var = c0.f7206c;
        c0Var.getClass();
        return c0Var.a(getClass()).g(this, (AbstractC0528w) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0507a
    public final int f() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0507a
    public final int g(f0 f0Var) {
        int iF;
        int iF2;
        if (m()) {
            if (f0Var == null) {
                c0 c0Var = c0.f7206c;
                c0Var.getClass();
                iF2 = c0Var.a(getClass()).f(this);
            } else {
                iF2 = f0Var.f(this);
            }
            if (iF2 >= 0) {
                return iF2;
            }
            throw new IllegalStateException(W5.e.i(iF2, "serialized size must be non-negative, was "));
        }
        if (f() != Integer.MAX_VALUE) {
            return f();
        }
        if (f0Var == null) {
            c0 c0Var2 = c0.f7206c;
            c0Var2.getClass();
            iF = c0Var2.a(getClass()).f(this);
        } else {
            iF = f0Var.f(this);
        }
        h(iF);
        return iF;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0507a
    public final void h(int i9) {
        if (i9 < 0) {
            throw new IllegalStateException(W5.e.i(i9, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i9 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
    }

    public final int hashCode() {
        if (m()) {
            c0 c0Var = c0.f7206c;
            c0Var.getClass();
            return c0Var.a(getClass()).d(this);
        }
        if (this.memoizedHashCode == 0) {
            c0 c0Var2 = c0.f7206c;
            c0Var2.getClass();
            this.memoizedHashCode = c0Var2.a(getClass()).d(this);
        }
        return this.memoizedHashCode;
    }

    public abstract Object i(f fVar);

    public final boolean m() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void n() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public final MessageType o() {
        return (MessageType) i(f.f7337d);
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = T.f7178a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        T.c(this, sb, 0);
        return sb.toString();
    }
}
