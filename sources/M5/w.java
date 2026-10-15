package M5;

import java.util.Objects;

/* JADX INFO: compiled from: ChaCha20Poly1305Parameters.java */
/* JADX INFO: loaded from: classes.dex */
public final class w extends AbstractC0319c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f3086a;

    /* JADX INFO: compiled from: ChaCha20Poly1305Parameters.java */
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f3087b = new a("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f3088c = new a("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f3089d = new a("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3090a;

        public a(String str) {
            this.f3090a = str;
        }

        public final String toString() {
            return this.f3090a;
        }
    }

    public w(a aVar) {
        this.f3086a = aVar;
    }

    @Override // L5.n
    public final boolean a() {
        return this.f3086a != a.f3089d;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof w) && ((w) obj).f3086a == this.f3086a;
    }

    public final int hashCode() {
        return Objects.hash(w.class, this.f3086a);
    }

    public final String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + this.f3086a + ")";
    }
}
