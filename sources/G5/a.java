package G5;

import android.graphics.Paint;
import android.graphics.Path;

/* JADX INFO: compiled from: ShadowRenderer.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f2286i = new int[3];
    public static final float[] j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f2287k = new int[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f2288l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f2289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f2290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f2291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f2295g = new Path();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f2296h;

    public a() {
        Paint paint = new Paint();
        this.f2296h = paint;
        Paint paint2 = new Paint();
        this.f2289a = paint2;
        this.f2292d = K.a.e(-16777216, 68);
        this.f2293e = K.a.e(-16777216, 20);
        this.f2294f = K.a.e(-16777216, 0);
        paint2.setColor(this.f2292d);
        paint.setColor(0);
        Paint paint3 = new Paint(4);
        this.f2290b = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f2291c = new Paint(paint3);
    }
}
