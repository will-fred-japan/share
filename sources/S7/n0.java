package S7;

/* JADX INFO: compiled from: Unconfined.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n0 extends AbstractC0410w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f4291c = 0;

    static {
        new n0();
    }

    @Override // S7.AbstractC0410w
    public final void g(B7.h hVar, Runnable runnable) {
        if (((r0) hVar.i(r0.f4301b)) == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
    }

    @Override // S7.AbstractC0410w
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
