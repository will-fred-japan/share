package cn.jpush.android.ad;

import cn.jiguang.api.JCoreManager;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f11136a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f11137e;

    public h() {
        this.f11136a = new Thread.UncaughtExceptionHandler() { // from class: cn.jpush.android.ad.h.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 93, null, null, thread, th);
                StringBuilder sb = new StringBuilder("name: ");
                sb.append(h.this.f11137e);
                sb.append(", thread id:");
                sb.append(thread != null ? thread.getName() : "");
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                Logger.e("JPushRunnable", sb.toString());
            }
        };
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f11136a);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }

    public h(String str) {
        this.f11137e = str;
        this.f11136a = new Thread.UncaughtExceptionHandler() { // from class: cn.jpush.android.ad.h.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 93, null, null, thread, th);
                StringBuilder sb = new StringBuilder("name: ");
                sb.append(h.this.f11137e);
                sb.append(", thread id: ");
                sb.append(thread != null ? thread.getName() : "");
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                Logger.e("JPushRunnable", sb.toString());
            }
        };
    }
}
