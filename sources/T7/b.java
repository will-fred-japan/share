package T7;

import S7.InterfaceC0411x;
import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: AndroidExceptionPreHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends B7.a implements InterfaceC0411x {
    private volatile Object _preHandler;

    public b() {
        super(InterfaceC0411x.a.f4307a);
        this._preHandler = this;
    }

    @Override // S7.InterfaceC0411x
    public final void y(Throwable th) {
        Method declaredMethod;
        if (Build.VERSION.SDK_INT < 28) {
            Object obj = this._preHandler;
            if (obj != this) {
                declaredMethod = (Method) obj;
            } else {
                try {
                    declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
                    if (!Modifier.isPublic(declaredMethod.getModifiers()) || !Modifier.isStatic(declaredMethod.getModifiers())) {
                        declaredMethod = null;
                    }
                } catch (Throwable unused) {
                }
                this._preHandler = declaredMethod;
            }
            Object objInvoke = declaredMethod != null ? declaredMethod.invoke(null, new Object[0]) : null;
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = objInvoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) objInvoke : null;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
