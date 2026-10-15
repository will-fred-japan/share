package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: RenderTask.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends m {
    @Override // pl.droidsonroids.gif.m
    public final void a() {
        d dVar = this.f20873a;
        long jO = dVar.f20849g.o(dVar.f20848f);
        if (jO >= 0) {
            this.f20873a.f20845c = SystemClock.uptimeMillis() + jO;
            if (this.f20873a.isVisible() && this.f20873a.f20844b) {
                d dVar2 = this.f20873a;
                if (!dVar2.f20853l) {
                    dVar2.f20843a.remove(this);
                    d dVar3 = this.f20873a;
                    dVar3.f20857p = dVar3.f20843a.schedule(this, jO, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f20873a.f20850h.isEmpty() && this.f20873a.f20849g.a() == this.f20873a.f20849g.h() - 1) {
                d dVar4 = this.f20873a;
                i iVar = dVar4.f20854m;
                GifInfoHandle gifInfoHandle = dVar4.f20849g;
                int iB = gifInfoHandle.b();
                if (iB != 0 && iB >= gifInfoHandle.f()) {
                    iB--;
                }
                iVar.sendEmptyMessageAtTime(iB, this.f20873a.f20845c);
            }
        } else {
            d dVar5 = this.f20873a;
            dVar5.f20845c = Long.MIN_VALUE;
            dVar5.f20844b = false;
        }
        if (!this.f20873a.isVisible() || this.f20873a.f20854m.hasMessages(-1)) {
            return;
        }
        this.f20873a.f20854m.sendEmptyMessageAtTime(-1, 0L);
    }
}
