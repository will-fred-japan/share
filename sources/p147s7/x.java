package p147s7;

/* JADX INFO: compiled from: Messages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f21378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f21379b;

    public x(y yVar, w wVar) {
        this.f21378a = yVar;
        this.f21379b = wVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(x.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        x xVar = (x) obj;
        return v.a(this.f21378a, xVar.f21378a) && v.a(this.f21379b, xVar.f21379b);
    }

    public final int hashCode() {
        return v.b(this.f21379b) + ((v.b(this.f21378a) + (x.class.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "SourceSpecification(type=" + this.f21378a + ", camera=" + this.f21379b + ")";
    }
}
