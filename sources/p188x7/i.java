package p188x7;

import java.io.Serializable;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i<A, B, C> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f22360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f22361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f22362c;

    public i(Integer num, Integer num2, Boolean bool) {
        this.f22360a = num;
        this.f22361b = num2;
        this.f22362c = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f22360a.equals(iVar.f22360a) && this.f22361b.equals(iVar.f22361b) && this.f22362c.equals(iVar.f22362c);
    }

    public final int hashCode() {
        return this.f22362c.hashCode() + ((this.f22361b.hashCode() + (this.f22360a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "(" + this.f22360a + ", " + this.f22361b + ", " + this.f22362c + ')';
    }
}
