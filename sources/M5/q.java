package M5;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: compiled from: AesGcmParameters.java */
/* JADX INFO: loaded from: classes.dex */
public final class q extends AbstractC0319c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f3051d;

    /* JADX INFO: compiled from: AesGcmParameters.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f3052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f3053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f3054c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b f3055d;

        public final q a() {
            Integer num = this.f3052a;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            }
            if (this.f3055d == null) {
                throw new GeneralSecurityException("Variant is not set");
            }
            if (this.f3053b == null) {
                throw new GeneralSecurityException("IV size is not set");
            }
            if (this.f3054c != null) {
                return new q(num.intValue(), this.f3053b.intValue(), this.f3054c.intValue(), this.f3055d);
            }
            throw new GeneralSecurityException("Tag size is not set");
        }

        public final void b() {
            this.f3053b = 12;
        }

        public final void c(int i9) {
            if (i9 != 16 && i9 != 24 && i9 != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i9)));
            }
            this.f3052a = Integer.valueOf(i9);
        }

        public final void d() {
            this.f3054c = 16;
        }
    }

    /* JADX INFO: compiled from: AesGcmParameters.java */
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f3056b = new b("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f3057c = new b("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f3058d = new b("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3059a;

        public b(String str) {
            this.f3059a = str;
        }

        public final String toString() {
            return this.f3059a;
        }
    }

    public q(int i9, int i10, int i11, b bVar) {
        this.f3048a = i9;
        this.f3049b = i10;
        this.f3050c = i11;
        this.f3051d = bVar;
    }

    public static a b() {
        a aVar = new a();
        aVar.f3052a = null;
        aVar.f3053b = null;
        aVar.f3054c = null;
        aVar.f3055d = b.f3058d;
        return aVar;
    }

    @Override // L5.n
    public final boolean a() {
        return this.f3051d != b.f3058d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return qVar.f3048a == this.f3048a && qVar.f3049b == this.f3049b && qVar.f3050c == this.f3050c && qVar.f3051d == this.f3051d;
    }

    public final int hashCode() {
        return Objects.hash(q.class, Integer.valueOf(this.f3048a), Integer.valueOf(this.f3049b), Integer.valueOf(this.f3050c), this.f3051d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesGcm Parameters (variant: ");
        sb.append(this.f3051d);
        sb.append(", ");
        sb.append(this.f3049b);
        sb.append("-byte IV, ");
        sb.append(this.f3050c);
        sb.append("-byte tag, and ");
        return A.f.i(sb, this.f3048a, "-byte key)");
    }
}
