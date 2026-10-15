package p106o0;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.L;

/* JADX INFO: compiled from: OnBackInvokedInput.android.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OnBackInvokedDispatcher f20660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OnBackInvokedCallback f20662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20663f;

    public m(OnBackInvokedDispatcher onBackInvokedDispatcher, int i9) {
        this.f20660c = onBackInvokedDispatcher;
        this.f20661d = i9;
        this.f20662e = Build.VERSION.SDK_INT == 33 ? new L(1, this) : new l(this);
    }

    @Override // p106o0.f
    public final void b(boolean z8) {
        if (z8 && !this.f20663f) {
            this.f20660c.registerOnBackInvokedCallback(this.f20661d, this.f20662e);
            this.f20663f = true;
        } else {
            if (z8 || !this.f20663f) {
                return;
            }
            this.f20660c.unregisterOnBackInvokedCallback(this.f20662e);
            this.f20663f = false;
        }
    }
}
