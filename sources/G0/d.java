package G0;

import android.graphics.Rect;

/* JADX INFO: compiled from: HardwareFoldingFeature.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D0.b f2216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b f2218c;

    /* JADX INFO: compiled from: HardwareFoldingFeature.kt */
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f2219b = new a("FOLD");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f2220c = new a("HINGE");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2221a;

        public a(String str) {
            this.f2221a = str;
        }

        public final String toString() {
            return this.f2221a;
        }
    }

    public d(D0.b bVar, a aVar, c.b bVar2) {
        this.f2216a = bVar;
        this.f2217b = aVar;
        this.f2218c = bVar2;
        int i9 = bVar.f1813c;
        int i10 = bVar.f1811a;
        int i11 = i9 - i10;
        int i12 = bVar.f1812b;
        if (i11 == 0 && bVar.f1814d - i12 == 0) {
            throw new IllegalArgumentException("Bounds must be non zero");
        }
        if (i10 != 0 && i12 != 0) {
            throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
        }
    }

    @Override // G0.a
    public final Rect a() {
        return this.f2216a.a();
    }

    @Override // G0.c
    public final c.a b() {
        D0.b bVar = this.f2216a;
        return (bVar.f1813c - bVar.f1811a == 0 || bVar.f1814d - bVar.f1812b == 0) ? c.a.f2210b : c.a.f2211c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!d.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        d dVar = (d) obj;
        return kotlin.jvm.internal.k.a(this.f2216a, dVar.f2216a) && kotlin.jvm.internal.k.a(this.f2217b, dVar.f2217b) && kotlin.jvm.internal.k.a(this.f2218c, dVar.f2218c);
    }

    @Override // G0.c
    public final c.b getState() {
        return this.f2218c;
    }

    public final int hashCode() {
        return this.f2218c.hashCode() + ((this.f2217b.hashCode() + (this.f2216a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return d.class.getSimpleName() + " { " + this.f2216a + ", type=" + this.f2217b + ", state=" + this.f2218c + " }";
    }
}
