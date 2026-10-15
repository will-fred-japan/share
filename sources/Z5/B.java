package Z5;

import com.google.crypto.tink.shaded.protobuf.AbstractC0583w;
import com.google.crypto.tink.shaded.protobuf.S;
import com.google.crypto.tink.shaded.protobuf.Z;
import com.google.crypto.tink.shaded.protobuf.d0;

/* JADX INFO: compiled from: KeyTypeEntry.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class B extends AbstractC0583w<B, a> implements S {
    public static final int CATALOGUE_NAME_FIELD_NUMBER = 5;
    private static final B DEFAULT_INSTANCE;
    public static final int KEY_MANAGER_VERSION_FIELD_NUMBER = 3;
    public static final int NEW_KEY_ALLOWED_FIELD_NUMBER = 4;
    private static volatile Z<B> PARSER = null;
    public static final int PRIMITIVE_NAME_FIELD_NUMBER = 1;
    public static final int TYPE_URL_FIELD_NUMBER = 2;
    private int keyManagerVersion_;
    private boolean newKeyAllowed_;
    private String primitiveName_ = "";
    private String typeUrl_ = "";
    private String catalogueName_ = "";

    /* JADX INFO: compiled from: KeyTypeEntry.java */
    public static final class a extends AbstractC0583w.a<B, a> implements S {
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
        B b9 = new B();
        DEFAULT_INSTANCE = b9;
        AbstractC0583w.A(B.class, b9);
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
            return new d0(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"primitiveName_", "typeUrl_", "keyManagerVersion_", "newKeyAllowed_", "catalogueName_"});
        }
        if (iOrdinal == 3) {
            return new B();
        }
        if (iOrdinal == 4) {
            return new a(DEFAULT_INSTANCE);
        }
        if (iOrdinal == 5) {
            return DEFAULT_INSTANCE;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        Z<B> z8 = PARSER;
        if (z8 != null) {
            return z8;
        }
        synchronized (B.class) {
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
