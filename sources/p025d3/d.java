package p025d3;

import W5.e;
import android.os.Process;
import java.util.concurrent.ThreadFactory;
import p010b3.b;

/* JADX INFO: compiled from: SingleThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18507a;

    /* JADX INFO: compiled from: SingleThreadFactory.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18508a;

        public a(Runnable runnable) {
            this.f18508a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);
            try {
                this.f18508a.run();
            } catch (Throwable th) {
                b.b("APM-AsyncTask", "SingleThreadFactory error when running in thread " + d.this.f18507a, th);
            }
        }
    }

    public d(String str) {
        this.f18507a = e.l("APM6-", str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        boolean z8 = A1.b.f1393A;
        String str = this.f18507a;
        if (z8) {
            b.a("APM-AsyncTask", "creating newThread " + str);
        }
        return new Thread(new a(runnable), str);
    }
}
