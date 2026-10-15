package S7;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class M implements U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4235a;

    public M(boolean z8) {
        this.f4235a = z8;
    }

    @Override // S7.U
    public final boolean a() {
        return this.f4235a;
    }

    @Override // S7.U
    public final e0 b() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.f4235a ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
