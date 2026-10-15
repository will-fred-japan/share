package L5;

import U5.C0448j;
import U5.F;
import U5.I;
import U5.J;
import U5.s;
import Z5.A;
import com.google.crypto.tink.shaded.protobuf.C0576o;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: KeysetHandle.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f2852a = new h();

    public static n a(byte[] bArr) throws GeneralSecurityException {
        try {
            A aN = A.N(bArr, C0576o.a());
            s sVar = s.f4729b;
            p012b6.a aVarA = J.a(aN.J());
            F f6 = new F(aN, aVarA);
            I i9 = sVar.f4730a.get();
            i9.getClass();
            return !i9.f4688d.containsKey(new I.b(F.class, aVarA)) ? new C0448j(f6) : sVar.b(f6);
        } catch (IOException e9) {
            throw new GeneralSecurityException("Failed to parse proto", e9);
        }
    }

    public static byte[] b(n nVar) {
        return nVar instanceof C0448j ? ((C0448j) nVar).f4716a.f4683b.j() : ((F) s.f4729b.h(nVar)).f4683b.j();
    }
}
