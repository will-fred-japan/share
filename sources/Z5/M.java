package Z5;

import com.google.crypto.tink.shaded.protobuf.AbstractC0583w;
import com.google.crypto.tink.shaded.protobuf.S;
import com.google.crypto.tink.shaded.protobuf.Z;
import com.google.crypto.tink.shaded.protobuf.d0;

/* JADX INFO: compiled from: XAesGcmParams.java */
/* JADX INFO: loaded from: classes.dex */
public final class M extends AbstractC0583w<M, a> implements S {
    private static final M DEFAULT_INSTANCE;
    private static volatile Z<M> PARSER = null;
    public static final int SALT_SIZE_FIELD_NUMBER = 1;
    private int saltSize_;

    /* JADX INFO: compiled from: XAesGcmParams.java */
    public static final class a extends AbstractC0583w.a<M, a> implements S {
        public a() {
            super(M.DEFAULT_INSTANCE);
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
    }

    static {
        M m8 = new M();
        DEFAULT_INSTANCE = m8;
        AbstractC0583w.A(M.class, m8);
    }

    public static void D(M m8, int i9) {
        m8.saltSize_ = i9;
    }

    public static M E() {
        return DEFAULT_INSTANCE;
    }

    public static a H() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public final int F() {
        return this.saltSize_;
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
            return new d0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"saltSize_"});
        }
        if (iOrdinal == 3) {
            return new M();
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
        Z<M> z8 = PARSER;
        if (z8 != null) {
            return z8;
        }
        synchronized (M.class) {
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
