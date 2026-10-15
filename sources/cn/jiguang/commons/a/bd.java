package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class bd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bc f9719a;

    public bd(bc bcVar) {
        this.f9719a = bcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bc bcVar = this.f9719a;
        bb.a(bcVar.f9718b, bcVar.f9717a);
    }
}
