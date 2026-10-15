package com.heytap.mcssdk.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14386a = "RegisterTimeoutTask";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f14387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f14388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f14389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f14390e = new Object();

    public static class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.g()) {
                e.b(f.f14386a, "register timeout, increment timeout count");
            }
            g.f().d();
        }
    }

    public f(Handler handler, long j) {
        this.f14387b = handler == null ? new Handler(Looper.getMainLooper()) : handler;
        this.f14388c = j;
    }

    public void a() {
        synchronized (this.f14390e) {
            try {
                b();
                a aVar = new a();
                this.f14389d = aVar;
                this.f14387b.postDelayed(aVar, this.f14388c);
                if (e.g()) {
                    e.b(f14386a, "register timeout task started, timeout: " + this.f14388c + "ms");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        Runnable runnable;
        synchronized (this.f14390e) {
            try {
                Handler handler = this.f14387b;
                if (handler != null && (runnable = this.f14389d) != null) {
                    handler.removeCallbacks(runnable);
                    this.f14389d = null;
                    if (e.g()) {
                        e.b(f14386a, "register timeout task cancelled");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean c() {
        boolean z8;
        synchronized (this.f14390e) {
            z8 = this.f14389d != null;
        }
        return z8;
    }
}
