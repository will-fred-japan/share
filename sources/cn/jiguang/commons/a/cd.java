package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class cd implements cr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ cc f9791a;

    public cd(cc ccVar) {
        this.f9791a = ccVar;
    }

    @Override // cn.jiguang.commons.a.cr
    public final void a() {
        ee.a();
        cc.a(this.f9791a);
    }

    @Override // cn.jiguang.commons.a.cr
    public final void b() {
        cc.b(this.f9791a);
    }

    @Override // cn.jiguang.commons.a.cr
    public final void c() {
        cc.c(this.f9791a);
    }

    @Override // cn.jiguang.commons.a.cr
    public final void a(String str) {
        ee.e("DataCollectionScheduler", "data collection scheduler error:" + str);
    }
}
