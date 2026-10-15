package F1;

import android.annotation.TargetApi;
import android.os.IBinder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: BinderHookHandler.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f2017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IBinder f2018c;

    @Override // java.lang.reflect.InvocationHandler
    @TargetApi(11)
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        IBinder iBinder = this.f2018c;
        if (iBinder != null && method.getName().equals("asBinder")) {
            return iBinder;
        }
        this.f2017b.a(method, objArr);
        return method.invoke(this.f2016a, objArr);
    }
}
