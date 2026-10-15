package B2;

import java.io.File;

/* JADX INFO: compiled from: HeaderStoreManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f1724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f1725b;

    /* JADX INFO: compiled from: HeaderStoreManager.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f1726a = new d();
    }

    public final synchronized void a() {
        if (this.f1724a) {
            return;
        }
        try {
            File file = new File(p199z2.b.o(), "header");
            this.f1725b = file;
            if (!file.exists()) {
                this.f1725b.mkdirs();
            }
        } catch (Throwable th) {
            p010b3.b.c("APM", "header store init error " + th.toString());
        }
        this.f1724a = true;
    }
}
