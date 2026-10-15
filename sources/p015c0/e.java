package p015c0;

import C7.a;
import D7.i;
import K7.p;
import p188x7.g;
import p188x7.k;
import y7.u;

/* JADX INFO: compiled from: Preferences.kt */
/* JADX INFO: loaded from: classes.dex */
@D7.e(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {358}, m = "invokeSuspend")
public final class e extends i implements p<c, B7.e<? super c>, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f8676d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(p<? super a, ? super B7.e<? super k>, ? extends Object> pVar, B7.e<? super e> eVar) {
        super(2, eVar);
        this.f8676d = (i) pVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [D7.i, K7.p] */
    @Override // D7.a
    public final B7.e<k> create(Object obj, B7.e<?> eVar) {
        e eVar2 = new e(this.f8676d, eVar);
        eVar2.f8675c = obj;
        return eVar2;
    }

    @Override // K7.p
    public final Object invoke(c cVar, B7.e<? super c> eVar) {
        return ((e) create(cVar, eVar)).invokeSuspend(k.f22364a);
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [D7.i, K7.p] */
    @Override // D7.a
    public final Object invokeSuspend(Object obj) {
        a aVar = a.f1806a;
        int i9 = this.f8674b;
        if (i9 != 0) {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a aVar2 = (a) this.f8675c;
            g.b(obj);
            return aVar2;
        }
        g.b(obj);
        a aVar3 = new a(u.J(((c) this.f8675c).a()), false);
        this.f8675c = aVar3;
        this.f8674b = 1;
        return this.f8676d.invoke(aVar3, this) == aVar ? aVar : aVar3;
    }
}
