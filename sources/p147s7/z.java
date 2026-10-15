package p147s7;

/* JADX INFO: compiled from: Messages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f21383a;

    public z() {
        this(null);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(z.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return v.a(this.f21383a, ((z) obj).f21383a);
    }

    public final int hashCode() {
        return v.b(this.f21383a) + (z.class.hashCode() * 31);
    }

    public final String toString() {
        return "VideoSelectionOptions(maxDurationSeconds=" + this.f21383a + ")";
    }

    public z(Long l8) {
        this.f21383a = l8;
    }
}
