package com.google.android.material.internal;

import T.G;
import T.L;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: CollapsingTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public CharSequence f13470A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public CharSequence f13471B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f13472C;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public Bitmap f13474E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public float f13475F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public float f13476G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public float f13477H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public float f13478I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f13479J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public int f13480K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public int[] f13481L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public boolean f13482M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public final TextPaint f13483N;
    public final TextPaint O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public LinearInterpolator f13484P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public LinearInterpolator f13485Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public float f13486R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public float f13487S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public float f13488T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public ColorStateList f13489U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public float f13490V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public float f13491W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public float f13492X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public StaticLayout f13493Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public float f13494Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f13495a;
    public float a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f13496b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f13497b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f13498c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public CharSequence f13499c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f13500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f13502e;
    public ColorStateList j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f13509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f13510l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13511m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13512n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13513o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13514p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13515q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Typeface f13516r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Typeface f13517s;
    public Typeface t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Typeface f13518u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Typeface f13519v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Typeface f13520w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Typeface f13521x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public E5.a f13522y;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13504f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13506g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f13507h = 15.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f13508i = 15.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextUtils.TruncateAt f13523z = TextUtils.TruncateAt.END;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final boolean f13473D = true;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final int f13501d0 = 1;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final float f13503e0 = 1.0f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final int f13505f0 = 1;

    public b(TextInputLayout textInputLayout) {
        this.f13495a = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.f13483N = textPaint;
        this.O = new TextPaint(textPaint);
        this.f13500d = new Rect();
        this.f13498c = new Rect();
        this.f13502e = new RectF();
        g(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int a(int i9, int i10, float f6) {
        float f9 = 1.0f - f6;
        return Color.argb(Math.round((Color.alpha(i10) * f6) + (Color.alpha(i9) * f9)), Math.round((Color.red(i10) * f6) + (Color.red(i9) * f9)), Math.round((Color.green(i10) * f6) + (Color.green(i9) * f9)), Math.round((Color.blue(i10) * f6) + (Color.blue(i9) * f9)));
    }

    public static float f(float f6, float f9, float f10, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f10 = timeInterpolator.getInterpolation(f10);
        }
        return p110o5.a.a(f6, f9, f10);
    }

    public final boolean b(CharSequence charSequence) {
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        boolean z8 = this.f13495a.getLayoutDirection() == 1;
        if (this.f13473D) {
            return (z8 ? R.c.f3908d : R.c.f3907c).b(charSequence, charSequence.length());
        }
        return z8;
    }

    public final void c(float f6, boolean z8) {
        float f9;
        float f10;
        Typeface typeface;
        boolean z9;
        Layout.Alignment alignment;
        if (this.f13470A == null) {
            return;
        }
        float fWidth = this.f13500d.width();
        float fWidth2 = this.f13498c.width();
        if (Math.abs(f6 - 1.0f) < 1.0E-5f) {
            f9 = this.f13508i;
            f10 = this.f13490V;
            this.f13475F = 1.0f;
            typeface = this.f13516r;
        } else {
            float f11 = this.f13507h;
            float f12 = this.f13491W;
            Typeface typeface2 = this.f13518u;
            if (Math.abs(f6 - 0.0f) < 1.0E-5f) {
                this.f13475F = 1.0f;
            } else {
                this.f13475F = f(this.f13507h, this.f13508i, f6, this.f13485Q) / this.f13507h;
            }
            float f13 = this.f13508i / this.f13507h;
            fWidth = (z8 || fWidth2 * f13 <= fWidth) ? fWidth2 : Math.min(fWidth / f13, fWidth2);
            f9 = f11;
            f10 = f12;
            typeface = typeface2;
        }
        TextPaint textPaint = this.f13483N;
        if (fWidth > 0.0f) {
            boolean z10 = this.f13476G != f9;
            boolean z11 = this.f13492X != f10;
            boolean z12 = this.f13521x != typeface;
            StaticLayout staticLayout = this.f13493Y;
            boolean z13 = z10 || z11 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z12 || this.f13482M;
            this.f13476G = f9;
            this.f13492X = f10;
            this.f13521x = typeface;
            this.f13482M = false;
            textPaint.setLinearText(this.f13475F != 1.0f);
            z9 = z13;
        } else {
            z9 = false;
        }
        if (this.f13471B == null || z9) {
            textPaint.setTextSize(this.f13476G);
            textPaint.setTypeface(this.f13521x);
            textPaint.setLetterSpacing(this.f13492X);
            boolean zB = b(this.f13470A);
            this.f13472C = zB;
            int i9 = this.f13501d0;
            if (i9 <= 1 || zB) {
                i9 = 1;
            }
            if (i9 == 1) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                int absoluteGravity = Gravity.getAbsoluteGravity(this.f13504f, zB ? 1 : 0) & 7;
                if (absoluteGravity == 1) {
                    alignment = Layout.Alignment.ALIGN_CENTER;
                } else if (absoluteGravity != 5) {
                    alignment = this.f13472C ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
                } else {
                    alignment = this.f13472C ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
                }
            }
            e eVar = new e(this.f13470A, textPaint, (int) fWidth);
            eVar.f13535k = this.f13523z;
            eVar.j = zB;
            eVar.f13530e = alignment;
            eVar.f13534i = false;
            eVar.f13531f = i9;
            eVar.f13532g = this.f13503e0;
            eVar.f13533h = this.f13505f0;
            StaticLayout staticLayoutA = eVar.a();
            staticLayoutA.getClass();
            this.f13493Y = staticLayoutA;
            this.f13471B = staticLayoutA.getText();
        }
    }

    public final float d() {
        TextPaint textPaint = this.O;
        textPaint.setTextSize(this.f13508i);
        textPaint.setTypeface(this.f13516r);
        textPaint.setLetterSpacing(this.f13490V);
        return -textPaint.ascent();
    }

    public final int e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f13481L;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void g(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.t;
            if (typeface != null) {
                this.f13517s = E5.g.a(configuration, typeface);
            }
            Typeface typeface2 = this.f13520w;
            if (typeface2 != null) {
                this.f13519v = E5.g.a(configuration, typeface2);
            }
            Typeface typeface3 = this.f13517s;
            if (typeface3 == null) {
                typeface3 = this.t;
            }
            this.f13516r = typeface3;
            Typeface typeface4 = this.f13519v;
            if (typeface4 == null) {
                typeface4 = this.f13520w;
            }
            this.f13518u = typeface4;
            h(true);
        }
    }

    public final void h(boolean z8) {
        float fMeasureText;
        StaticLayout staticLayout;
        TextInputLayout textInputLayout = this.f13495a;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z8) {
            return;
        }
        c(1.0f, z8);
        CharSequence charSequence = this.f13471B;
        TextPaint textPaint = this.f13483N;
        if (charSequence != null && (staticLayout = this.f13493Y) != null) {
            this.f13499c0 = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), this.f13523z);
        }
        CharSequence charSequence2 = this.f13499c0;
        if (charSequence2 != null) {
            this.f13494Z = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f13494Z = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f13506g, this.f13472C ? 1 : 0);
        int i9 = absoluteGravity & 112;
        Rect rect = this.f13500d;
        if (i9 == 48) {
            this.f13511m = rect.top;
        } else if (i9 != 80) {
            this.f13511m = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f13511m = textPaint.ascent() + rect.bottom;
        }
        int i10 = absoluteGravity & 8388615;
        if (i10 == 1) {
            this.f13513o = rect.centerX() - (this.f13494Z / 2.0f);
        } else if (i10 != 5) {
            this.f13513o = rect.left;
        } else {
            this.f13513o = rect.right - this.f13494Z;
        }
        c(0.0f, z8);
        StaticLayout staticLayout2 = this.f13493Y;
        float height = staticLayout2 != null ? staticLayout2.getHeight() : 0.0f;
        StaticLayout staticLayout3 = this.f13493Y;
        if (staticLayout3 == null || this.f13501d0 <= 1) {
            CharSequence charSequence3 = this.f13471B;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.f13493Y;
        if (staticLayout4 != null) {
            staticLayout4.getLineCount();
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f13504f, this.f13472C ? 1 : 0);
        int i11 = absoluteGravity2 & 112;
        Rect rect2 = this.f13498c;
        if (i11 == 48) {
            this.f13510l = rect2.top;
        } else if (i11 != 80) {
            this.f13510l = rect2.centerY() - (height / 2.0f);
        } else {
            this.f13510l = textPaint.descent() + (rect2.bottom - height);
        }
        int i12 = absoluteGravity2 & 8388615;
        if (i12 == 1) {
            this.f13512n = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i12 != 5) {
            this.f13512n = rect2.left;
        } else {
            this.f13512n = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.f13474E;
        if (bitmap != null) {
            bitmap.recycle();
            this.f13474E = null;
        }
        m(this.f13496b);
        float f6 = this.f13496b;
        RectF rectF = this.f13502e;
        rectF.left = f(rect2.left, rect.left, f6, this.f13484P);
        rectF.top = f(this.f13510l, this.f13511m, f6, this.f13484P);
        rectF.right = f(rect2.right, rect.right, f6, this.f13484P);
        rectF.bottom = f(rect2.bottom, rect.bottom, f6, this.f13484P);
        this.f13514p = f(this.f13512n, this.f13513o, f6, this.f13484P);
        this.f13515q = f(this.f13510l, this.f13511m, f6, this.f13484P);
        m(f6);
        p067j0.b bVar = p110o5.a.f20704b;
        this.a0 = 1.0f - f(0.0f, 1.0f, 1.0f - f6, bVar);
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        textInputLayout.postInvalidateOnAnimation();
        this.f13497b0 = f(1.0f, 0.0f, f6, bVar);
        textInputLayout.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.f13509k;
        ColorStateList colorStateList2 = this.j;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(e(colorStateList2), e(this.f13509k), f6));
        } else {
            textPaint.setColor(e(colorStateList));
        }
        float f9 = this.f13490V;
        float f10 = this.f13491W;
        if (f9 != f10) {
            textPaint.setLetterSpacing(f(f10, f9, f6, bVar));
        } else {
            textPaint.setLetterSpacing(f9);
        }
        this.f13477H = p110o5.a.a(0.0f, this.f13486R, f6);
        this.f13478I = p110o5.a.a(0.0f, this.f13487S, f6);
        this.f13479J = p110o5.a.a(0.0f, this.f13488T, f6);
        int iA = a(0, e(this.f13489U), f6);
        this.f13480K = iA;
        textPaint.setShadowLayer(this.f13477H, this.f13478I, this.f13479J, iA);
        textInputLayout.postInvalidateOnAnimation();
    }

    public final void i(ColorStateList colorStateList) {
        if (this.f13509k == colorStateList && this.j == colorStateList) {
            return;
        }
        this.f13509k = colorStateList;
        this.j = colorStateList;
        h(false);
    }

    public final boolean j(Typeface typeface) {
        E5.a aVar = this.f13522y;
        if (aVar != null) {
            aVar.f1989d = true;
        }
        if (this.t == typeface) {
            return false;
        }
        this.t = typeface;
        Typeface typefaceA = E5.g.a(this.f13495a.getContext().getResources().getConfiguration(), typeface);
        this.f13517s = typefaceA;
        if (typefaceA == null) {
            typefaceA = this.t;
        }
        this.f13516r = typefaceA;
        return true;
    }

    public final boolean k(Typeface typeface) {
        if (this.f13520w == typeface) {
            return false;
        }
        this.f13520w = typeface;
        Typeface typefaceA = E5.g.a(this.f13495a.getContext().getResources().getConfiguration(), typeface);
        this.f13519v = typefaceA;
        if (typefaceA == null) {
            typefaceA = this.f13520w;
        }
        this.f13518u = typefaceA;
        return true;
    }

    public final void l(float f6) {
        float fM = p027d5.a.m(f6, 0.0f, 1.0f);
        if (fM != this.f13496b) {
            this.f13496b = fM;
            RectF rectF = this.f13502e;
            Rect rect = this.f13498c;
            float f9 = rect.left;
            Rect rect2 = this.f13500d;
            rectF.left = f(f9, rect2.left, fM, this.f13484P);
            rectF.top = f(this.f13510l, this.f13511m, fM, this.f13484P);
            rectF.right = f(rect.right, rect2.right, fM, this.f13484P);
            rectF.bottom = f(rect.bottom, rect2.bottom, fM, this.f13484P);
            this.f13514p = f(this.f13512n, this.f13513o, fM, this.f13484P);
            this.f13515q = f(this.f13510l, this.f13511m, fM, this.f13484P);
            m(fM);
            p067j0.b bVar = p110o5.a.f20704b;
            this.a0 = 1.0f - f(0.0f, 1.0f, 1.0f - fM, bVar);
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            TextInputLayout textInputLayout = this.f13495a;
            textInputLayout.postInvalidateOnAnimation();
            this.f13497b0 = f(1.0f, 0.0f, fM, bVar);
            textInputLayout.postInvalidateOnAnimation();
            ColorStateList colorStateList = this.f13509k;
            ColorStateList colorStateList2 = this.j;
            TextPaint textPaint = this.f13483N;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(a(e(colorStateList2), e(this.f13509k), fM));
            } else {
                textPaint.setColor(e(colorStateList));
            }
            float f10 = this.f13490V;
            float f11 = this.f13491W;
            if (f10 != f11) {
                textPaint.setLetterSpacing(f(f11, f10, fM, bVar));
            } else {
                textPaint.setLetterSpacing(f10);
            }
            this.f13477H = p110o5.a.a(0.0f, this.f13486R, fM);
            this.f13478I = p110o5.a.a(0.0f, this.f13487S, fM);
            this.f13479J = p110o5.a.a(0.0f, this.f13488T, fM);
            int iA = a(0, e(this.f13489U), fM);
            this.f13480K = iA;
            textPaint.setShadowLayer(this.f13477H, this.f13478I, this.f13479J, iA);
            textInputLayout.postInvalidateOnAnimation();
        }
    }

    public final void m(float f6) {
        c(f6, false);
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        this.f13495a.postInvalidateOnAnimation();
    }
}
