package T;

import android.graphics.Point;

/* JADX INFO: renamed from: T.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: RoundedCornerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0435w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Point f4457c;

    public C0435w(int i9, int i10, Point point) {
        int i11 = point.x;
        int i12 = point.y;
        this.f4455a = i9;
        this.f4456b = i10;
        this.f4457c = new Point(i11, i12);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0435w) {
            C0435w c0435w = (C0435w) obj;
            if (this.f4455a == c0435w.f4455a && this.f4456b == c0435w.f4456b && this.f4457c.equals(c0435w.f4457c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4457c.hashCode() + (((this.f4455a * 31) + this.f4456b) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("RoundedCornerCompat{position=");
        int i9 = this.f4455a;
        if (i9 == 0) {
            str = "TopLeft";
        } else if (i9 == 1) {
            str = "TopRight";
        } else if (i9 != 2) {
            str = i9 != 3 ? "Invalid" : "BottomLeft";
        } else {
            str = "BottomRight";
        }
        sb.append(str);
        sb.append(", radius=");
        sb.append(this.f4456b);
        sb.append(", center=");
        sb.append(this.f4457c);
        sb.append('}');
        return sb.toString();
    }
}
