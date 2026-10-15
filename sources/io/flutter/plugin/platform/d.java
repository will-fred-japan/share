package io.flutter.plugin.platform;

import N6.B;
import android.view.View;

/* JADX INFO: compiled from: PlatformPlugin.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements View.OnSystemUiVisibilityChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f19604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f19605b;

    public d(c cVar, View view) {
        this.f19605b = cVar;
        this.f19604a = view;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i9) {
        this.f19604a.post(new B(this, i9, 2));
    }
}
