package M1;

import android.os.SystemClock;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: MainThreadMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends L1.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f2879b;

    public c(f fVar) {
        this.f2879b = fVar;
    }

    @Override // L1.a
    public final void a() {
        this.f2831a = false;
        f fVar = this.f2879b;
        boolean z8 = fVar.f2889e;
        if (fVar.f2888d && z8) {
            fVar.d(fVar.f2896m);
            fVar.f2889e = false;
            p133r2.b.f21107i.a(new d(fVar, SystemClock.uptimeMillis()));
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        long[] jArr = fVar.f2886b;
        jArr[1] = jUptimeMillis;
        jArr[3] = SystemClock.currentThreadTimeMillis();
        CopyOnWriteArrayList copyOnWriteArrayList = fVar.f2887c;
        for (int i9 = 0; i9 < copyOnWriteArrayList.size(); i9++) {
            K1.a aVar = (K1.a) copyOnWriteArrayList.get(i9);
            if (aVar.f2766a) {
                long j = jArr[0];
                long j8 = jArr[2];
                long j9 = jArr[1];
                long j10 = jArr[3];
                aVar.d(z8);
            }
        }
    }

    @Override // L1.a
    public final void b(String str) {
        this.f2831a = true;
        f fVar = this.f2879b;
        fVar.f2886b[0] = SystemClock.uptimeMillis();
        fVar.f2886b[2] = SystemClock.currentThreadTimeMillis();
        CopyOnWriteArrayList copyOnWriteArrayList = fVar.f2887c;
        for (int i9 = 0; i9 < copyOnWriteArrayList.size(); i9++) {
            K1.a aVar = (K1.a) copyOnWriteArrayList.get(i9);
            if (!aVar.f2766a) {
                aVar.a(str);
            }
        }
    }

    @Override // L1.a
    public final boolean c() {
        return this.f2879b.f2885a;
    }
}
