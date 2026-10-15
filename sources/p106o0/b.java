package p106o0;

/* JADX INFO: compiled from: NavigationEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f20626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f20627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f20628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f20629e;

    public b() {
        this(2, 0.0f, 0.0f, 0.0f, 0L);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            return this.f20627c == bVar.f20627c && this.f20628d == bVar.f20628d && this.f20626b == bVar.f20626b && this.f20625a == bVar.f20625a && this.f20629e == bVar.f20629e;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f20629e) + ((Integer.hashCode(this.f20625a) + ((Float.hashCode(this.f20626b) + ((Float.hashCode(this.f20628d) + (Float.hashCode(this.f20627c) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "NavigationEvent(touchX=" + this.f20627c + ", touchY=" + this.f20628d + ", progress=" + this.f20626b + ", swipeEdge=" + this.f20625a + ", frameTimeMillis=" + this.f20629e + ')';
    }

    public b(int i9, float f6, float f9, float f10, long j) {
        this.f20625a = i9;
        this.f20626b = f6;
        this.f20627c = f9;
        this.f20628d = f10;
        this.f20629e = j;
    }
}
