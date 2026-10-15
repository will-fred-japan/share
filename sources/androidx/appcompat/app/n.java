package androidx.appcompat.app;

import T.C0421h;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: compiled from: AppCompatDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends p030e.k implements g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppCompatDelegateImpl f5971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f5972f;

    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.appcompat.app.m] */
    public n(ContextThemeWrapper contextThemeWrapper, int i9) {
        int i10;
        if (i9 == 0) {
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i10 = typedValue.resourceId;
        } else {
            i10 = i9;
        }
        super(contextThemeWrapper, i10);
        final e eVar = (e) this;
        this.f5972f = new C0421h.a() { // from class: androidx.appcompat.app.m
            @Override // T.C0421h.a
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return eVar.e(keyEvent);
            }
        };
        i iVarC = c();
        if (i9 == 0) {
            TypedValue typedValue2 = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            i9 = typedValue2.resourceId;
        }
        ((AppCompatDelegateImpl) iVarC).f5876U = i9;
        iVarC.o();
    }

    @Override // p030e.k, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c().c(view, layoutParams);
    }

    public final i c() {
        if (this.f5971e == null) {
            i.c cVar = i.f5953a;
            this.f5971e = new AppCompatDelegateImpl(getContext(), getWindow(), this, this);
        }
        return this.f5971e;
    }

    public final void d() {
        p199z2.b.J(getWindow().getDecorView(), this);
        p011b4.h.G(getWindow().getDecorView(), this);
        A1.b.p1(getWindow().getDecorView(), this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        c().p();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0421h.b(this.f5972f, getWindow().getDecorView(), this, keyEvent);
    }

    public final boolean e(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final <T extends View> T findViewById(int i9) {
        return (T) c().e(i9);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        c().l();
    }

    @Override // p030e.k, android.app.Dialog
    public void onCreate(Bundle bundle) {
        c().k();
        super.onCreate(bundle);
        c().o();
    }

    @Override // p030e.k, android.app.Dialog
    public final void onStop() {
        super.onStop();
        c().t();
    }

    @Override // androidx.appcompat.app.g
    public final p089m.a onWindowStartingSupportActionMode(p089m.a.InterfaceC0228a interfaceC0228a) {
        return null;
    }

    @Override // p030e.k, android.app.Dialog
    public final void setContentView(int i9) {
        d();
        c().w(i9);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        c().B(charSequence);
    }

    @Override // p030e.k, android.app.Dialog
    public final void setContentView(View view) {
        d();
        c().x(view);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i9) {
        super.setTitle(i9);
        c().B(getContext().getString(i9));
    }

    @Override // p030e.k, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        c().y(view, layoutParams);
    }

    @Override // androidx.appcompat.app.g
    public final void onSupportActionModeFinished(p089m.a aVar) {
    }

    @Override // androidx.appcompat.app.g
    public final void onSupportActionModeStarted(p089m.a aVar) {
    }
}
