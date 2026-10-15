package p147s7;

/* JADX INFO: compiled from: Messages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f21374a;

    public t(s sVar) {
        this.f21374a = sVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(t.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return v.a(this.f21374a, ((t) obj).f21374a);
    }

    public final int hashCode() {
        return v.b(this.f21374a) + (t.class.hashCode() * 31);
    }

    public final String toString() {
        return "MediaSelectionOptions(imageSelectionOptions=" + this.f21374a + ")";
    }
}
