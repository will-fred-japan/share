package p147s7;

/* JADX INFO: compiled from: Messages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f21317c;

    public f(boolean z8, boolean z9, Long l8) {
        this.f21315a = z8;
        this.f21316b = z9;
        this.f21317c = l8;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(f.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        f fVar = (f) obj;
        return v.a(Boolean.valueOf(this.f21315a), Boolean.valueOf(fVar.f21315a)) && v.a(Boolean.valueOf(this.f21316b), Boolean.valueOf(fVar.f21316b)) && v.a(this.f21317c, fVar.f21317c);
    }

    public final int hashCode() {
        return v.b(this.f21317c) + ((v.b(Boolean.valueOf(this.f21316b)) + ((v.b(Boolean.valueOf(this.f21315a)) + (f.class.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "GeneralOptions(allowMultiple=" + this.f21315a + ", usePhotoPicker=" + this.f21316b + ", limit=" + this.f21317c + ")";
    }
}
