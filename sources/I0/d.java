package I0;

import G0.h;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import p188x7.k;

/* JADX INFO: compiled from: ExtensionWindowBackendApi2.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d implements H0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f2539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f2540b = new ReentrantLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f2541c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f2542d = new LinkedHashMap();

    public d(WindowLayoutComponent windowLayoutComponent) {
        this.f2539a = windowLayoutComponent;
    }

    @Override // H0.a
    public final void a(Context context, p114p0.b bVar, h hVar) {
        k kVar;
        ReentrantLock reentrantLock = this.f2540b;
        reentrantLock.lock();
        LinkedHashMap linkedHashMap = this.f2541c;
        try {
            f fVar = (f) linkedHashMap.get(context);
            LinkedHashMap linkedHashMap2 = this.f2542d;
            if (fVar != null) {
                fVar.b(hVar);
                linkedHashMap2.put(hVar, context);
                kVar = k.f22364a;
            } else {
                kVar = null;
            }
            if (kVar == null) {
                f fVar2 = new f(context);
                linkedHashMap.put(context, fVar2);
                linkedHashMap2.put(hVar, context);
                fVar2.b(hVar);
                this.f2539a.addWindowLayoutInfoListener(context, fVar2);
            }
            k kVar2 = k.f22364a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // H0.a
    public final void b(h hVar) {
        ReentrantLock reentrantLock = this.f2540b;
        reentrantLock.lock();
        LinkedHashMap linkedHashMap = this.f2542d;
        try {
            Context context = (Context) linkedHashMap.get(hVar);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            LinkedHashMap linkedHashMap2 = this.f2541c;
            f fVar = (f) linkedHashMap2.get(context);
            if (fVar == null) {
                reentrantLock.unlock();
                return;
            }
            ReentrantLock reentrantLock2 = fVar.f2544b;
            reentrantLock2.lock();
            LinkedHashSet linkedHashSet = fVar.f2546d;
            try {
                linkedHashSet.remove(hVar);
                reentrantLock2.unlock();
                linkedHashMap.remove(hVar);
                if (linkedHashSet.isEmpty()) {
                    linkedHashMap2.remove(context);
                    this.f2539a.removeWindowLayoutInfoListener(fVar);
                }
                k kVar = k.f22364a;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock2.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }
}
