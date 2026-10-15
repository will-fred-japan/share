package J2;

import java.util.Objects;

/* JADX INFO: compiled from: ThreadExceptionItem.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f2681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f2684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2685h;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f2678a == dVar.f2678a && this.f2679b.equals(dVar.f2679b);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f2678a), this.f2679b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ThreadExceptionItem{threadId=");
        sb.append(this.f2678a);
        sb.append(", threadName='");
        sb.append(this.f2679b);
        sb.append("', threadCpuTime=");
        sb.append(this.f2680c);
        sb.append(", processCpuTime=");
        sb.append(this.f2684g);
        sb.append(", cpuUsage=");
        sb.append(this.f2681d);
        sb.append(", weight=");
        sb.append(this.f2682e);
        sb.append(", nice=");
        return H2.a.a(sb, this.f2685h, '}');
    }
}
