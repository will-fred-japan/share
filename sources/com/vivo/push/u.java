package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: PushClientThread.java */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f16807a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HandlerThread f16808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Handler f16809c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f16808b = handlerThread;
        handlerThread.start();
        f16809c = new v(handlerThread.getLooper());
    }

    public static void a(t tVar, long j) {
        if (tVar == null) {
            com.vivo.push.util.w.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int iA = tVar.a();
        if (j > 0) {
            f16809c.removeMessages(iA);
        }
        Message message = new Message();
        message.what = iA;
        message.obj = tVar;
        f16809c.sendMessageDelayed(message, j);
    }

    public static void b(Runnable runnable) {
        Handler handler = f16809c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void a(s sVar) {
        Handler handler = f16809c;
        handler.removeCallbacks(sVar);
        handler.postDelayed(sVar, 15000L);
    }

    public static void a(Runnable runnable) {
        f16807a.post(runnable);
    }
}
