package Z5;

import com.google.crypto.tink.shaded.protobuf.AbstractC0570i;
import com.google.crypto.tink.shaded.protobuf.AbstractC0583w;
import com.google.crypto.tink.shaded.protobuf.C0576o;
import com.google.crypto.tink.shaded.protobuf.C0585y;
import com.google.crypto.tink.shaded.protobuf.C0586z;
import com.google.crypto.tink.shaded.protobuf.S;
import com.google.crypto.tink.shaded.protobuf.Z;
import com.google.crypto.tink.shaded.protobuf.c0;
import com.google.crypto.tink.shaded.protobuf.d0;
import java.io.ByteArrayInputStream;

/* JADX INFO: compiled from: Keyset.java */
/* JADX INFO: loaded from: classes.dex */
public final class C extends AbstractC0583w<C, a> implements S {
    private static final C DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile Z<C> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private C0585y.c<b> key_ = c0.f14046e;
    private int primaryKeyId_;

    /* JADX INFO: compiled from: Keyset.java */
    public static final class a extends AbstractC0583w.a<C, a> implements S {
        public a() {
            super(C.DEFAULT_INSTANCE);
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

    /* JADX INFO: compiled from: Keyset.java */
    public static final class b extends AbstractC0583w<b, a> implements S {
        private static final b DEFAULT_INSTANCE;
        public static final int KEY_DATA_FIELD_NUMBER = 1;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile Z<b> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        private int bitField0_;
        private y keyData_;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;

        /* JADX INFO: compiled from: Keyset.java */
        public static final class a extends AbstractC0583w.a<b, a> implements S {
            public a() {
                super(b.DEFAULT_INSTANCE);
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
            b bVar = new b();
            DEFAULT_INSTANCE = bVar;
            AbstractC0583w.A(b.class, bVar);
        }

        public static void D(b bVar, y yVar) {
            bVar.getClass();
            bVar.keyData_ = yVar;
            bVar.bitField0_ |= 1;
        }

        public static void E(b bVar, I i9) {
            bVar.getClass();
            bVar.outputPrefixType_ = i9.a();
        }

        public static void F(b bVar, z zVar) {
            bVar.getClass();
            bVar.status_ = zVar.a();
        }

        public static void H(b bVar, int i9) {
            bVar.keyId_ = i9;
        }

        public static a N() {
            return (a) DEFAULT_INSTANCE.l();
        }

        public final y I() {
            y yVar = this.keyData_;
            return yVar == null ? y.H() : yVar;
        }

        public final int J() {
            return this.keyId_;
        }

        public final I K() {
            I iB = I.b(this.outputPrefixType_);
            return iB == null ? I.UNRECOGNIZED : iB;
        }

        public final z L() {
            z zVar;
            int i9 = this.status_;
            if (i9 == 0) {
                zVar = z.UNKNOWN_STATUS;
            } else if (i9 == 1) {
                zVar = z.ENABLED;
            } else if (i9 != 2) {
                zVar = i9 != 3 ? null : z.DESTROYED;
            } else {
                zVar = z.DISABLED;
            }
            return zVar == null ? z.UNRECOGNIZED : zVar;
        }

        public final boolean M() {
            return (this.bitField0_ & 1) != 0;
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
                return new d0(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"bitField0_", "keyData_", "status_", "keyId_", "outputPrefixType_"});
            }
            if (iOrdinal == 3) {
                return new b();
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
            Z<b> z8 = PARSER;
            if (z8 != null) {
                return z8;
            }
            synchronized (b.class) {
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

    static {
        C c5 = new C();
        DEFAULT_INSTANCE = c5;
        AbstractC0583w.A(C.class, c5);
    }

    public static void D(C c5, int i9) {
        c5.primaryKeyId_ = i9;
    }

    public static void E(C c5, b bVar) {
        c5.getClass();
        C0585y.c<b> cVar = c5.key_;
        if (!cVar.e()) {
            c5.key_ = cVar.c(cVar.size() * 2);
        }
        c5.key_.add(bVar);
    }

    public static a K() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public static C L(ByteArrayInputStream byteArrayInputStream, C0576o c0576o) throws C0586z {
        AbstractC0583w abstractC0583wZ = AbstractC0583w.z(DEFAULT_INSTANCE, new AbstractC0570i.b(byteArrayInputStream), c0576o);
        AbstractC0583w.k(abstractC0583wZ);
        return (C) abstractC0583wZ;
    }

    public static C M(byte[] bArr, C0576o c0576o) {
        return (C) AbstractC0583w.y(DEFAULT_INSTANCE, bArr, c0576o);
    }

    public final b F(int i9) {
        return this.key_.get(i9);
    }

    public final int H() {
        return this.key_.size();
    }

    public final C0585y.c I() {
        return this.key_;
    }

    public final int J() {
        return this.primaryKeyId_;
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
            return new d0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", b.class});
        }
        if (iOrdinal == 3) {
            return new C();
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
        Z<C> z8 = PARSER;
        if (z8 != null) {
            return z8;
        }
        synchronized (C.class) {
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
