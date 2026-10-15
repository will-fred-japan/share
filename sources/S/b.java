package S;

import java.util.Objects;

/* JADX INFO: compiled from: Pair.java */
/* JADX INFO: loaded from: classes.dex */
public final class b<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f4087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f4088b;

    public b(F f6, S s8) {
        this.f4087a = f6;
        this.f4088b = s8;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(bVar.f4087a, this.f4087a) && Objects.equals(bVar.f4088b, this.f4088b);
    }

    public final int hashCode() {
        F f6 = this.f4087a;
        int iHashCode = f6 == null ? 0 : f6.hashCode();
        S s8 = this.f4088b;
        return (s8 != null ? s8.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "Pair{" + this.f4087a + " " + this.f4088b + "}";
    }
}
