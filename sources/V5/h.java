package V5;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: compiled from: HmacParameters.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends R5.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f4868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f4869d;

    /* JADX INFO: compiled from: HmacParameters.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f4870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f4871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f4872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f4873d;

        public final h a() {
            Integer num = this.f4870a;
            if (num == null) {
                throw new GeneralSecurityException("key size is not set");
            }
            if (this.f4871b == null) {
                throw new GeneralSecurityException("tag size is not set");
            }
            if (this.f4872c == null) {
                throw new GeneralSecurityException("hash type is not set");
            }
            if (this.f4873d == null) {
                throw new GeneralSecurityException("variant is not set");
            }
            if (num.intValue() < 16) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.f4870a));
            }
            Integer num2 = this.f4871b;
            int iIntValue = num2.intValue();
            b bVar = this.f4872c;
            if (iIntValue < 10) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
            }
            if (bVar == b.f4874b) {
                if (iIntValue > 20) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
                }
            } else if (bVar == b.f4875c) {
                if (iIntValue > 28) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
                }
            } else if (bVar == b.f4876d) {
                if (iIntValue > 32) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
                }
            } else if (bVar == b.f4877e) {
                if (iIntValue > 48) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
                }
            } else {
                if (bVar != b.f4878f) {
                    throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                }
                if (iIntValue > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num2));
                }
            }
            return new h(this.f4870a.intValue(), this.f4871b.intValue(), this.f4873d, this.f4872c);
        }
    }

    /* JADX INFO: compiled from: HmacParameters.java */
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f4874b = new b("SHA1");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f4875c = new b("SHA224");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f4876d = new b("SHA256");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f4877e = new b("SHA384");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f4878f = new b("SHA512");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4879a;

        public b(String str) {
            this.f4879a = str;
        }

        public final String toString() {
            return this.f4879a;
        }
    }

    /* JADX INFO: compiled from: HmacParameters.java */
    public static final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f4880b = new c("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f4881c = new c("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f4882d = new c("LEGACY");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f4883e = new c("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4884a;

        public c(String str) {
            this.f4884a = str;
        }

        public final String toString() {
            return this.f4884a;
        }
    }

    public h(int i9, int i10, c cVar, b bVar) {
        this.f4866a = i9;
        this.f4867b = i10;
        this.f4868c = cVar;
        this.f4869d = bVar;
    }

    public static a b() {
        a aVar = new a();
        aVar.f4870a = null;
        aVar.f4871b = null;
        aVar.f4872c = null;
        aVar.f4873d = c.f4883e;
        return aVar;
    }

    @Override // L5.n
    public final boolean a() {
        return this.f4868c != c.f4883e;
    }

    public final int c() {
        c cVar = c.f4883e;
        int i9 = this.f4867b;
        c cVar2 = this.f4868c;
        if (cVar2 == cVar) {
            return i9;
        }
        if (cVar2 == c.f4880b) {
            return i9 + 5;
        }
        if (cVar2 == c.f4881c) {
            return i9 + 5;
        }
        if (cVar2 == c.f4882d) {
            return i9 + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return hVar.f4866a == this.f4866a && hVar.c() == c() && hVar.f4868c == this.f4868c && hVar.f4869d == this.f4869d;
    }

    public final int hashCode() {
        return Objects.hash(h.class, Integer.valueOf(this.f4866a), Integer.valueOf(this.f4867b), this.f4868c, this.f4869d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HMAC Parameters (variant: ");
        sb.append(this.f4868c);
        sb.append(", hashType: ");
        sb.append(this.f4869d);
        sb.append(", ");
        sb.append(this.f4867b);
        sb.append("-byte tags, and ");
        return A.f.i(sb, this.f4866a, "-byte key)");
    }
}
