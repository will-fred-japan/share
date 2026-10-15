package p188x7;

import K7.a;
import java.io.Serializable;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h<T> implements b<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a<? extends T> f22357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f22358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f22359c;

    public h(a initializer) {
        k.e(initializer, "initializer");
        this.f22357a = initializer;
        this.f22358b = j.f22363a;
        this.f22359c = this;
    }

    @Override // p188x7.b
    public final T getValue() {
        T tInvoke;
        T t = (T) this.f22358b;
        j jVar = j.f22363a;
        if (t != jVar) {
            return t;
        }
        synchronized (this.f22359c) {
            tInvoke = (T) this.f22358b;
            if (tInvoke == jVar) {
                a<? extends T> aVar = this.f22357a;
                k.b(aVar);
                tInvoke = aVar.invoke();
                this.f22358b = tInvoke;
                this.f22357a = null;
            }
        }
        return tInvoke;
    }

    public final String toString() {
        return this.f22358b != j.f22363a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
