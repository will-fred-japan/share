package o;

import A0.h;

/* JADX INFO: compiled from: ArchTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f20620c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f20621b;

    public a() {
        super(13);
        this.f20621b = new b();
    }

    public static a w() {
        if (f20620c != null) {
            return f20620c;
        }
        synchronized (a.class) {
            try {
                if (f20620c == null) {
                    f20620c = new a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f20620c;
    }
}
