package T7;

import B7.h;
import S7.J;
import S7.X;
import X7.o;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f4570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f4572e;

    public c(Handler handler, boolean z8) {
        this.f4570c = handler;
        this.f4571d = z8;
        this.f4572e = z8 ? this : new c(handler, true);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.f4570c == this.f4570c && cVar.f4571d == this.f4571d;
    }

    @Override // S7.AbstractC0410w
    public final void g(h hVar, Runnable runnable) {
        if (this.f4570c.post(runnable)) {
            return;
        }
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        X x8 = (X) hVar.i(X.a.f4251a);
        if (x8 != null) {
            x8.b(cancellationException);
        }
        Z7.c cVar = J.f4233a;
        Z7.b.f5649c.g(hVar, runnable);
    }

    public final int hashCode() {
        return System.identityHashCode(this.f4570c) ^ (this.f4571d ? 1231 : 1237);
    }

    @Override // S7.AbstractC0410w
    public final boolean p(h hVar) {
        return (this.f4571d && k.a(Looper.myLooper(), this.f4570c.getLooper())) ? false : true;
    }

    @Override // T7.d, S7.AbstractC0410w
    public final String toString() {
        d dVarW;
        String str;
        Z7.c cVar = J.f4233a;
        d dVar = o.f5165a;
        if (this == dVar) {
            str = "Dispatchers.Main";
        } else {
            try {
                dVarW = dVar.w();
            } catch (UnsupportedOperationException unused) {
                dVarW = null;
            }
            str = this == dVarW ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f4570c.toString();
        return this.f4571d ? W5.e.u(string, ".immediate") : string;
    }

    @Override // T7.d
    public final d w() {
        return this.f4572e;
    }
}
