package pl.droidsonroids.gif;

/* JADX INFO: compiled from: SafeRunnable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f20873a;

    public m(d dVar) {
        this.f20873a = dVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f20873a.f20849g.l()) {
                return;
            }
            a();
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
