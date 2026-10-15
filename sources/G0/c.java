package G0;

/* JADX INFO: compiled from: FoldingFeature.kt */
/* JADX INFO: loaded from: classes.dex */
public interface c extends G0.a {

    /* JADX INFO: compiled from: FoldingFeature.kt */
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f2210b = new a("NONE");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f2211c = new a("FULL");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2212a;

        public a(String str) {
            this.f2212a = str;
        }

        public final String toString() {
            return this.f2212a;
        }
    }

    /* JADX INFO: compiled from: FoldingFeature.kt */
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f2213b = new b("FLAT");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f2214c = new b("HALF_OPENED");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2215a;

        public b(String str) {
            this.f2215a = str;
        }

        public final String toString() {
            return this.f2215a;
        }
    }

    a b();

    b getState();
}
