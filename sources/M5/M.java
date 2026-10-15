package M5;

import java.util.Objects;

/* JADX INFO: compiled from: XChaCha20Poly1305Parameters.java */
/* JADX INFO: loaded from: classes.dex */
public final class M extends AbstractC0319c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2968a;

    /* JADX INFO: compiled from: XChaCha20Poly1305Parameters.java */
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f2969b = new a("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f2970c = new a("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f2971d = new a("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2972a;

        public a(String str) {
            this.f2972a = str;
        }

        public final String toString() {
            return this.f2972a;
        }
    }

    public M(a aVar) {
        this.f2968a = aVar;
    }

    @Override // L5.n
    public final boolean a() {
        return this.f2968a != a.f2971d;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof M) && ((M) obj).f2968a == this.f2968a;
    }

    public final int hashCode() {
        return Objects.hash(M.class, this.f2968a);
    }

    public final String toString() {
        return "XChaCha20Poly1305 Parameters (variant: " + this.f2968a + ")";
    }
}
