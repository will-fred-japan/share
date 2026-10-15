package U5;

import java.security.Provider;
import java.security.Security;

/* JADX INFO: renamed from: U5.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ConscryptUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0439a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f4698a = {"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"};

    public static Provider a() {
        String[] strArr = f4698a;
        for (int i9 = 0; i9 < 3; i9++) {
            Provider provider = Security.getProvider(strArr[i9]);
            if (provider != null) {
                return provider;
            }
        }
        return null;
    }
}
