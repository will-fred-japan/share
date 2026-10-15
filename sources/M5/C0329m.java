package M5;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: renamed from: M5.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AesEaxParameters.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0329m extends AbstractC0319c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f3026d;

    /* JADX INFO: renamed from: M5.m$a */
    /* JADX INFO: compiled from: AesEaxParameters.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f3027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f3028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f3029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b f3030d;

        public final C0329m a() {
            Integer num = this.f3027a;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            }
            if (this.f3028b == null) {
                throw new GeneralSecurityException("IV size is not set");
            }
            if (this.f3030d == null) {
                throw new GeneralSecurityException("Variant is not set");
            }
            if (this.f3029c != null) {
                return new C0329m(num.intValue(), this.f3028b.intValue(), this.f3029c.intValue(), this.f3030d);
            }
            throw new GeneralSecurityException("Tag size is not set");
        }

        public final void b(int i9) {
            if (i9 != 12 && i9 != 16) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i9)));
            }
            this.f3028b = Integer.valueOf(i9);
        }

        public final void c(int i9) {
            if (i9 != 16 && i9 != 24 && i9 != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i9)));
            }
            this.f3027a = Integer.valueOf(i9);
        }

        public final void d() {
            this.f3029c = 16;
        }
    }

    /* JADX INFO: renamed from: M5.m$b */
    /* JADX INFO: compiled from: AesEaxParameters.java */
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f3031b = new b("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f3032c = new b("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f3033d = new b("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3034a;

        public b(String str) {
            this.f3034a = str;
        }

        public final String toString() {
            return this.f3034a;
        }
    }

    public C0329m(int i9, int i10, int i11, b bVar) {
        this.f3023a = i9;
        this.f3024b = i10;
        this.f3025c = i11;
        this.f3026d = bVar;
    }

    public static a b() {
        a aVar = new a();
        aVar.f3027a = null;
        aVar.f3028b = null;
        aVar.f3029c = null;
        aVar.f3030d = b.f3033d;
        return aVar;
    }

    @Override // L5.n
    public final boolean a() {
        return this.f3026d != b.f3033d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0329m)) {
            return false;
        }
        C0329m c0329m = (C0329m) obj;
        return c0329m.f3023a == this.f3023a && c0329m.f3024b == this.f3024b && c0329m.f3025c == this.f3025c && c0329m.f3026d == this.f3026d;
    }

    public final int hashCode() {
        return Objects.hash(C0329m.class, Integer.valueOf(this.f3023a), Integer.valueOf(this.f3024b), Integer.valueOf(this.f3025c), this.f3026d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesEax Parameters (variant: ");
        sb.append(this.f3026d);
        sb.append(", ");
        sb.append(this.f3024b);
        sb.append("-byte IV, ");
        sb.append(this.f3025c);
        sb.append("-byte tag, and ");
        return A.f.i(sb, this.f3023a, "-byte key)");
    }
}
