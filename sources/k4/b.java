package k4;

/* JADX INFO: loaded from: classes.dex */
public final class b extends s4.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19961a;

    @Override // s4.c.a
    public final boolean a(String str) {
        if (!this.f19961a && str.contains("android.os.Looper.loop")) {
            this.f19961a = true;
        }
        return !this.f19961a;
    }
}
