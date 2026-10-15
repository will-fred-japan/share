package cn.jiguang.commons.a;

import android.text.TextUtils;
import android.util.Base64;
import java.lang.ref.WeakReference;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class km {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<WeakReference<ko>> f10366a = new kn();

    public static String a(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return a(str.getBytes("UTF-8"), str2, str2);
            } catch (Throwable th) {
                defpackage.f.n(th, new StringBuilder("failed to aes encrypt: "), "SECURE");
            }
        }
        return "";
    }

    public static String b(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return new String(a(str, str2, str2), "UTF-8");
            } catch (Throwable th) {
                defpackage.f.n(th, new StringBuilder("failed to aes decrypt: "), "SECURE");
            }
        }
        return "";
    }

    public static String a(byte[] bArr, String str, String str2) {
        if (bArr == null || str == null || str2 == null) {
            return null;
        }
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    public static byte[] a(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            return null;
        }
        return a(Base64.decode(str, 2), str2, str3, false);
    }

    public static byte[] a(byte[] bArr, String str, String str2, boolean z8) {
        byte[] bArr2;
        if (str == null || str2 == null || bArr == null) {
            return null;
        }
        ThreadLocal<WeakReference<ko>> threadLocal = f10366a;
        WeakReference<ko> weakReference = threadLocal.get();
        ko koVar = weakReference != null ? weakReference.get() : null;
        if (koVar == null || koVar.f10367a == null) {
            ko koVar2 = new ko(Cipher.getInstance(d.j));
            threadLocal.set(new WeakReference<>(koVar2));
            koVar = koVar2;
        }
        try {
            if (!TextUtils.equals(koVar.f10368b, str) || !TextUtils.equals(koVar.f10369c, str2) || !Objects.equals(koVar.f10370d, Boolean.valueOf(z8))) {
                if (TextUtils.isEmpty(str)) {
                    bArr2 = new byte[0];
                } else {
                    int length = str.length() / 2;
                    byte[] bytes = str.substring(0, length).getBytes("UTF-8");
                    byte[] bytes2 = str.substring(length).getBytes("UTF-8");
                    byte[] bArr3 = new byte[bytes.length + bytes2.length];
                    System.arraycopy(bytes, 0, bArr3, 0, bytes.length);
                    System.arraycopy(bytes2, 0, bArr3, bytes.length, bytes2.length);
                    bArr2 = bArr3;
                }
                koVar.f10367a.init(z8 ? 1 : 2, new SecretKeySpec(bArr2, d.f9867i), new IvParameterSpec(str2.getBytes("UTF-8")));
                koVar.f10368b = str;
                koVar.f10369c = str2;
                koVar.f10370d = Boolean.valueOf(z8);
            }
            return koVar.f10367a.doFinal(bArr);
        } catch (Throwable th) {
            f10366a.remove();
            throw th;
        }
    }
}
