package N1;

import java.util.ArrayDeque;
import p094m5.l;
import p094m5.n;

/* JADX INFO: compiled from: EventConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f3160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f3161c;

    public void a(l lVar) {
        synchronized (this.f3160b) {
            try {
                if (((ArrayDeque) this.f3161c) == null) {
                    this.f3161c = new ArrayDeque();
                }
                ((ArrayDeque) this.f3161c).add(lVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(n nVar) {
        l lVar;
        synchronized (this.f3160b) {
            if (((ArrayDeque) this.f3161c) != null && !this.f3159a) {
                this.f3159a = true;
                while (true) {
                    synchronized (this.f3160b) {
                        try {
                            lVar = (l) ((ArrayDeque) this.f3161c).poll();
                            if (lVar == null) {
                                this.f3159a = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    lVar.a(nVar);
                }
            }
        }
    }
}
