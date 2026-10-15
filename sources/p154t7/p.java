package p154t7;

import D7.e;
import D7.i;
import p015c0.a;
import p015c0.c;
import p188x7.g;
import p188x7.k;

/* JADX INFO: compiled from: SharedPreferencesPlugin.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$dataStoreSetString$2", f = "SharedPreferencesPlugin.kt", l = {}, m = "invokeSuspend")
public final class p extends i implements K7.p<a, B7.e<? super k>, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f21598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c.a<String> f21599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f21600d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(c.a<String> aVar, String str, B7.e<? super p> eVar) {
        super(2, eVar);
        this.f21599c = aVar;
        this.f21600d = str;
    }

    @Override // D7.a
    public final B7.e<k> create(Object obj, B7.e<?> eVar) {
        p pVar = new p(this.f21599c, this.f21600d, eVar);
        pVar.f21598b = obj;
        return pVar;
    }

    @Override // K7.p
    public final Object invoke(a aVar, B7.e<? super k> eVar) {
        return ((p) create(aVar, eVar)).invokeSuspend(k.f22364a);
    }

    @Override // D7.a
    public final Object invokeSuspend(Object obj) {
        C7.a aVar = C7.a.f1806a;
        g.b(obj);
        ((a) this.f21598b).d(this.f21599c, this.f21600d);
        return k.f22364a;
    }
}
