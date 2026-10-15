package p162u7;

/* JADX INFO: compiled from: Messages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21751a;

    public a(boolean z8) {
        this.f21751a = z8;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(a.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return d.a(Boolean.valueOf(this.f21751a), Boolean.valueOf(((a) obj).f21751a));
    }

    public final int hashCode() {
        return d.b(Boolean.valueOf(this.f21751a)) + (a.class.hashCode() * 31);
    }

    public final String toString() {
        return "BrowserOptions(showTitle=" + this.f21751a + ")";
    }
}
