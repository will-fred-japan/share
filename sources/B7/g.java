package B7;

import K7.p;
import S7.l0;
import X7.y;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1760a;

    public /* synthetic */ g(int i9) {
        this.f1760a = i9;
    }

    @Override // K7.p
    public final Object invoke(Object obj, Object obj2) {
        d dVar;
        switch (this.f1760a) {
            case 0:
                h acc = (h) obj;
                h.a element = (h.a) obj2;
                k.e(acc, "acc");
                k.e(element, "element");
                h hVarD = acc.d(element.getKey());
                i iVar = i.f1761a;
                if (hVarD == iVar) {
                    return element;
                }
                f.a aVar = f.a.f1759a;
                f fVar = (f) hVarD.i(aVar);
                if (fVar == null) {
                    dVar = new d(hVarD, element);
                } else {
                    h hVarD2 = hVarD.d(aVar);
                    if (hVarD2 == iVar) {
                        return new d(element, fVar);
                    }
                    dVar = new d(new d(hVarD2, element), fVar);
                }
                return dVar;
            default:
                y yVar = (y) obj;
                h.a aVar2 = (h.a) obj2;
                if (aVar2 instanceof l0) {
                    l0<Object> l0Var = (l0) aVar2;
                    String strV = l0Var.v(yVar.f5178a);
                    int i9 = yVar.f5181d;
                    yVar.f5179b[i9] = strV;
                    yVar.f5181d = i9 + 1;
                    yVar.f5180c[i9] = l0Var;
                }
                return yVar;
        }
    }
}
