package U5;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.security.GeneralSecurityException;

/* JADX INFO: renamed from: U5.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LegacyProtoKey.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0447i extends A0.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final E f4713b;

    /* JADX INFO: renamed from: U5.i$a */
    /* JADX INFO: compiled from: LegacyProtoKey.java */
    public static class a extends L5.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Z5.I f4715b;

        public a(String str, Z5.I i9) {
            this.f4714a = str;
            this.f4715b = i9;
        }

        @Override // L5.n
        public final boolean a() {
            return this.f4715b != Z5.I.RAW;
        }

        public final String toString() {
            String str;
            int iOrdinal = this.f4715b.ordinal();
            if (iOrdinal == 1) {
                str = "TINK";
            } else if (iOrdinal == 2) {
                str = "LEGACY";
            } else if (iOrdinal != 3) {
                str = iOrdinal != 4 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "CRUNCHY";
            } else {
                str = "RAW";
            }
            return "(typeUrl=" + this.f4714a + ", outputPrefixType=" + str + ")";
        }
    }

    public C0447i(E e9) {
        super(4);
        e9.f4679d.ordinal();
        this.f4713b = e9;
    }

    public static void x(E e9) {
        e9.f4679d.ordinal();
    }

    @Override // A0.h
    public final Integer g() {
        return this.f4713b.f4681f;
    }

    @Override // A0.h
    public final L5.n m() {
        E e9 = this.f4713b;
        return new a(e9.f4676a, e9.f4680e);
    }

    public final p012b6.a w() throws GeneralSecurityException {
        E e9 = this.f4713b;
        if (e9.f4680e.equals(Z5.I.RAW)) {
            return p012b6.a.a(new byte[0]);
        }
        Z5.I i9 = Z5.I.TINK;
        Z5.I i10 = e9.f4680e;
        boolean zEquals = i10.equals(i9);
        Integer num = e9.f4681f;
        if (zEquals) {
            return t.b(num.intValue());
        }
        if (i10.equals(Z5.I.LEGACY) || i10.equals(Z5.I.CRUNCHY)) {
            return t.a(num.intValue());
        }
        throw new GeneralSecurityException("Unknown output prefix type");
    }
}
