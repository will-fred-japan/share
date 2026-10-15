package G0;

import T.Q;

/* JADX INFO: compiled from: WindowMetrics.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D0.b f2241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q f2242b;

    public k(D0.b bVar, Q _windowInsetsCompat) {
        kotlin.jvm.internal.k.e(_windowInsetsCompat, "_windowInsetsCompat");
        this.f2241a = bVar;
        this.f2242b = _windowInsetsCompat;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        k kVar = (k) obj;
        return kotlin.jvm.internal.k.a(this.f2241a, kVar.f2241a) && kotlin.jvm.internal.k.a(this.f2242b, kVar.f2242b);
    }

    public final int hashCode() {
        return this.f2242b.hashCode() + (this.f2241a.hashCode() * 31);
    }

    public final String toString() {
        return "WindowMetrics( bounds=" + this.f2241a + ", windowInsetsCompat=" + this.f2242b + ')';
    }
}
