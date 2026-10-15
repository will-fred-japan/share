package com.lzf.easyfloat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import kotlin.jvm.internal.k;
import p196y6.a;

/* JADX INFO: compiled from: DefaultCloseView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultCloseView extends BaseSwitchView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f16359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f16360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f16361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f16362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f16363h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Region f16364i;
    public final Region j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f16365k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        k.e(context, "context");
        this.f16356a = Color.parseColor("#99000000");
        this.f16357b = Color.parseColor("#99FF0000");
        this.f16360e = new Path();
        this.f16363h = new RectF();
        this.f16364i = new Region();
        this.j = new Region();
        this.f16365k = (int) ((4.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, a.f22393a, 0, 0);
            this.f16356a = typedArrayObtainStyledAttributes.getColor(2, this.f16356a);
            this.f16357b = typedArrayObtainStyledAttributes.getColor(1, this.f16357b);
            this.f16358c = typedArrayObtainStyledAttributes.getInt(0, this.f16358c);
            this.f16365k = typedArrayObtainStyledAttributes.getDimension(3, this.f16365k);
            typedArrayObtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        paint.setColor(this.f16356a);
        paint.setStrokeWidth(10.0f);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        p188x7.k kVar = p188x7.k.f22364a;
        this.f16359d = paint;
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Path path = this.f16360e;
        path.reset();
        Paint paint = this.f16359d;
        if (paint == null) {
            k.i("paint");
            throw null;
        }
        paint.setColor(this.f16356a);
        int i9 = this.f16358c;
        RectF rectF = this.f16363h;
        Region region = this.j;
        if (i9 == 0) {
            float paddingLeft = getPaddingLeft();
            float f6 = this.f16365k;
            float paddingRight = this.f16361f - getPaddingRight();
            float f9 = this.f16365k;
            rectF.set(paddingLeft + f6, f6, paddingRight - f9, (this.f16362g - f9) * 2);
            path.addOval(rectF, Path.Direction.CW);
            int paddingLeft2 = getPaddingLeft();
            float f10 = this.f16365k;
            region.set(paddingLeft2 + ((int) f10), (int) f10, (int) ((this.f16361f - getPaddingRight()) - this.f16365k), (int) this.f16362g);
        } else if (i9 == 1) {
            rectF.set(getPaddingLeft(), this.f16365k, this.f16361f - getPaddingRight(), this.f16362g);
            path.addRect(rectF, Path.Direction.CW);
            region.set(getPaddingLeft(), (int) this.f16365k, ((int) this.f16361f) - getPaddingRight(), (int) this.f16362g);
        } else if (i9 == 2) {
            float f11 = this.f16361f / 2;
            float f12 = this.f16362g;
            path.addCircle(f11, f12, f12 - this.f16365k, Path.Direction.CW);
            region.set(0, (int) this.f16365k, (int) this.f16361f, (int) this.f16362g);
        }
        this.f16364i.setPath(path, region);
        if (canvas != null) {
            Paint paint2 = this.f16359d;
            if (paint2 == null) {
                k.i("paint");
                throw null;
            }
            canvas.drawPath(path, paint2);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        super.onSizeChanged(i9, i10, i11, i12);
        this.f16361f = i9;
        this.f16362g = i10;
    }
}
