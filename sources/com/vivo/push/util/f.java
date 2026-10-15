package com.vivo.push.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ClientHandlerTimer.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f16865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f16866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<Integer, Message> f16867c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f16868d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16869e = 0;

    /* JADX INFO: compiled from: ClientHandlerTimer.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f16870a = new f();
    }

    public f() {
        HandlerThread handlerThread = new HandlerThread("ClientHandlerTimer");
        this.f16866b = handlerThread;
        handlerThread.start();
        this.f16865a = new Handler(this.f16866b.getLooper(), new g(this));
    }

    public static f a() {
        return a.f16870a;
    }

    public final int a(com.vivo.push.h.s sVar, long j) {
        synchronized (this.f16868d) {
            if (this.f16865a == null) {
                return -1;
            }
            this.f16869e++;
            Message messageObtain = Message.obtain();
            messageObtain.what = 10001;
            messageObtain.obj = sVar;
            messageObtain.arg1 = this.f16869e;
            this.f16865a.sendMessageDelayed(messageObtain, j);
            this.f16867c.put(Integer.valueOf(this.f16869e), messageObtain);
            return this.f16869e;
        }
    }

    public final int a(int i9) {
        Map<Integer, Message> map;
        Message message;
        synchronized (this.f16868d) {
            if (this.f16865a == null || (map = this.f16867c) == null || !map.containsKey(Integer.valueOf(i9)) || (message = this.f16867c.get(Integer.valueOf(i9))) == null) {
                return -1;
            }
            this.f16865a.removeMessages(10001, message.obj);
            return 0;
        }
    }
}
