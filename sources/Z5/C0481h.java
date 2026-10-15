package Z5;

import com.google.crypto.tink.shaded.protobuf.AbstractC0583w;
import com.google.crypto.tink.shaded.protobuf.S;
import com.google.crypto.tink.shaded.protobuf.Z;
import com.google.crypto.tink.shaded.protobuf.d0;

/* JADX INFO: renamed from: Z5.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AesCtrParams.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0481h extends AbstractC0583w<C0481h, a> implements S {
    private static final C0481h DEFAULT_INSTANCE;
    public static final int IV_SIZE_FIELD_NUMBER = 1;
    private static volatile Z<C0481h> PARSER;
    private int ivSize_;

    /* JADX INFO: renamed from: Z5.h$a */
    /* JADX INFO: compiled from: AesCtrParams.java */
    public static final class a extends AbstractC0583w.a<C0481h, a> implements S {
        public a() {
            super(C0481h.DEFAULT_INSTANCE);
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
        C0481h c0481h = new C0481h();
        DEFAULT_INSTANCE = c0481h;
        AbstractC0583w.A(C0481h.class, c0481h);
    }

    public static void D(C0481h c0481h, int i9) {
        c0481h.ivSize_ = i9;
    }

    public static C0481h E() {
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
            return new C0481h();
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
        Z<C0481h> z8 = PARSER;
        if (z8 != null) {
            return z8;
        }
        synchronized (C0481h.class) {
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
