package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class hv implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ hx f10164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ hu f10165b;

    public hv(hu huVar, hx hxVar) {
        this.f10165b = huVar;
        this.f10164a = hxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ee.d("JLocation", "gps async fallback");
        this.f10165b.a(this.f10164a, (ab) null, true);
    }
}
