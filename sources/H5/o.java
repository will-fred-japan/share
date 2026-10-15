package H5;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import java.util.ArrayList;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f2495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f2496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f2497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f2498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f2499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f2500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f2501g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f2502h = new ArrayList();

    /* JADX INFO: compiled from: ShapePath.java */
    public static class a extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f2503c;

        public a(c cVar) {
            this.f2503c = cVar;
        }

        @Override // H5.o.f
        public final void a(Matrix matrix, G5.a aVar, int i9, Canvas canvas) {
            c cVar = this.f2503c;
            float f6 = cVar.f2512f;
            float f9 = cVar.f2513g;
            RectF rectF = new RectF(cVar.f2508b, cVar.f2509c, cVar.f2510d, cVar.f2511e);
            aVar.getClass();
            boolean z8 = f9 < 0.0f;
            Path path = aVar.f2295g;
            int[] iArr = G5.a.f2287k;
            if (z8) {
                iArr[0] = 0;
                iArr[1] = aVar.f2294f;
                iArr[2] = aVar.f2293e;
                iArr[3] = aVar.f2292d;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f6, f9);
                path.close();
                float f10 = -i9;
                rectF.inset(f10, f10);
                iArr[0] = 0;
                iArr[1] = aVar.f2292d;
                iArr[2] = aVar.f2293e;
                iArr[3] = aVar.f2294f;
            }
            float fWidth = rectF.width() / 2.0f;
            if (fWidth <= 0.0f) {
                return;
            }
            float f11 = 1.0f - (i9 / fWidth);
            float[] fArr = G5.a.f2288l;
            fArr[1] = f11;
            fArr[2] = ((1.0f - f11) / 2.0f) + f11;
            RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP);
            Paint paint = aVar.f2290b;
            paint.setShader(radialGradient);
            canvas.save();
            canvas.concat(matrix);
            canvas.scale(1.0f, rectF.height() / rectF.width());
            if (!z8) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawPath(path, aVar.f2296h);
            }
            canvas.drawArc(rectF, f6, f9, true, paint);
            canvas.restore();
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class b extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f2504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f2505d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f2506e;

        public b(d dVar, float f6, float f9) {
            this.f2504c = dVar;
            this.f2505d = f6;
            this.f2506e = f9;
        }

        @Override // H5.o.f
        public final void a(Matrix matrix, G5.a aVar, int i9, Canvas canvas) {
            d dVar = this.f2504c;
            float f6 = dVar.f2515c;
            float f9 = this.f2506e;
            float f10 = dVar.f2514b;
            float f11 = this.f2505d;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f6 - f9, f10 - f11), 0.0f);
            Matrix matrix2 = this.f2518a;
            matrix2.set(matrix);
            matrix2.preTranslate(f11, f9);
            matrix2.preRotate(b());
            aVar.getClass();
            rectF.bottom += i9;
            rectF.offset(0.0f, -i9);
            int[] iArr = G5.a.f2286i;
            iArr[0] = aVar.f2294f;
            iArr[1] = aVar.f2293e;
            iArr[2] = aVar.f2292d;
            Paint paint = aVar.f2291c;
            float f12 = rectF.left;
            paint.setShader(new LinearGradient(f12, rectF.top, f12, rectF.bottom, iArr, G5.a.j, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix2);
            canvas.drawRect(rectF, paint);
            canvas.restore();
        }

        public final float b() {
            d dVar = this.f2504c;
            return (float) Math.toDegrees(Math.atan((dVar.f2515c - this.f2506e) / (dVar.f2514b - this.f2505d)));
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class c extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final RectF f2507h = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public final float f2508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public final float f2509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public final float f2510d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public final float f2511e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f2512f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f2513g;

        public c(float f6, float f9, float f10, float f11) {
            this.f2508b = f6;
            this.f2509c = f9;
            this.f2510d = f10;
            this.f2511e = f11;
        }

        @Override // H5.o.e
        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f2516a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f2507h;
            rectF.set(this.f2508b, this.f2509c, this.f2510d, this.f2511e);
            path.arcTo(rectF, this.f2512f, this.f2513g, false);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class d extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2515c;

        @Override // H5.o.e
        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f2516a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f2514b, this.f2515c);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f2516a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static abstract class f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Matrix f2517b = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f2518a = new Matrix();

        public abstract void a(Matrix matrix, G5.a aVar, int i9, Canvas canvas);
    }

    public o() {
        d(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public final void a(float f6) {
        float f9 = this.f2499e;
        if (f9 == f6) {
            return;
        }
        float f10 = ((f6 - f9) + 360.0f) % 360.0f;
        if (f10 > 180.0f) {
            return;
        }
        float f11 = this.f2497c;
        float f12 = this.f2498d;
        c cVar = new c(f11, f12, f11, f12);
        cVar.f2512f = this.f2499e;
        cVar.f2513g = f10;
        this.f2502h.add(new a(cVar));
        this.f2499e = f6;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f2501g;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((e) arrayList.get(i9)).a(matrix, path);
        }
    }

    public final void c(float f6, float f9) {
        d dVar = new d();
        dVar.f2514b = f6;
        dVar.f2515c = f9;
        this.f2501g.add(dVar);
        b bVar = new b(dVar, this.f2497c, this.f2498d);
        float fB = bVar.b() + 270.0f;
        float fB2 = bVar.b() + 270.0f;
        a(fB);
        this.f2502h.add(bVar);
        this.f2499e = fB2;
        this.f2497c = f6;
        this.f2498d = f9;
    }

    public final void d(float f6, float f9, float f10, float f11) {
        this.f2495a = f6;
        this.f2496b = f9;
        this.f2497c = f6;
        this.f2498d = f9;
        this.f2499e = f10;
        this.f2500f = (f10 + f11) % 360.0f;
        this.f2501g.clear();
        this.f2502h.clear();
    }
}
