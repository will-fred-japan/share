package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f13526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f13527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13529d;
    public boolean j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Layout.Alignment f13530e = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13531f = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f13532g = 1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13533h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13534i = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextUtils.TruncateAt f13535k = null;

    /* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
    public static class a extends Exception {
    }

    public e(CharSequence charSequence, TextPaint textPaint, int i9) {
        this.f13526a = charSequence;
        this.f13527b = textPaint;
        this.f13528c = i9;
        this.f13529d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f13526a == null) {
            this.f13526a = "";
        }
        int iMax = Math.max(0, this.f13528c);
        CharSequence charSequenceEllipsize = this.f13526a;
        int i9 = this.f13531f;
        TextPaint textPaint = this.f13527b;
        if (i9 == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.f13535k);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f13529d);
        this.f13529d = iMin;
        if (this.j && this.f13531f == 1) {
            this.f13530e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
        builderObtain.setAlignment(this.f13530e);
        builderObtain.setIncludePad(this.f13534i);
        builderObtain.setTextDirection(this.j ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f13535k;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f13531f);
        float f6 = this.f13532g;
        if (f6 != 1.0f) {
            builderObtain.setLineSpacing(0.0f, f6);
        }
        if (this.f13531f > 1) {
            builderObtain.setHyphenationFrequency(this.f13533h);
        }
        return builderObtain.build();
    }
}
