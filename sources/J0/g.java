package J0;

import G0.h;
import G0.j;
import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.layout.adapter.sidecar.SidecarCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import p188x7.k;
import y7.p;

/* JADX INFO: compiled from: SidecarWindowBackend.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g implements H0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile g f2654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReentrantLock f2655d = new ReentrantLock();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SidecarCompat f2656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f2657b = new CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: SidecarWindowBackend.kt */
    public final class a {
        public a() {
        }
    }

    /* JADX INFO: compiled from: SidecarWindowBackend.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f2659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h f2660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j f2661c;

        public b(Activity activity, p114p0.b bVar, h hVar) {
            this.f2659a = activity;
            this.f2660b = hVar;
        }
    }

    public g(SidecarCompat sidecarCompat) {
        this.f2656a = sidecarCompat;
        if (sidecarCompat != null) {
            sidecarCompat.d(new a());
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // H0.a
    public final void a(Context context, p114p0.b bVar, h hVar) {
        b next;
        WindowManager.LayoutParams attributes;
        k kVar = null;
        iBinder = null;
        IBinder iBinder = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        p pVar = p.f22408a;
        if (activity != null) {
            ReentrantLock reentrantLock = f2655d;
            reentrantLock.lock();
            try {
                SidecarCompat sidecarCompat = this.f2656a;
                if (sidecarCompat == null) {
                    hVar.accept(new j(pVar));
                    reentrantLock.unlock();
                    return;
                }
                CopyOnWriteArrayList<b> copyOnWriteArrayList = this.f2657b;
                boolean z8 = false;
                if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
                    Iterator<b> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().f2659a.equals(activity)) {
                            z8 = true;
                            break;
                        }
                    }
                }
                b bVar2 = new b(activity, bVar, hVar);
                copyOnWriteArrayList.add(bVar2);
                if (z8) {
                    Iterator<b> it2 = copyOnWriteArrayList.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                    } while (!activity.equals(next.f2659a));
                    b bVar3 = next;
                    j jVar = bVar3 != null ? bVar3.f2661c : null;
                    if (jVar != null) {
                        bVar2.f2661c = jVar;
                        bVar2.f2660b.accept(jVar);
                    }
                } else {
                    Window window = activity.getWindow();
                    if (window != null && (attributes = window.getAttributes()) != null) {
                        iBinder = attributes.token;
                    }
                    if (iBinder != null) {
                        sidecarCompat.c(iBinder, activity);
                    } else {
                        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new SidecarCompat.c(sidecarCompat, activity));
                    }
                }
                k kVar2 = k.f22364a;
                reentrantLock.unlock();
                kVar = k.f22364a;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        if (kVar == null) {
            hVar.accept(new j(pVar));
        }
    }

    @Override // H0.a
    public final void b(h hVar) {
        synchronized (f2655d) {
            try {
                if (this.f2656a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (b bVar : this.f2657b) {
                    if (bVar.f2660b == hVar) {
                        arrayList.add(bVar);
                    }
                }
                this.f2657b.removeAll(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Activity activity = ((b) it.next()).f2659a;
                    CopyOnWriteArrayList<b> copyOnWriteArrayList = this.f2657b;
                    if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
                        Iterator<b> it2 = copyOnWriteArrayList.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (it2.next().f2659a.equals(activity)) {
                                }
                            }
                        }
                    }
                    SidecarCompat sidecarCompat = this.f2656a;
                    if (sidecarCompat != null) {
                        sidecarCompat.b(activity);
                    }
                }
                k kVar = k.f22364a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
