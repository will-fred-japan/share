package com.google.android.material.textfield;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: EndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f13895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f13896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f13897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f13898d;

    public k(j jVar) {
        this.f13895a = jVar.f13868a;
        this.f13896b = jVar;
        this.f13897c = jVar.getContext();
        this.f13898d = jVar.f13874g;
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public R3.e h() {
        return null;
    }

    public boolean i(int i9) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this instanceof i;
    }

    public boolean l() {
        return false;
    }

    public final void q() {
        this.f13896b.f(false);
    }

    public void a() {
    }

    public void b() {
    }

    public void r() {
    }

    public void s() {
    }

    public void m(EditText editText) {
    }

    public void n(U.f fVar) {
    }

    public void o(AccessibilityEvent accessibilityEvent) {
    }

    public void p(boolean z8) {
    }
}
