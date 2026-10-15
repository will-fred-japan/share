package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class bc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ be f9717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bb f9718b;

    public bc(bb bbVar, be beVar) {
        this.f9718b = bbVar;
        this.f9717a = beVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f9718b.f9716i.get()) {
            this.f9718b.f9716i.set(false);
        } else {
            Object obj = this.f9718b.f9709b.get();
            if (obj == null) {
                this.f9718b.d();
                obj = this.f9718b.f9709b.get();
            }
            if (obj != null) {
                this.f9717a.a(obj);
                if (!em.a(this.f9718b.f9715h, this.f9718b.f9711d.get(), this.f9718b.f9713f) || em.a(this.f9718b.f9715h, this.f9718b.f9711d.get(), this.f9718b.f9713f, new bd(this))) {
                    return;
                }
            } else {
                ee.a(this.f9718b.f9715h, "no cached config, loading from network");
            }
        }
        bb.a(this.f9718b, this.f9717a);
    }
}
