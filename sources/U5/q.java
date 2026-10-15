package U5;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MutableParametersRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f4725b = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4726a = new HashMap();

    public final synchronized void a(String str, L5.n nVar) {
        try {
            if (!this.f4726a.containsKey(str)) {
                this.f4726a.put(str, nVar);
                return;
            }
            if (((L5.n) this.f4726a.get(str)).equals(nVar)) {
                return;
            }
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + this.f4726a.get(str) + "), cannot insert " + nVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Map<String, L5.n> map) {
        for (Map.Entry<String, L5.n> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }
}
