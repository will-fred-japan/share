package S7;

/* JADX INFO: renamed from: S7.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C0412y {
    public static final void a(B7.h hVar, Throwable th) {
        try {
            InterfaceC0411x interfaceC0411x = (InterfaceC0411x) hVar.i(InterfaceC0411x.a.f4307a);
            if (interfaceC0411x != null) {
                interfaceC0411x.y(th);
            } else {
                A1.b.f1(hVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                p188x7.j.a(runtimeException, th);
                th = runtimeException;
            }
            A1.b.f1(hVar, th);
        }
    }
}
