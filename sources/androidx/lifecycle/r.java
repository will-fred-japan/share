package androidx.lifecycle;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0534c;
import androidx.fragment.app.FragmentManager;
import java.util.Map;

/* JADX INFO: compiled from: LiveData.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class r<T> {
    public static final Object j = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7754a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p113p.b<Object, r<T>.c> f7755b = new p113p.b<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7756c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f7758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f7759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7762i;

    /* JADX INFO: compiled from: LiveData.java */
    public class a extends r<T>.c {
        @Override // androidx.lifecycle.r.c
        public final boolean j() {
            return true;
        }
    }

    /* JADX INFO: compiled from: LiveData.java */
    public class b extends r<T>.c implements InterfaceC0546l {
    }

    public r() {
        Object obj = j;
        this.f7759f = obj;
        this.f7758e = obj;
        this.f7760g = -1;
    }

    public static void a(String str) {
        o.a.w().f20621b.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(A.a.i("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(r<T>.c cVar) {
        if (cVar.f7764b) {
            if (!cVar.j()) {
                cVar.h(false);
                return;
            }
            int i9 = cVar.f7765c;
            int i10 = this.f7760g;
            if (i9 >= i10) {
                return;
            }
            cVar.f7765c = i10;
            DialogInterfaceOnCancelListenerC0534c.d dVar = cVar.f7763a;
            Object obj = this.f7758e;
            dVar.getClass();
            if (((InterfaceC0548n) obj) != null) {
                DialogInterfaceOnCancelListenerC0534c dialogInterfaceOnCancelListenerC0534c = DialogInterfaceOnCancelListenerC0534c.this;
                if (dialogInterfaceOnCancelListenerC0534c.f7600m0) {
                    View viewY = dialogInterfaceOnCancelListenerC0534c.y();
                    if (viewY.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                    if (dialogInterfaceOnCancelListenerC0534c.f7604q0 != null) {
                        if (FragmentManager.J(3)) {
                            Log.d("FragmentManager", "DialogFragment " + dVar + " setting the content view on " + dialogInterfaceOnCancelListenerC0534c.f7604q0);
                        }
                        dialogInterfaceOnCancelListenerC0534c.f7604q0.setContentView(viewY);
                    }
                }
            }
        }
    }

    public final void c(r<T>.c cVar) {
        if (this.f7761h) {
            this.f7762i = true;
            return;
        }
        this.f7761h = true;
        do {
            this.f7762i = false;
            if (cVar != null) {
                b(cVar);
                cVar = null;
            } else {
                p113p.b<Object, r<T>.c> bVar = this.f7755b;
                bVar.getClass();
                p.b.d dVar = new p.b.d();
                bVar.f20739c.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((c) ((Map.Entry) dVar.next()).getValue());
                    if (this.f7762i) {
                        break;
                    }
                }
            }
        } while (this.f7762i);
        this.f7761h = false;
    }

    /* JADX INFO: compiled from: LiveData.java */
    public abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DialogInterfaceOnCancelListenerC0534c.d f7763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7765c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ s f7766d;

        public c(s sVar, DialogInterfaceOnCancelListenerC0534c.d dVar) {
            this.f7766d = sVar;
            this.f7763a = dVar;
        }

        public final void h(boolean z8) {
            if (z8 == this.f7764b) {
                return;
            }
            this.f7764b = z8;
            int i9 = z8 ? 1 : -1;
            s sVar = this.f7766d;
            int i10 = sVar.f7756c;
            sVar.f7756c = i9 + i10;
            if (!sVar.f7757d) {
                sVar.f7757d = true;
                while (true) {
                    try {
                        int i11 = sVar.f7756c;
                        if (i10 == i11) {
                            break;
                        } else {
                            i10 = i11;
                        }
                    } catch (Throwable th) {
                        sVar.f7757d = false;
                        throw th;
                    }
                }
                sVar.f7757d = false;
            }
            if (this.f7764b) {
                sVar.c(this);
            }
        }

        public abstract boolean j();

        public void i() {
        }
    }
}
