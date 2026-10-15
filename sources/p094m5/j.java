package p094m5;

import D1.d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f20361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20362b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f20363c;

    public j(m mVar, c cVar) {
        this.f20361a = mVar;
        this.f20363c = cVar;
    }

    @Override // p094m5.l
    public final void a(n nVar) {
        if (nVar.b() || nVar.f20371d) {
            return;
        }
        synchronized (this.f20362b) {
        }
        this.f20361a.execute(new d(5, this, nVar));
    }
}
