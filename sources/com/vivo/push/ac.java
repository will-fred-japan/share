package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: Worker.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f16482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Handler f16483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f16484c = new Object();

    /* JADX INFO: compiled from: Worker.java */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ac.this.b(message);
        }
    }

    public ac() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.f16483b = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.f16482a = context;
    }

    public abstract void b(Message message);

    public final void a(Message message) {
        synchronized (this.f16484c) {
            try {
                Handler handler = this.f16483b;
                if (handler == null) {
                    String str = "Dead worker dropping a message: " + message.what;
                    com.vivo.push.util.w.e(getClass().getSimpleName(), str + " (Thread " + Thread.currentThread().getId() + ")");
                } else {
                    handler.sendMessage(message);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
