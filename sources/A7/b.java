package A7;

import java.util.Comparator;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Comparator<Comparable<? super Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1530a = new b();

    @Override // java.util.Comparator
    public final int compare(Comparable<? super Object> comparable, Comparable<? super Object> comparable2) {
        Comparable<? super Object> a3 = comparable;
        Comparable<? super Object> b9 = comparable2;
        k.e(a3, "a");
        k.e(b9, "b");
        return b9.compareTo(a3);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return a.f1529a;
    }
}
