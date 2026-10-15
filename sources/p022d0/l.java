package p022d0;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.emoji2.text.c;

/* JADX INFO: compiled from: TypefaceEmojiSpan.java */
/* JADX INFO: loaded from: classes.dex */
public final class l extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextPaint f18482e;

    /* JADX WARN: Code duplicated, block: B:19:0x0042  */
    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i9, int i10, float f6, int i11, int i12, int i13, Paint paint) {
        TextPaint textPaint = null;
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i9, i10, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                    TextPaint textPaint2 = this.f18482e;
                    if (textPaint2 == null) {
                        textPaint2 = new TextPaint();
                        this.f18482e = textPaint2;
                    }
                    textPaint = textPaint2;
                    textPaint.set(paint);
                    for (CharacterStyle characterStyle : characterStyleArr) {
                        characterStyle.updateDrawState(textPaint);
                    }
                } else if (paint instanceof TextPaint) {
                    textPaint = (TextPaint) paint;
                }
            } else if (paint instanceof TextPaint) {
                textPaint = (TextPaint) paint;
            }
        } else if (paint instanceof TextPaint) {
            textPaint = (TextPaint) paint;
        }
        TextPaint textPaint3 = textPaint;
        if (textPaint3 != null && textPaint3.bgColor != 0) {
            int color = textPaint3.getColor();
            Paint.Style style = textPaint3.getStyle();
            textPaint3.setColor(textPaint3.bgColor);
            textPaint3.setStyle(Paint.Style.FILL);
            canvas.drawRect(f6, i11, f6 + this.f18466c, i13, textPaint3);
            textPaint3.setStyle(style);
            textPaint3.setColor(color);
        }
        c.a().getClass();
        float f9 = i12;
        Paint paint2 = textPaint3;
        if (textPaint3 == null) {
            paint2 = paint;
        }
        k kVar = this.f18465b;
        i iVar = kVar.f18480b;
        Typeface typeface = iVar.f18471d;
        Typeface typeface2 = paint2.getTypeface();
        paint2.setTypeface(typeface);
        canvas.drawText(iVar.f18469b, kVar.f18479a * 2, 2, f6, f9, paint2);
        paint2.setTypeface(typeface2);
    }
}
