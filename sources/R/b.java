package R;

import B0.C0297k;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* JADX INFO: compiled from: PrecomputedTextCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Spannable {
    @Override // java.lang.CharSequence
    public final char charAt(int i9) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final <T> T[] getSpans(int i9, int i10, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        throw null;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        throw null;
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i9, int i10, Class cls) {
        throw null;
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT < 29) {
            throw null;
        }
        throw null;
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i9, int i10, int i11) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT < 29) {
            throw null;
        }
        throw null;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i9, int i10) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        throw null;
    }

    /* JADX INFO: compiled from: PrecomputedTextCompat.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextPaint f3901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f3902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f3904d;

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i9, int i10) {
            if (Build.VERSION.SDK_INT >= 29) {
                C0297k.m(textPaint).setBreakStrategy(i9).setHyphenationFrequency(i10).setTextDirection(textDirectionHeuristic).build();
            }
            this.f3901a = textPaint;
            this.f3902b = textDirectionHeuristic;
            this.f3903c = i9;
            this.f3904d = i10;
        }

        public final boolean a(a aVar) {
            if (this.f3903c != aVar.f3903c || this.f3904d != aVar.f3904d) {
                return false;
            }
            TextPaint textPaint = this.f3901a;
            float textSize = textPaint.getTextSize();
            TextPaint textPaint2 = aVar.f3901a;
            if (textSize != textPaint2.getTextSize() || textPaint.getTextScaleX() != textPaint2.getTextScaleX() || textPaint.getTextSkewX() != textPaint2.getTextSkewX() || textPaint.getLetterSpacing() != textPaint2.getLetterSpacing() || !TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) || textPaint.getFlags() != textPaint2.getFlags() || !textPaint.getTextLocales().equals(textPaint2.getTextLocales())) {
                return false;
            }
            if (textPaint.getTypeface() == null) {
                return textPaint2.getTypeface() == null;
            }
            return textPaint.getTypeface().equals(textPaint2.getTypeface());
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f3902b == aVar.f3902b;
        }

        public final int hashCode() {
            TextPaint textPaint = this.f3901a;
            return Objects.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), this.f3902b, Integer.valueOf(this.f3903c), Integer.valueOf(this.f3904d));
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder sb2 = new StringBuilder("textSize=");
            TextPaint textPaint = this.f3901a;
            sb2.append(textPaint.getTextSize());
            sb.append(sb2.toString());
            sb.append(", textScaleX=" + textPaint.getTextScaleX());
            sb.append(", textSkewX=" + textPaint.getTextSkewX());
            sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
            sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
            sb.append(", textLocale=" + textPaint.getTextLocales());
            sb.append(", typeface=" + textPaint.getTypeface());
            sb.append(", variationSettings=" + textPaint.getFontVariationSettings());
            sb.append(", textDir=" + this.f3902b);
            sb.append(", breakStrategy=" + this.f3903c);
            sb.append(", hyphenationFrequency=" + this.f3904d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f3901a = params.getTextPaint();
            this.f3902b = params.getTextDirection();
            this.f3903c = params.getBreakStrategy();
            this.f3904d = params.getHyphenationFrequency();
        }
    }
}
