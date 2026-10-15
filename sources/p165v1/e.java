package p165v1;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: StreamCompleteListenerManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21888a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<d> f21889b = new ArrayList<>();

    public final void a(c cVar) {
        boolean zD;
        synchronized (this) {
            try {
                zD = d();
                if (!zD) {
                    this.f21888a = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zD) {
            return;
        }
        Iterator it = b().iterator();
        while (it.hasNext()) {
            ((d) it.next()).b(cVar);
        }
    }

    public final ArrayList b() {
        ArrayList arrayList;
        synchronized (this.f21889b) {
            arrayList = new ArrayList(this.f21889b);
            this.f21889b.clear();
        }
        return arrayList;
    }

    public final void c(c cVar) {
        boolean zD;
        synchronized (this) {
            try {
                zD = d();
                if (!zD) {
                    this.f21888a = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zD) {
            return;
        }
        Iterator it = b().iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(cVar);
        }
    }

    public final boolean d() {
        boolean z8;
        synchronized (this) {
            z8 = this.f21888a;
        }
        return z8;
    }
}
