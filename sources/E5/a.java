package E5;

import A0.h;
import android.graphics.Typeface;

/* JADX INFO: compiled from: CancelableFontCallback.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Typeface f1987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0013a f1988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1989d;

    /* JADX INFO: renamed from: E5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CancelableFontCallback.java */
    public interface InterfaceC0013a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0013a interfaceC0013a, Typeface typeface) {
        super(3);
        this.f1987b = typeface;
        this.f1988c = interfaceC0013a;
    }

    @Override // A0.h
    public final void r(int i9) {
        if (this.f1989d) {
            return;
        }
        this.f1988c.a(this.f1987b);
    }

    @Override // A0.h
    public final void s(Typeface typeface, boolean z8) {
        if (this.f1989d) {
            return;
        }
        this.f1988c.a(typeface);
    }
}
