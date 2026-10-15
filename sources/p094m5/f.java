package p094m5;

import S4.C0376g;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
public final class f<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f20355a = new n();

    public final void a(TResult tresult) {
        this.f20355a.d(tresult);
    }

    public final void b(Exception exc) {
        n nVar = this.f20355a;
        nVar.getClass();
        C0376g.f(exc, "Exception must not be null");
        synchronized (nVar.f20368a) {
            try {
                if (nVar.f20370c) {
                    return;
                }
                nVar.f20370c = true;
                nVar.f20373f = exc;
                nVar.f20369b.b(nVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
