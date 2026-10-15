package B7;

import B7.h.a;
import K7.l;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<B extends h.a, E extends B> implements h.b<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l<h.a, E> f1754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h.b<?> f1755b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [B7.h$b<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [K7.l<? super B7.h$a, ? extends E extends B>, K7.l<B7.h$a, E extends B>] */
    public b(h.b<B> baseKey, l<? super h.a, ? extends E> lVar) {
        k.e(baseKey, "baseKey");
        this.f1754a = lVar;
        this.f1755b = baseKey instanceof b ? (h.b<B>) ((b) baseKey).f1755b : baseKey;
    }
}
