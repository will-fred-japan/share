package Z5;

import com.google.crypto.tink.shaded.protobuf.AbstractC0583w;
import com.google.crypto.tink.shaded.protobuf.S;
import com.google.crypto.tink.shaded.protobuf.Z;
import com.google.crypto.tink.shaded.protobuf.d0;

/* JADX INFO: renamed from: Z5.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AesEaxParams.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0484k extends AbstractC0583w<C0484k, a> implements S {
    private static final C0484k DEFAULT_INSTANCE;
    public static final int IV_SIZE_FIELD_NUMBER = 1;
    private static volatile Z<C0484k> PARSER;
    private int ivSize_;

    /* JADX INFO: renamed from: Z5.k$a */
    /* JADX INFO: compiled from: AesEaxParams.java */
    public static final class a extends AbstractC0583w.a<C0484k, a> implements S {
        public a() {
            super(C0484k.DEFAULT_INSTANCE);
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
        C0484k c0484k = new C0484k();
        DEFAULT_INSTANCE = c0484k;
        AbstractC0583w.A(C0484k.class, c0484k);
    }

    public static void D(C0484k c0484k, int i9) {
        c0484k.ivSize_ = i9;
    }

    public static C0484k E() {
        return DEFAULT_INSTANCE;
    }

    public static a H() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public final int F() {
        return this.ivSize_;
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
            return new d0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"ivSize_"});
        }
        if (iOrdinal == 3) {
            return new C0484k();
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
        Z<C0484k> z8 = PARSER;
        if (z8 != null) {
            return z8;
        }
        synchronized (C0484k.class) {
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
