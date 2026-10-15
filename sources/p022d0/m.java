package p022d0;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: UnprecomputeTextOnModificationSpannable.java */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18483a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Spannable f18484b;

    /* JADX INFO: compiled from: UnprecomputeTextOnModificationSpannable.java */
    public static class a {
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof R.b;
        }
    }

    /* JADX INFO: compiled from: UnprecomputeTextOnModificationSpannable.java */
    public static class b extends a {
        @Override // d0.m.a
        public final boolean a(CharSequence charSequence) {
            return n.g(charSequence) || (charSequence instanceof R.b);
        }
    }

    public m(Spannable spannable) {
        this.f18484b = spannable;
    }

    public final void a() {
        Spannable spannable = this.f18484b;
        if (!this.f18483a) {
            if ((Build.VERSION.SDK_INT < 28 ? new a() : new b()).a(spannable)) {
                this.f18484b = new SpannableString(spannable);
            }
        }
        this.f18483a = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i9) {
        return this.f18484b.charAt(i9);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f18484b.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f18484b.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f18484b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f18484b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f18484b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final <T> T[] getSpans(int i9, int i10, Class<T> cls) {
        return (T[]) this.f18484b.getSpans(i9, i10, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f18484b.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i9, int i10, Class cls) {
        return this.f18484b.nextSpanTransition(i9, i10, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.f18484b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i9, int i10, int i11) {
        a();
        this.f18484b.setSpan(obj, i9, i10, i11);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i9, int i10) {
        return this.f18484b.subSequence(i9, i10);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f18484b.toString();
    }
}
