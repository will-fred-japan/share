package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class ih implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ii f10198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ id f10199b;

    public ih(id idVar, ii iiVar) {
        this.f10199b = idVar;
        this.f10198a = iiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f10199b.f10186f.get()) {
            id.b(this.f10199b, this.f10198a);
            this.f10199b.b();
        }
    }
}
