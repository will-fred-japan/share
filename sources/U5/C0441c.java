package U5;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/* JADX INFO: renamed from: U5.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: KeyManagerRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0441c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f4699c = Logger.getLogger(C0441c.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0441c f4700d = new C0441c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f4701a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f4702b = new ConcurrentHashMap();

    public final L5.d a(Class cls, String str) throws GeneralSecurityException {
        L5.d<?> dVarB = b(str);
        if (dVarB.a().equals(cls)) {
            return dVarB;
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + dVarB.getClass() + ", which only supports: " + dVarB.a());
    }

    public final synchronized L5.d<?> b(String str) {
        if (!this.f4701a.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str + ", see https://developers.google.com/tink/faq/registration_errors");
        }
        return (L5.d) this.f4701a.get(str);
    }

    public final synchronized void c(C0446h c0446h) {
        try {
            String str = c0446h.f4709a;
            if (this.f4702b.containsKey(str) && !((Boolean) this.f4702b.get(str)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
            }
            L5.d dVar = (L5.d) this.f4701a.get(str);
            if (dVar != null && !dVar.getClass().equals(C0446h.class)) {
                f4699c.warning("Attempted overwrite of a registered key manager for key type ".concat(str));
                throw new GeneralSecurityException("typeUrl (" + str + ") is already registered with " + dVar.getClass().getName() + ", cannot be re-registered with " + C0446h.class.getName());
            }
            this.f4701a.putIfAbsent(str, c0446h);
            this.f4702b.put(str, Boolean.TRUE);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void d(C0446h c0446h) {
        e(c0446h, Q5.a.EnumC0044a.f3866a);
    }

    public final synchronized void e(C0446h c0446h, Q5.a.EnumC0044a enumC0044a) {
        if (!enumC0044a.a()) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        c(c0446h);
    }
}
