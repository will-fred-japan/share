package cn.jpush.android.thirdpush.huawei.a;

import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.Logger;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f11591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f11592b = new a();

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            JThirdPlatFormInterface.onEvent(thread, th);
            StringBuilder sb = new StringBuilder("name: ");
            sb.append(b.this.f11591a);
            sb.append(", thread id:");
            sb.append(thread != null ? thread.getName() : "");
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
            sb.append("\n e:");
            sb.append(th);
            Logger.e("JHWRunnable", sb.toString());
        }
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f11592b);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}
