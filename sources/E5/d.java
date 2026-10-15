package E5;

import A0.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;

/* JADX INFO: compiled from: TextAppearance.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f1990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f1994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f1995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f1996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f1998i;
    public final ColorStateList j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f1999k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f2000l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2001m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Typeface f2002n;

    /* JADX INFO: compiled from: TextAppearance.java */
    public class a extends J.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f2003a;

        public a(h hVar) {
            this.f2003a = hVar;
        }

        @Override // J.g.c
        public final void b(int i9) {
            d.this.f2001m = true;
            this.f2003a.r(i9);
        }

        @Override // J.g.c
        public final void c(Typeface typeface) {
            d dVar = d.this;
            dVar.f2002n = Typeface.create(typeface, dVar.f1992c);
            dVar.f2001m = true;
            this.f2003a.s(dVar.f2002n, false);
        }
    }

    public d(Context context, int i9) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i9, p103n5.a.f20585C);
        this.f1999k = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.j = c.a(context, typedArrayObtainStyledAttributes, 3);
        c.a(context, typedArrayObtainStyledAttributes, 4);
        c.a(context, typedArrayObtainStyledAttributes, 5);
        this.f1992c = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.f1993d = typedArrayObtainStyledAttributes.getInt(1, 1);
        int i10 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f2000l = typedArrayObtainStyledAttributes.getResourceId(i10, 0);
        this.f1991b = typedArrayObtainStyledAttributes.getString(i10);
        typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.f1990a = c.a(context, typedArrayObtainStyledAttributes, 6);
        this.f1994e = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        this.f1995f = typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
        this.f1996g = typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i9, p103n5.a.f20607u);
        this.f1997h = typedArrayObtainStyledAttributes2.hasValue(0);
        this.f1998i = typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f2002n;
        int i9 = this.f1992c;
        if (typeface == null && (str = this.f1991b) != null) {
            this.f2002n = Typeface.create(str, i9);
        }
        if (this.f2002n == null) {
            int i10 = this.f1993d;
            if (i10 == 1) {
                this.f2002n = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.f2002n = Typeface.SERIF;
            } else if (i10 != 3) {
                this.f2002n = Typeface.DEFAULT;
            } else {
                this.f2002n = Typeface.MONOSPACE;
            }
            this.f2002n = Typeface.create(this.f2002n, i9);
        }
    }

    public final Typeface b(Context context) {
        if (this.f2001m) {
            return this.f2002n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceA = J.g.a(context, this.f2000l);
                this.f2002n = typefaceA;
                if (typefaceA != null) {
                    this.f2002n = Typeface.create(typefaceA, this.f1992c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e9) {
                Log.d("TextAppearance", "Error loading font " + this.f1991b, e9);
            }
        }
        a();
        this.f2001m = true;
        return this.f2002n;
    }

    public final void c(Context context, h hVar) {
        if (d(context)) {
            b(context);
        } else {
            a();
        }
        int i9 = this.f2000l;
        if (i9 == 0) {
            this.f2001m = true;
        }
        if (this.f2001m) {
            hVar.s(this.f2002n, true);
            return;
        }
        try {
            a aVar = new a(hVar);
            ThreadLocal<TypedValue> threadLocal = J.g.f2623a;
            if (context.isRestricted()) {
                aVar.a(-4);
            } else {
                J.g.b(context, i9, new TypedValue(), 0, aVar, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f2001m = true;
            hVar.r(1);
        } catch (Exception e9) {
            Log.d("TextAppearance", "Error loading font " + this.f1991b, e9);
            this.f2001m = true;
            hVar.r(-3);
        }
    }

    public final boolean d(Context context) {
        Typeface typefaceB = null;
        int i9 = this.f2000l;
        if (i9 != 0) {
            ThreadLocal<TypedValue> threadLocal = J.g.f2623a;
            if (!context.isRestricted()) {
                typefaceB = J.g.b(context, i9, new TypedValue(), 0, null, false, true);
            }
        }
        return typefaceB != null;
    }

    public final void e(Context context, TextPaint textPaint, h hVar) {
        f(context, textPaint, hVar);
        ColorStateList colorStateList = this.j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f1990a;
        textPaint.setShadowLayer(this.f1996g, this.f1994e, this.f1995f, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void f(Context context, TextPaint textPaint, h hVar) {
        if (d(context)) {
            g(context, textPaint, b(context));
            return;
        }
        a();
        g(context, textPaint, this.f2002n);
        c(context, new e(this, context, textPaint, hVar));
    }

    public final void g(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = g.a(context.getResources().getConfiguration(), typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i9 = (~typeface.getStyle()) & this.f1992c;
        textPaint.setFakeBoldText((i9 & 1) != 0);
        textPaint.setTextSkewX((i9 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f1999k);
        if (this.f1997h) {
            textPaint.setLetterSpacing(this.f1998i);
        }
    }
}
