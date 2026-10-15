package F1;

import android.os.IBinder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: BinderProxyHookHandler.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f2019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f2020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f2021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Class<?> f2022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Class<?> f2023e;

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        boolean zEquals = "queryLocalInterface".equals(method.getName());
        IBinder iBinder = this.f2019a;
        if (!zEquals) {
            return method.invoke(iBinder, objArr);
        }
        ClassLoader classLoader = obj.getClass().getClassLoader();
        Class[] clsArr = {this.f2023e};
        Class<?> cls = this.f2022d;
        c cVar = this.f2021c;
        IBinder iBinder2 = this.f2020b;
        a aVar = new a();
        aVar.f2018c = null;
        try {
            aVar.f2016a = cls.getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
            aVar.f2017b = cVar;
            aVar.f2018c = iBinder2;
        } catch (Exception unused) {
        }
        return Proxy.newProxyInstance(classLoader, clsArr, aVar);
    }
}
