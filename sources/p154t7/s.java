package p154t7;

import D7.c;
import V7.e;
import java.util.Set;
import p188x7.g;
import p188x7.k;

/* JADX INFO: compiled from: Emitters.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s<T> implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f21614a;

    /* JADX INFO: compiled from: Emitters.kt */
    @D7.e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", l = {223}, m = "emit")
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f21615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21616b;

        public a(B7.e eVar) {
            super(eVar);
        }

        @Override // D7.a
        public final Object invokeSuspend(Object obj) {
            this.f21615a = obj;
            this.f21616b |= Integer.MIN_VALUE;
            return s.this.a(null, this);
        }
    }

    public s(e eVar) {
        this.f21614a = eVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // V7.e
    public final Object a(Object obj, B7.e eVar) {
        a aVar;
        if (eVar instanceof a) {
            aVar = (a) eVar;
            int i9 = aVar.f21616b;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                aVar.f21616b = i9 - Integer.MIN_VALUE;
            } else {
                aVar = new a(eVar);
            }
        } else {
            aVar = new a(eVar);
        }
        Object obj2 = aVar.f21615a;
        C7.a aVar2 = C7.a.f1806a;
        int i10 = aVar.f21616b;
        if (i10 == 0) {
            g.b(obj2);
            Set<c0.c.a<?>> setKeySet = ((p015c0.c) obj).a().keySet();
            aVar.f21616b = 1;
            if (this.f21614a.a(setKeySet, aVar) == aVar2) {
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
