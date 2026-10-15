package cn.jiguang.commons.a;

import android.content.Context;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class A implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f9590b;

    public /* synthetic */ A(Context context, int i9) {
        this.f9589a = i9;
        this.f9590b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9589a) {
            case 0:
                ec.a(this.f9590b);
                break;
            default:
                androidx.profileinstaller.c.b(this.f9590b, new p114p0.b(), androidx.profileinstaller.c.f7900a, false);
                break;
        }
    }
}
