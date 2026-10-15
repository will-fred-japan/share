package O6;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: DatabaseWorkerPool.java */
/* JADX INFO: loaded from: classes.dex */
public final class l implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f3533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f3534c;

    public l(int i9, int i10) {
        switch (i10) {
            case 1:
                this.f3533b = new ConcurrentLinkedQueue();
                this.f3532a = i9;
                break;
            default:
                this.f3532a = i9;
                break;
        }
    }

    @Override // O6.j
    public void a() {
        HandlerThread handlerThread = (HandlerThread) this.f3533b;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f3533b = null;
            this.f3534c = null;
        }
    }

    @Override // O6.j
    public void b(h hVar) {
        ((Handler) this.f3534c).post(hVar.f3517b);
    }

    public void d(Object obj) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f3533b;
        concurrentLinkedQueue.add(obj);
        if (concurrentLinkedQueue.size() > this.f3532a) {
            Object objPoll = concurrentLinkedQueue.poll();
            if (((p174w2.a.C0278a) this.f3534c) != null) {
                p150t2.b bVar = (p150t2.b) objPoll;
                if (p174w2.a.f22106c) {
                    p010b3.b.c("APM-CommonEvent", "evicted Monitorable " + bVar);
                }
            }
        }
    }

    @Override // O6.j
    public void start() {
        HandlerThread handlerThread = new HandlerThread("Sqflite", this.f3532a);
        this.f3533b = handlerThread;
        handlerThread.start();
        this.f3534c = new Handler(((HandlerThread) this.f3533b).getLooper());
    }
}
