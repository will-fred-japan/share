package B7;

import K7.p;
import java.io.Serializable;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements h, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f1761a = new i();
    private static final long serialVersionUID = 0;

    @Override // B7.h
    public final h d(h.b<?> key) {
        k.e(key, "key");
        return this;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // B7.h
    public final <E extends h.a> E i(h.b<E> key) {
        k.e(key, "key");
        return null;
    }

    @Override // B7.h
    public final h r(h context) {
        k.e(context, "context");
        return context;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // B7.h
    public final <R> R A(R r8, p<? super R, ? super h.a, ? extends R> pVar) {
        return r8;
    }
}
