package Q;

import android.os.Handler;

/* JADX INFO: compiled from: RequestExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public final class o<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f3688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f3689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f3690c;

    /* JADX INFO: compiled from: RequestExecutor.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f3691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f3692b;

        public a(j jVar, Object obj) {
            this.f3691a = jVar;
            this.f3692b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f3691a.accept(this.f3692b);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        try {
            objCall = this.f3688a.call();
        } catch (Exception unused) {
            objCall = null;
        }
        this.f3690c.post(new a(this.f3689b, objCall));
    }
}
