package p129q7;

import Z6.e;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import defpackage.f;
import p088l7.s;

/* JADX INFO: compiled from: SensitiveContentPlugin.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f21030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f21032c;

    public b(int i9, e eVar, s sVar) {
        this.f21030a = eVar;
        this.f21031b = i9;
        this.f21032c = sVar;
        sVar.f20200a = this;
    }

    @SuppressLint({"NewApi"})
    public final int a() {
        if (Build.VERSION.SDK_INT < 35) {
            return 2;
        }
        e eVar = this.f21030a;
        int i9 = this.f21031b;
        View viewFindViewById = eVar.findViewById(i9);
        if (viewFindViewById != null) {
            return viewFindViewById.getContentSensitivity();
        }
        throw new IllegalArgumentException(f.b(i9, "FlutterView with ID ", "not found"));
    }

    @SuppressLint({"NewApi"})
    public final void b(int i9) {
        if (Build.VERSION.SDK_INT < 35) {
            throw new IllegalStateException("isSupported() should be called before attempting to set content sensitivity as it is not supported on this device.");
        }
        e eVar = this.f21030a;
        int i10 = this.f21031b;
        View viewFindViewById = eVar.findViewById(i10);
        if (viewFindViewById == null) {
            throw new IllegalArgumentException(f.b(i10, "FlutterView with ID ", "not found"));
        }
        if (viewFindViewById.getContentSensitivity() == i9) {
            return;
        }
        viewFindViewById.setContentSensitivity(i9);
        viewFindViewById.invalidate();
    }
}
