package Z5;

import com.google.crypto.tink.shaded.protobuf.AbstractC0569h;
import com.google.crypto.tink.shaded.protobuf.AbstractC0583w;
import com.google.crypto.tink.shaded.protobuf.C0576o;
import com.google.crypto.tink.shaded.protobuf.S;
import com.google.crypto.tink.shaded.protobuf.Z;
import com.google.crypto.tink.shaded.protobuf.d0;

/* JADX INFO: compiled from: KeyTemplate.java */
/* JADX INFO: loaded from: classes.dex */
public final class A extends AbstractC0583w<A, a> implements S {
    private static final A DEFAULT_INSTANCE;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 3;
    private static volatile Z<A> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int outputPrefixType_;
    private String typeUrl_ = "";
    private AbstractC0569h value_ = AbstractC0569h.f14069b;

    /* JADX INFO: compiled from: KeyTemplate.java */
    public static final class a extends AbstractC0583w.a<A, a> implements S {
        public a() {
            super(A.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0583w.a, com.google.crypto.tink.shaded.protobuf.Q.a
        public final /* bridge */ /* synthetic */ AbstractC0583w G() {
            return G();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0583w.a
        public final /* bridge */ /* synthetic */ Object clone() {
            return clone();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0583w.a, com.google.crypto.tink.shaded.protobuf.S
        public final AbstractC0583w e() {
            return this.f14170a;
        }

        public final void l(I i9) {
            i();
            A.F((A) this.f14171b, i9);
        }

        public final void m(String str) {
            i();
            A.D((A) this.f14171b, str);
        }

        public final void n(AbstractC0569h abstractC0569h) {
            i();
            A.E((A) this.f14171b, abstractC0569h);
        }
    }

    static {
        A a3 = new A();
        DEFAULT_INSTANCE = a3;
        AbstractC0583w.A(A.class, a3);
    }

    public static void D(A a3, String str) {
        a3.getClass();
        str.getClass();
        a3.typeUrl_ = str;
    }

    public static void E(A a3, AbstractC0569h abstractC0569h) {
        a3.getClass();
        abstractC0569h.getClass();
        a3.value_ = abstractC0569h;
    }

    public static void F(A a3, I i9) {
        a3.getClass();
        a3.outputPrefixType_ = i9.a();
    }

    public static A H() {
        return DEFAULT_INSTANCE;
    }

    public static a L() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public static a M(A a3) {
        AbstractC0583w.a aVarL = DEFAULT_INSTANCE.l();
        aVarL.j(a3);
        return (a) aVarL;
    }

    public static A N(byte[] bArr, C0576o c0576o) {
        return (A) AbstractC0583w.y(DEFAULT_INSTANCE, bArr, c0576o);
    }

    public final I I() {
        I iB = I.b(this.outputPrefixType_);
        return iB == null ? I.UNRECOGNIZED : iB;
    }

    public final String J() {
        return this.typeUrl_;
    }

    public final AbstractC0569h K() {
        return this.value_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0583w, com.google.crypto.tink.shaded.protobuf.Q
    public final /* bridge */ /* synthetic */ AbstractC0583w.a b() {
        return b();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0583w, com.google.crypto.tink.shaded.protobuf.S
    public final /* bridge */ /* synthetic */ AbstractC0583w e() {
        return e();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0583w
    public final Object m(AbstractC0583w.f fVar) {
        Z bVar;
        int iOrdinal = fVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new d0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "outputPrefixType_"});
        }
        if (iOrdinal == 3) {
            return new A();
        }
        if (iOrdinal == 4) {
            return new a();
        }
        if (iOrdinal == 5) {
            return DEFAULT_INSTANCE;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        Z<A> z8 = PARSER;
        if (z8 != null) {
            return z8;
        }
        synchronized (A.class) {
            try {
                bVar = PARSER;
                if (bVar == null) {
                    bVar = new AbstractC0583w.b();
                    PARSER = bVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }
}
