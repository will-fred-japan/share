package p099n1;

/* JADX INFO: compiled from: Pair.java */
/* JADX INFO: loaded from: classes.dex */
public final class e<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f20558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Number f20559b;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Object obj, Number number) {
        this.f20558a = obj;
        this.f20559b = number;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        F f6 = eVar.f20558a;
        F f9 = this.f20558a;
        if (f6 != f9 && (f6 == null || !f6.equals(f9))) {
            return false;
        }
        Number number = eVar.f20559b;
        Number number2 = this.f20559b;
        if (number != number2) {
            return number != null && number.equals(number2);
        }
        return true;
    }

    public final int hashCode() {
        F f6 = this.f20558a;
        int iHashCode = f6 == null ? 0 : f6.hashCode();
        Number number = this.f20559b;
        return iHashCode ^ (number != null ? number.hashCode() : 0);
    }

    public final String toString() {
        return "Pair{" + String.valueOf(this.f20558a) + " " + this.f20559b + "}";
    }
}
