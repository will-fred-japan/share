package com.google.android.material.slider;

import H5.f;
import H5.k;
import T.G;
import T.L;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.SeekBar;
import cn.ikaile.ruoshui.client.R;
import com.google.android.material.internal.l;
import com.google.android.material.slider.BaseSlider;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import p142s2.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L, T> extends View {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f13648A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f13649B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f13650C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public ColorStateList f13651D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public ColorStateList f13652E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public ColorStateList f13653F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public ColorStateList f13654G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public ColorStateList f13655H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public Drawable f13656I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ArrayList f13657J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public float f13658K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public int f13659L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f13661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f13662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13668i;
    public int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13670l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13671m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13672n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public MotionEvent f13673o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f13674p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13675q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f13676r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList<Float> f13677s;
    public int t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13678u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f13679v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float[] f13680w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f13681x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f13682y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13683z;

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f13684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f13685b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<Float> f13686c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f13687d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f13688e;

        public class a implements Parcelable.Creator<SliderState> {
            @Override // android.os.Parcelable.Creator
            public final SliderState createFromParcel(Parcel parcel) {
                SliderState sliderState = new SliderState(parcel);
                sliderState.f13684a = parcel.readFloat();
                sliderState.f13685b = parcel.readFloat();
                ArrayList<Float> arrayList = new ArrayList<>();
                sliderState.f13686c = arrayList;
                parcel.readList(arrayList, Float.class.getClassLoader());
                sliderState.f13687d = parcel.readFloat();
                sliderState.f13688e = parcel.createBooleanArray()[0];
                return sliderState;
            }

            @Override // android.os.Parcelable.Creator
            public final SliderState[] newArray(int i9) {
                return new SliderState[i9];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeFloat(this.f13684a);
            parcel.writeFloat(this.f13685b);
            parcel.writeList(this.f13686c);
            parcel.writeFloat(this.f13687d);
            parcel.writeBooleanArray(new boolean[]{this.f13688e});
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseSlider.this.getClass();
            throw null;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            BaseSlider baseSlider = BaseSlider.this;
            ViewGroup viewGroupB = l.b(baseSlider);
            if (viewGroupB != null) {
                viewGroupB.getOverlay();
            }
            baseSlider.getClass();
            throw null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f13691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f13692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f13693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ c[] f13694d;

        /* JADX INFO: Fake field, exist only in values array */
        c EF0;

        static {
            c cVar = new c("BOTH", 0);
            c cVar2 = new c("LEFT", 1);
            f13691a = cVar2;
            c cVar3 = new c("RIGHT", 2);
            f13692b = cVar3;
            c cVar4 = new c("NONE", 3);
            f13693c = cVar4;
            f13694d = new c[]{cVar, cVar2, cVar3, cVar4};
        }

        public c() {
            throw null;
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f13694d.clone();
        }
    }

    private float[] getActiveRange() {
        float fFloatValue = this.f13677s.get(0).floatValue();
        ArrayList<Float> arrayList = this.f13677s;
        float fFloatValue2 = arrayList.get(arrayList.size() - 1).floatValue();
        if (this.f13677s.size() == 1) {
            fFloatValue = this.f13675q;
        }
        float fL = l(fFloatValue);
        float fL2 = l(fFloatValue2);
        return h() ? new float[]{fL2, fL} : new float[]{fL, fL2};
    }

    private float getValueOfTouchPosition() {
        double dRound;
        float f6 = this.f13658K;
        float f9 = this.f13679v;
        if (f9 > 0.0f) {
            int i9 = (int) ((this.f13676r - this.f13675q) / f9);
            dRound = ((double) Math.round(f6 * i9)) / ((double) i9);
        } else {
            dRound = f6;
        }
        if (h()) {
            dRound = 1.0d - dRound;
        }
        float f10 = this.f13676r;
        float f11 = this.f13675q;
        return (float) ((dRound * ((double) (f10 - f11))) + ((double) f11));
    }

    private float getValueOfTouchPositionAbsolute() {
        float f6 = this.f13658K;
        if (h()) {
            f6 = 1.0f - f6;
        }
        float f9 = this.f13676r;
        float f10 = this.f13675q;
        return ((f9 - f10) * f6) + f10;
    }

    private void setValuesInternal(ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.f13677s.size() == arrayList.size() && this.f13677s.equals(arrayList)) {
            return;
        }
        this.f13677s = arrayList;
        this.f13650C = true;
        this.f13678u = 0;
        o();
        throw null;
    }

    public final int a() {
        int i9 = this.f13663d;
        if (i9 == 1 || i9 == 3) {
            throw null;
        }
        return 0;
    }

    public final ValueAnimator b(boolean z8) {
        int iC;
        TimeInterpolator timeInterpolatorD;
        float fFloatValue = z8 ? 0.0f : 1.0f;
        ValueAnimator valueAnimator = z8 ? this.f13662c : this.f13661b;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, z8 ? 1.0f : 0.0f);
        if (z8) {
            iC = C5.c.c(getContext(), R.attr.motionDurationMedium4, 83);
            timeInterpolatorD = C5.c.d(getContext(), R.attr.motionEasingEmphasizedInterpolator, p110o5.a.f20707e);
        } else {
            iC = C5.c.c(getContext(), R.attr.motionDurationShort3, 117);
            timeInterpolatorD = C5.c.d(getContext(), R.attr.motionEasingEmphasizedAccelerateInterpolator, p110o5.a.f20705c);
        }
        valueAnimatorOfFloat.setDuration(iC);
        valueAnimatorOfFloat.setInterpolator(timeInterpolatorD);
        valueAnimatorOfFloat.addUpdateListener(new a());
        return valueAnimatorOfFloat;
    }

    public final void c(Canvas canvas, int i9, int i10, float f6, Drawable drawable) {
        canvas.save();
        canvas.translate(((int) (l(f6) * i9)) - (drawable.getBounds().width() / 2.0f), i10 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    public final void d() {
        if (this.f13660a) {
            this.f13660a = false;
            ValueAnimator valueAnimatorB = b(false);
            this.f13662c = valueAnimatorB;
            this.f13661b = null;
            valueAnimatorB.addListener(new b());
            this.f13662c.start();
        }
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        throw null;
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        e(this.f13655H);
        throw null;
    }

    public final void e(ColorStateList colorStateList) {
        colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public final boolean f(double d9) {
        double dDoubleValue = new BigDecimal(Double.toString(d9)).divide(new BigDecimal(Float.toString(this.f13679v)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    public final boolean g(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) != 3) {
            for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        throw null;
    }

    public int getActiveThumbIndex() {
        return this.t;
    }

    public int getFocusedThumbIndex() {
        return this.f13678u;
    }

    public int getHaloRadius() {
        return this.f13667h;
    }

    public ColorStateList getHaloTintList() {
        return this.f13651D;
    }

    public int getLabelBehavior() {
        return this.f13663d;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.f13679v;
    }

    public float getThumbElevation() {
        throw null;
    }

    public int getThumbHeight() {
        return this.f13666g;
    }

    public int getThumbRadius() {
        return this.f13665f / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        throw null;
    }

    public float getThumbStrokeWidth() {
        throw null;
    }

    public ColorStateList getThumbTintList() {
        throw null;
    }

    public int getThumbTrackGapSize() {
        return this.f13668i;
    }

    public int getThumbWidth() {
        return this.f13665f;
    }

    public int getTickActiveRadius() {
        return this.f13682y;
    }

    public ColorStateList getTickActiveTintList() {
        return this.f13652E;
    }

    public int getTickInactiveRadius() {
        return this.f13683z;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.f13653F;
    }

    public ColorStateList getTickTintList() {
        if (this.f13653F.equals(this.f13652E)) {
            return this.f13652E;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.f13654G;
    }

    public int getTrackHeight() {
        return this.f13664e;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.f13655H;
    }

    public int getTrackInsideCornerSize() {
        return this.f13671m;
    }

    public int getTrackSidePadding() {
        return 0;
    }

    public int getTrackStopIndicatorSize() {
        return this.f13670l;
    }

    public ColorStateList getTrackTintList() {
        if (this.f13655H.equals(this.f13654G)) {
            return this.f13654G;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.f13648A;
    }

    public float getValueFrom() {
        return this.f13675q;
    }

    public float getValueTo() {
        return this.f13676r;
    }

    public List<Float> getValues() {
        return new ArrayList(this.f13677s);
    }

    public final boolean h() {
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        return getLayoutDirection() == 1;
    }

    public final void i() {
        if (this.f13679v <= 0.0f) {
            return;
        }
        p();
        int iMin = Math.min((int) (((this.f13676r - this.f13675q) / this.f13679v) + 1.0f), (this.f13648A / 0) + 1);
        if (this.f13680w.length != iMin * 2) {
            this.f13680w = new float[iMin * 2];
        }
        float f6 = this.f13648A / (iMin - 1);
        for (int i9 = 0; i9 < iMin * 2; i9 += 2) {
            float[] fArr = this.f13680w;
            float f9 = 0;
            fArr[i9] = ((i9 / 2.0f) * f6) + f9;
            a();
            fArr[i9 + 1] = f9;
        }
    }

    public final boolean j(int i9) {
        int i10 = this.f13678u;
        long j = ((long) i10) + ((long) i9);
        long size = this.f13677s.size() - 1;
        if (j < 0) {
            j = 0;
        } else if (j > size) {
            j = size;
        }
        int i11 = (int) j;
        this.f13678u = i11;
        if (i11 == i10) {
            return false;
        }
        if (this.t != -1) {
            this.t = i11;
        }
        o();
        postInvalidate();
        return true;
    }

    public final void k(int i9) {
        if (h()) {
            i9 = i9 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i9;
        }
        j(i9);
    }

    public final float l(float f6) {
        float f9 = this.f13675q;
        float f10 = (f6 - f9) / (this.f13676r - f9);
        return h() ? 1.0f - f10 : f10;
    }

    public boolean m() {
        if (this.t != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float fR = r(valueOfTouchPositionAbsolute);
        this.t = 0;
        float fAbs = Math.abs(this.f13677s.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i9 = 1; i9 < this.f13677s.size(); i9++) {
            float fAbs2 = Math.abs(this.f13677s.get(i9).floatValue() - valueOfTouchPositionAbsolute);
            float fR2 = r(this.f13677s.get(i9).floatValue());
            if (Float.compare(fAbs2, fAbs) > 0) {
                break;
            }
            boolean z8 = !h() ? fR2 - fR >= 0.0f : fR2 - fR <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.t = i9;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fR2 - fR) < 0) {
                        this.t = -1;
                        return false;
                    }
                    if (z8) {
                        this.t = i9;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.t != -1;
    }

    public final void n(float f6) {
        int i9 = this.t;
        this.f13678u = i9;
        if (Math.abs(f6 - this.f13677s.get(i9).floatValue()) < 1.0E-4d) {
            return;
        }
        float minSeparation = getMinSeparation();
        if (this.f13659L == 0) {
            if (minSeparation == 0.0f) {
                minSeparation = 0.0f;
            } else {
                float f9 = (minSeparation - 0) / this.f13648A;
                float f10 = this.f13675q;
                minSeparation = ((f10 - this.f13676r) * f9) + f10;
            }
        }
        if (h()) {
            minSeparation = -minSeparation;
        }
        int i10 = i9 + 1;
        int i11 = i9 - 1;
        this.f13677s.set(i9, Float.valueOf(p027d5.a.m(f6, i11 < 0 ? this.f13675q : minSeparation + this.f13677s.get(i11).floatValue(), i10 >= this.f13677s.size() ? this.f13676r : this.f13677s.get(i10).floatValue() - minSeparation)));
        throw null;
    }

    public final void o() {
        if (!(getBackground() instanceof RippleDrawable) || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iL = (int) ((l(this.f13677s.get(this.f13678u).floatValue()) * this.f13648A) + 0);
            a();
            int i9 = this.f13667h;
            background.setHotspotBounds(iL - i9, 0 - i9, iL + i9, i9);
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(null);
        throw null;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.f13660a = false;
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:142:0x010e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x010b A[LOOP:0: B:36:0x00a5->B:56:0x010b, LOOP_END] */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i9;
        float f6;
        BaseSlider<S, L, T> baseSlider = this;
        Canvas canvas2 = canvas;
        if (baseSlider.f13650C) {
            baseSlider.p();
            baseSlider.i();
        }
        super.onDraw(canvas);
        baseSlider.a();
        float fFloatValue = baseSlider.f13677s.get(0).floatValue();
        ArrayList<Float> arrayList = baseSlider.f13677s;
        float fFloatValue2 = arrayList.get(arrayList.size() - 1).floatValue();
        if (fFloatValue2 < baseSlider.f13676r || (baseSlider.f13677s.size() > 1 && fFloatValue > baseSlider.f13675q)) {
            int i10 = baseSlider.f13648A;
            float[] activeRange = baseSlider.getActiveRange();
            float f9 = 0;
            float f10 = i10;
            if ((activeRange[1] * f10) + f9 < i10) {
                if (baseSlider.f13668i > 0) {
                    throw null;
                }
                Paint.Style style = Paint.Style.STROKE;
                throw null;
            }
            if ((activeRange[0] * f10) + f9 > f9) {
                if (baseSlider.f13668i > 0) {
                    throw null;
                }
                Paint.Style style2 = Paint.Style.STROKE;
                throw null;
            }
        }
        if (fFloatValue2 > baseSlider.f13675q) {
            int i11 = baseSlider.f13648A;
            float[] activeRange2 = baseSlider.getActiveRange();
            float f11 = 0;
            float f12 = i11;
            float fR = (activeRange2[1] * f12) + f11;
            float fR2 = (activeRange2[0] * f12) + f11;
            if (baseSlider.f13668i <= 0) {
                Paint.Style style3 = Paint.Style.STROKE;
                throw null;
            }
            c cVar = c.f13693c;
            if (baseSlider.f13677s.size() == 1) {
                cVar = baseSlider.h() ? c.f13692b : c.f13691a;
            }
            for (int i12 = 0; i12 < baseSlider.f13677s.size(); i12++) {
                if (baseSlider.f13677s.size() > 1) {
                    if (i12 > 0) {
                        fR2 = baseSlider.r(baseSlider.f13677s.get(i12 - 1).floatValue());
                    }
                    fR = baseSlider.r(baseSlider.f13677s.get(i12).floatValue());
                    if (baseSlider.h()) {
                        fR = fR2;
                        fR2 = fR;
                    }
                }
                int iOrdinal = cVar.ordinal();
                if (iOrdinal != 1) {
                    if (iOrdinal == 2) {
                        fR2 += baseSlider.f13668i;
                        fR = (baseSlider.f13664e / 2.0f) + fR;
                    } else if (iOrdinal == 3) {
                        f6 = baseSlider.f13668i;
                        fR2 += f6;
                    }
                    if (fR2 >= fR) {
                        throw null;
                    }
                } else {
                    fR2 -= baseSlider.f13664e / 2.0f;
                    f6 = baseSlider.f13668i;
                }
                fR -= f6;
                if (fR2 >= fR) {
                    throw null;
                }
            }
        }
        if (baseSlider.f13681x && baseSlider.f13679v > 0.0f) {
            float[] activeRange3 = baseSlider.getActiveRange();
            int iCeil = (int) Math.ceil(((baseSlider.f13680w.length / 2.0f) - 1.0f) * activeRange3[0]);
            int iFloor = (int) Math.floor(((baseSlider.f13680w.length / 2.0f) - 1.0f) * activeRange3[1]);
            if (iCeil > 0) {
                canvas2.drawPoints(baseSlider.f13680w, 0, iCeil * 2, null);
            }
            if (iCeil <= iFloor) {
                canvas2.drawPoints(baseSlider.f13680w, iCeil * 2, ((iFloor - iCeil) + 1) * 2, null);
            }
            int i13 = (iFloor + 1) * 2;
            float[] fArr = baseSlider.f13680w;
            if (i13 < fArr.length) {
                canvas2.drawPoints(fArr, i13, fArr.length - i13, null);
            }
        }
        int i14 = 0;
        if (baseSlider.f13670l > 0) {
            if (baseSlider.f13677s.size() >= 1) {
                ArrayList<Float> arrayList2 = baseSlider.f13677s;
                float fFloatValue3 = arrayList2.get(arrayList2.size() - 1).floatValue();
                float f13 = baseSlider.f13676r;
                if (fFloatValue3 < f13) {
                    canvas2.drawPoint(baseSlider.r(f13), 0, null);
                }
            }
            if (baseSlider.f13677s.size() > 1) {
                float fFloatValue4 = baseSlider.f13677s.get(0).floatValue();
                float f14 = baseSlider.f13675q;
                if (fFloatValue4 > f14) {
                    canvas2.drawPoint(baseSlider.r(f14), 0, null);
                }
            }
        }
        if ((baseSlider.f13674p || baseSlider.isFocused()) && baseSlider.isEnabled()) {
            int i15 = baseSlider.f13648A;
            if (!(baseSlider.getBackground() instanceof RippleDrawable)) {
                float f15 = 0;
                int iL = (int) ((baseSlider.l(baseSlider.f13677s.get(baseSlider.f13678u).floatValue()) * i15) + f15);
                if (Build.VERSION.SDK_INT < 28) {
                    int i16 = baseSlider.f13667h;
                    canvas2.clipRect(iL - i16, 0 - i16, iL + i16, i16, Region.Op.UNION);
                }
                canvas2.drawCircle(iL, f15, baseSlider.f13667h, null);
            }
        }
        int i17 = baseSlider.f13663d;
        if (i17 == 0 || i17 == 1) {
            if (baseSlider.t != -1 && baseSlider.isEnabled()) {
                if (baseSlider.f13660a) {
                    throw null;
                }
                baseSlider.f13660a = true;
                ValueAnimator valueAnimatorB = baseSlider.b(true);
                baseSlider.f13661b = valueAnimatorB;
                baseSlider.f13662c = null;
                valueAnimatorB.start();
                throw null;
            }
            baseSlider.d();
        } else if (i17 == 2) {
            baseSlider.d();
        } else {
            if (i17 != 3) {
                throw new IllegalArgumentException("Unexpected labelBehavior: " + baseSlider.f13663d);
            }
            if (baseSlider.isEnabled()) {
                Rect rect = new Rect();
                l.b(baseSlider).getHitRect(rect);
                if (baseSlider.getLocalVisibleRect(rect)) {
                    if (baseSlider.f13660a) {
                        throw null;
                    }
                    baseSlider.f13660a = true;
                    ValueAnimator valueAnimatorB2 = baseSlider.b(true);
                    baseSlider.f13661b = valueAnimatorB2;
                    baseSlider.f13662c = null;
                    valueAnimatorB2.start();
                    throw null;
                }
            }
            baseSlider.d();
        }
        int i18 = baseSlider.f13648A;
        int i19 = 0;
        while (i19 < baseSlider.f13677s.size()) {
            float fFloatValue5 = baseSlider.f13677s.get(i19).floatValue();
            Drawable drawable = baseSlider.f13656I;
            if (drawable != null) {
                i9 = i14;
                baseSlider.c(canvas2, i18, i9, fFloatValue5, drawable);
            } else {
                i9 = i14;
                if (i19 < baseSlider.f13657J.size()) {
                    baseSlider.c(canvas, i18, i9, fFloatValue5, (Drawable) baseSlider.f13657J.get(i19));
                } else {
                    if (!baseSlider.isEnabled()) {
                        float f16 = 0;
                        canvas.drawCircle((baseSlider.l(fFloatValue5) * i18) + f16, f16, baseSlider.getThumbRadius(), null);
                    }
                    baseSlider.c(canvas, i18, i9, fFloatValue5, null);
                }
            }
            i19++;
            baseSlider = this;
            canvas2 = canvas;
            i14 = i9;
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z8, int i9, Rect rect) {
        super.onFocusChanged(z8, i9, rect);
        if (!z8) {
            this.t = -1;
            throw null;
        }
        if (i9 == 1) {
            j(Integer.MAX_VALUE);
            throw null;
        }
        if (i9 == 2) {
            j(Integer.MIN_VALUE);
            throw null;
        }
        if (i9 == 17) {
            k(Integer.MAX_VALUE);
            throw null;
        }
        if (i9 != 66) {
            throw null;
        }
        k(Integer.MIN_VALUE);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0047  */
    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i9, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i9, keyEvent);
        }
        if (this.f13677s.size() == 1) {
            this.t = 0;
        }
        Float fValueOf = null;
        Boolean boolValueOf = null;
        if (this.t == -1) {
            if (i9 != 61) {
                if (i9 == 66) {
                    this.t = this.f13678u;
                    postInvalidate();
                    boolValueOf = Boolean.TRUE;
                } else if (i9 == 81) {
                    j(1);
                    boolValueOf = Boolean.TRUE;
                } else if (i9 == 69) {
                    j(-1);
                    boolValueOf = Boolean.TRUE;
                } else if (i9 != 70) {
                    switch (i9) {
                        case 21:
                            k(-1);
                            boolValueOf = Boolean.TRUE;
                            break;
                        case 22:
                            k(1);
                            boolValueOf = Boolean.TRUE;
                            break;
                        case 23:
                            this.t = this.f13678u;
                            postInvalidate();
                            boolValueOf = Boolean.TRUE;
                            break;
                    }
                } else {
                    j(1);
                    boolValueOf = Boolean.TRUE;
                }
            } else if (keyEvent.hasNoModifiers()) {
                boolValueOf = Boolean.valueOf(j(1));
            } else {
                boolValueOf = keyEvent.isShiftPressed() ? Boolean.valueOf(j(-1)) : Boolean.FALSE;
            }
            return boolValueOf != null ? boolValueOf.booleanValue() : super.onKeyDown(i9, keyEvent);
        }
        boolean zIsLongPress = this.f13649B | keyEvent.isLongPress();
        this.f13649B = zIsLongPress;
        float fRound = 1.0f;
        if (zIsLongPress) {
            float f6 = this.f13679v;
            fRound = f6 != 0.0f ? f6 : 1.0f;
            float f9 = (this.f13676r - this.f13675q) / fRound;
            float f10 = 20;
            if (f9 > f10) {
                fRound *= Math.round(f9 / f10);
            }
        } else {
            float f11 = this.f13679v;
            if (f11 != 0.0f) {
                fRound = f11;
            }
        }
        if (i9 == 21) {
            if (!h()) {
                fRound = -fRound;
            }
            fValueOf = Float.valueOf(fRound);
        } else if (i9 == 22) {
            if (h()) {
                fRound = -fRound;
            }
            fValueOf = Float.valueOf(fRound);
        } else if (i9 == 69) {
            fValueOf = Float.valueOf(-fRound);
        } else if (i9 == 70 || i9 == 81) {
            fValueOf = Float.valueOf(fRound);
        }
        if (fValueOf != null) {
            n(fValueOf.floatValue() + this.f13677s.get(this.t).floatValue());
            return true;
        }
        if (i9 != 23) {
            if (i9 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return j(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return j(-1);
                }
                return false;
            }
            if (i9 != 66) {
                return super.onKeyDown(i9, keyEvent);
            }
        }
        this.t = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i9, KeyEvent keyEvent) {
        this.f13649B = false;
        return super.onKeyUp(i9, keyEvent);
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        int i11 = this.f13663d;
        if (i11 == 1 || i11 == 3) {
            throw null;
        }
        super.onMeasure(i9, View.MeasureSpec.makeMeasureSpec(0, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.f13675q = sliderState.f13684a;
        this.f13676r = sliderState.f13685b;
        setValuesInternal(sliderState.f13686c);
        this.f13679v = sliderState.f13687d;
        if (sliderState.f13688e) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f13684a = this.f13675q;
        sliderState.f13685b = this.f13676r;
        sliderState.f13686c = new ArrayList<>(this.f13677s);
        sliderState.f13687d = this.f13679v;
        sliderState.f13688e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        this.f13648A = Math.max(i9, 0);
        i();
        o();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cd  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        int i9;
        if (isEnabled()) {
            float x8 = motionEvent.getX();
            float f6 = 0;
            float f9 = (x8 - f6) / this.f13648A;
            this.f13658K = f9;
            float fMax = Math.max(0.0f, f9);
            this.f13658K = fMax;
            this.f13658K = Math.min(1.0f, fMax);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f13672n = x8;
                if (!g(motionEvent)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (m()) {
                        requestFocus();
                        this.f13674p = true;
                        n(getValueOfTouchPosition());
                        o();
                        int i10 = this.f13668i;
                        if (i10 > 0) {
                            int i11 = this.f13665f;
                            this.j = i11;
                            this.f13669k = i10;
                            int iRound = Math.round(i11 * 0.5f);
                            int i12 = this.f13665f - iRound;
                            setThumbWidth(iRound);
                            setThumbTrackGapSize(this.f13668i - (i12 / 2));
                        }
                        invalidate();
                        throw null;
                    }
                }
            } else if (actionMasked == 1) {
                this.f13674p = false;
                motionEvent2 = this.f13673o;
                if (motionEvent2 == null && motionEvent2.getActionMasked() == 0 && Math.abs(this.f13673o.getX() - motionEvent.getX()) <= f6 && Math.abs(this.f13673o.getY() - motionEvent.getY()) <= f6 && m()) {
                    throw null;
                }
                if (this.t != -1) {
                    n(getValueOfTouchPosition());
                    o();
                    if (this.f13668i > 0 && (i9 = this.j) != -1 && this.f13669k != -1) {
                        setThumbWidth(i9);
                        setThumbTrackGapSize(this.f13669k);
                    }
                    this.t = -1;
                    throw null;
                }
                invalidate();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    this.f13674p = false;
                    motionEvent2 = this.f13673o;
                    if (motionEvent2 == null) {
                    }
                    if (this.t != -1) {
                        n(getValueOfTouchPosition());
                        o();
                        if (this.f13668i > 0) {
                            setThumbWidth(i9);
                            setThumbTrackGapSize(this.f13669k);
                        }
                        this.t = -1;
                        throw null;
                    }
                    invalidate();
                }
            } else if (this.f13674p) {
                if (m()) {
                    this.f13674p = true;
                    n(getValueOfTouchPosition());
                    o();
                    invalidate();
                }
            } else if (!g(motionEvent) || Math.abs(x8 - this.f13672n) >= f6) {
                getParent().requestDisallowInterceptTouchEvent(true);
                throw null;
            }
            setPressed(this.f13674p);
            this.f13673o = MotionEvent.obtain(motionEvent);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i9) {
        A1.b bVar;
        super.onVisibilityChanged(view, i9);
        if (i9 != 0) {
            ViewGroup viewGroupB = l.b(this);
            if (viewGroupB == null) {
                bVar = null;
            } else {
                bVar = new A1.b();
                viewGroupB.getOverlay();
            }
            if (bVar != null) {
                throw null;
            }
        }
    }

    public final void p() {
        if (this.f13650C) {
            float f6 = this.f13675q;
            float f9 = this.f13676r;
            if (f6 >= f9) {
                throw new IllegalStateException("valueFrom(" + this.f13675q + ") must be smaller than valueTo(" + this.f13676r + ")");
            }
            if (f9 <= f6) {
                throw new IllegalStateException("valueTo(" + this.f13676r + ") must be greater than valueFrom(" + this.f13675q + ")");
            }
            if (this.f13679v > 0.0f && !q(f9)) {
                throw new IllegalStateException("The stepSize(" + this.f13679v + ") must be 0, or a factor of the valueFrom(" + this.f13675q + ")-valueTo(" + this.f13676r + ") range");
            }
            for (Float f10 : this.f13677s) {
                if (f10.floatValue() < this.f13675q || f10.floatValue() > this.f13676r) {
                    throw new IllegalStateException("Slider value(" + f10 + ") must be greater or equal to valueFrom(" + this.f13675q + "), and lower or equal to valueTo(" + this.f13676r + ")");
                }
                if (this.f13679v > 0.0f && !q(f10.floatValue())) {
                    float f11 = this.f13675q;
                    float f12 = this.f13679v;
                    throw new IllegalStateException("Value(" + f10 + ") must be equal to valueFrom(" + f11 + ") plus a multiple of stepSize(" + f12 + ") when using stepSize(" + f12 + ")");
                }
            }
            float minSeparation = getMinSeparation();
            if (minSeparation < 0.0f) {
                throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal to 0");
            }
            float f13 = this.f13679v;
            if (f13 > 0.0f && minSeparation > 0.0f) {
                if (this.f13659L != 1) {
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") cannot be set as a dimension when using stepSize(" + this.f13679v + ")");
                }
                if (minSeparation < f13 || !f(minSeparation)) {
                    float f14 = this.f13679v;
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal and a multiple of stepSize(" + f14 + ") when using stepSize(" + f14 + ")");
                }
            }
            float f15 = this.f13679v;
            if (f15 != 0.0f) {
                if (((int) f15) != f15) {
                    Log.w("BaseSlider", "Floating point value used for stepSize(" + f15 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f16 = this.f13675q;
                if (((int) f16) != f16) {
                    Log.w("BaseSlider", "Floating point value used for valueFrom(" + f16 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f17 = this.f13676r;
                if (((int) f17) != f17) {
                    Log.w("BaseSlider", "Floating point value used for valueTo(" + f17 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
            }
            this.f13650C = false;
        }
    }

    public final boolean q(float f6) {
        return f(new BigDecimal(Float.toString(f6)).subtract(new BigDecimal(Float.toString(this.f13675q)), MathContext.DECIMAL64).doubleValue());
    }

    public final float r(float f6) {
        return (l(f6) * this.f13648A) + 0;
    }

    public void setActiveThumbIndex(int i9) {
        this.t = i9;
    }

    public void setCustomThumbDrawable(int i9) {
        setCustomThumbDrawable(getResources().getDrawable(i9));
    }

    public void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i9 = 0; i9 < iArr.length; i9++) {
            drawableArr[i9] = getResources().getDrawable(iArr[i9]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z8) {
        super.setEnabled(z8);
        setLayerType(z8 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i9) {
        if (i9 < 0 || i9 >= this.f13677s.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.f13678u = i9;
        throw null;
    }

    public void setHaloRadius(int i9) {
        if (i9 == this.f13667h) {
            return;
        }
        this.f13667h = i9;
        Drawable background = getBackground();
        if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setRadius(this.f13667h);
        } else {
            postInvalidate();
        }
    }

    public void setHaloRadiusResource(int i9) {
        setHaloRadius(getResources().getDimensionPixelSize(i9));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f13651D)) {
            return;
        }
        this.f13651D = colorStateList;
        Drawable background = getBackground();
        if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
        } else {
            e(colorStateList);
            throw null;
        }
    }

    public void setLabelBehavior(int i9) {
        if (this.f13663d != i9) {
            this.f13663d = i9;
            requestLayout();
        }
    }

    public void setSeparationUnit(int i9) {
        this.f13659L = i9;
        this.f13650C = true;
        postInvalidate();
    }

    public void setStepSize(float f6) {
        if (f6 >= 0.0f) {
            if (this.f13679v != f6) {
                this.f13679v = f6;
                this.f13650C = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The stepSize(" + f6 + ") must be 0, or a factor of the valueFrom(" + this.f13675q + ")-valueTo(" + this.f13676r + ") range");
    }

    public void setThumbElevation(float f6) {
        throw null;
    }

    public void setThumbElevationResource(int i9) {
        setThumbElevation(getResources().getDimension(i9));
    }

    public void setThumbHeight(int i9) {
        if (i9 == this.f13666g) {
            return;
        }
        this.f13666g = i9;
        throw null;
    }

    public void setThumbHeightResource(int i9) {
        setThumbHeight(getResources().getDimensionPixelSize(i9));
    }

    public void setThumbRadius(int i9) {
        int i10 = i9 * 2;
        setThumbWidth(i10);
        setThumbHeight(i10);
    }

    public void setThumbRadiusResource(int i9) {
        setThumbRadius(getResources().getDimensionPixelSize(i9));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setThumbStrokeColorResource(int i9) {
        if (i9 != 0) {
            setThumbStrokeColor(I.a.b(getContext(), i9));
        }
    }

    public void setThumbStrokeWidth(float f6) {
        throw null;
    }

    public void setThumbStrokeWidthResource(int i9) {
        if (i9 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i9));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        throw null;
    }

    public void setThumbTrackGapSize(int i9) {
        if (this.f13668i == i9) {
            return;
        }
        this.f13668i = i9;
        invalidate();
    }

    public void setThumbWidth(int i9) {
        if (i9 == this.f13665f) {
            return;
        }
        this.f13665f = i9;
        new k();
        new k();
        new k();
        new k();
        new f();
        new f();
        new f();
        new f();
        A1.b bVarT = j.t(0);
        H5.l.a.b(bVarT);
        H5.l.a.b(bVarT);
        H5.l.a.b(bVarT);
        H5.l.a.b(bVarT);
        throw null;
    }

    public void setThumbWidthResource(int i9) {
        setThumbWidth(getResources().getDimensionPixelSize(i9));
    }

    public void setTickActiveRadius(int i9) {
        if (this.f13682y == i9) {
            return;
        }
        this.f13682y = i9;
        throw null;
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f13652E)) {
            return;
        }
        this.f13652E = colorStateList;
        e(colorStateList);
        throw null;
    }

    public void setTickInactiveRadius(int i9) {
        if (this.f13683z == i9) {
            return;
        }
        this.f13683z = i9;
        throw null;
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f13653F)) {
            return;
        }
        this.f13653F = colorStateList;
        e(colorStateList);
        throw null;
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z8) {
        if (this.f13681x != z8) {
            this.f13681x = z8;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f13654G)) {
            return;
        }
        this.f13654G = colorStateList;
        e(colorStateList);
        throw null;
    }

    public void setTrackHeight(int i9) {
        if (this.f13664e == i9) {
            return;
        }
        this.f13664e = i9;
        throw null;
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f13655H)) {
            return;
        }
        this.f13655H = colorStateList;
        e(colorStateList);
        throw null;
    }

    public void setTrackInsideCornerSize(int i9) {
        if (this.f13671m == i9) {
            return;
        }
        this.f13671m = i9;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i9) {
        if (this.f13670l == i9) {
            return;
        }
        this.f13670l = i9;
        throw null;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f6) {
        this.f13675q = f6;
        this.f13650C = true;
        postInvalidate();
    }

    public void setValueTo(float f6) {
        this.f13676r = f6;
        this.f13650C = true;
        postInvalidate();
    }

    public void setValues(Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public void setCustomThumbDrawable(Drawable drawable) {
        Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        int intrinsicWidth = drawableNewDrawable.getIntrinsicWidth();
        int intrinsicHeight = drawableNewDrawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawableNewDrawable.setBounds(0, 0, this.f13665f, this.f13666g);
        } else {
            float fMax = Math.max(this.f13665f, this.f13666g) / Math.max(intrinsicWidth, intrinsicHeight);
            drawableNewDrawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
        this.f13656I = drawableNewDrawable;
        this.f13657J.clear();
        postInvalidate();
    }

    public void setValues(List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }

    public void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.f13656I = null;
        this.f13657J = new ArrayList();
        for (Drawable drawable : drawableArr) {
            ArrayList arrayList = this.f13657J;
            Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
            int intrinsicWidth = drawableNewDrawable.getIntrinsicWidth();
            int intrinsicHeight = drawableNewDrawable.getIntrinsicHeight();
            if (intrinsicWidth == -1 && intrinsicHeight == -1) {
                drawableNewDrawable.setBounds(0, 0, this.f13665f, this.f13666g);
            } else {
                float fMax = Math.max(this.f13665f, this.f13666g) / Math.max(intrinsicWidth, intrinsicHeight);
                drawableNewDrawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
            }
            arrayList.add(drawableNewDrawable);
        }
        postInvalidate();
    }

    public void setLabelFormatter(com.google.android.material.slider.a aVar) {
    }
}
