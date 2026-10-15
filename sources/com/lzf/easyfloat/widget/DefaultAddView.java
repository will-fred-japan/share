package com.lzf.easyfloat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: DefaultAddView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultAddView extends BaseSwitchView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f16349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f16350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f16351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f16352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Region f16353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Region f16354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f16355g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultAddView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        k.e(context, "context");
        this.f16350b = new Path();
        this.f16353e = new Region();
        this.f16354f = new Region();
        this.f16355g = 18.0f;
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#AA000000"));
        paint.setStrokeWidth(10.0f);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        p188x7.k kVar = p188x7.k.f22364a;
        this.f16349a = paint;
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Path path = this.f16350b;
        path.reset();
        float f6 = this.f16351c;
        float f9 = this.f16352d;
        float fMin = Math.min(f6, f9);
        float f10 = this.f16355g;
        path.addCircle(f6, f9, fMin - f10, Path.Direction.CW);
        Region region = this.f16354f;
        region.set((int) f10, (int) f10, (int) this.f16351c, (int) this.f16352d);
        this.f16353e.setPath(path, region);
        if (canvas != null) {
            Paint paint = this.f16349a;
            if (paint == null) {
                k.i("paint");
                throw null;
            }
            canvas.drawPath(path, paint);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        super.onSizeChanged(i9, i10, i11, i12);
        this.f16351c = i9;
        this.f16352d = i10;
    }
}
