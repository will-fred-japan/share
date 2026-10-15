package p188x7;

import java.io.Serializable;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e<A, B> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f22353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f22354b;

    public e(A a3, B b9) {
        this.f22353a = a3;
        this.f22354b = b9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return k.a(this.f22353a, eVar.f22353a) && k.a(this.f22354b, eVar.f22354b);
    }

    public final int hashCode() {
        A a3 = this.f22353a;
        int iHashCode = (a3 == null ? 0 : a3.hashCode()) * 31;
        B b9 = this.f22354b;
        return iHashCode + (b9 != null ? b9.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f22353a + ", " + this.f22354b + ')';
    }
}
