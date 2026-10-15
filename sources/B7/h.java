package B7;

import K7.p;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface h {

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface a extends h {

        /* JADX INFO: renamed from: B7.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineContext.kt */
        public static final class C0007a {
            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends a> E a(a aVar, b<E> key) {
                k.e(key, "key");
                if (k.a(aVar.getKey(), key)) {
                    return aVar;
                }
                return null;
            }

            public static h b(a aVar, b<?> key) {
                k.e(key, "key");
                return k.a(aVar.getKey(), key) ? i.f1761a : aVar;
            }
        }

        b<?> getKey();
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface b<E extends a> {
    }

    <R> R A(R r8, p<? super R, ? super a, ? extends R> pVar);

    h d(b<?> bVar);

    <E extends a> E i(b<E> bVar);

    h r(h hVar);
}
