package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: androidx.appcompat.widget.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatBackgroundHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0492d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f6592a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public I f6595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public I f6596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public I f6597f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6594c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0495g f6593b = C0495g.a();

    public C0492d(View view) {
        this.f6592a = view;
    }

    public final void a() {
        View view = this.f6592a;
        Drawable background = view.getBackground();
        if (background != null) {
            if (this.f6595d != null) {
                if (this.f6597f == null) {
                    this.f6597f = new I();
                }
                I i9 = this.f6597f;
                i9.f6415a = null;
                i9.f6418d = false;
                i9.f6416b = null;
                i9.f6417c = false;
                WeakHashMap<View, T.L> weakHashMap = T.G.f4313a;
                ColorStateList backgroundTintList = view.getBackgroundTintList();
                if (backgroundTintList != null) {
                    i9.f6418d = true;
                    i9.f6415a = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = view.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    i9.f6417c = true;
                    i9.f6416b = backgroundTintMode;
                }
                if (i9.f6418d || i9.f6417c) {
                    C0495g.e(background, i9, view.getDrawableState());
                    return;
                }
            }
            I i10 = this.f6596e;
            if (i10 != null) {
                C0495g.e(background, i10, view.getDrawableState());
                return;
            }
            I i11 = this.f6595d;
            if (i11 != null) {
                C0495g.e(background, i11, view.getDrawableState());
            }
        }
    }

    public final ColorStateList b() {
        I i9 = this.f6596e;
        if (i9 != null) {
            return i9.f6415a;
        }
        return null;
    }

    public final PorterDuff.Mode c() {
        I i9 = this.f6596e;
        if (i9 != null) {
            return i9.f6416b;
        }
        return null;
    }

    public final void d(AttributeSet attributeSet, int i9) {
        ColorStateList colorStateListF;
        View view = this.f6592a;
        Context context = view.getContext();
        int[] iArr = p059i.a.f19197z;
        K kE = K.e(context, attributeSet, iArr, i9);
        TypedArray typedArray = kE.f6420b;
        View view2 = this.f6592a;
        T.G.l(view2, view2.getContext(), iArr, attributeSet, kE.f6420b, i9);
        try {
            if (typedArray.hasValue(0)) {
                this.f6594c = typedArray.getResourceId(0, -1);
                C0495g c0495g = this.f6593b;
                Context context2 = view.getContext();
                int i10 = this.f6594c;
                synchronized (c0495g) {
                    colorStateListF = c0495g.f6612a.f(context2, i10);
                }
                if (colorStateListF != null) {
                    g(colorStateListF);
                }
            }
            if (typedArray.hasValue(1)) {
                view.setBackgroundTintList(kE.a(1));
            }
            if (typedArray.hasValue(2)) {
                view.setBackgroundTintMode(u.c(typedArray.getInt(2, -1), null));
            }
            kE.f();
        } catch (Throwable th) {
            kE.f();
            throw th;
        }
    }

    public final void e() {
        this.f6594c = -1;
        g(null);
        a();
    }

    public final void f(int i9) {
        ColorStateList colorStateListF;
        this.f6594c = i9;
        C0495g c0495g = this.f6593b;
        if (c0495g != null) {
            Context context = this.f6592a.getContext();
            synchronized (c0495g) {
                colorStateListF = c0495g.f6612a.f(context, i9);
            }
        } else {
            colorStateListF = null;
        }
        g(colorStateListF);
        a();
    }

    public final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f6595d == null) {
                this.f6595d = new I();
            }
            I i9 = this.f6595d;
            i9.f6415a = colorStateList;
            i9.f6418d = true;
        } else {
            this.f6595d = null;
        }
        a();
    }

    public final void h(ColorStateList colorStateList) {
        if (this.f6596e == null) {
            this.f6596e = new I();
        }
        I i9 = this.f6596e;
        i9.f6415a = colorStateList;
        i9.f6418d = true;
        a();
    }

    public final void i(PorterDuff.Mode mode) {
        if (this.f6596e == null) {
            this.f6596e = new I();
        }
        I i9 = this.f6596e;
        i9.f6416b = mode;
        i9.f6417c = true;
        a();
    }
}
