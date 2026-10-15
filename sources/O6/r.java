package O6;

/* JADX INFO: compiled from: SqflitePlugin.java */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f3558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p096m7.k f3559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f3560c;

    public r(t tVar, g gVar, p096m7.k kVar) {
        this.f3560c = tVar;
        this.f3558a = gVar;
        this.f3559b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (t.f3568f) {
            t.a(this.f3560c, this.f3558a);
        }
        this.f3559b.success(null);
    }
}
