package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f94a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f95a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile b f96a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f97a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f17021b;

    public ai() {
        this(false);
    }

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final LinkedBlockingQueue<b> f99a;

        public a() {
            super("PackageProcessor");
            this.f99a = new LinkedBlockingQueue<>();
        }

        public void a(b bVar) {
            try {
                this.f99a.add(bVar);
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = ai.this.f17020a > 0 ? ai.this.f17020a : Long.MAX_VALUE;
            while (!ai.this.f97a) {
                try {
                    b bVarPoll = this.f99a.poll(j, TimeUnit.SECONDS);
                    ai.this.f96a = bVarPoll;
                    if (bVarPoll != null) {
                        a(0, bVarPoll);
                        bVarPoll.b();
                        a(1, bVarPoll);
                    } else if (ai.this.f17020a > 0) {
                        ai.this.a();
                    }
                } catch (InterruptedException e9) {
                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
                }
            }
        }

        private void a(int i9, b bVar) {
            try {
                ai.this.f94a.sendMessage(ai.this.f94a.obtainMessage(i9, bVar));
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
            }
        }
    }

    public ai(boolean z8) {
        this(z8, 0);
    }

    public ai(boolean z8, int i9) {
        this.f94a = null;
        this.f97a = false;
        this.f17020a = 0;
        this.f94a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.push.ai.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b bVar = (b) message.obj;
                int i10 = message.what;
                if (i10 == 0) {
                    bVar.a();
                } else if (i10 == 1) {
                    bVar.mo250c();
                }
                super.handleMessage(message);
            }
        };
        this.f17021b = z8;
        this.f17020a = i9;
    }

    public synchronized void a(b bVar) {
        try {
            if (this.f95a == null) {
                a aVar = new a();
                this.f95a = aVar;
                aVar.setDaemon(this.f17021b);
                this.f97a = false;
                this.f95a.start();
            }
            this.f95a.a(bVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f95a = null;
        this.f97a = true;
    }

    public void a(final b bVar, long j) {
        this.f94a.postDelayed(new Runnable() { // from class: com.xiaomi.push.ai.2
            @Override // java.lang.Runnable
            public void run() {
                ai.this.a(bVar);
            }
        }, j);
    }

    public static abstract class b {
        public abstract void b();

        public void a() {
        }

        /* JADX INFO: renamed from: c */
        public void mo250c() {
        }
    }
}
