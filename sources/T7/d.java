package T7;

import S7.AbstractC0410w;
import S7.C;
import S7.F;
import S7.J;
import X7.o;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends AbstractC0410w implements F {
    @Override // S7.AbstractC0410w
    public String toString() {
        d dVarW;
        String str;
        Z7.c cVar = J.f4233a;
        d dVar = o.f5165a;
        if (this == dVar) {
            str = "Dispatchers.Main";
        } else {
            try {
                dVarW = dVar.w();
            } catch (UnsupportedOperationException unused) {
                dVarW = null;
            }
            str = this == dVarW ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        return getClass().getSimpleName() + '@' + C.a(this);
    }

    public abstract d w();
}
