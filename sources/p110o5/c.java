package p110o5;

import A.f;
import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: MotionTiming.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20710a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimeInterpolator f20712c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20713d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20714e = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f20711b = 150;

    public c(long j) {
        this.f20710a = j;
    }

    public final TimeInterpolator a() {
        TimeInterpolator timeInterpolator = this.f20712c;
        return timeInterpolator != null ? timeInterpolator : a.f20704b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f20710a == cVar.f20710a && this.f20711b == cVar.f20711b && this.f20713d == cVar.f20713d && this.f20714e == cVar.f20714e) {
            return a().getClass().equals(cVar.a().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f20710a;
        long j8 = this.f20711b;
        return ((((a().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) ((j8 >>> 32) ^ j8))) * 31)) * 31) + this.f20713d) * 31) + this.f20714e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(c.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.f20710a);
        sb.append(" duration: ");
        sb.append(this.f20711b);
        sb.append(" interpolator: ");
        sb.append(a().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.f20713d);
        sb.append(" repeatMode: ");
        return f.i(sb, this.f20714e, "}\n");
    }
}
