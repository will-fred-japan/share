package U7;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f4786b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4787a;

    /* JADX INFO: compiled from: Channel.kt */
    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f4788a;

        public a(Throwable th) {
            this.f4788a = th;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                return kotlin.jvm.internal.k.a(this.f4788a, ((a) obj).f4788a);
            }
            return false;
        }

        public final int hashCode() {
            Throwable th = this.f4788a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // U7.i.b
        public final String toString() {
            return "Closed(" + this.f4788a + ')';
        }
    }

    /* JADX INFO: compiled from: Channel.kt */
    public static class b {
        public String toString() {
            return "Failed";
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return kotlin.jvm.internal.k.a(this.f4787a, ((i) obj).f4787a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f4787a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f4787a;
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
