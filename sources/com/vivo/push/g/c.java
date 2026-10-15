package com.vivo.push.g;

import A.f;
import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.w;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: RsaSecurity.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PrivateKey f16608a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PublicKey f16609b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private KeyStore f16610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private X500Principal f16611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f16612e;

    public c(Context context) {
        this.f16612e = context;
        a(context);
    }

    private synchronized void a(Context context) {
        try {
            b();
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
        } catch (Exception e9) {
            e9.printStackTrace();
            w.a("RsaSecurity", "init error" + e9.getMessage());
        }
    }

    private void b(Context context) {
        try {
            if (context == null) {
                w.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                return;
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 999);
            KeyPairGeneratorSpec keyPairGeneratorSpecBuild = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(this.f16611d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(keyPairGeneratorSpecBuild);
            keyPairGenerator.generateKeyPair();
        } catch (Exception e9) {
            e9.printStackTrace();
            f.m(e9, new StringBuilder("generateRSAKeyPairSign error"), "RsaSecurity");
        }
    }

    private PrivateKey c(Context context) {
        try {
            PrivateKey privateKey = this.f16608a;
            if (privateKey != null) {
                return privateKey;
            }
            if (context == null) {
                w.d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            KeyStore.Entry entryD = d(context);
            if (entryD instanceof KeyStore.PrivateKeyEntry) {
                PrivateKey privateKey2 = ((KeyStore.PrivateKeyEntry) entryD).getPrivateKey();
                this.f16608a = privateKey2;
                return privateKey2;
            }
            return null;
        } catch (Exception e9) {
            e9.printStackTrace();
            f.m(e9, new StringBuilder("getPrivateKeySigin error"), "RsaSecurity");
        }
    }

    private KeyStore.Entry d(Context context) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException {
        try {
            if (context == null) {
                w.d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
            return this.f16610c.getEntry("PushRsaKeyAlias", null);
        } catch (Exception e9) {
            b(context);
            KeyStore.Entry entry = this.f16610c.getEntry("PushRsaKeyAlias", null);
            e9.printStackTrace();
            f.m(e9, new StringBuilder("getPrivateKeySigin error"), "RsaSecurity");
            return entry;
        }
    }

    @Override // com.vivo.push.g.a
    public final String a(String str) {
        try {
            if (TextUtils.isEmpty(str) || c(this.f16612e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey privateKeyC = c(this.f16612e);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKeyC);
            signature.update(bytes);
            String strEncodeToString = Base64.encodeToString(signature.sign(), 2);
            w.d("RsaSecurity", str.hashCode() + " = " + strEncodeToString);
            return strEncodeToString;
        } catch (Exception e9) {
            e9.printStackTrace();
            f.m(e9, new StringBuilder("signClientSDK error"), "RsaSecurity");
            return null;
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.f16610c == null) {
                b();
            }
            return this.f16610c.containsAlias(str);
        } catch (Exception e9) {
            e9.printStackTrace();
            f.m(e9, new StringBuilder("getPrivateKeySigin error"), "RsaSecurity");
            return false;
        }
    }

    @Override // com.vivo.push.g.a
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e9) {
            e9.printStackTrace();
            f.m(e9, new StringBuilder("verifyClientSDK error"), "RsaSecurity");
            return false;
        }
    }

    private void b() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f16610c = keyStore;
            keyStore.load(null);
            this.f16611d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e9) {
            e9.printStackTrace();
            f.m(e9, new StringBuilder("initKeyStore error"), "RsaSecurity");
        }
    }

    @Override // com.vivo.push.g.a
    public final PublicKey a() {
        try {
            PublicKey publicKey = this.f16609b;
            if (publicKey != null) {
                return publicKey;
            }
            KeyStore.Entry entryD = d(this.f16612e);
            if (!(entryD instanceof KeyStore.PrivateKeyEntry)) {
                return null;
            }
            PublicKey publicKey2 = ((KeyStore.PrivateKeyEntry) entryD).getCertificate().getPublicKey();
            this.f16609b = publicKey2;
            return publicKey2;
        } catch (Exception e9) {
            e9.printStackTrace();
            f.m(e9, new StringBuilder("getPublicKeySign error"), "RsaSecurity");
            return null;
        }
    }
}
