package com.google.android.material.textfield;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: CutoutDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends H5.h {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f13849z = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a f13850y;

    /* JADX INFO: compiled from: CutoutDrawable.java */
    @TargetApi(18)
    public static class b extends e {
        @Override // H5.h
        public final void f(Canvas canvas) {
            if (this.f13850y.f13851q.isEmpty()) {
                super.f(canvas);
                return;
            }
            canvas.save();
            canvas.clipOutRect(this.f13850y.f13851q);
            super.f(canvas);
            canvas.restore();
        }
    }

    @Override // H5.h, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.f13850y = new a(this.f13850y);
        return this;
    }

    public final void o(float f6, float f9, float f10, float f11) {
        RectF rectF = this.f13850y.f13851q;
        if (f6 == rectF.left && f9 == rectF.top && f10 == rectF.right && f11 == rectF.bottom) {
            return;
        }
        rectF.set(f6, f9, f10, f11);
        invalidateSelf();
    }

    /* JADX INFO: compiled from: CutoutDrawable.java */
    public static final class a extends H5.h.b {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final RectF f13851q;

        public a(H5.l lVar, RectF rectF) {
            super(lVar);
            this.f13851q = rectF;
        }

        @Override // H5.h.b, android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            b bVar = new b(this);
            bVar.f13850y = this;
            bVar.invalidateSelf();
            return bVar;
        }

        public a(a aVar) {
            super(aVar);
            this.f13851q = aVar.f13851q;
        }
    }
}
