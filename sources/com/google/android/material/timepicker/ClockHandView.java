package com.google.android.material.timepicker;

import T.G;
import T.L;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import cn.ikaile.ruoshui.client.R;
import com.google.android.material.internal.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ValueAnimator f13963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f13965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f13967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f13968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f13969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f13970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f13971i;
    public boolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f13972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13973l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13974m;

    public interface a {
        void a(float f6);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        this.f13963a = new ValueAnimator();
        this.f13965c = new ArrayList();
        Paint paint = new Paint();
        this.f13968f = paint;
        this.f13969g = new RectF();
        this.f13974m = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p103n5.a.f20595g, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        C5.c.c(context, R.attr.motionDurationLong2, 200);
        C5.c.d(context, R.attr.motionEasingEmphasizedInterpolator, p110o5.a.f20704b);
        this.f13973l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f13966d = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        Resources resources = getResources();
        this.f13970h = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f13967e = resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int a(int i9) {
        return i9 == 2 ? Math.round(this.f13973l * 0.66f) : this.f13973l;
    }

    public final void b(float f6) {
        ValueAnimator valueAnimator = this.f13963a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float f9 = f6 % 360.0f;
        this.f13971i = f9;
        this.f13972k = Math.toRadians(f9 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fA = a(this.f13974m);
        float fCos = (((float) Math.cos(this.f13972k)) * fA) + width;
        float fSin = (fA * ((float) Math.sin(this.f13972k))) + height;
        float f10 = this.f13966d;
        this.f13969g.set(fCos - f10, fSin - f10, fCos + f10, fSin + f10);
        Iterator it = this.f13965c.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(f9);
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int iA = a(this.f13974m);
        float f6 = width;
        float f9 = iA;
        float fCos = (((float) Math.cos(this.f13972k)) * f9) + f6;
        float f10 = height;
        float fSin = (f9 * ((float) Math.sin(this.f13972k))) + f10;
        Paint paint = this.f13968f;
        paint.setStrokeWidth(0.0f);
        int i9 = this.f13966d;
        canvas.drawCircle(fCos, fSin, i9, paint);
        double dSin = Math.sin(this.f13972k);
        double d9 = iA - i9;
        paint.setStrokeWidth(this.f13970h);
        canvas.drawLine(f6, f10, width + ((int) (Math.cos(this.f13972k) * d9)), height + ((int) (d9 * dSin)), paint);
        canvas.drawCircle(f6, f10, this.f13967e, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        if (this.f13963a.isRunning()) {
            return;
        }
        b(this.f13971i);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z8;
        boolean z9;
        int actionMasked = motionEvent.getActionMasked();
        float x8 = motionEvent.getX();
        float y8 = motionEvent.getY();
        boolean z10 = false;
        if (actionMasked == 0) {
            this.j = false;
            z8 = true;
            z9 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z9 = this.j;
            if (this.f13964b) {
                this.f13974m = ((float) Math.hypot((double) (x8 - ((float) (getWidth() / 2))), (double) (y8 - ((float) (getHeight() / 2))))) <= ((float) a(2)) + l.a(getContext(), 12) ? 2 : 1;
            }
            z8 = false;
        } else {
            z9 = false;
            z8 = false;
        }
        boolean z11 = this.j;
        int degrees = (int) Math.toDegrees(Math.atan2(y8 - (getHeight() / 2), x8 - (getWidth() / 2)));
        int i9 = degrees + 90;
        if (i9 < 0) {
            i9 = degrees + 450;
        }
        float f6 = i9;
        boolean z12 = this.f13971i != f6;
        if (z8 && z12) {
            z10 = true;
        } else if (z12 || z9) {
            b(f6);
            z10 = true;
        }
        this.j = z11 | z10;
        return true;
    }
}
