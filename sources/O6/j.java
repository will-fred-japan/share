package O6;

/* JADX INFO: compiled from: DatabaseWorkerPool.java */
/* JADX INFO: loaded from: classes.dex */
public interface j {

    /* JADX INFO: compiled from: DatabaseWorkerPool.java */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f3524a;

        public a(g gVar) {
            this.f3524a = gVar;
        }
    }

    void a();

    void b(h hVar);

    default void c(g gVar, Runnable runnable) {
        b(new h(gVar == null ? null : new a(gVar), runnable));
    }

    void start();
}
