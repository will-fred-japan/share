package p172w0;

import J.k;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: VectorDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends p172w0.e {
    public static final PorterDuff.Mode j = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f21983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuffColorFilter f21984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorFilter f21985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f21988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Matrix f21989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f21990i;

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static class a extends e {
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static class b extends e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public J.d f21991d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public J.d f21993f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f21992e = 0.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f21994g = 1.0f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f21995h = 1.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f21996i = 0.0f;
        public float j = 1.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f21997k = 0.0f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Paint.Cap f21998l = Paint.Cap.BUTT;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Paint.Join f21999m = Paint.Join.MITER;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f22000n = 4.0f;

        @Override // w0.f.d
        public final boolean a() {
            return this.f21993f.b() || this.f21991d.b();
        }

        /* JADX WARN: Code duplicated, block: B:7:0x001c  */
        @Override // w0.f.d
        public final boolean b(int[] iArr) {
            boolean z8;
            J.d dVar = this.f21993f;
            boolean z9 = false;
            if (dVar.b()) {
                ColorStateList colorStateList = dVar.f2608b;
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (colorForState != dVar.f2609c) {
                    dVar.f2609c = colorForState;
                    z8 = true;
                } else {
                    z8 = false;
                }
            } else {
                z8 = false;
            }
            J.d dVar2 = this.f21991d;
            if (dVar2.b()) {
                ColorStateList colorStateList2 = dVar2.f2608b;
                int colorForState2 = colorStateList2.getColorForState(iArr, colorStateList2.getDefaultColor());
                if (colorForState2 != dVar2.f2609c) {
                    dVar2.f2609c = colorForState2;
                    z9 = true;
                }
            }
            return z8 | z9;
        }

        public float getFillAlpha() {
            return this.f21995h;
        }

        public int getFillColor() {
            return this.f21993f.f2609c;
        }

        public float getStrokeAlpha() {
            return this.f21994g;
        }

        public int getStrokeColor() {
            return this.f21991d.f2609c;
        }

        public float getStrokeWidth() {
            return this.f21992e;
        }

        public float getTrimPathEnd() {
            return this.j;
        }

        public float getTrimPathOffset() {
            return this.f21997k;
        }

        public float getTrimPathStart() {
            return this.f21996i;
        }

        public void setFillAlpha(float f6) {
            this.f21995h = f6;
        }

        public void setFillColor(int i9) {
            this.f21993f.f2609c = i9;
        }

        public void setStrokeAlpha(float f6) {
            this.f21994g = f6;
        }

        public void setStrokeColor(int i9) {
            this.f21991d.f2609c = i9;
        }

        public void setStrokeWidth(float f6) {
            this.f21992e = f6;
        }

        public void setTrimPathEnd(float f6) {
            this.j = f6;
        }

        public void setTrimPathOffset(float f6) {
            this.f21997k = f6;
        }

        public void setTrimPathStart(float f6) {
            this.f21996i = f6;
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static abstract class d {
        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static class g extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C0276f f22030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorStateList f22031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f22032d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f22033e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bitmap f22034f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ColorStateList f22035g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f22036h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f22037i;
        public boolean j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f22038k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Paint f22039l;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f22029a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new f(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new f(this);
        }
    }

    public f() {
        this.f21987f = true;
        this.f21988g = new float[9];
        this.f21989h = new Matrix();
        this.f21990i = new Rect();
        g gVar = new g();
        gVar.f22031c = null;
        gVar.f22032d = j;
        gVar.f22030b = new C0276f();
        this.f21983b = gVar;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f21982a;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f21990i;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f21985d;
        if (colorFilter == null) {
            colorFilter = this.f21984c;
        }
        Matrix matrix = this.f21989h;
        canvas.getMatrix(matrix);
        float[] fArr = this.f21988g;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iHeight = (int) (rect.height() * fAbs2);
        int iMin = Math.min(OpusCodecConfig.APPLICATION_VOIP, iWidth);
        int iMin2 = Math.min(OpusCodecConfig.APPLICATION_VOIP, iHeight);
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && getLayoutDirection() == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        g gVar = this.f21983b;
        Bitmap bitmap = gVar.f22034f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != gVar.f22034f.getHeight()) {
            gVar.f22034f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            gVar.f22038k = true;
        }
        if (this.f21987f) {
            g gVar2 = this.f21983b;
            if (gVar2.f22038k || gVar2.f22035g != gVar2.f22031c || gVar2.f22036h != gVar2.f22032d || gVar2.j != gVar2.f22033e || gVar2.f22037i != gVar2.f22030b.getRootAlpha()) {
                g gVar3 = this.f21983b;
                gVar3.f22034f.eraseColor(0);
                Canvas canvas2 = new Canvas(gVar3.f22034f);
                C0276f c0276f = gVar3.f22030b;
                c0276f.a(c0276f.f22021g, C0276f.f22014p, canvas2, iMin, iMin2);
                g gVar4 = this.f21983b;
                gVar4.f22035g = gVar4.f22031c;
                gVar4.f22036h = gVar4.f22032d;
                gVar4.f22037i = gVar4.f22030b.getRootAlpha();
                gVar4.j = gVar4.f22033e;
                gVar4.f22038k = false;
            }
        } else {
            g gVar5 = this.f21983b;
            gVar5.f22034f.eraseColor(0);
            Canvas canvas3 = new Canvas(gVar5.f22034f);
            C0276f c0276f2 = gVar5.f22030b;
            c0276f2.a(c0276f2.f22021g, C0276f.f22014p, canvas3, iMin, iMin2);
        }
        g gVar6 = this.f21983b;
        if (gVar6.f22030b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (gVar6.f22039l == null) {
                Paint paint2 = new Paint();
                gVar6.f22039l = paint2;
                paint2.setFilterBitmap(true);
            }
            gVar6.f22039l.setAlpha(gVar6.f22030b.getRootAlpha());
            gVar6.f22039l.setColorFilter(colorFilter);
            paint = gVar6.f22039l;
        }
        canvas.drawBitmap(gVar6.f22034f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.getAlpha() : this.f21983b.f22030b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f21983b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.getColorFilter() : this.f21985d;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f21982a != null) {
            return new h(this.f21982a.getConstantState());
        }
        this.f21983b.f22029a = getChangingConfigurations();
        return this.f21983b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f21983b.f22030b.f22023i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f21983b.f22030b.f22022h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.isAutoMirrored() : this.f21983b.f22033e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        g gVar = this.f21983b;
        if (gVar == null) {
            return false;
        }
        C0276f c0276f = gVar.f22030b;
        if (c0276f.f22027n == null) {
            c0276f.f22027n = Boolean.valueOf(c0276f.f22021g.a());
        }
        if (c0276f.f22027n.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.f21983b.f22031c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f21986e && super.mutate() == this) {
            g gVar = this.f21983b;
            g gVar2 = new g();
            gVar2.f22031c = null;
            gVar2.f22032d = j;
            if (gVar != null) {
                gVar2.f22029a = gVar.f22029a;
                C0276f c0276f = new C0276f(gVar.f22030b);
                gVar2.f22030b = c0276f;
                if (gVar.f22030b.f22019e != null) {
                    c0276f.f22019e = new Paint(gVar.f22030b.f22019e);
                }
                if (gVar.f22030b.f22018d != null) {
                    gVar2.f22030b.f22018d = new Paint(gVar.f22030b.f22018d);
                }
                gVar2.f22031c = gVar.f22031c;
                gVar2.f22032d = gVar.f22032d;
                gVar2.f22033e = gVar.f22033e;
            }
            this.f21983b = gVar2;
            this.f21986e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z8;
        PorterDuff.Mode mode;
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        g gVar = this.f21983b;
        ColorStateList colorStateList = gVar.f22031c;
        if (colorStateList == null || (mode = gVar.f22032d) == null) {
            z8 = false;
        } else {
            this.f21984c = a(colorStateList, mode);
            invalidateSelf();
            z8 = true;
        }
        C0276f c0276f = gVar.f22030b;
        if (c0276f.f22027n == null) {
            c0276f.f22027n = Boolean.valueOf(c0276f.f22021g.a());
        }
        if (c0276f.f22027n.booleanValue()) {
            boolean zB = gVar.f22030b.f22021g.b(iArr);
            gVar.f22038k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z8;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j8) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j8);
        } else {
            super.scheduleSelf(runnable, j8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setAlpha(i9);
        } else if (this.f21983b.f22030b.getRootAlpha() != i9) {
            this.f21983b.f22030b.setRootAlpha(i9);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z8) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setAutoMirrored(z8);
        } else {
            this.f21983b.f22033e = z8;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f21985d = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i9) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setTint(i9);
        } else {
            setTintList(ColorStateList.valueOf(i9));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        g gVar = this.f21983b;
        if (gVar.f22031c != colorStateList) {
            gVar.f22031c = colorStateList;
            this.f21984c = a(colorStateList, gVar.f22032d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setTintMode(mode);
            return;
        }
        g gVar = this.f21983b;
        if (gVar.f22032d != mode) {
            gVar.f22032d = mode;
            this.f21984c = a(gVar.f22031c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z8, boolean z9) {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.setVisible(z8, z9) : super.setVisible(z8, z9);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static class h extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f22040a;

        public h(Drawable.ConstantState constantState) {
            this.f22040a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return this.f22040a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f22040a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            f fVar = new f();
            fVar.f21982a = (VectorDrawable) this.f22040a.newDrawable();
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.f21982a = (VectorDrawable) this.f22040a.newDrawable(resources);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.f21982a = (VectorDrawable) this.f22040a.newDrawable(resources, theme);
            return fVar;
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static abstract class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public K.c.a[] f22011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22013c;

        public e() {
            this.f22011a = null;
            this.f22013c = 0;
        }

        public K.c.a[] getPathData() {
            return this.f22011a;
        }

        public String getPathName() {
            return this.f22012b;
        }

        public void setPathData(K.c.a[] aVarArr) {
            K.c.a[] aVarArr2 = this.f22011a;
            boolean z8 = false;
            if (aVarArr2 != null && aVarArr != null && aVarArr2.length == aVarArr.length) {
                int i9 = 0;
                while (true) {
                    if (i9 >= aVarArr2.length) {
                        z8 = true;
                        break;
                    }
                    K.c.a aVar = aVarArr2[i9];
                    char c5 = aVar.f2748a;
                    K.c.a aVar2 = aVarArr[i9];
                    if (c5 != aVar2.f2748a || aVar.f2749b.length != aVar2.f2749b.length) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            if (!z8) {
                this.f22011a = K.c.c(aVarArr);
                return;
            }
            K.c.a[] aVarArr3 = this.f22011a;
            for (int i10 = 0; i10 < aVarArr.length; i10++) {
                aVarArr3[i10].f2748a = aVarArr[i10].f2748a;
                int i11 = 0;
                while (true) {
                    float[] fArr = aVarArr[i10].f2749b;
                    if (i11 < fArr.length) {
                        aVarArr3[i10].f2749b[i11] = fArr[i11];
                        i11++;
                    }
                }
            }
        }

        public e(e eVar) {
            this.f22011a = null;
            this.f22013c = 0;
            this.f22012b = eVar.f22012b;
            this.f22011a = K.c.c(eVar.f22011a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i9;
        int i10;
        char c5;
        int i11;
        Paint.Cap cap;
        Paint.Join join;
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f21983b;
        gVar.f22030b = new C0276f();
        TypedArray typedArrayD = k.d(resources, theme, attributeSet, p172w0.a.f21963a);
        g gVar2 = this.f21983b;
        C0276f c0276f = gVar2.f22030b;
        int i12 = !k.c(xmlPullParser, "tintMode") ? -1 : typedArrayD.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (i12 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i12 != 5) {
            if (i12 != 9) {
                switch (i12) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        gVar2.f22032d = mode;
        int i13 = 1;
        ColorStateList colorStateListA = null;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
            TypedValue typedValue = new TypedValue();
            typedArrayD.getValue(1, typedValue);
            int i14 = typedValue.type;
            if (i14 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i14 >= 28 && i14 <= 31) {
                colorStateListA = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = typedArrayD.getResources();
                int resourceId = typedArrayD.getResourceId(1, 0);
                ThreadLocal<TypedValue> threadLocal = J.c.f2606a;
                try {
                    colorStateListA = J.c.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e9) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e9);
                }
            }
        }
        ColorStateList colorStateList = colorStateListA;
        if (colorStateList != null) {
            gVar2.f22031c = colorStateList;
        }
        boolean z8 = gVar2.f22033e;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z8 = typedArrayD.getBoolean(5, z8);
        }
        gVar2.f22033e = z8;
        float f6 = c0276f.j;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f6 = typedArrayD.getFloat(7, f6);
        }
        c0276f.j = f6;
        float f9 = c0276f.f22024k;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f9 = typedArrayD.getFloat(8, f9);
        }
        c0276f.f22024k = f9;
        if (c0276f.j <= 0.0f) {
            throw new XmlPullParserException(typedArrayD.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f9 > 0.0f) {
            c0276f.f22022h = typedArrayD.getDimension(3, c0276f.f22022h);
            float dimension = typedArrayD.getDimension(2, c0276f.f22023i);
            c0276f.f22023i = dimension;
            if (c0276f.f22022h <= 0.0f) {
                throw new XmlPullParserException(typedArrayD.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = c0276f.getAlpha();
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
                    alpha = typedArrayD.getFloat(4, alpha);
                }
                c0276f.setAlpha(alpha);
                String string = typedArrayD.getString(0);
                if (string != null) {
                    c0276f.f22026m = string;
                    c0276f.f22028o.put(string, c0276f);
                }
                typedArrayD.recycle();
                gVar.f22029a = getChangingConfigurations();
                gVar.f22038k = true;
                g gVar3 = this.f21983b;
                C0276f c0276f2 = gVar3.f22030b;
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(c0276f2.f22021g);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z9 = true;
                while (eventType != i13 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        c cVar = (c) arrayDeque.peek();
                        boolean zEquals = "path".equals(name);
                        i9 = depth;
                        p155u.a<String, Object> aVar = c0276f2.f22028o;
                        if (zEquals) {
                            b bVar = new b();
                            TypedArray typedArrayD2 = k.d(resources, theme, attributeSet, p172w0.a.f21965c);
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                String string2 = typedArrayD2.getString(0);
                                if (string2 != null) {
                                    bVar.f22012b = string2;
                                }
                                String string3 = typedArrayD2.getString(2);
                                if (string3 != null) {
                                    bVar.f22011a = K.c.b(string3);
                                }
                                bVar.f21993f = k.b(typedArrayD2, xmlPullParser, theme, "fillColor", 1);
                                float f10 = bVar.f21995h;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                                    f10 = typedArrayD2.getFloat(12, f10);
                                }
                                bVar.f21995h = f10;
                                int i15 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? typedArrayD2.getInt(8, -1) : -1;
                                Paint.Cap cap2 = bVar.f21998l;
                                if (i15 == 0) {
                                    cap = Paint.Cap.BUTT;
                                } else if (i15 != 1) {
                                    cap = i15 != 2 ? cap2 : Paint.Cap.SQUARE;
                                } else {
                                    cap = Paint.Cap.ROUND;
                                }
                                bVar.f21998l = cap;
                                int i16 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? typedArrayD2.getInt(9, -1) : -1;
                                Paint.Join join2 = bVar.f21999m;
                                if (i16 == 0) {
                                    join = Paint.Join.MITER;
                                } else if (i16 != 1) {
                                    join = i16 != 2 ? join2 : Paint.Join.BEVEL;
                                } else {
                                    join = Paint.Join.ROUND;
                                }
                                bVar.f21999m = join;
                                float f11 = bVar.f22000n;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                                    f11 = typedArrayD2.getFloat(10, f11);
                                }
                                bVar.f22000n = f11;
                                bVar.f21991d = k.b(typedArrayD2, xmlPullParser, theme, "strokeColor", 3);
                                float f12 = bVar.f21994g;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                                    f12 = typedArrayD2.getFloat(11, f12);
                                }
                                bVar.f21994g = f12;
                                float f13 = bVar.f21992e;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                                    f13 = typedArrayD2.getFloat(4, f13);
                                }
                                bVar.f21992e = f13;
                                float f14 = bVar.j;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                                    f14 = typedArrayD2.getFloat(6, f14);
                                }
                                bVar.j = f14;
                                float f15 = bVar.f21997k;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                                    f15 = typedArrayD2.getFloat(7, f15);
                                }
                                bVar.f21997k = f15;
                                float f16 = bVar.f21996i;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                                    f16 = typedArrayD2.getFloat(5, f16);
                                }
                                bVar.f21996i = f16;
                                int i17 = bVar.f22013c;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                                    i17 = typedArrayD2.getInt(13, i17);
                                }
                                bVar.f22013c = i17;
                            }
                            typedArrayD2.recycle();
                            cVar.f22002b.add(bVar);
                            if (bVar.getPathName() != null) {
                                aVar.put(bVar.getPathName(), bVar);
                            }
                            gVar3.f22029a = gVar3.f22029a;
                            i11 = 1;
                            z9 = false;
                            c5 = '\b';
                        } else {
                            c0276f2 = c0276f2;
                            c5 = '\b';
                            if ("clip-path".equals(name)) {
                                a aVar2 = new a();
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                    TypedArray typedArrayD3 = k.d(resources, theme, attributeSet, p172w0.a.f21966d);
                                    String string4 = typedArrayD3.getString(0);
                                    if (string4 != null) {
                                        aVar2.f22012b = string4;
                                    }
                                    String string5 = typedArrayD3.getString(1);
                                    if (string5 != null) {
                                        aVar2.f22011a = K.c.b(string5);
                                    }
                                    aVar2.f22013c = !k.c(xmlPullParser, "fillType") ? 0 : typedArrayD3.getInt(2, 0);
                                    typedArrayD3.recycle();
                                }
                                cVar.f22002b.add(aVar2);
                                if (aVar2.getPathName() != null) {
                                    aVar.put(aVar2.getPathName(), aVar2);
                                }
                                gVar3.f22029a = gVar3.f22029a;
                            } else if ("group".equals(name)) {
                                c cVar2 = new c();
                                TypedArray typedArrayD4 = k.d(resources, theme, attributeSet, p172w0.a.f21964b);
                                float f17 = cVar2.f22003c;
                                if (k.c(xmlPullParser, "rotation")) {
                                    f17 = typedArrayD4.getFloat(5, f17);
                                }
                                cVar2.f22003c = f17;
                                i11 = 1;
                                cVar2.f22004d = typedArrayD4.getFloat(1, cVar2.f22004d);
                                cVar2.f22005e = typedArrayD4.getFloat(2, cVar2.f22005e);
                                float f18 = cVar2.f22006f;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                                    f18 = typedArrayD4.getFloat(3, f18);
                                }
                                cVar2.f22006f = f18;
                                float f19 = cVar2.f22007g;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                                    f19 = typedArrayD4.getFloat(4, f19);
                                }
                                cVar2.f22007g = f19;
                                float f20 = cVar2.f22008h;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                                    f20 = typedArrayD4.getFloat(6, f20);
                                }
                                cVar2.f22008h = f20;
                                float f21 = cVar2.f22009i;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                                    f21 = typedArrayD4.getFloat(7, f21);
                                }
                                cVar2.f22009i = f21;
                                String string6 = typedArrayD4.getString(0);
                                if (string6 != null) {
                                    cVar2.f22010k = string6;
                                }
                                cVar2.c();
                                typedArrayD4.recycle();
                                cVar.f22002b.add(cVar2);
                                arrayDeque.push(cVar2);
                                if (cVar2.getGroupName() != null) {
                                    aVar.put(cVar2.getGroupName(), cVar2);
                                }
                                gVar3.f22029a = gVar3.f22029a;
                            }
                            i11 = 1;
                        }
                        i10 = i11;
                    } else {
                        c0276f2 = c0276f2;
                        i9 = depth;
                        i10 = i13;
                        c5 = '\b';
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i13 = i10;
                    depth = i9;
                    c0276f2 = c0276f2;
                }
                if (!z9) {
                    this.f21984c = a(gVar.f22031c, gVar.f22032d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayD.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayD.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f22001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<d> f22002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f22003c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f22004d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f22005e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f22006f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f22007g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f22008h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f22009i;
        public final Matrix j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f22010k;

        public c() {
            this.f22001a = new Matrix();
            this.f22002b = new ArrayList<>();
            this.f22003c = 0.0f;
            this.f22004d = 0.0f;
            this.f22005e = 0.0f;
            this.f22006f = 1.0f;
            this.f22007g = 1.0f;
            this.f22008h = 0.0f;
            this.f22009i = 0.0f;
            this.j = new Matrix();
            this.f22010k = null;
        }

        @Override // w0.f.d
        public final boolean a() {
            int i9 = 0;
            while (true) {
                ArrayList<d> arrayList = this.f22002b;
                if (i9 >= arrayList.size()) {
                    return false;
                }
                if (arrayList.get(i9).a()) {
                    return true;
                }
                i9++;
            }
        }

        @Override // w0.f.d
        public final boolean b(int[] iArr) {
            int i9 = 0;
            boolean zB = false;
            while (true) {
                ArrayList<d> arrayList = this.f22002b;
                if (i9 >= arrayList.size()) {
                    return zB;
                }
                zB |= arrayList.get(i9).b(iArr);
                i9++;
            }
        }

        public final void c() {
            Matrix matrix = this.j;
            matrix.reset();
            matrix.postTranslate(-this.f22004d, -this.f22005e);
            matrix.postScale(this.f22006f, this.f22007g);
            matrix.postRotate(this.f22003c, 0.0f, 0.0f);
            matrix.postTranslate(this.f22008h + this.f22004d, this.f22009i + this.f22005e);
        }

        public String getGroupName() {
            return this.f22010k;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.f22004d;
        }

        public float getPivotY() {
            return this.f22005e;
        }

        public float getRotation() {
            return this.f22003c;
        }

        public float getScaleX() {
            return this.f22006f;
        }

        public float getScaleY() {
            return this.f22007g;
        }

        public float getTranslateX() {
            return this.f22008h;
        }

        public float getTranslateY() {
            return this.f22009i;
        }

        public void setPivotX(float f6) {
            if (f6 != this.f22004d) {
                this.f22004d = f6;
                c();
            }
        }

        public void setPivotY(float f6) {
            if (f6 != this.f22005e) {
                this.f22005e = f6;
                c();
            }
        }

        public void setRotation(float f6) {
            if (f6 != this.f22003c) {
                this.f22003c = f6;
                c();
            }
        }

        public void setScaleX(float f6) {
            if (f6 != this.f22006f) {
                this.f22006f = f6;
                c();
            }
        }

        public void setScaleY(float f6) {
            if (f6 != this.f22007g) {
                this.f22007g = f6;
                c();
            }
        }

        public void setTranslateX(float f6) {
            if (f6 != this.f22008h) {
                this.f22008h = f6;
                c();
            }
        }

        public void setTranslateY(float f6) {
            if (f6 != this.f22009i) {
                this.f22009i = f6;
                c();
            }
        }

        public c(c cVar, p155u.a<String, Object> aVar) {
            e aVar2;
            this.f22001a = new Matrix();
            this.f22002b = new ArrayList<>();
            this.f22003c = 0.0f;
            this.f22004d = 0.0f;
            this.f22005e = 0.0f;
            this.f22006f = 1.0f;
            this.f22007g = 1.0f;
            this.f22008h = 0.0f;
            this.f22009i = 0.0f;
            Matrix matrix = new Matrix();
            this.j = matrix;
            this.f22010k = null;
            this.f22003c = cVar.f22003c;
            this.f22004d = cVar.f22004d;
            this.f22005e = cVar.f22005e;
            this.f22006f = cVar.f22006f;
            this.f22007g = cVar.f22007g;
            this.f22008h = cVar.f22008h;
            this.f22009i = cVar.f22009i;
            String str = cVar.f22010k;
            this.f22010k = str;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(cVar.j);
            ArrayList<d> arrayList = cVar.f22002b;
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                d dVar = arrayList.get(i9);
                if (dVar instanceof c) {
                    this.f22002b.add(new c((c) dVar, aVar));
                } else {
                    if (dVar instanceof b) {
                        b bVar = (b) dVar;
                        b bVar2 = new b(bVar);
                        bVar2.f21992e = 0.0f;
                        bVar2.f21994g = 1.0f;
                        bVar2.f21995h = 1.0f;
                        bVar2.f21996i = 0.0f;
                        bVar2.j = 1.0f;
                        bVar2.f21997k = 0.0f;
                        bVar2.f21998l = Paint.Cap.BUTT;
                        bVar2.f21999m = Paint.Join.MITER;
                        bVar2.f22000n = 4.0f;
                        bVar2.f21991d = bVar.f21991d;
                        bVar2.f21992e = bVar.f21992e;
                        bVar2.f21994g = bVar.f21994g;
                        bVar2.f21993f = bVar.f21993f;
                        bVar2.f22013c = bVar.f22013c;
                        bVar2.f21995h = bVar.f21995h;
                        bVar2.f21996i = bVar.f21996i;
                        bVar2.j = bVar.j;
                        bVar2.f21997k = bVar.f21997k;
                        bVar2.f21998l = bVar.f21998l;
                        bVar2.f21999m = bVar.f21999m;
                        bVar2.f22000n = bVar.f22000n;
                        aVar2 = bVar2;
                    } else if (dVar instanceof a) {
                        aVar2 = new a((a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f22002b.add(aVar2);
                    String str2 = aVar2.f22012b;
                    if (str2 != null) {
                        aVar.put(str2, aVar2);
                    }
                }
            }
        }
    }

    public f(g gVar) {
        this.f21987f = true;
        this.f21988g = new float[9];
        this.f21989h = new Matrix();
        this.f21990i = new Rect();
        this.f21983b = gVar;
        this.f21984c = a(gVar.f22031c, gVar.f22032d);
    }

    /* JADX INFO: renamed from: w0.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static class C0276f {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final Matrix f22014p = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Path f22015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f22016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Matrix f22017c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Paint f22018d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Paint f22019e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public PathMeasure f22020f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c f22021g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f22022h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f22023i;
        public float j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f22024k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f22025l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f22026m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Boolean f22027n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final p155u.a<String, Object> f22028o;

        public C0276f() {
            this.f22017c = new Matrix();
            this.f22022h = 0.0f;
            this.f22023i = 0.0f;
            this.j = 0.0f;
            this.f22024k = 0.0f;
            this.f22025l = 255;
            this.f22026m = null;
            this.f22027n = null;
            this.f22028o = new p155u.a<>();
            this.f22021g = new c();
            this.f22015a = new Path();
            this.f22016b = new Path();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(c cVar, Matrix matrix, Canvas canvas, int i9, int i10) {
            char c5;
            float f6;
            int i11;
            c cVar2 = cVar;
            char c9 = 1;
            cVar2.f22001a.set(matrix);
            Matrix matrix2 = cVar2.f22001a;
            matrix2.preConcat(cVar2.j);
            canvas.save();
            char c10 = 0;
            int i12 = 0;
            while (true) {
                ArrayList<d> arrayList = cVar2.f22002b;
                if (i12 >= arrayList.size()) {
                    canvas.restore();
                    return;
                }
                d dVar = arrayList.get(i12);
                if (dVar instanceof c) {
                    a((c) dVar, matrix2, canvas, i9, i10);
                } else {
                    if (dVar instanceof e) {
                        e eVar = (e) dVar;
                        float f9 = i9 / this.j;
                        float f10 = i10 / this.f22024k;
                        float fMin = Math.min(f9, f10);
                        Matrix matrix3 = this.f22017c;
                        matrix3.set(matrix2);
                        matrix3.postScale(f9, f10);
                        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                        matrix2.mapVectors(fArr);
                        float fHypot = (float) Math.hypot(fArr[c10], fArr[c9]);
                        boolean z8 = c9;
                        boolean z9 = c10;
                        float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                        float f11 = (fArr[z9 ? 1 : 0] * fArr[3]) - (fArr[z8 ? 1 : 0] * fArr[2]);
                        float fMax = Math.max(fHypot, fHypot2);
                        float fAbs = fMax > 0.0f ? Math.abs(f11) / fMax : 0.0f;
                        if (fAbs != 0.0f) {
                            eVar.getClass();
                            Path path = this.f22015a;
                            path.reset();
                            K.c.a[] aVarArr = eVar.f22011a;
                            if (aVarArr != null) {
                                K.c.a.b(aVarArr, path);
                            }
                            Path path2 = this.f22016b;
                            path2.reset();
                            if (eVar instanceof a) {
                                path2.setFillType(eVar.f22013c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                path2.addPath(path, matrix3);
                                canvas.clipPath(path2);
                            } else {
                                b bVar = (b) eVar;
                                float f12 = bVar.f21996i;
                                if (f12 != 0.0f || bVar.j != 1.0f) {
                                    float f13 = bVar.f21997k;
                                    float f14 = (f12 + f13) % 1.0f;
                                    float f15 = (bVar.j + f13) % 1.0f;
                                    if (this.f22020f == null) {
                                        this.f22020f = new PathMeasure();
                                    }
                                    this.f22020f.setPath(path, z9);
                                    float length = this.f22020f.getLength();
                                    float f16 = f14 * length;
                                    float f17 = f15 * length;
                                    path.reset();
                                    if (f16 > f17) {
                                        this.f22020f.getSegment(f16, length, path, z8);
                                        f6 = 0.0f;
                                        this.f22020f.getSegment(0.0f, f17, path, z8);
                                    } else {
                                        f6 = 0.0f;
                                        this.f22020f.getSegment(f16, f17, path, z8);
                                    }
                                    path.rLineTo(f6, f6);
                                }
                                path2.addPath(path, matrix3);
                                J.d dVar2 = bVar.f21993f;
                                float f18 = 255.0f;
                                if ((dVar2.f2607a == null && dVar2.f2609c == 0) ? false : true) {
                                    if (this.f22019e == null) {
                                        i11 = 16777215;
                                        Paint paint = new Paint(1);
                                        this.f22019e = paint;
                                        paint.setStyle(Paint.Style.FILL);
                                    } else {
                                        i11 = 16777215;
                                    }
                                    Paint paint2 = this.f22019e;
                                    Shader shader = dVar2.f2607a;
                                    if (shader != null) {
                                        shader.setLocalMatrix(matrix3);
                                        paint2.setShader(shader);
                                        paint2.setAlpha(Math.round(bVar.f21995h * 255.0f));
                                    } else {
                                        paint2.setShader(null);
                                        paint2.setAlpha(255);
                                        int i13 = dVar2.f2609c;
                                        float f19 = bVar.f21995h;
                                        PorterDuff.Mode mode = f.j;
                                        paint2.setColor((i13 & i11) | (((int) (Color.alpha(i13) * f19)) << 24));
                                    }
                                    paint2.setColorFilter(null);
                                    path2.setFillType(bVar.f22013c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                    canvas.drawPath(path2, paint2);
                                } else {
                                    f18 = 255.0f;
                                    i11 = 16777215;
                                }
                                J.d dVar3 = bVar.f21991d;
                                if (dVar3.f2607a != null || dVar3.f2609c != 0) {
                                    if (this.f22018d == null) {
                                        Paint paint3 = new Paint(1);
                                        this.f22018d = paint3;
                                        paint3.setStyle(Paint.Style.STROKE);
                                    }
                                    Paint paint4 = this.f22018d;
                                    Paint.Join join = bVar.f21999m;
                                    if (join != null) {
                                        paint4.setStrokeJoin(join);
                                    }
                                    Paint.Cap cap = bVar.f21998l;
                                    if (cap != null) {
                                        paint4.setStrokeCap(cap);
                                    }
                                    paint4.setStrokeMiter(bVar.f22000n);
                                    Shader shader2 = dVar3.f2607a;
                                    if (shader2 != null) {
                                        shader2.setLocalMatrix(matrix3);
                                        paint4.setShader(shader2);
                                        paint4.setAlpha(Math.round(bVar.f21994g * f18));
                                    } else {
                                        paint4.setShader(null);
                                        paint4.setAlpha(255);
                                        int i14 = dVar3.f2609c;
                                        float f20 = bVar.f21994g;
                                        PorterDuff.Mode mode2 = f.j;
                                        paint4.setColor((i14 & i11) | (((int) (Color.alpha(i14) * f20)) << 24));
                                    }
                                    paint4.setColorFilter(null);
                                    paint4.setStrokeWidth(bVar.f21992e * fMin * fAbs);
                                    canvas.drawPath(path2, paint4);
                                }
                            }
                        }
                        c5 = 1;
                    }
                    i12++;
                    cVar2 = cVar;
                    c9 = c5;
                    c10 = 0;
                }
                c5 = c9;
                i12++;
                cVar2 = cVar;
                c9 = c5;
                c10 = 0;
            }
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f22025l;
        }

        public void setAlpha(float f6) {
            setRootAlpha((int) (f6 * 255.0f));
        }

        public void setRootAlpha(int i9) {
            this.f22025l = i9;
        }

        public C0276f(C0276f c0276f) {
            this.f22017c = new Matrix();
            this.f22022h = 0.0f;
            this.f22023i = 0.0f;
            this.j = 0.0f;
            this.f22024k = 0.0f;
            this.f22025l = 255;
            this.f22026m = null;
            this.f22027n = null;
            p155u.a<String, Object> aVar = new p155u.a<>();
            this.f22028o = aVar;
            this.f22021g = new c(c0276f.f22021g, aVar);
            this.f22015a = new Path(c0276f.f22015a);
            this.f22016b = new Path(c0276f.f22016b);
            this.f22022h = c0276f.f22022h;
            this.f22023i = c0276f.f22023i;
            this.j = c0276f.j;
            this.f22024k = c0276f.f22024k;
            this.f22025l = c0276f.f22025l;
            this.f22026m = c0276f.f22026m;
            String str = c0276f.f22026m;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f22027n = c0276f.f22027n;
        }
    }
}
