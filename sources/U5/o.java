package U5;

import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: compiled from: MutableKeyDerivationRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f4720b = new o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4721a = new HashMap();

    /* JADX INFO: compiled from: MutableKeyDerivationRegistry.java */
    public interface a<ParametersT extends L5.n> {
    }

    public final synchronized <ParametersT extends L5.n> void a(a<ParametersT> aVar, Class<ParametersT> cls) {
        try {
            a aVar2 = (a) this.f4721a.get(cls);
            if (aVar2 != null && !aVar2.equals(aVar)) {
                throw new GeneralSecurityException("Different key creator for parameters class already inserted");
            }
            this.f4721a.put(cls, aVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
