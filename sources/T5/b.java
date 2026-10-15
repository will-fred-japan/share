package T5;

import android.security.keystore.KeyGenParameterSpec;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: compiled from: AndroidKeystore.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: compiled from: AndroidKeystore.java */
    public static final class a implements L5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SecretKey f4561a;

        public a(String str, KeyStore keyStore) throws InvalidKeyException {
            SecretKey secretKey = (SecretKey) keyStore.getKey(str, null);
            this.f4561a = secretKey;
            if (secretKey == null) {
                throw new InvalidKeyException(W5.e.l("Keystore cannot load the key with ID: ", str));
            }
        }

        @Override // L5.a
        public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 2147483619) {
                throw new GeneralSecurityException("plaintext too long");
            }
            byte[] bArr3 = new byte[bArr.length + 28];
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, this.f4561a);
            cipher.updateAAD(bArr2);
            if (cipher.doFinal(bArr, 0, bArr.length, bArr3, 12) != bArr.length + 16) {
                throw new GeneralSecurityException("encryption failed: bytesWritten is wrong");
            }
            byte[] iv = cipher.getIV();
            if (iv.length != 12) {
                throw new GeneralSecurityException("IV has unexpected length");
            }
            System.arraycopy(iv, 0, bArr3, 0, 12);
            return bArr3;
        }

        @Override // L5.a
        public final byte[] b(byte[] bArr, byte[] bArr2) throws BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
            if (bArr.length < 28) {
                throw new BadPaddingException("ciphertext too short");
            }
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, this.f4561a, gCMParameterSpec);
            cipher.updateAAD(bArr2);
            return cipher.doFinal(bArr, 12, bArr.length - 12);
        }
    }

    public static void a(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(str, 3).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(keyGenParameterSpecBuild);
        keyGenerator.generateKey();
    }
}
