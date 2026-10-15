package H1;

/* JADX INFO: compiled from: AbsBatteryTimeStats.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f2344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f2345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f2346c;

    public a(b bVar, boolean z8, long j) {
        this.f2346c = bVar;
        this.f2344a = z8;
        this.f2345b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        G1.a.c.f2257a.c(new R1.b(this.f2344a, this.f2346c.f2353a, jCurrentTimeMillis, this.f2345b));
    }
}
