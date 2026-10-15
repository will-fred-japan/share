package O6;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: DatabaseWorker.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f3520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f3521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public A6.a f3522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f3523f;

    public i(String str, int i9) {
        this.f3518a = str;
        this.f3519b = i9;
    }

    public final synchronized void a(A6.a aVar) {
        HandlerThread handlerThread = new HandlerThread(this.f3518a, this.f3519b);
        this.f3520c = handlerThread;
        handlerThread.start();
        this.f3521d = new Handler(this.f3520c.getLooper());
        this.f3522e = aVar;
    }
}
