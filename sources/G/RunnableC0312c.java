package G;

/* JADX INFO: renamed from: G.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityRecreator.java */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0312c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0314e.a f2069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2070b;

    public RunnableC0312c(C0314e.a aVar, Object obj) {
        this.f2069a = aVar;
        this.f2070b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2069a.f2080a = this.f2070b;
    }
}
