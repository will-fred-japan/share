package p147s7;

import W5.e;

/* JADX INFO: compiled from: Messages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f21371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f21372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f21373c;

    public s(Double d9, Double d10, long j) {
        this.f21371a = d9;
        this.f21372b = d10;
        this.f21373c = j;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(s.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        s sVar = (s) obj;
        return v.a(this.f21371a, sVar.f21371a) && v.a(this.f21372b, sVar.f21372b) && v.a(Long.valueOf(this.f21373c), Long.valueOf(sVar.f21373c));
    }

    public final int hashCode() {
        return v.b(Long.valueOf(this.f21373c)) + ((v.b(this.f21372b) + ((v.b(this.f21371a) + (s.class.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ImageSelectionOptions(maxWidth=");
        sb.append(this.f21371a);
        sb.append(", maxHeight=");
        sb.append(this.f21372b);
        sb.append(", quality=");
        return e.m(sb, this.f21373c, ")");
    }
}
