package cn.jiguang.v;

import android.util.Base64;
import java.security.MessageDigest;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10824a = cn.jiguang.t.a.b(new byte[]{33, 1, 18, 42, 60, 35, 39, 7, 24, 32, 73, 84, 82, 116, 101, 95});

    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 2));
    }

    public static String b(String str) {
        return c(str) ? "" : Pattern.compile("[^\\w#$@\\-一-龥]+").matcher(str).replaceAll("");
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    public static String d(String str) {
        if (str != null && !"".equals(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(i.f10822c);
                messageDigest.update(str.getBytes());
                return a(messageDigest.digest());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b9 : bArr) {
            a(stringBuffer, b9);
        }
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, byte b9) {
        String str = f10824a;
        stringBuffer.append(str.charAt((b9 >> 4) & 15));
        stringBuffer.append(str.charAt(b9 & 15));
    }
}
