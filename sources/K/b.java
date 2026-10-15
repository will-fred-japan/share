package K;

import android.graphics.Insets;

/* JADX INFO: compiled from: Insets.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f2743e = new b(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2747d;

    /* JADX INFO: compiled from: Insets.java */
    public static class a {
        public static Insets a(int i9, int i10, int i11, int i12) {
            return Insets.of(i9, i10, i11, i12);
        }
    }

    public b(int i9, int i10, int i11, int i12) {
        this.f2744a = i9;
        this.f2745b = i10;
        this.f2746c = i11;
        this.f2747d = i12;
    }

    public static b a(b bVar, b bVar2) {
        return c(Math.max(bVar.f2744a, bVar2.f2744a), Math.max(bVar.f2745b, bVar2.f2745b), Math.max(bVar.f2746c, bVar2.f2746c), Math.max(bVar.f2747d, bVar2.f2747d));
    }

    public static b b(b bVar, b bVar2) {
        return c(Math.min(bVar.f2744a, bVar2.f2744a), Math.min(bVar.f2745b, bVar2.f2745b), Math.min(bVar.f2746c, bVar2.f2746c), Math.min(bVar.f2747d, bVar2.f2747d));
    }

    public static b c(int i9, int i10, int i11, int i12) {
        return (i9 == 0 && i10 == 0 && i11 == 0 && i12 == 0) ? f2743e : new b(i9, i10, i11, i12);
    }

    public static b d(Insets insets) {
        return c(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets e() {
        return a.a(this.f2744a, this.f2745b, this.f2746c, this.f2747d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2747d == bVar.f2747d && this.f2744a == bVar.f2744a && this.f2746c == bVar.f2746c && this.f2745b == bVar.f2745b;
    }

    public final int hashCode() {
        return (((((this.f2744a * 31) + this.f2745b) * 31) + this.f2746c) * 31) + this.f2747d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Insets{left=");
        sb.append(this.f2744a);
        sb.append(", top=");
        sb.append(this.f2745b);
        sb.append(", right=");
        sb.append(this.f2746c);
        sb.append(", bottom=");
        return H2.a.a(sb, this.f2747d, '}');
    }
}
