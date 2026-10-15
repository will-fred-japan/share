package Z7;

import S7.C;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f5656c;

    public h(Runnable runnable, long j, boolean z8) {
        super(j, z8);
        this.f5656c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5656c.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f5656c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(C.a(runnable));
        sb.append(", ");
        sb.append(this.f5654a);
        sb.append(", ");
        sb.append(this.f5655b ? "Blocking" : "Non-blocking");
        sb.append(']');
        return sb.toString();
    }
}
