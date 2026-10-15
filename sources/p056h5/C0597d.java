package p056h5;

import P4.a;
import P4.c;
import Q4.C0352h;
import S4.C0376g;
import android.text.TextUtils;
import p071j5.AbstractC0609a;
import p094m5.h;
import p094m5.n;
import p185x4.d;

/* JADX INFO: renamed from: h5.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0597d extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f19058i = new a("LocationServices.API", new C0595b(), new a.f());

    public final n d(d.a aVar) {
        String simpleName = AbstractC0609a.class.getSimpleName();
        C0376g.f(aVar, "Listener must not be null");
        if (TextUtils.isEmpty(simpleName)) {
            throw new IllegalArgumentException("Listener type must not be empty");
        }
        n nVarB = b(new C0352h.a<>(aVar, simpleName), 2418);
        nVarB.getClass();
        n nVar = new n();
        nVarB.f20369b.a(new h(nVar));
        nVarB.f();
        return nVar;
    }
}
