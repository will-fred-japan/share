package p094m5;

import Q.a;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f20358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20359b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f20360c;

    public i(Executor executor, b bVar) {
        this.f20358a = executor;
        this.f20360c = bVar;
    }

    @Override // p094m5.l
    public final void a(n nVar) {
        synchronized (this.f20359b) {
        }
        this.f20358a.execute(new a(this, nVar, 4, false));
    }
}
