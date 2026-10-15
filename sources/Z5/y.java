package Z5;

import com.google.crypto.tink.shaded.protobuf.AbstractC0569h;
import com.google.crypto.tink.shaded.protobuf.AbstractC0583w;
import com.google.crypto.tink.shaded.protobuf.C0585y;
import com.google.crypto.tink.shaded.protobuf.S;
import com.google.crypto.tink.shaded.protobuf.Z;
import com.google.crypto.tink.shaded.protobuf.d0;

/* JADX INFO: compiled from: KeyData.java */
/* JADX INFO: loaded from: classes.dex */
public final class y extends AbstractC0583w<y, a> implements S {
    private static final y DEFAULT_INSTANCE;
    public static final int KEY_MATERIAL_TYPE_FIELD_NUMBER = 3;
    private static volatile Z<y> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int keyMaterialType_;
    private String typeUrl_ = "";
    private AbstractC0569h value_ = AbstractC0569h.f14069b;

    /* JADX INFO: compiled from: KeyData.java */
    public static final class a extends AbstractC0583w.a<y, a> implements S {
        public a() {
            super(y.DEFAULT_INSTANCE);
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

    /* JADX INFO: compiled from: KeyData.java */
    public enum b implements C0585y.a {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5546a;

        b(int i9) {
            this.f5546a = i9;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C0585y.a
        public final int a() {
            if (this != UNRECOGNIZED) {
                return this.f5546a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        y yVar = new y();
        DEFAULT_INSTANCE = yVar;
        AbstractC0583w.A(y.class, yVar);
    }

    public static void D(y yVar, String str) {
        yVar.getClass();
        str.getClass();
        yVar.typeUrl_ = str;
    }

    public static void E(y yVar, AbstractC0569h abstractC0569h) {
        yVar.getClass();
        abstractC0569h.getClass();
        yVar.value_ = abstractC0569h;
    }

    public static void F(y yVar, b bVar) {
        yVar.getClass();
        yVar.keyMaterialType_ = bVar.a();
    }

    public static y H() {
        return DEFAULT_INSTANCE;
    }

    public static a L() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public final b I() {
        b bVar;
        int i9 = this.keyMaterialType_;
        if (i9 == 0) {
            bVar = b.UNKNOWN_KEYMATERIAL;
        } else if (i9 == 1) {
            bVar = b.SYMMETRIC;
        } else if (i9 == 2) {
            bVar = b.ASYMMETRIC_PRIVATE;
        } else if (i9 != 3) {
            bVar = i9 != 4 ? null : b.REMOTE;
        } else {
            bVar = b.ASYMMETRIC_PUBLIC;
        }
        return bVar == null ? b.UNRECOGNIZED : bVar;
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
            return new d0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "keyMaterialType_"});
        }
        if (iOrdinal == 3) {
            return new y();
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
        Z<y> z8 = PARSER;
        if (z8 != null) {
            return z8;
        }
        synchronized (y.class) {
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
