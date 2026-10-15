package G6;

import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2338b;

    public /* synthetic */ f(int i9, Object obj) {
        this.f2337a = i9;
        this.f2338b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f2337a) {
            case 0:
                Integer num = (Integer) ((p188x7.e) obj2).f22353a;
                ((e) this.f2338b).getClass();
                return p199z2.b.t(Boolean.valueOf(e.j(num)), Boolean.valueOf(e.j((Integer) ((p188x7.e) obj).f22353a)));
            default:
                int iCompare = ((h) this.f2338b).compare(obj, obj2);
                return iCompare != 0 ? iCompare : p199z2.b.t(Integer.valueOf(((e.a) obj).f2331a.getId()), Integer.valueOf(((e.a) obj2).f2331a.getId()));
        }
    }
}
