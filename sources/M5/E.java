package M5;

import java.util.Objects;

/* JADX INFO: compiled from: LegacyKmsEnvelopeAeadParameters.java */
/* JADX INFO: loaded from: classes.dex */
public final class E extends AbstractC0319c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0319c f2925d;

    /* JADX INFO: compiled from: LegacyKmsEnvelopeAeadParameters.java */
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f2926b = new a("ASSUME_AES_GCM");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f2927c = new a("ASSUME_XCHACHA20POLY1305");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f2928d = new a("ASSUME_CHACHA20POLY1305");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f2929e = new a("ASSUME_AES_CTR_HMAC");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f2930f = new a("ASSUME_AES_EAX");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f2931g = new a("ASSUME_AES_GCM_SIV");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2932a;

        public a(String str) {
            this.f2932a = str;
        }

        public final String toString() {
            return this.f2932a;
        }
    }

    /* JADX INFO: compiled from: LegacyKmsEnvelopeAeadParameters.java */
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f2933b = new b("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f2934c = new b("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2935a;

        public b(String str) {
            this.f2935a = str;
        }

        public final String toString() {
            return this.f2935a;
        }
    }

    public E(b bVar, String str, a aVar, AbstractC0319c abstractC0319c) {
        this.f2922a = bVar;
        this.f2923b = str;
        this.f2924c = aVar;
        this.f2925d = abstractC0319c;
    }

    @Override // L5.n
    public final boolean a() {
        return this.f2922a != b.f2934c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof E)) {
            return false;
        }
        E e9 = (E) obj;
        return e9.f2924c.equals(this.f2924c) && e9.f2925d.equals(this.f2925d) && e9.f2923b.equals(this.f2923b) && e9.f2922a.equals(this.f2922a);
    }

    public final int hashCode() {
        return Objects.hash(E.class, this.f2923b, this.f2924c, this.f2925d, this.f2922a);
    }

    public final String toString() {
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.f2923b + ", dekParsingStrategy: " + this.f2924c + ", dekParametersForNewKeys: " + this.f2925d + ", variant: " + this.f2922a + ")";
    }
}
