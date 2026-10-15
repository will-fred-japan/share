package com.google.android.material.timepicker;

import T.G;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import cn.ikaile.ruoshui.client.R;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends c implements ClockHandView.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final b f13948A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final int[] f13949B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final float[] f13950C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final int f13951D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final int f13952E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final int f13953F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final int f13954G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final String[] f13955H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public float f13956I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ColorStateList f13957J;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ClockHandView f13958v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f13959w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final RectF f13960x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f13961y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final SparseArray<TextView> f13962z;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        this.f13959w = new Rect();
        this.f13960x = new RectF();
        this.f13961y = new Rect();
        SparseArray<TextView> sparseArray = new SparseArray<>();
        this.f13962z = sparseArray;
        this.f13950C = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p103n5.a.f20594f, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListA = E5.c.a(context, typedArrayObtainStyledAttributes, 1);
        this.f13957J = colorStateListA;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f13958v = clockHandView;
        this.f13951D = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateListA.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.f13949B = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.f13965c.add(this);
        int defaultColor = I.a.b(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListA2 = E5.c.a(context, typedArrayObtainStyledAttributes, 0);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a(this));
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.f13948A = new b(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.f13955H = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z8 = false;
        for (int i9 = 0; i9 < Math.max(this.f13955H.length, size); i9++) {
            TextView textView = sparseArray.get(i9);
            if (i9 >= this.f13955H.length) {
                removeView(textView);
                sparseArray.remove(i9);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i9, textView);
                    addView(textView);
                }
                textView.setText(this.f13955H[i9]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i9));
                int i10 = (i9 / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i10));
                z8 = i10 > 1 ? true : z8;
                G.m(textView, this.f13948A);
                textView.setTextColor(this.f13957J);
            }
        }
        ClockHandView clockHandView2 = this.f13958v;
        if (clockHandView2.f13964b && !z8) {
            clockHandView2.f13974m = 1;
        }
        clockHandView2.f13964b = z8;
        clockHandView2.invalidate();
        this.f13952E = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.f13953F = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.f13954G = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.a
    public final void a(float f6) {
        if (Math.abs(this.f13956I - f6) > 0.001f) {
            this.f13956I = f6;
            j();
        }
    }

    @Override // com.google.android.material.timepicker.c
    public final void i() {
        super.i();
        int i9 = 0;
        while (true) {
            SparseArray<TextView> sparseArray = this.f13962z;
            if (i9 >= sparseArray.size()) {
                return;
            }
            sparseArray.get(i9).setVisibility(0);
            i9++;
        }
    }

    public final void j() {
        SparseArray<TextView> sparseArray;
        RectF rectF;
        Rect rect;
        RectF rectF2 = this.f13958v.f13969g;
        float f6 = Float.MAX_VALUE;
        TextView textView = null;
        int i9 = 0;
        while (true) {
            sparseArray = this.f13962z;
            int size = sparseArray.size();
            rectF = this.f13960x;
            rect = this.f13959w;
            if (i9 >= size) {
                break;
            }
            TextView textView2 = sparseArray.get(i9);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float fHeight = rectF.height() * rectF.width();
                if (fHeight < f6) {
                    textView = textView2;
                    f6 = fHeight;
                }
            }
            i9++;
        }
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            TextView textView3 = sparseArray.get(i10);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                Rect rect2 = this.f13961y;
                textView3.getLineBounds(0, rect2);
                rectF.inset(rect2.left, rect2.top);
                textView3.getPaint().setShader(RectF.intersects(rectF2, rectF) ? new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.f13949B, this.f13950C, Shader.TileMode.CLAMP) : null);
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.f13955H.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        j();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.f13954G / Math.max(Math.max(this.f13952E / displayMetrics.heightPixels, this.f13953F / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
