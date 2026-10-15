package G6;

import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f2340a;

    public h(e eVar) {
        this.f2340a = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t6) {
        Integer num = ((e.a) t6).f2332b;
        this.f2340a.getClass();
        return p199z2.b.t(Boolean.valueOf(e.j(num)), Boolean.valueOf(e.j(((e.a) t).f2332b)));
    }
}
