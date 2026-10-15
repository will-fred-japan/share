package p023d1;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import p016c1.d;

/* JADX INFO: compiled from: ApmInnerThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f18486b;

    /* JADX INFO: renamed from: d1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApmInnerThreadFactory.java */
    public class RunnableC0193a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18487a;

        public RunnableC0193a(Runnable runnable) {
            this.f18487a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);
            b bVar = a.this.f18486b;
            if (bVar != null) {
                bVar.b(Thread.currentThread().getId());
            }
            try {
                Runnable runnable = this.f18487a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable unused) {
                d.a.f8685a.getClass();
            }
        }
    }

    /* JADX INFO: compiled from: ApmInnerThreadFactory.java */
    public interface b {
        void b(long j);
    }

    public a(String str) {
        this.f18485a = "APM_".concat(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(new RunnableC0193a(runnable), this.f18485a);
    }
}
