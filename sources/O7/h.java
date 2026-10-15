package O7;

/* JADX INFO: compiled from: PrimitiveRanges.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f3592d = new h(1, 0, 1);

    @Override // O7.f
    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        if (isEmpty() && ((h) obj).isEmpty()) {
            return true;
        }
        h hVar = (h) obj;
        if (this.f3585a == hVar.f3585a) {
            return this.f3586b == hVar.f3586b;
        }
        return false;
    }

    @Override // O7.f
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f3585a * 31) + this.f3586b;
    }

    @Override // O7.f
    public final boolean isEmpty() {
        return this.f3585a > this.f3586b;
    }

    @Override // O7.f
    public final String toString() {
        return this.f3585a + ".." + this.f3586b;
    }
}
