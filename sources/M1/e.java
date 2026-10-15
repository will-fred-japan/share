package M1;

import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MainThreadMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f2882a;

    /* JADX INFO: compiled from: MainThreadMonitor.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                f.g(e.this.f2882a);
            } catch (Throwable unused) {
            }
        }
    }

    public e(f fVar) {
        this.f2882a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Method declaredMethod;
        f fVar = this.f2882a;
        try {
            fVar.f2896m = new a();
            Object objA = f.a(fVar, fVar.j, "mLock");
            fVar.f2890f = objA;
            if (objA == null) {
                fVar.f2890f = f.h(fVar, fVar.j, "mLock");
            }
            Object[] objArr = (Object[]) f.a(fVar, fVar.j, "mCallbackQueues");
            fVar.f2891g = objArr;
            if (objArr == null) {
                fVar.f2891g = (Object[]) f.h(fVar, fVar.j, "mCallbackQueues");
            }
            int i9 = Build.VERSION.SDK_INT;
            if (i9 == 28) {
                fVar.f2892h = (long[]) f.h(fVar, f.h(fVar, fVar.j, "mFrameInfo"), "mFrameInfo");
            } else if (i9 > 28) {
                fVar.f2892h = (long[]) f.h(fVar, f.h(fVar, fVar.j, "mFrameInfo"), "frameInfo");
            } else {
                fVar.f2892h = (long[]) f.a(fVar, f.a(fVar, fVar.j, "mFrameInfo"), "mFrameInfo");
            }
            Object obj = fVar.f2891g[0];
            try {
                declaredMethod = obj.getClass().getDeclaredMethod("addCallbackLocked", Long.TYPE, Object.class, Object.class);
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
                declaredMethod = null;
            }
            fVar.f2893i = declaredMethod;
            fVar.d(fVar.f2896m);
        } catch (Exception unused2) {
        }
    }
}
