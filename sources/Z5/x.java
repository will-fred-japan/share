package Z5;

import com.google.crypto.tink.shaded.protobuf.AbstractC0583w;
import com.google.crypto.tink.shaded.protobuf.S;
import com.google.crypto.tink.shaded.protobuf.Z;
import com.google.crypto.tink.shaded.protobuf.d0;

/* JADX INFO: compiled from: HmacParams.java */
/* JADX INFO: loaded from: classes.dex */
public final class x extends AbstractC0583w<x, a> implements S {
    private static final x DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    private static volatile Z<x> PARSER = null;
    public static final int TAG_SIZE_FIELD_NUMBER = 2;
    private int hash_;
    private int tagSize_;

    /* JADX INFO: compiled from: HmacParams.java */
    public static final class a extends AbstractC0583w.a<x, a> implements S {
        public a() {
            super(x.DEFAULT_INSTANCE);
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
        x xVar = new x();
        DEFAULT_INSTANCE = xVar;
        AbstractC0583w.A(x.class, xVar);
    }

    public static void D(x xVar, u uVar) {
        xVar.getClass();
        xVar.hash_ = uVar.a();
    }

    public static void E(x xVar, int i9) {
        xVar.tagSize_ = i9;
    }

    public static x F() {
        return DEFAULT_INSTANCE;
    }

    public static a J() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public final u H() {
        u uVar;
        int i9 = this.hash_;
        if (i9 == 0) {
            uVar = u.UNKNOWN_HASH;
        } else if (i9 == 1) {
            uVar = u.SHA1;
        } else if (i9 == 2) {
            uVar = u.SHA384;
        } else if (i9 == 3) {
            uVar = u.SHA256;
        } else if (i9 != 4) {
            uVar = i9 != 5 ? null : u.SHA224;
        } else {
            uVar = u.SHA512;
        }
        return uVar == null ? u.UNRECOGNIZED : uVar;
    }

    public final int I() {
        return this.tagSize_;
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
            return new d0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"hash_", "tagSize_"});
        }
        if (iOrdinal == 3) {
            return new x();
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
        Z<x> z8 = PARSER;
        if (z8 != null) {
            return z8;
        }
        synchronized (x.class) {
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
