package G6;

import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f2339a;

    public g(f fVar) {
        this.f2339a = fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t6) {
        int iCompare = this.f2339a.compare(t, t6);
        return iCompare != 0 ? iCompare : p199z2.b.t((Comparable) ((p188x7.e) t).f22353a, (Comparable) ((p188x7.e) t6).f22353a);
    }
}
