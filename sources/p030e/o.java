package p030e;

import android.window.OnBackInvokedDispatcher;
import p106o0.c;
import p106o0.f;
import p106o0.k;
import p106o0.n;
import p188x7.h;

/* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f18582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f18583b;

    /* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
    public final class a extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f18584c;

        public a() {
            c cVar = new c(new R3.c(5, o.this));
            cVar.a(this);
            this.f18584c = cVar;
        }

        @Override // p106o0.f
        public final void b(boolean z8) {
            o.this.getClass();
        }
    }

    public o(Runnable runnable) {
        this.f18582a = runnable;
        this.f18583b = p011b4.h.E(new i(1, this));
    }

    public final a a() {
        return (a) this.f18583b.getValue();
    }

    public final void b(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        a().f18584c.b(new k(onBackInvokedDispatcher, 0), 1);
        a().f18584c.b(new n(onBackInvokedDispatcher, 1000000), 0);
    }

    public o() {
        this(null);
    }
}
