package p106o0;

import androidx.datastore.preferences.protobuf.C0524s;
import java.util.List;
import kotlin.jvm.internal.k;
import y7.h;
import y7.p;

/* JADX INFO: compiled from: NavigationEventHistory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20640b;

    public e(int i9, List list) {
        this.f20639a = list;
        this.f20640b = i9;
        if (list.isEmpty() && i9 == -1) {
            return;
        }
        List list2 = list;
        if (!list2.isEmpty()) {
            int size = list2.size();
            if (i9 >= 0 && i9 < size) {
                return;
            }
        }
        StringBuilder sbA = C0524s.a(i9, "Invalid 'NavigationEventHistory' state:  'currentIndex' must be within the bounds of 'mergedHistory' (or -1 if empty). Received: currentIndex = '", "', bounds = '");
        sbA.append(h.A(list2));
        sbA.append("'.");
        throw new IllegalArgumentException(sbA.toString().toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f20640b == eVar.f20640b && k.a(this.f20639a, eVar.f20639a);
    }

    public final int hashCode() {
        return this.f20639a.hashCode() + (this.f20640b * 31);
    }

    public final String toString() {
        return "NavigationEventHistory(currentIndex=" + this.f20640b + ", mergedHistory=" + this.f20639a + ')';
    }

    public e() {
        this(-1, p.f22408a);
    }
}
