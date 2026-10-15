package O7;

import java.util.Iterator;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes2.dex */
public class f implements Iterable<Integer>, L7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3587c;

    public f(int i9, int i10, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i11 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f3585a = i9;
        this.f3586b = p199z2.b.B(i9, i10, i11);
        this.f3587c = i11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        if (isEmpty() && ((f) obj).isEmpty()) {
            return true;
        }
        f fVar = (f) obj;
        return this.f3585a == fVar.f3585a && this.f3586b == fVar.f3586b && this.f3587c == fVar.f3587c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3585a * 31) + this.f3586b) * 31) + this.f3587c;
    }

    public boolean isEmpty() {
        int i9 = this.f3587c;
        int i10 = this.f3586b;
        int i11 = this.f3585a;
        if (i9 > 0) {
            return i11 > i10;
        }
        return i11 < i10;
    }

    @Override // java.lang.Iterable
    public final Iterator<Integer> iterator() {
        return new g(this.f3585a, this.f3586b, this.f3587c);
    }

    public String toString() {
        StringBuilder sb;
        int i9 = this.f3586b;
        int i10 = this.f3585a;
        int i11 = this.f3587c;
        if (i11 > 0) {
            sb = new StringBuilder();
            sb.append(i10);
            sb.append("..");
            sb.append(i9);
            sb.append(" step ");
            sb.append(i11);
        } else {
            sb = new StringBuilder();
            sb.append(i10);
            sb.append(" downTo ");
            sb.append(i9);
            sb.append(" step ");
            sb.append(-i11);
        }
        return sb.toString();
    }
}
