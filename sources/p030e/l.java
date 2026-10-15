package p030e;

import K7.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: FullyDrawnReporter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f18571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f18572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f18574d;

    public l(Executor executor, c cVar) {
        k.e(executor, "executor");
        this.f18571a = executor;
        this.f18572b = new Object();
        this.f18574d = new ArrayList();
    }

    public final void a() {
        synchronized (this.f18572b) {
            try {
                this.f18573c = true;
                Iterator it = this.f18574d.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).invoke();
                }
                this.f18574d.clear();
                p188x7.k kVar = p188x7.k.f22364a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
