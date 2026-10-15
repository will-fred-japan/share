package E5;

import A0.h;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: compiled from: TextAppearance.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f2005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextPaint f2006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f2007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d f2008e;

    public e(d dVar, Context context, TextPaint textPaint, h hVar) {
        super(3);
        this.f2008e = dVar;
        this.f2005b = context;
        this.f2006c = textPaint;
        this.f2007d = hVar;
    }

    @Override // A0.h
    public final void r(int i9) {
        this.f2007d.r(i9);
    }

    @Override // A0.h
    public final void s(Typeface typeface, boolean z8) {
        this.f2008e.g(this.f2005b, this.f2006c, typeface);
        this.f2007d.s(typeface, z8);
    }
}
