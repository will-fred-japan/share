package cn.jiguang.ak;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
final class a extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0122a f9197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f9198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f9199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicLong f9200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f9201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f9202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final cn.jiguang.av.b f9203h;

    /* JADX INFO: renamed from: cn.jiguang.ak.a$a, reason: collision with other inner class name */
    public interface InterfaceC0122a {
        void a(cn.jiguang.al.a aVar);
    }

    public a(long j, boolean z8, InterfaceC0122a interfaceC0122a, Context context) {
        this(j, z8, interfaceC0122a, new f(), context);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        setName("jg_anr_watchdog");
        long j = this.f9199d;
        while (!isInterrupted()) {
            if (!i.a() || !i.b(this.f9202g)) {
                cn.jiguang.x.f.c("ANRWatchDog", "isSentrySample1 false or anr switch disabled");
                return;
            }
            boolean z8 = this.f9200e.get() == 0;
            this.f9200e.addAndGet(j);
            if (z8) {
                this.f9198c.a(this.f9203h);
            }
            try {
                Thread.sleep(j);
                if (this.f9200e.get() != 0 && !this.f9201f.get()) {
                    if (!this.f9196a && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        cn.jiguang.x.f.i("ANRWatchDog", "An ANR was detected but ignored because the debugger is connected.");
                        this.f9201f.set(true);
                    } else if (!i.a() || !i.b(this.f9202g)) {
                        cn.jiguang.x.f.c("ANRWatchDog", "isSentrySample2 false or anr switch disabled");
                        return;
                    } else if (a()) {
                        cn.jiguang.x.f.i("ANRWatchDog", "Raising ANR");
                        this.f9197b.a(new cn.jiguang.al.a(W5.e.m(new StringBuilder("Application Not Responding for at least "), this.f9199d, " ms."), this.f9198c.a()));
                        j = this.f9199d;
                        this.f9201f.set(true);
                    }
                }
            } catch (InterruptedException e9) {
                Thread.currentThread().interrupt();
                cn.jiguang.x.f.i("ANRWatchDog", "Interrupted: " + e9.getMessage());
                return;
            }
        }
    }

    public a(long j, boolean z8, InterfaceC0122a interfaceC0122a, e eVar, Context context) {
        this.f9200e = new AtomicLong(0L);
        this.f9201f = new AtomicBoolean(false);
        this.f9203h = new cn.jiguang.av.b() { // from class: cn.jiguang.ak.a.1
            @Override // cn.jiguang.av.b
            public void a() {
                a.this.f9200e.set(0L);
                a.this.f9201f.set(false);
            }
        };
        this.f9196a = z8;
        this.f9197b = interfaceC0122a;
        this.f9199d = j;
        this.f9198c = eVar;
        this.f9202g = context;
    }

    private boolean a() {
        Context context = this.f9202g;
        if (context == null) {
            cn.jiguang.x.f.i("ANRWatchDog", "ignore anr because context is null");
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(MTCommonConstants.Lifecycle.KEY_ACTIVITY);
        if (activityManager == null) {
            cn.jiguang.x.f.i("ANRWatchDog", "ignore anr because ActivityManager is null");
            return false;
        }
        try {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState == null || processesInErrorState.isEmpty()) {
                cn.jiguang.x.f.c("ANRWatchDog", "ignore anr because no process is in error state");
                return false;
            }
            String packageName = this.f9202g.getPackageName();
            String strA = cn.jiguang.aw.a.a(this.f9202g);
            if (strA == null) {
                cn.jiguang.x.f.i("ANRWatchDog", "ignore anr because processName is null");
                return false;
            }
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo != null) {
                    cn.jiguang.x.f.c("ANRWatchDog", "ProcessErrorStateInfo condition:" + processErrorStateInfo.condition + ", processName:" + processErrorStateInfo.processName + ", shortMsg:" + processErrorStateInfo.shortMsg);
                    if (processErrorStateInfo.condition == 2 && (TextUtils.equals(processErrorStateInfo.processName, strA) || TextUtils.equals(processErrorStateInfo.processName, packageName))) {
                        return true;
                    }
                }
            }
            cn.jiguang.x.f.c("ANRWatchDog", "ignore anr because current process is not NOT_RESPONDING");
            return false;
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("getProcessesInErrorState failed: "), "ANRWatchDog");
            return false;
        }
    }
}
