package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import cn.ikaile.ruoshui.client.R;
import p056h5.C0598e;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0493e f6315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0492d f6316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0504p f6317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0496h f6318d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        H.a(context);
        F.a(getContext(), this);
        C0504p c0504p = new C0504p(this);
        this.f6317c = c0504p;
        c0504p.f(attributeSet, R.attr.checkedTextViewStyle);
        c0504p.b();
        C0492d c0492d = new C0492d(this);
        this.f6316b = c0492d;
        c0492d.d(attributeSet, R.attr.checkedTextViewStyle);
        this.f6315a = new C0493e(this);
        Context context2 = getContext();
        int[] iArr = p059i.a.f19184l;
        K kE = K.e(context2, attributeSet, iArr, R.attr.checkedTextViewStyle);
        TypedArray typedArray = kE.f6420b;
        T.G.l(this, getContext(), iArr, attributeSet, kE.f6420b, R.attr.checkedTextViewStyle);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(C0598e.v(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        setCheckMarkDrawable(C0598e.v(getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(C0598e.v(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                setCheckMarkTintList(kE.a(2));
            }
            if (typedArray.hasValue(3)) {
                setCheckMarkTintMode(u.c(typedArray.getInt(3, -1), null));
            }
            kE.f();
            getEmojiTextViewHelper().b(attributeSet, R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            kE.f();
            throw th;
        }
    }

    private C0496h getEmojiTextViewHelper() {
        if (this.f6318d == null) {
            this.f6318d = new C0496h(this);
        }
        return this.f6318d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0504p c0504p = this.f6317c;
        if (c0504p != null) {
            c0504p.b();
        }
        C0492d c0492d = this.f6316b;
        if (c0492d != null) {
            c0492d.a();
        }
        C0493e c0493e = this.f6315a;
        if (c0493e != null) {
            c0493e.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.d.f(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0492d c0492d = this.f6316b;
        if (c0492d != null) {
            return c0492d.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0492d c0492d = this.f6316b;
        if (c0492d != null) {
            return c0492d.c();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0493e c0493e = this.f6315a;
        if (c0493e != null) {
            return c0493e.f6599b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0493e c0493e = this.f6315a;
        if (c0493e != null) {
            return c0493e.f6600c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f6317c.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f6317c.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        A1.b.k1(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z8) {
        super.setAllCaps(z8);
        getEmojiTextViewHelper().c(z8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0492d c0492d = this.f6316b;
        if (c0492d != null) {
            c0492d.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        C0492d c0492d = this.f6316b;
        if (c0492d != null) {
            c0492d.f(i9);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0493e c0493e = this.f6315a;
        if (c0493e != null) {
            if (c0493e.f6603f) {
                c0493e.f6603f = false;
            } else {
                c0493e.f6603f = true;
                c0493e.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0504p c0504p = this.f6317c;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0504p c0504p = this.f6317c;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.d.g(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z8) {
        getEmojiTextViewHelper().d(z8);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0492d c0492d = this.f6316b;
        if (c0492d != null) {
            c0492d.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0492d c0492d = this.f6316b;
        if (c0492d != null) {
            c0492d.i(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0493e c0493e = this.f6315a;
        if (c0493e != null) {
            c0493e.f6599b = colorStateList;
            c0493e.f6601d = true;
            c0493e.a();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0493e c0493e = this.f6315a;
        if (c0493e != null) {
            c0493e.f6600c = mode;
            c0493e.f6602e = true;
            c0493e.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0504p c0504p = this.f6317c;
        c0504p.l(colorStateList);
        c0504p.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0504p c0504p = this.f6317c;
        c0504p.m(mode);
        c0504p.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i9) {
        super.setTextAppearance(context, i9);
        C0504p c0504p = this.f6317c;
        if (c0504p != null) {
            c0504p.g(context, i9);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i9) {
        setCheckMarkDrawable(C0598e.v(getContext(), i9));
    }
}
