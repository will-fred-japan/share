package H2;

/* JADX INFO: compiled from: CpuCollectManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends p025d3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f2376d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar) {
        super(300000L, 300000L);
        this.f2376d = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2376d.a();
    }
}
