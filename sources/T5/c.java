package T5;

import android.util.Log;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.ProviderException;
import javax.crypto.BadPaddingException;

/* JADX INFO: compiled from: AndroidKeystoreAesGcm.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements L5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b.a f4562a;

    public c(String str) throws GeneralSecurityException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            this.f4562a = new b.a(str, keyStore);
        } catch (IOException e9) {
            throw new GeneralSecurityException(e9);
        }
    }

    @Override // L5.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        b.a aVar = this.f4562a;
        try {
            return aVar.a(bArr, bArr2);
        } catch (GeneralSecurityException | ProviderException e9) {
            Log.w("c", "encountered a potentially transient KeyStore error, will wait and retry", e9);
            try {
                Thread.sleep((int) (Math.random() * 100.0d));
            } catch (InterruptedException unused) {
            }
            return aVar.a(bArr, bArr2);
        }
    }

    @Override // L5.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws BadPaddingException {
        b.a aVar = this.f4562a;
        try {
            return aVar.b(bArr, bArr2);
        } catch (ProviderException e9) {
            e = e9;
            Log.w("c", "encountered a potentially transient KeyStore error, will wait and retry", e);
            try {
                Thread.sleep((int) (Math.random() * 100.0d));
            } catch (InterruptedException unused) {
            }
            return aVar.b(bArr, bArr2);
        } catch (BadPaddingException e10) {
            throw e10;
        } catch (GeneralSecurityException e11) {
            e = e11;
            Log.w("c", "encountered a potentially transient KeyStore error, will wait and retry", e);
            Thread.sleep((int) (Math.random() * 100.0d));
            return aVar.b(bArr, bArr2);
        }
    }
}
