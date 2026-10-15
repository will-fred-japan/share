package cn.jiguang.commons.a;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class ez implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ey f10028a;

    public ez(ey eyVar) {
        this.f10028a = eyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10028a.f10023l.compareAndSet(false, true);
        try {
            ArrayList arrayList = new ArrayList();
            int i9 = 0;
            do {
                fd fdVar = (fd) this.f10028a.f10017e.poll();
                if (fdVar == null) {
                    break;
                }
                arrayList.add(fdVar);
                this.f10028a.f10018f.decrementAndGet();
                i9++;
            } while (i9 < 5000);
            if (!arrayList.isEmpty()) {
                ee.a("JEXS", "queue poll count:" + arrayList.size());
                ey.a(this.f10028a, arrayList);
            }
            if (this.f10028a.f10017e.isEmpty()) {
                this.f10028a.f10025n.set(0);
            } else {
                this.f10028a.f10023l.set(false);
                int i10 = this.f10028a.f10018f.get();
                if (i10 < 0) {
                    this.f10028a.f10018f.set(0);
                    i10 = 0;
                }
                if (i10 >= 500) {
                    this.f10028a.a(i10);
                } else {
                    this.f10028a.h();
                }
            }
        } catch (Throwable th) {
            try {
                ee.d("JEXS", "process bundles err: " + th.getMessage());
            } finally {
                this.f10028a.f10023l.set(false);
            }
        }
    }
}
