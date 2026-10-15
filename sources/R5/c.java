package R5;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: compiled from: AesSivParameters.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f4020b;

    /* JADX INFO: compiled from: AesSivParameters.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f4021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f4022b;

        public final c a() {
            Integer num = this.f4021a;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            }
            if (this.f4022b != null) {
                return new c(num.intValue(), this.f4022b);
            }
            throw new GeneralSecurityException("Variant is not set");
        }

        public final void b(int i9) {
            if (i9 != 32 && i9 != 48 && i9 != 64) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", Integer.valueOf(i9)));
            }
            this.f4021a = Integer.valueOf(i9);
        }
    }

    /* JADX INFO: compiled from: AesSivParameters.java */
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f4023b = new b("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f4024c = new b("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f4025d = new b("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4026a;

        public b(String str) {
            this.f4026a = str;
        }

        public final String toString() {
            return this.f4026a;
        }
    }

    public c(int i9, b bVar) {
        this.f4019a = i9;
        this.f4020b = bVar;
    }

    public static a b() {
        a aVar = new a();
        aVar.f4021a = null;
        aVar.f4022b = b.f4025d;
        return aVar;
    }

    @Override // L5.n
    public final boolean a() {
        return this.f4020b != b.f4025d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.f4019a == this.f4019a && cVar.f4020b == this.f4020b;
    }

    public final int hashCode() {
        return Objects.hash(c.class, Integer.valueOf(this.f4019a), this.f4020b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesSiv Parameters (variant: ");
        sb.append(this.f4020b);
        sb.append(", ");
        return A.f.i(sb, this.f4019a, "-byte key)");
    }
}
