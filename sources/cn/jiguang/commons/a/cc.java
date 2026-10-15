package cn.jiguang.commons.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<cg> f9789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ch f9790b;

    private cc() {
        this.f9789a = new AtomicReference<>(cg.STOPPED);
        ch chVar = new ch(285000L, false);
        this.f9790b = chVar;
        chVar.a(new cd(this));
        ee.a("DataCollectionScheduler", "datacollectionscheduler initialized:285000ms");
    }

    public static cc a() {
        return cf.f9794a;
    }

    public final void b() {
        cg cgVar = this.f9789a.get();
        cg cgVar2 = cg.RUNNING;
        if (cgVar == cgVar2) {
            ee.a("DataCollectionScheduler", "data collection scheduler already running");
            return;
        }
        AtomicReference<cg> atomicReference = this.f9789a;
        while (!atomicReference.compareAndSet(cgVar, cgVar2)) {
            if (atomicReference.get() != cgVar) {
                ee.a("DataCollectionScheduler", "failed to start scheduler, state changed");
                return;
            }
        }
        ee.a("DataCollectionScheduler", "starting data collection scheduler");
        this.f9790b.a();
    }

    public final void c() {
        cg cgVar = this.f9789a.get();
        cg cgVar2 = cg.STOPPED;
        if (cgVar == cgVar2) {
            ee.a("DataCollectionScheduler", "data collection scheduler already stopped");
            return;
        }
        AtomicReference<cg> atomicReference = this.f9789a;
        while (!atomicReference.compareAndSet(cgVar, cgVar2)) {
            if (atomicReference.get() != cgVar) {
                ee.a("DataCollectionScheduler", "failed to stop scheduler, state changed");
                return;
            }
        }
        ee.a("DataCollectionScheduler", "stopping data collection scheduler");
        this.f9790b.b();
    }

    public final boolean d() {
        return this.f9789a.get() == cg.RUNNING;
    }

    public /* synthetic */ cc(byte b9) {
        this();
    }

    public static /* synthetic */ void a(cc ccVar) {
        ee.a("DataCollectionScheduler", "performing scheduled task");
        try {
            bl.e().a((be) new ce(ccVar, new AtomicBoolean(false)));
        } catch (Throwable th) {
            W5.f.p(th, new StringBuilder("error in scheduled task:"), "DataCollectionScheduler", th);
        }
    }

    public static /* synthetic */ void b(cc ccVar) {
        ee.a("DataCollectionScheduler", "data collection scheduler started");
        ccVar.a(cg.RUNNING);
    }

    public static /* synthetic */ void c(cc ccVar) {
        ee.a("DataCollectionScheduler", "data collection scheduler stopped");
        ccVar.a(cg.STOPPED);
    }

    private void a(cg cgVar) {
        cg andSet = this.f9789a.getAndSet(cgVar);
        if (andSet != cgVar) {
            ee.a("DataCollectionScheduler", "scheduler state changed:" + andSet + " to " + cgVar);
        }
    }
}
