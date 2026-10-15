package p154t7;

import V7.e;
import p015c0.c;
import p188x7.g;
import p188x7.k;

/* JADX INFO: compiled from: Emitters.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r<T> implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f21609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.a f21610b;

    /* JADX INFO: compiled from: Emitters.kt */
    @D7.e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
    public static final class a extends D7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f21611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21612b;

        public a(B7.e eVar) {
            super(eVar);
        }

        @Override // D7.a
        public final Object invokeSuspend(Object obj) {
            this.f21611a = obj;
            this.f21612b |= Integer.MIN_VALUE;
            return r.this.a(null, this);
        }
    }

    public r(e eVar, c.a aVar) {
        this.f21609a = eVar;
        this.f21610b = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // V7.e
    public final Object a(Object obj, B7.e eVar) {
        a aVar;
        if (eVar instanceof a) {
            aVar = (a) eVar;
            int i9 = aVar.f21612b;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                aVar.f21612b = i9 - Integer.MIN_VALUE;
            } else {
                aVar = new a(eVar);
            }
        } else {
            aVar = new a(eVar);
        }
        Object obj2 = aVar.f21611a;
        C7.a aVar2 = C7.a.f1806a;
        int i10 = aVar.f21612b;
        if (i10 == 0) {
            g.b(obj2);
            Object objB = ((c) obj).b(this.f21610b);
            aVar.f21612b = 1;
            if (this.f21609a.a(objB, aVar) == aVar2) {
                return aVar2;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g.b(obj2);
        }
        return k.f22364a;
    }
}
