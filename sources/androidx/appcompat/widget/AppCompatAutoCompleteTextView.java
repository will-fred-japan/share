package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import p056h5.C0598e;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatAutoCompleteTextView extends AutoCompleteTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f6304d = {R.attr.popupBackground};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0492d f6305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0504p f6306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final J.f f6307c;

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0492d c0492d = this.f6305a;
        if (c0492d != null) {
            c0492d.a();
        }
        C0504p c0504p = this.f6306b;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.d.f(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0492d c0492d = this.f6305a;
        if (c0492d != null) {
            return c0492d.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0492d c0492d = this.f6305a;
        if (c0492d != null) {
            return c0492d.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f6306b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f6306b.e();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        A1.b.k1(editorInfo, inputConnectionOnCreateInputConnection, this);
        return this.f6307c.j(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0492d c0492d = this.f6305a;
        if (c0492d != null) {
            c0492d.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        C0492d c0492d = this.f6305a;
        if (c0492d != null) {
            c0492d.f(i9);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0504p c0504p = this.f6306b;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0504p c0504p = this.f6306b;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.d.g(callback, this));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i9) {
        setDropDownBackgroundDrawable(C0598e.v(getContext(), i9));
    }

    public void setEmojiCompatEnabled(boolean z8) {
        this.f6307c.k(z8);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f6307c.h(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0492d c0492d = this.f6305a;
        if (c0492d != null) {
            c0492d.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0492d c0492d = this.f6305a;
        if (c0492d != null) {
            c0492d.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0504p c0504p = this.f6306b;
        c0504p.l(colorStateList);
        c0504p.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0504p c0504p = this.f6306b;
        c0504p.m(mode);
        c0504p.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i9) {
        super.setTextAppearance(context, i9);
        C0504p c0504p = this.f6306b;
        if (c0504p != null) {
            c0504p.g(context, i9);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, cn.ikaile.ruoshui.client.R.attr.autoCompleteTextViewStyle);
        H.a(context);
        F.a(getContext(), this);
        K kE = K.e(getContext(), attributeSet, f6304d, cn.ikaile.ruoshui.client.R.attr.autoCompleteTextViewStyle);
        if (kE.f6420b.hasValue(0)) {
            setDropDownBackgroundDrawable(kE.b(0));
        }
        kE.f();
        C0492d c0492d = new C0492d(this);
        this.f6305a = c0492d;
        c0492d.d(attributeSet, cn.ikaile.ruoshui.client.R.attr.autoCompleteTextViewStyle);
        C0504p c0504p = new C0504p(this);
        this.f6306b = c0504p;
        c0504p.f(attributeSet, cn.ikaile.ruoshui.client.R.attr.autoCompleteTextViewStyle);
        c0504p.b();
        J.f fVar = new J.f(this);
        this.f6307c = fVar;
        fVar.i(attributeSet, cn.ikaile.ruoshui.client.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerH = fVar.h(keyListener);
        if (keyListenerH == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerH);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }
}
