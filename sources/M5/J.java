package M5;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: XAesGcmParameters.java */
/* JADX INFO: loaded from: classes.dex */
public final class J extends AbstractC0319c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2956b;

    /* JADX INFO: compiled from: XAesGcmParameters.java */
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f2957b = new a("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f2958c = new a("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2959a;

        public a(String str) {
            this.f2959a = str;
        }

        public final String toString() {
            return this.f2959a;
        }
    }

    public J(a aVar, int i9) {
        this.f2955a = aVar;
        this.f2956b = i9;
    }

    public static J b(a aVar, int i9) throws GeneralSecurityException {
        if (i9 < 8 || i9 > 12) {
            throw new GeneralSecurityException("Salt size must be between 8 and 12 bytes");
        }
        return new J(aVar, i9);
    }

    @Override // L5.n
    public final boolean a() {
        return this.f2955a != a.f2958c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof J)) {
            return false;
        }
        J j = (J) obj;
        return j.f2955a == this.f2955a && j.f2956b == this.f2956b;
    }

    public final int hashCode() {
        return Objects.hash(J.class, this.f2955a, Integer.valueOf(this.f2956b));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("X-AES-GCM Parameters (variant: ");
        sb.append(this.f2955a);
        sb.append("salt_size_bytes: ");
        return A.f.i(sb, this.f2956b, ")");
    }
}
