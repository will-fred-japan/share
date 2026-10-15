package Z5;

import com.google.crypto.tink.shaded.protobuf.AbstractC0583w;
import com.google.crypto.tink.shaded.protobuf.S;
import com.google.crypto.tink.shaded.protobuf.Z;
import com.google.crypto.tink.shaded.protobuf.d0;

/* JADX INFO: renamed from: Z5.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AesCtrKeyFormat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0480g extends AbstractC0583w<C0480g, a> implements S {
    private static final C0480g DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Z<C0480g> PARSER;
    private int bitField0_;
    private int keySize_;
    private C0481h params_;

    /* JADX INFO: renamed from: Z5.g$a */
    /* JADX INFO: compiled from: AesCtrKeyFormat.java */
    public static final class a extends AbstractC0583w.a<C0480g, a> implements S {
        public a() {
            super(C0480g.DEFAULT_INSTANCE);
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
        C0480g c0480g = new C0480g();
        DEFAULT_INSTANCE = c0480g;
        AbstractC0583w.A(C0480g.class, c0480g);
    }

    public static void D(C0480g c0480g, C0481h c0481h) {
        c0480g.getClass();
        c0480g.params_ = c0481h;
        c0480g.bitField0_ |= 1;
    }

    public static void E(C0480g c0480g, int i9) {
        c0480g.keySize_ = i9;
    }

    public static C0480g F() {
        return DEFAULT_INSTANCE;
    }

    public static a J() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public final int H() {
        return this.keySize_;
    }

    public final C0481h I() {
        C0481h c0481h = this.params_;
        return c0481h == null ? C0481h.E() : c0481h;
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
            return new d0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"bitField0_", "params_", "keySize_"});
        }
        if (iOrdinal == 3) {
            return new C0480g();
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
        Z<C0480g> z8 = PARSER;
        if (z8 != null) {
            return z8;
        }
        synchronized (C0480g.class) {
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
