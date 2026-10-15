package p057h6;

import android.content.Context;
import android.util.Base64;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: LegacyNamespaceKeyRecovery.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b[] f19095a = {b.RSA_ECB_OAEPwithSHA_256andMGF1Padding, b.RSA_ECB_PKCS1Padding};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f19096b = {"AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", "VGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", "VGhpcyBpcyB0aGUga2V5IGZvcihBIHNlY3XyZZBzdG9yYWdlIEFFUyBLZXkK"};

    /* JADX INFO: compiled from: LegacyNamespaceKeyRecovery.java */
    public interface a {
    }

    public static boolean a(byte[] bArr, SecretKeySpec secretKeySpec, String str, int i9, AlgorithmParameterSpec algorithmParameterSpec) {
        if (bArr.length <= i9) {
            return false;
        }
        try {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i9, bArr.length);
            Cipher cipher = Cipher.getInstance(str);
            cipher.init(2, secretKeySpec, algorithmParameterSpec);
            cipher.doFinal(bArrCopyOfRange);
            return true;
        } catch (Throwable th) {
            if (th instanceof VirtualMachineError) {
                throw th;
            }
            return false;
        }
    }

    public static boolean b(Context context, String str, String str2, byte[] bArr) {
        String strC = c(context, str, str2);
        if (strC != null) {
            try {
                byte[] bArrDecode = Base64.decode(strC, 0);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                if (a(bArrDecode, secretKeySpec, "AES/GCM/NoPadding", 12, new GCMParameterSpec(128, bArrDecode.length >= 12 ? Arrays.copyOfRange(bArrDecode, 0, 12) : new byte[0]))) {
                    return true;
                }
                if (a(bArrDecode, secretKeySpec, "AES/CBC/PKCS7Padding", 16, new IvParameterSpec(bArrDecode.length >= 16 ? Arrays.copyOfRange(bArrDecode, 0, 16) : new byte[0]))) {
                    return true;
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    public static String c(Context context, String str, String str2) {
        for (Map.Entry<String, ?> entry : context.getSharedPreferences(str, 0).getAll().entrySet()) {
            if ((entry.getValue() instanceof String) && entry.getKey().contains(str2)) {
                return (String) entry.getValue();
            }
        }
        return null;
    }
}
