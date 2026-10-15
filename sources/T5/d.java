package T5;

import L5.k;
import U5.G;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import p004a6.l;

/* JADX INFO: compiled from: AndroidKeystoreKmsClient.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f4563a = new Object();

    public static boolean c(String str) {
        synchronized (f4563a) {
            try {
                String strB = l.b(str);
                try {
                    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                    keyStore.load(null);
                    if (keyStore.containsAlias(strB)) {
                        return false;
                    }
                    b.a(strB);
                    return true;
                } catch (IOException e9) {
                    throw new GeneralSecurityException(e9);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // L5.k
    public final c a(String str) throws GeneralSecurityException {
        c cVar;
        try {
            synchronized (f4563a) {
                cVar = new c(l.b(str));
                byte[] bArrA = G.a(10);
                byte[] bArr = new byte[0];
                if (!Arrays.equals(bArrA, cVar.b(cVar.a(bArrA, bArr), bArr))) {
                    throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
                }
            }
            return cVar;
        } catch (IOException e9) {
            throw new GeneralSecurityException(e9);
        }
    }

    @Override // L5.k
    public final boolean b(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }
}
