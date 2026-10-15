package M5;

import java.util.Objects;

/* JADX INFO: compiled from: LegacyKmsAeadParameters.java */
/* JADX INFO: loaded from: classes.dex */
public final class B extends AbstractC0319c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2911b;

    /* JADX INFO: compiled from: LegacyKmsAeadParameters.java */
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f2912b = new a("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f2913c = new a("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2914a;

        public a(String str) {
            this.f2914a = str;
        }

        public final String toString() {
            return this.f2914a;
        }
    }

    public B(String str, a aVar) {
        this.f2910a = str;
        this.f2911b = aVar;
    }

    @Override // L5.n
    public final boolean a() {
        return this.f2911b != a.f2913c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof B)) {
            return false;
        }
        B b9 = (B) obj;
        return b9.f2910a.equals(this.f2910a) && b9.f2911b.equals(this.f2911b);
    }

    public final int hashCode() {
        return Objects.hash(B.class, this.f2910a, this.f2911b);
    }

    public final String toString() {
        return "LegacyKmsAead Parameters (keyUri: " + this.f2910a + ", variant: " + this.f2911b + ")";
    }
}
