package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TextDrawableHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f13538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f13539d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakReference<b> f13541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public E5.d f13542g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f13536a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f13537b = new a(this);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13540e = true;

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    public class a extends A0.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f13543b;

        public a(f fVar) {
            super(3);
            this.f13543b = fVar;
        }

        @Override // A0.h
        public final void r(int i9) {
            f fVar = this.f13543b;
            fVar.f13540e = true;
            b bVar = fVar.f13541f.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // A0.h
        public final void s(Typeface typeface, boolean z8) {
            if (z8) {
                return;
            }
            f fVar = this.f13543b;
            fVar.f13540e = true;
            b bVar = fVar.f13541f.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public f(b bVar) {
        this.f13541f = new WeakReference<>(null);
        this.f13541f = new WeakReference<>(bVar);
    }

    public final float a(String str) {
        if (!this.f13540e) {
            return this.f13538c;
        }
        b(str);
        return this.f13538c;
    }

    public final void b(String str) {
        TextPaint textPaint = this.f13536a;
        this.f13538c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        this.f13539d = str != null ? Math.abs(textPaint.getFontMetrics().ascent) : 0.0f;
        this.f13540e = false;
    }

    public final void c(E5.d dVar, Context context) {
        if (this.f13542g != dVar) {
            this.f13542g = dVar;
            if (dVar != null) {
                TextPaint textPaint = this.f13536a;
                a aVar = this.f13537b;
                dVar.f(context, textPaint, aVar);
                b bVar = this.f13541f.get();
                if (bVar != null) {
                    textPaint.drawableState = bVar.getState();
                }
                dVar.e(context, textPaint, aVar);
                this.f13540e = true;
            }
            b bVar2 = this.f13541f.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }
}
