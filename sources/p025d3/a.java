package p025d3;

/* JADX INFO: compiled from: AsyncTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18497c;

    public a(long j) {
        this(j, 0L);
    }

    public a(long j, long j8) {
        this.f18495a = j;
        this.f18497c = j8;
        if (j8 > 0) {
            this.f18496b = true;
        }
    }
}
