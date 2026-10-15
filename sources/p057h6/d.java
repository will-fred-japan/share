package p057h6;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import p049g6.n;

/* JADX INFO: compiled from: KeyCipherImplementationAES23.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f19090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f19091c;

    public d(Context context, n nVar) throws Exception {
        this.f19090b = context;
        this.f19091c = nVar;
        this.f19089a = context.getPackageName() + ".FlutterSecureStoragePluginKey" + nVar.d();
        e();
    }

    @Override // p057h6.a
    public final byte[] a(Key key) {
        throw new UnsupportedOperationException("AES symmetric keys in AndroidKeyStore cannot wrap other keys");
    }

    @Override // p057h6.a
    public final Cipher b(Context context) throws Exception {
        e();
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Key key = keyStore.getKey(this.f19089a, null);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.f19091c.c(), 0);
        String string = sharedPreferences.getString("KeyStoreIV1", null);
        if (string != null && sharedPreferences.contains("BVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK")) {
            cipher.init(2, key, new GCMParameterSpec(128, Base64.decode(string, 0)));
            return cipher;
        }
        cipher.init(1, key);
        byte[] iv = cipher.getIV();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("KeyStoreIV1", Base64.encodeToString(iv, 0));
        editorEdit.apply();
        return cipher;
    }

    @Override // p057h6.a
    public final Key c(byte[] bArr) {
        throw new UnsupportedOperationException("AES symmetric keys in AndroidKeyStore cannot unwrap other keys");
    }

    @Override // p057h6.a
    public final void d() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        keyStore.deleteEntry(this.f19089a);
        this.f19090b.getSharedPreferences(this.f19091c.c(), 0).edit().remove("KeyStoreIV1").apply();
    }

    public final void e() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        String str = this.f19089a;
        Key key = keyStore.getKey(str, null);
        if (key == null) {
            f();
            return;
        }
        if (key instanceof SecretKey) {
            return;
        }
        Log.w("AESCipher23", "Alias " + str + " holds a " + key.getClass().getSimpleName() + ", not a SecretKey, replacing it with a fresh symmetric key");
        keyStore.deleteEntry(str);
        f();
    }

    public final void f() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        Context context = this.f19090b;
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        boolean z8 = keyguardManager != null && keyguardManager.isDeviceSecure();
        n nVar = this.f19091c;
        if (nVar.f18953h && !z8) {
            throw new Exception("BIOMETRIC_UNAVAILABLE: Biometric enforcement enabled but device has no PIN, pattern, password, or biometric enrolled. Cannot generate secure key.");
        }
        if (!z8) {
            Log.w("AESCipher23", "Device has no PIN/biometric security. Generating key without user authentication requirement (enforceBiometrics=false).");
        }
        String str = this.f19089a;
        KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256);
        boolean z9 = nVar.f18954i;
        if (z8) {
            keySize.setUserAuthenticationRequired(true);
            if (Build.VERSION.SDK_INT >= 30) {
                keySize.setUserAuthenticationParameters(0, z9 ? 2 : 3);
            } else {
                keySize.setUserAuthenticationValidityDurationSeconds(-1);
            }
            keySize.setInvalidatedByBiometricEnrollment(true);
        } else {
            keySize.setUserAuthenticationRequired(false);
        }
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 28) {
            keySize.setUnlockedDeviceRequired(true);
            if (i9 < 28 ? false : context.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
                keySize.setIsStrongBoxBacked(true);
                Log.d("AESCipher23", "StrongBox is available and enabled for biometric key");
            } else {
                Log.w("AESCipher23", "StrongBox requested but not available on this device. Using standard TEE.");
            }
        }
        try {
            keyGenerator.init(keySize.build());
            keyGenerator.generateKey();
        } catch (Exception e9) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28) {
                if (i10 < 28 ? false : context.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
                    Log.w("AESCipher23", " Key generation failed with StrongBox. Retrying without StrongBox.", e9);
                    KeyGenParameterSpec.Builder unlockedDeviceRequired = new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).setUnlockedDeviceRequired(true);
                    if (z8) {
                        unlockedDeviceRequired.setUserAuthenticationRequired(true);
                        if (i10 >= 30) {
                            unlockedDeviceRequired.setUserAuthenticationParameters(0, z9 ? 2 : 3);
                        } else {
                            unlockedDeviceRequired.setUserAuthenticationValidityDurationSeconds(-1);
                        }
                        unlockedDeviceRequired.setInvalidatedByBiometricEnrollment(true);
                    }
                    keyGenerator.init(unlockedDeviceRequired.build());
                    keyGenerator.generateKey();
                    Log.d("AESCipher23", "Key generation succeeded without StrongBox");
                    return;
                }
            }
            throw e9;
        }
    }
}
