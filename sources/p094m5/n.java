package p094m5;

import N1.e;
import S4.C0376g;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
public final class n<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20368a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f20369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f20371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f20372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Exception f20373f;

    public n() {
        e eVar = new e();
        eVar.f3160b = new Object();
        this.f20369b = eVar;
    }

    public final TResult a() {
        TResult tresult;
        synchronized (this.f20368a) {
            try {
                C0376g.g("Task is not yet complete", this.f20370c);
                if (this.f20371d) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.f20373f;
                if (exc != null) {
                    throw new e(exc);
                }
                tresult = (TResult) this.f20372e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tresult;
    }

    public final boolean b() {
        boolean z8;
        synchronized (this.f20368a) {
            try {
                z8 = false;
                if (this.f20370c && !this.f20371d && this.f20373f == null) {
                    z8 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z8;
    }

    public final void c(Exception exc) {
        C0376g.f(exc, "Exception must not be null");
        synchronized (this.f20368a) {
            e();
            this.f20370c = true;
            this.f20373f = exc;
        }
        this.f20369b.b(this);
    }

    public final void d(Object obj) {
        synchronized (this.f20368a) {
            e();
            this.f20370c = true;
            this.f20372e = obj;
        }
        this.f20369b.b(this);
    }

    public final void e() {
        boolean z8;
        Exception exc;
        String strConcat;
        if (this.f20370c) {
            int i9 = a.f20354a;
            synchronized (this.f20368a) {
                z8 = this.f20370c;
            }
            if (!z8) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            synchronized (this.f20368a) {
                exc = this.f20373f;
            }
            if (exc != null) {
                strConcat = "failure";
            } else if (b()) {
                strConcat = "result ".concat(String.valueOf(a()));
            } else {
                strConcat = this.f20371d ? "cancellation" : "unknown issue";
            }
        }
    }

    public final void f() {
        synchronized (this.f20368a) {
            try {
                if (this.f20370c) {
                    this.f20369b.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
