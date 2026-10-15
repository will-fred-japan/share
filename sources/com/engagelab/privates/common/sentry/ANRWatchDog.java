package com.engagelab.privates.common.sentry;

import W5.e;
import android.content.Context;
import android.os.Debug;
import com.engagelab.privates.common.b;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.sentry.entity.ApplicationNotResponding;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class ANRWatchDog extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ANRListener f12362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.engagelab.privates.common.a f12363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicLong f12365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f12366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MTRunnable f12367g;

    public interface ANRListener {
        void onAppNotResponding(ApplicationNotResponding applicationNotResponding);
    }

    public class a extends MTRunnable {
        public a() {
        }

        @Override // com.engagelab.privates.common.sentry.MTRunnable
        public void MTRun() {
            ANRWatchDog.this.f12365e.set(0L);
            ANRWatchDog.this.f12366f.set(false);
        }
    }

    public ANRWatchDog(long j, boolean z8, ANRListener aNRListener, Context context) {
        this(j, z8, aNRListener, new b(), context);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        setName("ENGAGELAB-PRIVATES-anr-watchdog");
        long j = this.f12364d;
        while (!isInterrupted()) {
            if (!SentryEntryHelper.isSentryCrashLogEnabled()) {
                MTCommonLog.d("ANRWatchDog", "isSentrySample1 false");
                return;
            }
            boolean z8 = this.f12365e.get() == 0;
            this.f12365e.addAndGet(j);
            if (z8) {
                this.f12363c.a(this.f12367g);
            }
            try {
                Thread.sleep(j);
                if (this.f12365e.get() != 0 && !this.f12366f.get()) {
                    if (!this.f12361a && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        MTCommonLog.w("ANRWatchDog", "An ANR was detected but ignored because the debugger is connected.");
                        this.f12366f.set(true);
                    } else {
                        if (!SentryEntryHelper.isSentryCrashLogEnabled()) {
                            MTCommonLog.d("ANRWatchDog", "isSentrySample2 false");
                            return;
                        }
                        MTCommonLog.w("ANRWatchDog", "Raising ANR");
                        this.f12362b.onAppNotResponding(new ApplicationNotResponding(e.m(new StringBuilder("Application Not Responding for at least "), this.f12364d, " ms."), this.f12363c.a()));
                        j = this.f12364d;
                        this.f12366f.set(true);
                    }
                }
            } catch (InterruptedException e9) {
                Thread.currentThread().interrupt();
                MTCommonLog.w("ANRWatchDog", "Interrupted: " + e9.getMessage());
                return;
            }
        }
    }

    public ANRWatchDog(long j, boolean z8, ANRListener aNRListener, com.engagelab.privates.common.a aVar, Context context) {
        this.f12365e = new AtomicLong(0L);
        this.f12366f = new AtomicBoolean(false);
        this.f12367g = new a();
        this.f12361a = z8;
        this.f12362b = aNRListener;
        this.f12364d = j;
        this.f12363c = aVar;
    }
}
