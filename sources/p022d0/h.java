package p022d0;

import A1.b;
import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import p031e0.a;

/* JADX INFO: compiled from: EmojiSpan.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f18465b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f18464a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short f18466c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f18467d = 1.0f;

    public h(k kVar) {
        b.K0(kVar, "rasterizer cannot be null");
        this.f18465b = kVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i9, int i10, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f18464a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        k kVar = this.f18465b;
        a aVarB = kVar.b();
        int iA = aVarB.a(14);
        this.f18467d = fAbs / (iA != 0 ? aVarB.f18589b.getShort(iA + aVarB.f18588a) : (short) 0);
        a aVarB2 = kVar.b();
        int iA2 = aVarB2.a(14);
        if (iA2 != 0) {
            aVarB2.f18589b.getShort(iA2 + aVarB2.f18588a);
        }
        a aVarB3 = kVar.b();
        int iA3 = aVarB3.a(12);
        short s8 = (short) ((iA3 != 0 ? aVarB3.f18589b.getShort(iA3 + aVarB3.f18588a) : (short) 0) * this.f18467d);
        this.f18466c = s8;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s8;
    }
}
