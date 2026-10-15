package V5;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: compiled from: AesCmacParameters.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends R5.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f4843c;

    /* JADX INFO: compiled from: AesCmacParameters.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f4844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f4845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f4846c;

        public final c a() {
            Integer num = this.f4844a;
            if (num == null) {
                throw new GeneralSecurityException("key size not set");
            }
            if (this.f4845b == null) {
                throw new GeneralSecurityException("tag size not set");
            }
            if (this.f4846c != null) {
                return new c(num.intValue(), this.f4845b.intValue(), this.f4846c);
            }
            throw new GeneralSecurityException("variant not set");
        }

        public final void b(int i9) {
            if (i9 != 16 && i9 != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i9 * 8)));
            }
            this.f4844a = Integer.valueOf(i9);
        }

        public final void c(int i9) {
            if (i9 < 10 || 16 < i9) {
                throw new GeneralSecurityException(W5.e.i(i9, "Invalid tag size for AesCmacParameters: "));
            }
            this.f4845b = Integer.valueOf(i9);
        }
    }

    /* JADX INFO: compiled from: AesCmacParameters.java */
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f4847b = new b("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f4848c = new b("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f4849d = new b("LEGACY");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f4850e = new b("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4851a;

        public b(String str) {
            this.f4851a = str;
        }

        public final String toString() {
            return this.f4851a;
        }
    }

    public c(int i9, int i10, b bVar) {
        this.f4841a = i9;
        this.f4842b = i10;
        this.f4843c = bVar;
    }

    public static a b() {
        a aVar = new a();
        aVar.f4844a = null;
        aVar.f4845b = null;
        aVar.f4846c = b.f4850e;
        return aVar;
    }

    @Override // L5.n
    public final boolean a() {
        return this.f4843c != b.f4850e;
    }

    public final int c() {
        b bVar = b.f4850e;
        int i9 = this.f4842b;
        b bVar2 = this.f4843c;
        if (bVar2 == bVar) {
            return i9;
        }
        if (bVar2 == b.f4847b) {
            return i9 + 5;
        }
        if (bVar2 == b.f4848c) {
            return i9 + 5;
        }
        if (bVar2 == b.f4849d) {
            return i9 + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.f4841a == this.f4841a && cVar.c() == c() && cVar.f4843c == this.f4843c;
    }

    public final int hashCode() {
        return Objects.hash(c.class, Integer.valueOf(this.f4841a), Integer.valueOf(this.f4842b), this.f4843c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AES-CMAC Parameters (variant: ");
        sb.append(this.f4843c);
        sb.append(", ");
        sb.append(this.f4842b);
        sb.append("-byte tags, and ");
        return A.f.i(sb, this.f4841a, "-byte key)");
    }
}
