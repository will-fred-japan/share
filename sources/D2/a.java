package D2;

import S4.C0376g;
import com.google.android.gms.location.ActivityTransition;
import java.util.Comparator;

/* JADX INFO: compiled from: DiskFileHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1852a;

    /* JADX WARN: Code duplicated, block: B:12:0x0022 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:13:0x0024 A[ORIG_RETURN, RETURN] */
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f1852a) {
            case 0:
                return String.CASE_INSENSITIVE_ORDER.compare((String) obj, (String) obj2);
            default:
                ActivityTransition activityTransition = (ActivityTransition) obj;
                ActivityTransition activityTransition2 = (ActivityTransition) obj2;
                C0376g.e(activityTransition);
                C0376g.e(activityTransition2);
                int i9 = activityTransition.f12679a;
                int i10 = activityTransition2.f12679a;
                if (i9 != i10) {
                    if (i9 >= i10) {
                        return 1;
                    }
                    return -1;
                }
                int i11 = activityTransition.f12680b;
                int i12 = activityTransition2.f12680b;
                if (i11 == i12) {
                    return 0;
                }
                if (i11 >= i12) {
                    return 1;
                }
                return -1;
        }
    }
}
