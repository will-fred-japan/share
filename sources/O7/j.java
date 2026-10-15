package O7;

import java.util.Iterator;

/* JADX INFO: compiled from: PrimitiveRanges.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements Iterable<Long>, L7.a {
    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        if (1 > 0) {
            ((j) obj).getClass();
            if (1 > 0) {
                return true;
            }
        }
        ((j) obj).getClass();
        return 0 == 0;
    }

    public final int hashCode() {
        if (1 > 0) {
            return -1;
        }
        return (int) (((long) 31) + (0 ^ (0 >>> 32)));
    }

    @Override // java.lang.Iterable
    public final Iterator<Long> iterator() {
        return new i(0L, 0L);
    }

    public final String toString() {
        return "1..0";
    }
}
