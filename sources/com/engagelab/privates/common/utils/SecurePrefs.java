package com.engagelab.privates.common.utils;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import java.security.KeyStore;
import java.security.UnrecoverableEntryException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes.dex */
public final class SecurePrefs {
    private static final int GCM_TAG_LENGTH_BITS = 128;
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String KEY_ALIAS = "engagelab_sdk_sp_key";
    private static final Object KEY_LOCK = new Object();
    private static final int KEY_SIZE_BITS = 128;
    private static final String TRANSFORMATION = "AES/GCM/NoPadding";

    private SecurePrefs() {
    }

    public static String decrypt(String str) {
        int i9;
        if (str == null || str.isEmpty()) {
            return str;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            if (bArrDecode.length < 2) {
                throw new IllegalArgumentException("cipher too short");
            }
            int i10 = bArrDecode[0] & 255;
            if (i10 <= 0 || bArrDecode.length <= (i9 = i10 + 1)) {
                throw new IllegalArgumentException("cipher malformed, ivLen=" + i10);
            }
            byte[] bArr = new byte[i10];
            System.arraycopy(bArrDecode, 1, bArr, 0, i10);
            int length = (bArrDecode.length - 1) - i10;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArrDecode, i9, bArr2, 0, length);
            SecretKey orCreateKey = getOrCreateKey();
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(2, orCreateKey, new GCMParameterSpec(128, bArr));
            return new String(cipher.doFinal(bArr2), "UTF-8");
        } catch (Throwable th) {
            throw new RuntimeException("SecurePrefs decrypt failed: " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public static String encrypt(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        try {
            SecretKey orCreateKey = getOrCreateKey();
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(1, orCreateKey);
            byte[] iv = cipher.getIV();
            byte[] bArrDoFinal = cipher.doFinal(str.getBytes("UTF-8"));
            byte[] bArr = new byte[iv.length + 1 + bArrDoFinal.length];
            bArr[0] = (byte) iv.length;
            System.arraycopy(iv, 0, bArr, 1, iv.length);
            System.arraycopy(bArrDoFinal, 0, bArr, iv.length + 1, bArrDoFinal.length);
            return Base64.encodeToString(bArr, 2);
        } catch (Throwable th) {
            throw new RuntimeException("SecurePrefs encrypt failed: " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    private static SecretKey getOrCreateKey() {
        synchronized (KEY_LOCK) {
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
            KeyStore.Entry entry = null;
            keyStore.load(null);
            try {
                entry = keyStore.getEntry(KEY_ALIAS, null);
            } catch (UnrecoverableEntryException unused) {
                keyStore.deleteEntry(KEY_ALIAS);
            }
            if (entry instanceof KeyStore.SecretKeyEntry) {
                return ((KeyStore.SecretKeyEntry) entry).getSecretKey();
            }
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", KEYSTORE_PROVIDER);
            keyGenerator.init(new KeyGenParameterSpec.Builder(KEY_ALIAS, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(128).build());
            return keyGenerator.generateKey();
        }
    }
}
