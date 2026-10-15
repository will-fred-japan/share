package W7;

import kotlin.jvm.internal.B;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5103a;

    /* JADX INFO: compiled from: SafeCollector.kt */
    public /* synthetic */ class a extends kotlin.jvm.internal.j implements K7.q<V7.e<? super Object>, Object, B7.e<? super p188x7.k>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f5104c = new a(3, V7.e.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);

        @Override // K7.q
        public final Object b(V7.e<? super Object> eVar, Object obj, B7.e<? super p188x7.k> eVar2) {
            return eVar.a(obj, eVar2);
        }
    }

    static {
        a aVar = a.f5104c;
        kotlin.jvm.internal.k.c(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        B.b(3, aVar);
        f5103a = aVar;
    }
}
