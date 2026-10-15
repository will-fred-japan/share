package J2;

import K2.f;
import K2.g;
import K2.h;
import K2.i;

/* JADX INFO: compiled from: CpuExceptionStateMachine.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public V2.a f2670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p193y3.a f2671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f2672f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public I2.c f2673g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f2674h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f2675i;
    public i j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public K2.d f2676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f2677l;

    public final void a(a aVar) {
        if (this.f2667a && this.f2668b) {
            this.f2672f = aVar;
            I2.c cVar = this.f2673g;
            V2.a aVar2 = this.f2670d;
            aVar.b(cVar, aVar2 == null || !aVar2.isForeground());
            if (A1.b.f1393A) {
                p010b3.b.d("APM-CPU", "change cpu exception detect state: " + this.f2672f);
            }
        }
    }

    public final synchronized void b(boolean z8) {
        a aVar = this.f2672f;
        if (aVar != null && this.f2667a) {
            if (this.f2669c == z8) {
                return;
            }
            this.f2669c = z8;
            aVar.d(z8);
        }
    }
}
