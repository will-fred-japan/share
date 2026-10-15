package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final class iw implements Runnable {
    private iw() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ey.b().a((Object) 1047);
            it.a().b();
        } catch (Throwable th) {
            ey.b().a((Object) 1039);
            defpackage.f.n(th, new StringBuilder("run err:"), "JUaidManager");
        }
    }

    public /* synthetic */ iw(byte b9) {
        this();
    }
}
