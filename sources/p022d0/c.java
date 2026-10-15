package p022d0;

import android.text.TextPaint;

/* JADX INFO: compiled from: DefaultGlyphChecker.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f18449b = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f18450a;

    public c() {
        TextPaint textPaint = new TextPaint();
        this.f18450a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
