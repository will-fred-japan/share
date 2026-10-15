package p106o0;

import p030e.o;

/* JADX INFO: compiled from: NavigationEventInput.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f20641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20642b;

    public final void a() {
        c cVar = this.f20641a;
        if (cVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (!this.f20642b) {
            cVar.c(this, null);
        }
        g gVar = cVar.f20631b;
        gVar.getClass();
        if (equals(gVar.f20650h) && -1 == gVar.f20649g) {
            d<?> dVarC = gVar.f20648f;
            if (dVarC == null) {
                dVarC = gVar.c(-1);
            }
            gVar.f20648f = null;
            gVar.f20649g = 0;
            gVar.f20650h = null;
            if (dVarC == null) {
                Runnable runnable = ((o) cVar.f20630a.f3994b).f18582a;
                if (runnable != null) {
                    runnable.run();
                }
            } else {
                h.a aVar = h.a.f20656a;
                dVarC.b();
            }
            gVar.f20643a.setValue(h.a.f20656a);
        }
        this.f20642b = false;
    }

    public void b(boolean z8) {
    }
}
