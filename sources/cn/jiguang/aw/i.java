package cn.jiguang.aw;

import android.util.Base64;
import com.starburst.sdk.core.tts.EventType;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9511a = l.b(new byte[]{77, 85});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9512b = l.b(new byte[]{84, 115, EventType.ERROR, 81});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9513c = l.b(new byte[]{101, 116, 83, 80, 43, 61, 32, 99, 1});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9514d = t.f9548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f9515e = t.f9549e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f9516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f9517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f9518c;

        public a(byte[] bArr, String str, byte[] bArr2) {
            this.f9516a = bArr;
            this.f9518c = str;
            this.f9517b = bArr2;
        }
    }

    public static KeyPair a() {
        return a(f9513c);
    }

    public static PublicKey b(String str) {
        if (str == null || str.isEmpty()) {
            cn.jiguang.x.f.i("ECCUtils", "Public key string cannot be null or empty");
            return null;
        }
        try {
            return KeyFactory.getInstance(f9511a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable th) {
            cn.jiguang.x.f.b("ECCUtils", "Failed to restore public key from Base64: " + th.getMessage(), th);
            return null;
        }
    }

    public static a c(String str) {
        try {
            KeyPair keyPairA = a();
            if (keyPairA == null) {
                cn.jiguang.x.f.i("ECCUtils", "Failed to generate temporary key pair");
                return null;
            }
            PrivateKey privateKey = keyPairA.getPrivate();
            byte[] encoded = keyPairA.getPublic().getEncoded();
            String strEncodeToString = Base64.encodeToString(encoded, 2);
            PublicKey publicKeyB = b(str);
            if (publicKeyB == null) {
                cn.jiguang.x.f.i("ECCUtils", "Failed to restore public key from Base64");
                return null;
            }
            byte[] bArrA = a(privateKey, publicKeyB);
            if (bArrA == null) {
                return null;
            }
            return new a(bArrA, strEncodeToString, encoded);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static KeyPair a(String str) {
        if (str == null || str.isEmpty()) {
            cn.jiguang.x.f.i("ECCUtils", "Curve name cannot be null or empty");
            return null;
        }
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(f9511a);
            keyPairGenerator.initialize(new ECGenParameterSpec(str), new SecureRandom());
            return keyPairGenerator.generateKeyPair();
        } catch (Throwable th) {
            cn.jiguang.x.f.b("ECCUtils", "Failed to generate ECC key pair: " + th.getMessage(), th);
            return null;
        }
    }

    public static byte[] a(PrivateKey privateKey, PublicKey publicKey) {
        if (privateKey == null || publicKey == null) {
            cn.jiguang.x.f.i("ECCUtils", "Private key and public key cannot be null");
            return null;
        }
        try {
            KeyAgreement keyAgreement = KeyAgreement.getInstance(f9512b);
            keyAgreement.init(privateKey);
            keyAgreement.doPhase(publicKey, true);
            return keyAgreement.generateSecret();
        } catch (Throwable th) {
            cn.jiguang.x.f.b("ECCUtils", "Failed to generate shared secret: " + th.getMessage(), th);
            return null;
        }
    }
}
