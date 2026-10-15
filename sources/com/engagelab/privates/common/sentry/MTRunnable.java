package com.engagelab.privates.common.sentry;

import android.os.Looper;
import com.engagelab.privates.common.log.MTCommonLog;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class MTRunnable implements Runnable {
    private static final String TAG = "MTRunnable";
    public String mName;
    private Thread.UncaughtExceptionHandler threadUncaughtExceptionHandler;

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            SentryCrashHandler.getInstance().handleException(thread, th);
            StringBuilder sb = new StringBuilder("name: ");
            sb.append(MTRunnable.this.mName);
            sb.append(", thread id:");
            sb.append(thread != null ? thread.getName() : "");
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
            sb.append("\n e:");
            sb.append(th);
            MTCommonLog.e(MTRunnable.TAG, sb.toString());
        }
    }

    public class b implements Thread.UncaughtExceptionHandler {
        public b() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            SentryCrashHandler.getInstance().handleException(thread, th);
            StringBuilder sb = new StringBuilder("name: ");
            sb.append(MTRunnable.this.mName);
            sb.append(", thread id: ");
            sb.append(thread != null ? thread.getName() : "");
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
            sb.append("\n e:");
            sb.append(th);
            MTCommonLog.e(MTRunnable.TAG, sb.toString());
        }
    }

    public MTRunnable() {
        this.threadUncaughtExceptionHandler = new a();
    }

    public abstract void MTRun();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.threadUncaughtExceptionHandler);
        StringBuilder sb = new StringBuilder("name:");
        sb.append(this.mName);
        sb.append(",thread:");
        sb.append(Thread.currentThread().getName());
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(Thread.currentThread().getId());
        sb.append(", is main thread:");
        sb.append(Looper.getMainLooper() == Looper.myLooper());
        MTCommonLog.debugOnly(TAG, sb.toString());
        MTRun();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }

    public MTRunnable(String str) {
        this.mName = str;
        this.threadUncaughtExceptionHandler = new b();
    }
}
