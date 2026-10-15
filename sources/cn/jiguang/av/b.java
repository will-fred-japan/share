package cn.jiguang.av;

import cn.jiguang.ak.h;
import cn.jiguang.x.f;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f9463a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f9464h;

    public b() {
        this.f9463a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.av.b.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                h.a().a(thread, th);
                StringBuilder sb = new StringBuilder("name: ");
                sb.append(b.this.f9464h);
                sb.append(", thread id:");
                sb.append(thread != null ? thread.getName() : "");
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                f.l("JCoreRunnable", sb.toString());
            }
        };
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f9463a);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }

    public b(String str) {
        this.f9464h = str;
        this.f9463a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.av.b.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                h.a().a(thread, th);
                StringBuilder sb = new StringBuilder("name: ");
                sb.append(b.this.f9464h);
                sb.append(", thread id: ");
                sb.append(thread != null ? thread.getName() : "");
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                f.l("JCoreRunnable", sb.toString());
            }
        };
    }
}
