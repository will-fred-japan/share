package G0;

import java.util.List;
import y7.n;

/* JADX INFO: compiled from: WindowLayoutInfo.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2240a;

    public j(List<? extends a> list) {
        this.f2240a = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !j.class.equals(obj.getClass())) {
            return false;
        }
        return this.f2240a.equals(((j) obj).f2240a);
    }

    public final int hashCode() {
        return this.f2240a.hashCode();
    }

    public final String toString() {
        return n.M((Iterable) this.f2240a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", null, 56);
    }
}
