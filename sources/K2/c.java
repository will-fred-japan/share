package K2;

/* JADX INFO: compiled from: NormalCoolDownState.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends p025d3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ J2.c f2810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d f2811e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, long j, J2.c cVar) {
        super(j, 0L);
        this.f2811e = dVar;
        this.f2810d = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2811e.c("cool down task run, is back?: " + this.f2811e.f2813c);
        J2.c cVar = this.f2810d;
        synchronized (cVar) {
            cVar.a(cVar.f2677l);
        }
    }
}
