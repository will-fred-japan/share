package p130r;

import android.os.Handler;
import android.os.Looper;
import p006b.e;

/* JADX INFO: compiled from: CustomTabsSession.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f21083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f21084b;

    public i(l lVar) {
        this.f21084b = lVar;
        attachInterface(this, e.f8476p);
        this.f21083a = new Handler(Looper.getMainLooper());
    }
}
