package B7;

import K7.p;
import S7.l0;
import S7.r;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1756a;

    public /* synthetic */ c(int i9) {
        this.f1756a = i9;
    }

    @Override // K7.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1756a) {
            case 0:
                String acc = (String) obj;
                h.a element = (h.a) obj2;
                k.e(acc, "acc");
                k.e(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            case 1:
                return Boolean.valueOf(((Boolean) obj).booleanValue() || (((h.a) obj2) instanceof r));
            case 2:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            default:
                l0 l0Var = (l0) obj;
                h.a aVar = (h.a) obj2;
                if (l0Var != null) {
                    return l0Var;
                }
                if (aVar instanceof l0) {
                    return (l0) aVar;
                }
                return null;
        }
    }
}
