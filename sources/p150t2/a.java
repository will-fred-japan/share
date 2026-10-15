package p150t2;

import N1.g;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: compiled from: Monitor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f21400a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedTransferQueue f21401b = new LinkedTransferQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f21402c = false;

    public static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        f21401b.offer(bVar);
        if (f21402c) {
            return;
        }
        synchronized (a.class) {
            if (f21402c) {
                return;
            }
            f21402c = true;
            new Thread(new g(4), "APM-Monitor").start();
        }
    }
}
