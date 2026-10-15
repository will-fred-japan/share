package y7;

import java.util.Collection;

/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes2.dex */
public class i extends h {
    public static int E(Iterable iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
