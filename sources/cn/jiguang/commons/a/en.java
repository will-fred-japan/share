package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class en implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f9973b;

    public en(String str, Runnable runnable) {
        this.f9972a = str;
        this.f9973b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            fe.a().a(new eo(this), fl.NETWORK);
        } finally {
            em.f9971d.remove(this.f9972a);
        }
    }
}
