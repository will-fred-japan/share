package L5;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: KmsClients.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<k> f2865a = new CopyOnWriteArrayList<>();

    public static k a(String str) throws GeneralSecurityException {
        for (k kVar : f2865a) {
            if (kVar.b(str)) {
                return kVar;
            }
        }
        throw new GeneralSecurityException(W5.e.l("No KMS client does support: ", str));
    }
}
