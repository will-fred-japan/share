package U5;

import M5.C0327k;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: compiled from: MutableKeyCreationRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f4718b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4719a = new HashMap();

    static {
        C0327k c0327k = new C0327k(3);
        n nVar = new n();
        try {
            nVar.a(c0327k, C0448j.class);
            f4718b = nVar;
        } catch (GeneralSecurityException e9) {
            throw new IllegalStateException("unexpected error.", e9);
        }
    }

    public final synchronized <ParametersT extends L5.n> void a(InterfaceC0440b<ParametersT> interfaceC0440b, Class<ParametersT> cls) {
        try {
            InterfaceC0440b interfaceC0440b2 = (InterfaceC0440b) this.f4719a.get(cls);
            if (interfaceC0440b2 != null && !interfaceC0440b2.equals(interfaceC0440b)) {
                throw new GeneralSecurityException("Different key creator for parameters class " + cls + " already inserted");
            }
            this.f4719a.put(cls, interfaceC0440b);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final A0.h b(L5.n nVar, Integer num) {
        A0.h hVarA;
        synchronized (this) {
            InterfaceC0440b interfaceC0440b = (InterfaceC0440b) this.f4719a.get(nVar.getClass());
            if (interfaceC0440b == null) {
                throw new GeneralSecurityException("Cannot create a new key for parameters " + nVar + ": no key creator for this class was registered.");
            }
            hVarA = interfaceC0440b.a(nVar, num);
        }
        return hVarA;
    }
}
