package U5;

import com.google.crypto.tink.shaded.protobuf.AbstractC0569h;
import com.google.crypto.tink.shaded.protobuf.Q;
import com.google.crypto.tink.shaded.protobuf.Z;
import java.security.GeneralSecurityException;

/* JADX INFO: renamed from: U5.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LegacyKeyManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0446h<P> implements L5.d<P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<P> f4710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Z5.y.b f4711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Z<? extends Q> f4712d;

    public C0446h(String str, Class<P> cls, Z5.y.b bVar, Z<? extends Q> z8) {
        this.f4712d = z8;
        this.f4709a = str;
        this.f4710b = cls;
        this.f4711c = bVar;
    }

    @Override // L5.d
    public final Class<P> a() {
        return this.f4710b;
    }

    @Override // L5.d
    public final P b(AbstractC0569h abstractC0569h) throws GeneralSecurityException {
        return (P) r.f4727b.a(s.f4729b.a(E.a(this.f4709a, abstractC0569h, this.f4711c, Z5.I.RAW, null)), this.f4710b);
    }

    @Override // L5.d
    public final Z5.y c(AbstractC0569h abstractC0569h) throws GeneralSecurityException {
        Z5.A.a aVarL = Z5.A.L();
        aVarL.m(this.f4709a);
        aVarL.n(abstractC0569h);
        aVarL.l(Z5.I.RAW);
        Z5.A aF = aVarL.f();
        F f6 = new F(aF, J.a(aF.J()));
        s sVar = s.f4729b;
        E e9 = (E) sVar.g(n.f4718b.b(sVar.b(f6), null));
        Z5.y.a aVarL2 = Z5.y.L();
        String str = e9.f4676a;
        aVarL2.i();
        Z5.y.D((Z5.y) aVarL2.f14171b, str);
        aVarL2.i();
        Z5.y.E((Z5.y) aVarL2.f14171b, e9.f4678c);
        Z5.y.b bVar = e9.f4679d;
        aVarL2.i();
        Z5.y.F((Z5.y) aVarL2.f14171b, bVar);
        return aVarL2.f();
    }
}
