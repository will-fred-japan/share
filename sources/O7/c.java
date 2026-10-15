package O7;

/* JADX INFO: compiled from: PrimitiveRanges.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f3584c = 0;

    static {
        new c();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        char c5 = this.f3578a;
        if (kotlin.jvm.internal.k.f(1, c5) <= 0 || kotlin.jvm.internal.k.f(1, ((c) obj).f3578a) <= 0) {
            c cVar = (c) obj;
            cVar.getClass();
            if (c5 != cVar.f3578a) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        char c5 = this.f3578a;
        if (kotlin.jvm.internal.k.f(1, c5) > 0) {
            return -1;
        }
        return 31 + c5;
    }

    public final String toString() {
        return "\u0001.." + this.f3578a;
    }
}
