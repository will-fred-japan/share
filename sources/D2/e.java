package D2;

/* JADX INFO: compiled from: LogSender.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends p025d3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f1886d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar) {
        super(0L, 30000L);
        this.f1886d = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        f fVar = this.f1886d;
        if (jCurrentTimeMillis - fVar.f1890d >= fVar.f1889c) {
            try {
                f.e(fVar);
            } catch (Throwable th) {
                p010b3.b.b(p199z2.a.f22469a, "send", th);
            }
            fVar.f1890d = System.currentTimeMillis();
        }
    }
}
