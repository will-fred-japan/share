package D0;

import android.graphics.Rect;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Bounds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1814d;

    public b(Rect rect) {
        int i9 = rect.left;
        int i10 = rect.top;
        int i11 = rect.right;
        int i12 = rect.bottom;
        this.f1811a = i9;
        this.f1812b = i10;
        this.f1813c = i11;
        this.f1814d = i12;
        if (i9 > i11) {
            throw new IllegalArgumentException(W5.e.h(i9, i11, "Left must be less than or equal to right, left: ", ", right: ").toString());
        }
        if (i10 > i12) {
            throw new IllegalArgumentException(W5.e.h(i10, i12, "top must be less than or equal to bottom, top: ", ", bottom: ").toString());
        }
    }

    public final Rect a() {
        return new Rect(this.f1811a, this.f1812b, this.f1813c, this.f1814d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!b.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        k.c(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        b bVar = (b) obj;
        return this.f1811a == bVar.f1811a && this.f1812b == bVar.f1812b && this.f1813c == bVar.f1813c && this.f1814d == bVar.f1814d;
    }

    public final int hashCode() {
        return (((((this.f1811a * 31) + this.f1812b) * 31) + this.f1813c) * 31) + this.f1814d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(b.class.getSimpleName());
        sb.append(" { [");
        sb.append(this.f1811a);
        sb.append(',');
        sb.append(this.f1812b);
        sb.append(',');
        sb.append(this.f1813c);
        sb.append(',');
        return A.f.i(sb, this.f1814d, "] }");
    }
}
