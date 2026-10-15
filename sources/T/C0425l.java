package T;

import androidx.lifecycle.AbstractC0544j;
import androidx.lifecycle.InterfaceC0546l;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: T.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MenuHostHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0425l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f4440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<InterfaceC0426m> f4441b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f4442c = new HashMap();

    /* JADX INFO: renamed from: T.l$a */
    /* JADX INFO: compiled from: MenuHostHelper.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0544j f4443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC0546l f4444b;

        public a(AbstractC0544j abstractC0544j, InterfaceC0546l interfaceC0546l) {
            this.f4443a = abstractC0544j;
            this.f4444b = interfaceC0546l;
            abstractC0544j.a(interfaceC0546l);
        }
    }

    public C0425l(Runnable runnable) {
        this.f4440a = runnable;
    }

    public final void a(InterfaceC0426m interfaceC0426m) {
        this.f4441b.remove(interfaceC0426m);
        a aVar = (a) this.f4442c.remove(interfaceC0426m);
        if (aVar != null) {
            aVar.f4443a.c(aVar.f4444b);
            aVar.f4444b = null;
        }
        this.f4440a.run();
    }
}
