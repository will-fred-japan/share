package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatToggleButton extends ToggleButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0492d f6371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0504p f6372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0496h f6373c;

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        F.a(getContext(), this);
        C0492d c0492d = new C0492d(this);
        this.f6371a = c0492d;
        c0492d.d(attributeSet, R.attr.buttonStyleToggle);
        C0504p c0504p = new C0504p(this);
        this.f6372b = c0504p;
        c0504p.f(attributeSet, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.buttonStyleToggle);
    }

    private C0496h getEmojiTextViewHelper() {
        if (this.f6373c == null) {
            this.f6373c = new C0496h(this);
        }
        return this.f6373c;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0492d c0492d = this.f6371a;
        if (c0492d != null) {
            c0492d.a();
        }
        C0504p c0504p = this.f6372b;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0492d c0492d = this.f6371a;
        if (c0492d != null) {
            return c0492d.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0492d c0492d = this.f6371a;
        if (c0492d != null) {
            return c0492d.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f6372b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f6372b.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z8) {
        super.setAllCaps(z8);
        getEmojiTextViewHelper().c(z8);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0492d c0492d = this.f6371a;
        if (c0492d != null) {
            c0492d.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        C0492d c0492d = this.f6371a;
        if (c0492d != null) {
            c0492d.f(i9);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0504p c0504p = this.f6372b;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0504p c0504p = this.f6372b;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z8) {
        getEmojiTextViewHelper().d(z8);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0492d c0492d = this.f6371a;
        if (c0492d != null) {
            c0492d.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0492d c0492d = this.f6371a;
        if (c0492d != null) {
            c0492d.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0504p c0504p = this.f6372b;
        c0504p.l(colorStateList);
        c0504p.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0504p c0504p = this.f6372b;
        c0504p.m(mode);
        c0504p.b();
    }
}
