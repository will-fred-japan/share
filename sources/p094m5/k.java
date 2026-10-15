package p094m5;

import E3.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f20364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20365b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f20366c;

    public k(m mVar, d dVar) {
        this.f20364a = mVar;
        this.f20366c = dVar;
    }

    @Override // p094m5.l
    public final void a(n nVar) {
        if (nVar.b()) {
            synchronized (this.f20365b) {
            }
            this.f20364a.execute(new b(2, this, nVar));
        }
    }
}
