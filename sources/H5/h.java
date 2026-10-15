package H5;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;
import java.util.Objects;

/* JADX INFO: compiled from: MaterialShapeDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends Drawable implements p {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Paint f2419x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f2420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o.f[] f2421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o.f[] f2422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitSet f2423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Matrix f2425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f2426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f2427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f2428i;
    public final RectF j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Region f2429k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Region f2430l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l f2431m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f2432n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f2433o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final G5.a f2434p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f2435q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final m f2436r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PorterDuffColorFilter f2437s;
    public PorterDuffColorFilter t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f2438u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f2439v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f2440w;

    /* JADX INFO: compiled from: MaterialShapeDrawable.java */
    public class a {
        public a() {
        }
    }

    static {
        Paint paint = new Paint(1);
        f2419x = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public h() {
        this(new l());
    }

    public final void b(RectF rectF, Path path) {
        b bVar = this.f2420a;
        this.f2436r.a(bVar.f2442a, bVar.f2450i, rectF, this.f2435q, path);
        if (this.f2420a.f2449h != 1.0f) {
            Matrix matrix = this.f2425f;
            matrix.reset();
            float f6 = this.f2420a.f2449h;
            matrix.setScale(f6, f6, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f2439v, true);
    }

    public final int c(int i9) {
        int i10;
        b bVar = this.f2420a;
        float f6 = bVar.f2453m + 0.0f + bVar.f2452l;
        p195y5.a aVar = bVar.f2443b;
        if (aVar == null || !aVar.f22388a || K.a.e(i9, 255) != aVar.f22391d) {
            return i9;
        }
        float f9 = aVar.f22392e;
        float fMin = (f9 <= 0.0f || f6 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f6 / f9)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i9);
        int iD = p011b4.h.D(K.a.e(i9, 255), aVar.f22389b, fMin);
        if (fMin > 0.0f && (i10 = aVar.f22390c) != 0) {
            iD = K.a.c(K.a.e(i10, p195y5.a.f22387f), iD);
        }
        return K.a.e(iD, iAlpha);
    }

    public final void d(Canvas canvas) {
        if (this.f2423d.cardinality() > 0) {
            Log.w("h", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i9 = this.f2420a.f2455o;
        Path path = this.f2426g;
        G5.a aVar = this.f2434p;
        if (i9 != 0) {
            canvas.drawPath(path, aVar.f2289a);
        }
        for (int i10 = 0; i10 < 4; i10++) {
            o.f fVar = this.f2421b[i10];
            int i11 = this.f2420a.f2454n;
            Matrix matrix = o.f.f2517b;
            fVar.a(matrix, aVar, i11, canvas);
            this.f2422c[i10].a(matrix, aVar, this.f2420a.f2454n, canvas);
        }
        if (this.f2440w) {
            double d9 = 0;
            int iSin = (int) (Math.sin(Math.toRadians(d9)) * ((double) this.f2420a.f2455o));
            int iCos = (int) (Math.cos(Math.toRadians(d9)) * ((double) this.f2420a.f2455o));
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, f2419x);
            canvas.translate(iSin, iCos);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = this.f2432n;
        paint.setColorFilter(this.f2437s);
        int alpha = paint.getAlpha();
        int i9 = this.f2420a.f2451k;
        paint.setAlpha(((i9 + (i9 >>> 7)) * alpha) >>> 8);
        Paint paint2 = this.f2433o;
        paint2.setColorFilter(this.t);
        paint2.setStrokeWidth(this.f2420a.j);
        int alpha2 = paint2.getAlpha();
        int i10 = this.f2420a.f2451k;
        paint2.setAlpha(((i10 + (i10 >>> 7)) * alpha2) >>> 8);
        boolean z8 = this.f2424e;
        Path path = this.f2426g;
        if (z8) {
            l lVarF = this.f2420a.f2442a.f(new i(-(h() ? paint2.getStrokeWidth() / 2.0f : 0.0f)));
            this.f2431m = lVarF;
            float f6 = this.f2420a.f2450i;
            RectF rectF = this.j;
            rectF.set(g());
            float strokeWidth = h() ? paint2.getStrokeWidth() / 2.0f : 0.0f;
            rectF.inset(strokeWidth, strokeWidth);
            this.f2436r.a(lVarF, f6, rectF, null, this.f2427h);
            b(g(), path);
            this.f2424e = false;
        }
        b bVar = this.f2420a;
        bVar.getClass();
        if (bVar.f2454n > 0) {
            int i11 = Build.VERSION.SDK_INT;
            if (!this.f2420a.f2442a.d(g()) && !path.isConvex() && i11 < 29) {
                canvas.save();
                double d9 = 0;
                canvas.translate((int) (Math.sin(Math.toRadians(d9)) * ((double) this.f2420a.f2455o)), (int) (Math.cos(Math.toRadians(d9)) * ((double) this.f2420a.f2455o)));
                if (this.f2440w) {
                    RectF rectF2 = this.f2439v;
                    int iWidth = (int) (rectF2.width() - getBounds().width());
                    int iHeight = (int) (rectF2.height() - getBounds().height());
                    if (iWidth < 0 || iHeight < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.f2420a.f2454n * 2) + ((int) rectF2.width()) + iWidth, (this.f2420a.f2454n * 2) + ((int) rectF2.height()) + iHeight, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                    float f9 = (getBounds().left - this.f2420a.f2454n) - iWidth;
                    float f10 = (getBounds().top - this.f2420a.f2454n) - iHeight;
                    canvas2.translate(-f9, -f10);
                    d(canvas2);
                    canvas.drawBitmap(bitmapCreateBitmap, f9, f10, (Paint) null);
                    bitmapCreateBitmap.recycle();
                    canvas.restore();
                } else {
                    d(canvas);
                    canvas.restore();
                }
            }
        }
        b bVar2 = this.f2420a;
        Paint.Style style = bVar2.f2456p;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            e(canvas, paint, path, bVar2.f2442a, g());
        }
        if (h()) {
            f(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    public final void e(Canvas canvas, Paint paint, Path path, l lVar, RectF rectF) {
        if (!lVar.d(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = lVar.f2464f.a(rectF) * this.f2420a.f2450i;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    public void f(Canvas canvas) {
        Paint paint = this.f2433o;
        Path path = this.f2427h;
        l lVar = this.f2431m;
        RectF rectF = this.j;
        rectF.set(g());
        float strokeWidth = h() ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        e(canvas, paint, path, lVar, rectF);
    }

    public final RectF g() {
        RectF rectF = this.f2428i;
        rectF.set(getBounds());
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2420a.f2451k;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f2420a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        this.f2420a.getClass();
        if (this.f2420a.f2442a.d(g())) {
            outline.setRoundRect(getBounds(), this.f2420a.f2442a.f2463e.a(g()) * this.f2420a.f2450i);
            return;
        }
        RectF rectFG = g();
        Path path = this.f2426g;
        b(rectFG, path);
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 30) {
            x5.a.b.a(outline, path);
            return;
        }
        if (i9 >= 29) {
            try {
                p186x5.a.C0282a.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            p186x5.a.C0282a.a(outline, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f2420a.f2448g;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f2429k;
        region.set(bounds);
        RectF rectFG = g();
        Path path = this.f2426g;
        b(rectFG, path);
        Region region2 = this.f2430l;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final boolean h() {
        Paint.Style style = this.f2420a.f2456p;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f2433o.getStrokeWidth() > 0.0f;
    }

    public final void i(Context context) {
        this.f2420a.f2443b = new p195y5.a(context);
        n();
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f2424e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f2420a.f2446e;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f2420a.getClass();
        ColorStateList colorStateList2 = this.f2420a.f2445d;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f2420a.f2444c;
        return colorStateList3 != null && colorStateList3.isStateful();
    }

    public final void j(float f6) {
        b bVar = this.f2420a;
        if (bVar.f2453m != f6) {
            bVar.f2453m = f6;
            n();
        }
    }

    public final void k(ColorStateList colorStateList) {
        b bVar = this.f2420a;
        if (bVar.f2444c != colorStateList) {
            bVar.f2444c = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean l(int[] iArr) {
        boolean z8;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f2420a.f2444c == null || color2 == (colorForState2 = this.f2420a.f2444c.getColorForState(iArr, (color2 = (paint2 = this.f2432n).getColor())))) {
            z8 = false;
        } else {
            paint2.setColor(colorForState2);
            z8 = true;
        }
        if (this.f2420a.f2445d == null || color == (colorForState = this.f2420a.f2445d.getColorForState(iArr, (color = (paint = this.f2433o).getColor())))) {
            return z8;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean m() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f2437s;
        PorterDuffColorFilter porterDuffColorFilter3 = this.t;
        b bVar = this.f2420a;
        ColorStateList colorStateList = bVar.f2446e;
        PorterDuff.Mode mode = bVar.f2447f;
        Paint paint = this.f2432n;
        if (colorStateList == null || mode == null) {
            int color = paint.getColor();
            int iC = c(color);
            this.f2438u = iC;
            porterDuffColorFilter = iC != color ? new PorterDuffColorFilter(iC, PorterDuff.Mode.SRC_IN) : null;
        } else {
            int iC2 = c(colorStateList.getColorForState(getState(), 0));
            this.f2438u = iC2;
            porterDuffColorFilter = new PorterDuffColorFilter(iC2, mode);
        }
        this.f2437s = porterDuffColorFilter;
        this.f2420a.getClass();
        this.t = null;
        this.f2420a.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.f2437s) && Objects.equals(porterDuffColorFilter3, this.t)) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f2420a = new b(this.f2420a);
        return this;
    }

    public final void n() {
        b bVar = this.f2420a;
        float f6 = bVar.f2453m + 0.0f;
        bVar.f2454n = (int) Math.ceil(0.75f * f6);
        this.f2420a.f2455o = (int) Math.ceil(f6 * 0.25f);
        m();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f2424e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z8 = l(iArr) || m();
        if (z8) {
            invalidateSelf();
        }
        return z8;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i9) {
        b bVar = this.f2420a;
        if (bVar.f2451k != i9) {
            bVar.f2451k = i9;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2420a.getClass();
        super.invalidateSelf();
    }

    @Override // H5.p
    public final void setShapeAppearanceModel(l lVar) {
        this.f2420a.f2442a = lVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i9) {
        setTintList(ColorStateList.valueOf(i9));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2420a.f2446e = colorStateList;
        m();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f2420a;
        if (bVar.f2447f != mode) {
            bVar.f2447f = mode;
            m();
            super.invalidateSelf();
        }
    }

    public h(Context context, AttributeSet attributeSet, int i9, int i10) {
        this(l.b(context, attributeSet, i9, i10).a());
    }

    public h(l lVar) {
        this(new b(lVar));
    }

    public h(b bVar) {
        m mVar;
        this.f2421b = new o.f[4];
        this.f2422c = new o.f[4];
        this.f2423d = new BitSet(8);
        this.f2425f = new Matrix();
        this.f2426g = new Path();
        this.f2427h = new Path();
        this.f2428i = new RectF();
        this.j = new RectF();
        this.f2429k = new Region();
        this.f2430l = new Region();
        Paint paint = new Paint(1);
        this.f2432n = paint;
        Paint paint2 = new Paint(1);
        this.f2433o = paint2;
        this.f2434p = new G5.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            mVar = m.a.f2492a;
        } else {
            mVar = new m();
        }
        this.f2436r = mVar;
        this.f2439v = new RectF();
        this.f2440w = true;
        this.f2420a = bVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        m();
        l(getState());
        this.f2435q = new a();
    }

    /* JADX INFO: compiled from: MaterialShapeDrawable.java */
    public static class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l f2442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p195y5.a f2443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorStateList f2444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ColorStateList f2445d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ColorStateList f2446e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public PorterDuff.Mode f2447f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Rect f2448g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f2449h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f2450i;
        public float j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f2451k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f2452l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f2453m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f2454n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f2455o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Paint.Style f2456p;

        public b(l lVar) {
            this.f2444c = null;
            this.f2445d = null;
            this.f2446e = null;
            this.f2447f = PorterDuff.Mode.SRC_IN;
            this.f2448g = null;
            this.f2449h = 1.0f;
            this.f2450i = 1.0f;
            this.f2451k = 255;
            this.f2452l = 0.0f;
            this.f2453m = 0.0f;
            this.f2454n = 0;
            this.f2455o = 0;
            this.f2456p = Paint.Style.FILL_AND_STROKE;
            this.f2442a = lVar;
            this.f2443b = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h hVar = new h(this);
            hVar.f2424e = true;
            return hVar;
        }

        public b(b bVar) {
            this.f2444c = null;
            this.f2445d = null;
            this.f2446e = null;
            this.f2447f = PorterDuff.Mode.SRC_IN;
            this.f2448g = null;
            this.f2449h = 1.0f;
            this.f2450i = 1.0f;
            this.f2451k = 255;
            this.f2452l = 0.0f;
            this.f2453m = 0.0f;
            this.f2454n = 0;
            this.f2455o = 0;
            this.f2456p = Paint.Style.FILL_AND_STROKE;
            this.f2442a = bVar.f2442a;
            this.f2443b = bVar.f2443b;
            this.j = bVar.j;
            this.f2444c = bVar.f2444c;
            this.f2445d = bVar.f2445d;
            this.f2447f = bVar.f2447f;
            this.f2446e = bVar.f2446e;
            this.f2451k = bVar.f2451k;
            this.f2449h = bVar.f2449h;
            this.f2455o = bVar.f2455o;
            this.f2450i = bVar.f2450i;
            this.f2452l = bVar.f2452l;
            this.f2453m = bVar.f2453m;
            this.f2454n = bVar.f2454n;
            this.f2456p = bVar.f2456p;
            if (bVar.f2448g != null) {
                this.f2448g = new Rect(bVar.f2448g);
            }
        }
    }
}
