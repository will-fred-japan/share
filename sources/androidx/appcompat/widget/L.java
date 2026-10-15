package androidx.appcompat.widget;

import android.window.OnBackInvokedCallback;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class L implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6423b;

    public /* synthetic */ L(int i9, Object obj) {
        this.f6422a = i9;
        this.f6423b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f6422a) {
            case 0:
                ((Runnable) this.f6423b).run();
                break;
            default:
                ((p106o0.m) this.f6423b).a();
                break;
        }
    }
}
