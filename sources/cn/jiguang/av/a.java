package cn.jiguang.av;

import cn.jiguang.x.f;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a implements RejectedExecutionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ThreadPoolExecutor f9461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f9462d;

    public a(String str, int i9) {
        this.f9460b = str;
        if (i9 <= 0) {
            this.f9459a = 3;
        }
        this.f9459a = i9;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        f.c("JRejectedExecutionHandler", "poolName: " + this.f9460b + ", Exceeded ThreadPoolExecutor pool size");
        if (this.f9461c == null) {
            synchronized (this) {
                try {
                    if (this.f9461c == null) {
                        this.f9462d = new LinkedBlockingQueue<>();
                        int i9 = this.f9459a;
                        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(i9, i9, 3L, TimeUnit.SECONDS, this.f9462d, new c(this.f9460b + "_rjt"));
                        this.f9461c = threadPoolExecutor2;
                        threadPoolExecutor2.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.f9461c.execute(runnable);
    }
}
