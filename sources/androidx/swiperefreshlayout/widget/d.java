package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: CircularProgressDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends Drawable implements Animatable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LinearInterpolator f8374g = new LinearInterpolator();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final p067j0.b f8375h = new p067j0.b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f8376i = {-16777216};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f8377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f8378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Resources f8379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ValueAnimator f8380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f8381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8382f;

    /* JADX INFO: compiled from: CircularProgressDrawable.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f8383a = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f8384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f8385c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Paint f8386d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f8387e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f8388f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f8389g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f8390h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int[] f8391i;
        public int j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f8392k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f8393l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f8394m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f8395n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Path f8396o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f8397p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f8398q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f8399r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f8400s;
        public int t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f8401u;

        public a() {
            Paint paint = new Paint();
            this.f8384b = paint;
            Paint paint2 = new Paint();
            this.f8385c = paint2;
            Paint paint3 = new Paint();
            this.f8386d = paint3;
            this.f8387e = 0.0f;
            this.f8388f = 0.0f;
            this.f8389g = 0.0f;
            this.f8390h = 5.0f;
            this.f8397p = 1.0f;
            this.t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public final void a(int i9) {
            this.j = i9;
            this.f8401u = this.f8391i[i9];
        }
    }

    public d(Context context) {
        context.getClass();
        this.f8379c = context.getResources();
        a aVar = new a();
        this.f8377a = aVar;
        aVar.f8391i = f8376i;
        aVar.a(0);
        aVar.f8390h = 2.5f;
        aVar.f8384b.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new b(this, aVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f8374g);
        valueAnimatorOfFloat.addListener(new c(this, aVar));
        this.f8380d = valueAnimatorOfFloat;
    }

    public static void d(float f6, a aVar) {
        if (f6 <= 0.75f) {
            aVar.f8401u = aVar.f8391i[aVar.j];
            return;
        }
        float f9 = (f6 - 0.75f) / 0.25f;
        int[] iArr = aVar.f8391i;
        int i9 = aVar.j;
        int i10 = iArr[i9];
        int i11 = iArr[(i9 + 1) % iArr.length];
        int i12 = (i10 >> 24) & 255;
        int i13 = (i10 >> 16) & 255;
        int i14 = (i10 >> 8) & 255;
        int i15 = i10 & 255;
        aVar.f8401u = ((i12 + ((int) ((((i11 >> 24) & 255) - i12) * f9))) << 24) | ((i13 + ((int) ((((i11 >> 16) & 255) - i13) * f9))) << 16) | ((i14 + ((int) ((((i11 >> 8) & 255) - i14) * f9))) << 8) | (i15 + ((int) (f9 * ((i11 & 255) - i15))));
    }

    public final void a(float f6, a aVar, boolean z8) {
        float interpolation;
        float interpolation2;
        if (this.f8382f) {
            d(f6, aVar);
            float fFloor = (float) (Math.floor(aVar.f8394m / 0.8f) + 1.0d);
            float f9 = aVar.f8392k;
            float f10 = aVar.f8393l;
            aVar.f8387e = (((f10 - 0.01f) - f9) * f6) + f9;
            aVar.f8388f = f10;
            float f11 = aVar.f8394m;
            aVar.f8389g = ((fFloor - f11) * f6) + f11;
            return;
        }
        if (f6 != 1.0f || z8) {
            float f12 = aVar.f8394m;
            p067j0.b bVar = f8375h;
            if (f6 < 0.5f) {
                interpolation = aVar.f8392k;
                interpolation2 = (bVar.getInterpolation(f6 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float f13 = aVar.f8392k + 0.79f;
                interpolation = f13 - (((1.0f - bVar.getInterpolation((f6 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = f13;
            }
            float f14 = (0.20999998f * f6) + f12;
            float f15 = (f6 + this.f8381e) * 216.0f;
            aVar.f8387e = interpolation;
            aVar.f8388f = interpolation2;
            aVar.f8389g = f14;
            this.f8378b = f15;
        }
    }

    public final void b(float f6, float f9, float f10, float f11) {
        float f12 = this.f8379c.getDisplayMetrics().density;
        float f13 = f9 * f12;
        a aVar = this.f8377a;
        aVar.f8390h = f13;
        aVar.f8384b.setStrokeWidth(f13);
        aVar.f8398q = f6 * f12;
        aVar.a(0);
        aVar.f8399r = (int) (f10 * f12);
        aVar.f8400s = (int) (f11 * f12);
    }

    public final void c(int i9) {
        if (i9 == 0) {
            b(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            b(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f8378b, bounds.exactCenterX(), bounds.exactCenterY());
        a aVar = this.f8377a;
        RectF rectF = aVar.f8383a;
        float f6 = aVar.f8398q;
        float fMin = (aVar.f8390h / 2.0f) + f6;
        if (f6 <= 0.0f) {
            fMin = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((aVar.f8399r * aVar.f8397p) / 2.0f, aVar.f8390h / 2.0f);
        }
        rectF.set(bounds.centerX() - fMin, bounds.centerY() - fMin, bounds.centerX() + fMin, bounds.centerY() + fMin);
        float f9 = aVar.f8387e;
        float f10 = aVar.f8389g;
        float f11 = (f9 + f10) * 360.0f;
        float f12 = ((aVar.f8388f + f10) * 360.0f) - f11;
        Paint paint = aVar.f8384b;
        paint.setColor(aVar.f8401u);
        paint.setAlpha(aVar.t);
        float f13 = aVar.f8390h / 2.0f;
        rectF.inset(f13, f13);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, aVar.f8386d);
        float f14 = -f13;
        rectF.inset(f14, f14);
        canvas.drawArc(rectF, f11, f12, false, paint);
        if (aVar.f8395n) {
            Path path = aVar.f8396o;
            if (path == null) {
                Path path2 = new Path();
                aVar.f8396o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float fMin2 = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f15 = (aVar.f8399r * aVar.f8397p) / 2.0f;
            aVar.f8396o.moveTo(0.0f, 0.0f);
            aVar.f8396o.lineTo(aVar.f8399r * aVar.f8397p, 0.0f);
            Path path3 = aVar.f8396o;
            float f16 = aVar.f8399r;
            float f17 = aVar.f8397p;
            path3.lineTo((f16 * f17) / 2.0f, aVar.f8400s * f17);
            aVar.f8396o.offset((rectF.centerX() + fMin2) - f15, (aVar.f8390h / 2.0f) + rectF.centerY());
            aVar.f8396o.close();
            Paint paint2 = aVar.f8385c;
            paint2.setColor(aVar.f8401u);
            paint2.setAlpha(aVar.t);
            canvas.save();
            canvas.rotate(f11 + f12, rectF.centerX(), rectF.centerY());
            canvas.drawPath(aVar.f8396o, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f8377a.t;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f8380d.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        this.f8377a.t = i9;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f8377a.f8384b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f8380d.cancel();
        a aVar = this.f8377a;
        float f6 = aVar.f8387e;
        aVar.f8392k = f6;
        float f9 = aVar.f8388f;
        aVar.f8393l = f9;
        aVar.f8394m = aVar.f8389g;
        if (f9 != f6) {
            this.f8382f = true;
            this.f8380d.setDuration(666L);
            this.f8380d.start();
            return;
        }
        aVar.a(0);
        aVar.f8392k = 0.0f;
        aVar.f8393l = 0.0f;
        aVar.f8394m = 0.0f;
        aVar.f8387e = 0.0f;
        aVar.f8388f = 0.0f;
        aVar.f8389g = 0.0f;
        this.f8380d.setDuration(1332L);
        this.f8380d.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f8380d.cancel();
        this.f8378b = 0.0f;
        a aVar = this.f8377a;
        if (aVar.f8395n) {
            aVar.f8395n = false;
        }
        aVar.a(0);
        aVar.f8392k = 0.0f;
        aVar.f8393l = 0.0f;
        aVar.f8394m = 0.0f;
        aVar.f8387e = 0.0f;
        aVar.f8388f = 0.0f;
        aVar.f8389g = 0.0f;
        invalidateSelf();
    }
}
