package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0492d f6308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0504p f6309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0496h f6310c;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    private C0496h getEmojiTextViewHelper() {
        if (this.f6310c == null) {
            this.f6310c = new C0496h(this);
        }
        return this.f6310c;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0492d c0492d = this.f6308a;
        if (c0492d != null) {
            c0492d.a();
        }
        C0504p c0504p = this.f6309b;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (Q.f6466c) {
            return super.getAutoSizeMaxTextSize();
        }
        C0504p c0504p = this.f6309b;
        if (c0504p != null) {
            return Math.round(c0504p.f6644i.f6661e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (Q.f6466c) {
            return super.getAutoSizeMinTextSize();
        }
        C0504p c0504p = this.f6309b;
        if (c0504p != null) {
            return Math.round(c0504p.f6644i.f6660d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (Q.f6466c) {
            return super.getAutoSizeStepGranularity();
        }
        C0504p c0504p = this.f6309b;
        if (c0504p != null) {
            return Math.round(c0504p.f6644i.f6659c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (Q.f6466c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0504p c0504p = this.f6309b;
        return c0504p != null ? c0504p.f6644i.f6662f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (Q.f6466c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C0504p c0504p = this.f6309b;
        if (c0504p != null) {
            return c0504p.f6644i.f6657a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.d.f(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0492d c0492d = this.f6308a;
        if (c0492d != null) {
            return c0492d.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0492d c0492d = this.f6308a;
        if (c0492d != null) {
            return c0492d.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f6309b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f6309b.e();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        C0504p c0504p = this.f6309b;
        if (c0504p == null || Q.f6466c) {
            return;
        }
        c0504p.f6644i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
        super.onTextChanged(charSequence, i9, i10, i11);
        C0504p c0504p = this.f6309b;
        if (c0504p == null || Q.f6466c) {
            return;
        }
        r rVar = c0504p.f6644i;
        if (rVar.f()) {
            rVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z8) {
        super.setAllCaps(z8);
        getEmojiTextViewHelper().c(z8);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i9, int i10, int i11, int i12) {
        if (Q.f6466c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i9, i10, i11, i12);
            return;
        }
        C0504p c0504p = this.f6309b;
        if (c0504p != null) {
            c0504p.i(i9, i10, i11, i12);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i9) {
        if (Q.f6466c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i9);
            return;
        }
        C0504p c0504p = this.f6309b;
        if (c0504p != null) {
            c0504p.j(iArr, i9);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i9) {
        if (Q.f6466c) {
            super.setAutoSizeTextTypeWithDefaults(i9);
            return;
        }
        C0504p c0504p = this.f6309b;
        if (c0504p != null) {
            c0504p.k(i9);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0492d c0492d = this.f6308a;
        if (c0492d != null) {
            c0492d.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        C0492d c0492d = this.f6308a;
        if (c0492d != null) {
            c0492d.f(i9);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.d.g(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z8) {
        getEmojiTextViewHelper().d(z8);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z8) {
        C0504p c0504p = this.f6309b;
        if (c0504p != null) {
            c0504p.f6636a.setAllCaps(z8);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0492d c0492d = this.f6308a;
        if (c0492d != null) {
            c0492d.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0492d c0492d = this.f6308a;
        if (c0492d != null) {
            c0492d.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0504p c0504p = this.f6309b;
        c0504p.l(colorStateList);
        c0504p.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0504p c0504p = this.f6309b;
        c0504p.m(mode);
        c0504p.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i9) {
        super.setTextAppearance(context, i9);
        C0504p c0504p = this.f6309b;
        if (c0504p != null) {
            c0504p.g(context, i9);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i9, float f6) {
        boolean z8 = Q.f6466c;
        if (z8) {
            super.setTextSize(i9, f6);
            return;
        }
        C0504p c0504p = this.f6309b;
        if (c0504p == null || z8) {
            return;
        }
        r rVar = c0504p.f6644i;
        if (rVar.f()) {
            return;
        }
        rVar.g(i9, f6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatButton(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        H.a(context);
        F.a(getContext(), this);
        C0492d c0492d = new C0492d(this);
        this.f6308a = c0492d;
        c0492d.d(attributeSet, i9);
        C0504p c0504p = new C0504p(this);
        this.f6309b = c0504p;
        c0504p.f(attributeSet, i9);
        c0504p.b();
        getEmojiTextViewHelper().b(attributeSet, i9);
    }
}
