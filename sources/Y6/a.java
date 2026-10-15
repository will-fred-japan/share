package Y6;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: FlutterInjector.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5265a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        StringBuilder sb = new StringBuilder("flutter-worker-");
        int i9 = this.f5265a;
        this.f5265a = i9 + 1;
        sb.append(i9);
        thread.setName(sb.toString());
        return thread;
    }
}
