package E0;

import D7.e;
import D7.i;
import K7.p;
import S7.InterfaceC0413z;
import V7.d;
import p188x7.g;
import p188x7.k;

/* JADX INFO: compiled from: CallbackToFlowAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.window.java.core.CallbackToFlowAdapter$connect$1$1", f = "CallbackToFlowAdapter.kt", l = {46}, m = "invokeSuspend")
public final class a extends i implements p<InterfaceC0413z, B7.e<? super k>, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d<Object> f1953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Z6.i f1954d;

    /* JADX INFO: renamed from: E0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CallbackToFlowAdapter.kt */
    public static final class C0011a<T> implements V7.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Z6.i f1955a;

        public C0011a(Z6.i iVar) {
            this.f1955a = iVar;
        }

        @Override // V7.e
        public final Object a(T t, B7.e<? super k> eVar) {
            this.f1955a.accept(t);
            return k.f22364a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d dVar, Z6.i iVar, B7.e eVar) {
        super(2, eVar);
        this.f1953c = dVar;
        this.f1954d = iVar;
    }

    @Override // D7.a
    public final B7.e<k> create(Object obj, B7.e<?> eVar) {
        return new a(this.f1953c, this.f1954d, eVar);
    }

    @Override // K7.p
    public final Object invoke(InterfaceC0413z interfaceC0413z, B7.e<? super k> eVar) {
        return ((a) create(interfaceC0413z, eVar)).invokeSuspend(k.f22364a);
    }

    @Override // D7.a
    public final Object invokeSuspend(Object obj) {
        C7.a aVar = C7.a.f1806a;
        int i9 = this.f1952b;
        if (i9 == 0) {
            g.b(obj);
            C0011a c0011a = new C0011a(this.f1954d);
            this.f1952b = 1;
            if (this.f1953c.c(c0011a, this) == aVar) {
                return aVar;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g.b(obj);
        }
        return k.f22364a;
    }
}
