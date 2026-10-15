package cn.jpush.android.ad;

import android.util.Base64;
import android.util.Log;
import cn.jpush.android.helper.Logger;
import com.starburst.sdk.core.tts.EventType;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f11180f = e.b(new byte[]{87, 84, 99});

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f11181g = e.b(new byte[]{73, 83, 66, 31, 99, 91, 75, 57, 65, 123, 99, 74, 61, 70, 112, 84, 68, 112, 102, 113});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11175a = e.b(new byte[]{91, 85, 5});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11176b = e.b(new byte[]{99, 104, 88, 37, 39});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f11177c = e.b(new byte[]{74, 64, 87, 60, 2, 21, 47});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f11178d = e.b(new byte[]{87, 69, 109, 65, 120, 98, 68, 65, 119, 107, 115});

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f11179e = e.b(new byte[]{124, 112, 70, 65, 55, 123, 115, 114, 69, 82, 112, 124, 111, Utf8.REPLACEMENT_BYTE, 125, 69, 106, 123, 119, 118, 85, EventType.ERROR, 112, 111, 115, 98, 68});

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static HashMap<String, MessageDigest> f11182h = new HashMap<>();

    private static <T> T a(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static String b(String str, String str2) {
        try {
            return new String(a(str, str2, str2));
        } catch (Exception unused) {
            Logger.w("", "Unexpected - failed to AES decrypt.");
            return "";
        }
    }

    private static byte[] c(String str, String str2) throws UnsupportedEncodingException {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }

    public static String a(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(f11177c).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i9 = 0; i9 < bArrDigest.length; i9++) {
                String upperCase = Integer.toHexString(bArrDigest[i9] & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                if (i9 < bArrDigest.length - 1) {
                    sb.append(Constants.COLON_SEPARATOR);
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            Logger.w("Secure", " fail, error is " + th.getMessage());
            return "";
        }
    }

    public static String b(String str, String str2, String str3) {
        return new String(Base64.encode(a(str, b(str2), str3), 2), "UTF-8");
    }

    public static String a(String str, String str2) {
        try {
            return a(str.getBytes(), str2, str2);
        } catch (Exception unused) {
            Logger.w("", "Unexpected - failed to AES encrypt.");
            return "";
        }
    }

    private static RSAPublicKey b(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable th) {
            Log.d("JumpManager", "rsa loadRSAKey e=" + th);
            return null;
        }
    }

    public static String a(byte[] bArr, String str, String str2) {
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    private static IvParameterSpec a(byte[] bArr) {
        try {
            return (IvParameterSpec) a(IvParameterSpec.class, new Object[]{bArr}, (Class<?>[]) new Class[]{byte[].class});
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        return a(Base64.decode(str, 2), str2, str3, false);
    }

    private static synchronized byte[] a(String str, RSAPublicKey rSAPublicKey, String str2) {
        byte[] bArrDecode;
        Cipher cipher;
        bArrDecode = Base64.decode(str, 2);
        cipher = Cipher.getInstance(str2);
        cipher.init(2, rSAPublicKey);
        return Base64.decode(cipher.doFinal(bArrDecode), 2);
    }

    public static synchronized byte[] a(byte[] bArr, String str, String str2, boolean z8) {
        if (str == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(c(str, "UTF-8"), f11180f);
        IvParameterSpec ivParameterSpecA = a(str2.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance(f11181g);
        cipher.init(z8 ? 1 : 2, secretKeySpec, ivParameterSpecA);
        return cipher.doFinal(bArr);
    }
}
