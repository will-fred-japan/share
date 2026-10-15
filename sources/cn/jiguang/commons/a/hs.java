package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class hs implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f10161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ hr f10162b;

    public hs(hr hrVar, String str) {
        this.f10162b = hrVar;
        this.f10161a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        hq.a(this.f10162b.f10160a, this.f10161a);
    }
}
