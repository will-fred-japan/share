package io.flutter.plugin.editing;

import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import p088l7.r;

/* JADX INFO: compiled from: ScribePlugin.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputMethodManager f19530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f19531b;

    public c(View view, InputMethodManager inputMethodManager, r rVar) {
        if (Build.VERSION.SDK_INT >= 33) {
            view.setAutoHandwritingEnabled(false);
        }
        this.f19531b = view;
        this.f19530a = inputMethodManager;
        rVar.f20198a = this;
    }
}
