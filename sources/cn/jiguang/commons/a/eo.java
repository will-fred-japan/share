package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class eo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ en f9974a;

    public eo(en enVar) {
        this.f9974a = enVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ee.a(this.f9974a.f9972a, "delay time is over,ready to request");
        this.f9974a.f9973b.run();
    }
}
