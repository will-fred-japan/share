package D0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ConsumerAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d implements c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Method f1818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1820c;

    public d(Method method, Object obj, Object obj2) {
        this.f1818a = method;
        this.f1819b = obj;
        this.f1820c = obj2;
    }

    @Override // D0.c.b
    public final void dispose() throws IllegalAccessException, InvocationTargetException {
        this.f1818a.invoke(this.f1819b, this.f1820c);
    }
}
