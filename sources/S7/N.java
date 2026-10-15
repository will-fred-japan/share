package S7;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class N extends AbstractC0410w {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f4236f = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y7.e<H<?>> f4239e;

    public long B() {
        return !C() ? Long.MAX_VALUE : 0L;
    }

    public final boolean C() {
        y7.e<H<?>> eVar = this.f4239e;
        if (eVar == null) {
            return false;
        }
        H<?> hRemoveFirst = eVar.isEmpty() ? null : eVar.removeFirst();
        if (hRemoveFirst == null) {
            return false;
        }
        hRemoveFirst.run();
        return true;
    }

    public final void w(boolean z8) {
        long j = this.f4237c - (z8 ? 4294967296L : 1L);
        this.f4237c = j;
        if (j <= 0 && this.f4238d) {
            shutdown();
        }
    }

    public final void z(boolean z8) {
        this.f4237c = (z8 ? 4294967296L : 1L) + this.f4237c;
        if (z8) {
            return;
        }
        this.f4238d = true;
    }

    public void shutdown() {
    }
}
