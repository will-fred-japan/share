package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: renamed from: androidx.appcompat.widget.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatSeekBarHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0501m extends C0499k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatSeekBar f6627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f6628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorStateList f6629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f6630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6632i;

    public C0501m(AppCompatSeekBar appCompatSeekBar) {
        super(appCompatSeekBar);
        this.f6629f = null;
        this.f6630g = null;
        this.f6631h = false;
        this.f6632i = false;
        this.f6627d = appCompatSeekBar;
    }

    @Override // androidx.appcompat.widget.C0499k
    public final void a(AttributeSet attributeSet, int i9) {
        super.a(attributeSet, R.attr.seekBarStyle);
        AppCompatSeekBar appCompatSeekBar = this.f6627d;
        Context context = appCompatSeekBar.getContext();
        int[] iArr = p059i.a.f19180g;
        K kE = K.e(context, attributeSet, iArr, R.attr.seekBarStyle);
        T.G.l(appCompatSeekBar, appCompatSeekBar.getContext(), iArr, attributeSet, kE.f6420b, R.attr.seekBarStyle);
        Drawable drawableC = kE.c(0);
        if (drawableC != null) {
            appCompatSeekBar.setThumb(drawableC);
        }
        Drawable drawableB = kE.b(1);
        Drawable drawable = this.f6628e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f6628e = drawableB;
        if (drawableB != null) {
            drawableB.setCallback(appCompatSeekBar);
            drawableB.setLayoutDirection(appCompatSeekBar.getLayoutDirection());
            if (drawableB.isStateful()) {
                drawableB.setState(appCompatSeekBar.getDrawableState());
            }
            c();
        }
        appCompatSeekBar.invalidate();
        TypedArray typedArray = kE.f6420b;
        if (typedArray.hasValue(3)) {
            this.f6630g = u.c(typedArray.getInt(3, -1), this.f6630g);
            this.f6632i = true;
        }
        if (typedArray.hasValue(2)) {
            this.f6629f = kE.a(2);
            this.f6631h = true;
        }
        kE.f();
        c();
    }

    public final void c() {
        Drawable drawable = this.f6628e;
        if (drawable != null) {
            if (this.f6631h || this.f6632i) {
                Drawable drawableMutate = drawable.mutate();
                this.f6628e = drawableMutate;
                if (this.f6631h) {
                    drawableMutate.setTintList(this.f6629f);
                }
                if (this.f6632i) {
                    this.f6628e.setTintMode(this.f6630g);
                }
                if (this.f6628e.isStateful()) {
                    this.f6628e.setState(this.f6627d.getDrawableState());
                }
            }
        }
    }

    public final void d(Canvas canvas) {
        if (this.f6628e != null) {
            AppCompatSeekBar appCompatSeekBar = this.f6627d;
            int max = appCompatSeekBar.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f6628e.getIntrinsicWidth();
                int intrinsicHeight = this.f6628e.getIntrinsicHeight();
                int i9 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i10 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f6628e.setBounds(-i9, -i10, i9, i10);
                float width = ((appCompatSeekBar.getWidth() - appCompatSeekBar.getPaddingLeft()) - appCompatSeekBar.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(appCompatSeekBar.getPaddingLeft(), appCompatSeekBar.getHeight() / 2);
                for (int i11 = 0; i11 <= max; i11++) {
                    this.f6628e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
