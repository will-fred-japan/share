package A0;

import B0.AbstractC0287a;
import B0.C0299m;
import B0.G;
import B0.O;
import B0.P;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: TracingController.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: compiled from: TracingController.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final G f1375a;

        static {
            G g4 = new G();
            AbstractC0287a.g gVar = O.f1662z;
            if (gVar.b()) {
                g4.f1609a = C0299m.a();
                g4.f1610b = null;
            } else {
                if (!gVar.c()) {
                    throw O.a();
                }
                g4.f1609a = null;
                g4.f1610b = P.b.f1665a.getTracingController();
            }
            f1375a = g4;
        }
    }

    public abstract boolean a();

    public abstract void b(i iVar);

    public abstract boolean c(FileOutputStream fileOutputStream, ExecutorService executorService);
}
