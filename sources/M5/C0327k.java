package M5;

import U5.C0441c;
import U5.C0447i;
import U5.C0448j;
import U5.InterfaceC0440b;
import java.security.GeneralSecurityException;

/* JADX INFO: renamed from: M5.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0327k implements InterfaceC0440b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3019a;

    public /* synthetic */ C0327k(int i9) {
        this.f3019a = i9;
    }

    @Override // U5.InterfaceC0440b
    public final A0.h a(L5.n nVar, Integer num) throws GeneralSecurityException {
        switch (this.f3019a) {
            case 0:
                C0329m c0329m = (C0329m) nVar;
                int i9 = c0329m.f3023a;
                if (i9 == 24) {
                    throw new GeneralSecurityException("192 bit AES EAX Parameters are not valid");
                }
                C0326j.a aVar = new C0326j.a();
                aVar.f3017b = null;
                aVar.f3016a = c0329m;
                aVar.f3018c = num;
                aVar.f3017b = J6.a.f(i9);
                return aVar.a();
            case 1:
                return u.y(((w) nVar).f3086a, J6.a.f(32), num);
            case 2:
                return D.y((E) nVar, num);
            default:
                Z5.A a3 = ((C0448j) nVar).f4716a.f4683b;
                C0441c c0441c = C0441c.f4700d;
                L5.d<?> dVarB = c0441c.b(a3.J());
                if (!((Boolean) c0441c.f4702b.get(a3.J())).booleanValue()) {
                    throw new GeneralSecurityException("Creating new keys is not allowed.");
                }
                Z5.y yVarC = dVarB.c(a3.K());
                return new C0447i(U5.E.a(yVarC.J(), yVarC.K(), yVarC.I(), a3.I(), num));
        }
    }
}
