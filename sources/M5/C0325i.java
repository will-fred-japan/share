package M5;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: renamed from: M5.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AesCtrHmacAeadParameters.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0325i extends AbstractC0319c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f2994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f2995f;

    /* JADX INFO: renamed from: M5.i$a */
    /* JADX INFO: compiled from: AesCtrHmacAeadParameters.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f2996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f2997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f2998c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f2999d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public b f3000e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f3001f;

        public final C0325i a() {
            if (this.f2996a == null) {
                throw new GeneralSecurityException("AES key size is not set");
            }
            if (this.f2997b == null) {
                throw new GeneralSecurityException("HMAC key size is not set");
            }
            if (this.f2998c == null) {
                throw new GeneralSecurityException("iv size is not set");
            }
            Integer num = this.f2999d;
            if (num == null) {
                throw new GeneralSecurityException("tag size is not set");
            }
            if (this.f3000e == null) {
                throw new GeneralSecurityException("hash type is not set");
            }
            if (this.f3001f == null) {
                throw new GeneralSecurityException("variant is not set");
            }
            int iIntValue = num.intValue();
            b bVar = this.f3000e;
            if (bVar == b.f3002b) {
                if (iIntValue > 20) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num));
                }
            } else if (bVar == b.f3003c) {
                if (iIntValue > 28) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num));
                }
            } else if (bVar == b.f3004d) {
                if (iIntValue > 32) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num));
                }
            } else if (bVar == b.f3005e) {
                if (iIntValue > 48) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num));
                }
            } else {
                if (bVar != b.f3006f) {
                    throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
                }
                if (iIntValue > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num));
                }
            }
            return new C0325i(this.f2996a.intValue(), this.f2997b.intValue(), this.f2998c.intValue(), this.f2999d.intValue(), this.f3001f, this.f3000e);
        }

        public final void b(int i9) {
            if (i9 != 16 && i9 != 24 && i9 != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i9)));
            }
            this.f2996a = Integer.valueOf(i9);
        }

        public final void c(int i9) {
            if (i9 < 16) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", Integer.valueOf(i9)));
            }
            this.f2997b = Integer.valueOf(i9);
        }

        public final void d(int i9) {
            if (i9 < 12 || i9 > 16) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", Integer.valueOf(i9)));
            }
            this.f2998c = Integer.valueOf(i9);
        }

        public final void e(int i9) {
            if (i9 < 10) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(i9)));
            }
            this.f2999d = Integer.valueOf(i9);
        }
    }

    /* JADX INFO: renamed from: M5.i$b */
    /* JADX INFO: compiled from: AesCtrHmacAeadParameters.java */
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f3002b = new b("SHA1");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f3003c = new b("SHA224");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f3004d = new b("SHA256");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f3005e = new b("SHA384");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f3006f = new b("SHA512");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3007a;

        public b(String str) {
            this.f3007a = str;
        }

        public final String toString() {
            return this.f3007a;
        }
    }

    /* JADX INFO: renamed from: M5.i$c */
    /* JADX INFO: compiled from: AesCtrHmacAeadParameters.java */
    public static final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f3008b = new c("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f3009c = new c("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f3010d = new c("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3011a;

        public c(String str) {
            this.f3011a = str;
        }

        public final String toString() {
            return this.f3011a;
        }
    }

    public C0325i(int i9, int i10, int i11, int i12, c cVar, b bVar) {
        this.f2990a = i9;
        this.f2991b = i10;
        this.f2992c = i11;
        this.f2993d = i12;
        this.f2994e = cVar;
        this.f2995f = bVar;
    }

    public static a b() {
        a aVar = new a();
        aVar.f2996a = null;
        aVar.f2997b = null;
        aVar.f2998c = null;
        aVar.f2999d = null;
        aVar.f3000e = null;
        aVar.f3001f = c.f3010d;
        return aVar;
    }

    @Override // L5.n
    public final boolean a() {
        return this.f2994e != c.f3010d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0325i)) {
            return false;
        }
        C0325i c0325i = (C0325i) obj;
        return c0325i.f2990a == this.f2990a && c0325i.f2991b == this.f2991b && c0325i.f2992c == this.f2992c && c0325i.f2993d == this.f2993d && c0325i.f2994e == this.f2994e && c0325i.f2995f == this.f2995f;
    }

    public final int hashCode() {
        return Objects.hash(C0325i.class, Integer.valueOf(this.f2990a), Integer.valueOf(this.f2991b), Integer.valueOf(this.f2992c), Integer.valueOf(this.f2993d), this.f2994e, this.f2995f);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesCtrHmacAead Parameters (variant: ");
        sb.append(this.f2994e);
        sb.append(", hashType: ");
        sb.append(this.f2995f);
        sb.append(", ");
        sb.append(this.f2992c);
        sb.append("-byte IV, and ");
        sb.append(this.f2993d);
        sb.append("-byte tags, and ");
        sb.append(this.f2990a);
        sb.append("-byte AES key, and ");
        return A.f.i(sb, this.f2991b, "-byte HMAC key)");
    }
}
