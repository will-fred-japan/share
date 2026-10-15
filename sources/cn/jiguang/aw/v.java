package cn.jiguang.aw;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<MessageDigest> f9561a = new ThreadLocal<MessageDigest>() { // from class: cn.jiguang.aw.v.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance(t.f9545a);
            } catch (Exception unused) {
                return null;
            }
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<MessageDigest> f9562b = new ThreadLocal<MessageDigest>() { // from class: cn.jiguang.aw.v.2
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance(t.f9546b);
            } catch (Exception unused) {
                return null;
            }
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<MessageDigest> f9563c = new ThreadLocal<MessageDigest>() { // from class: cn.jiguang.aw.v.3
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance(t.f9547c);
            } catch (Exception unused) {
                return null;
            }
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Pattern f9564d = Pattern.compile("((2[0-4]\\d|25[0-5]|[01]?\\d{1,2})\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d{1,2})");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static SimpleDateFormat f9565e = new SimpleDateFormat("HHH:mm:ss:SSS", Locale.ENGLISH);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Class<?> f9566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Method f9567g;

    public static String a(String str, String str2) {
        try {
            if (f9566f == null) {
                f9566f = Class.forName("android.os.SystemProperties");
            }
            if (f9567g == null) {
                f9567g = f9566f.getMethod("get", String.class, String.class);
            }
            return (String) f9567g.invoke(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String b(String str) {
        return a(str) ? "" : Pattern.compile("[^\\w#$@\\-一-龥]+").matcher(str).replaceAll("");
    }

    public static String c(byte[] bArr) {
        try {
            MessageDigest messageDigest = f9562b.get();
            if (messageDigest == null) {
                messageDigest = MessageDigest.getInstance(t.f9546b);
            }
            messageDigest.reset();
            byte[] bArrDigest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b9 : bArrDigest) {
                int i9 = b9 & 255;
                if (i9 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i9));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            cn.jiguang.x.f.c("StringUtils", "Get SHash error");
            return "";
        }
    }

    public static String d(String str) {
        try {
            MessageDigest messageDigest = f9561a.get();
            if (messageDigest == null) {
                messageDigest = MessageDigest.getInstance(t.f9545a);
            }
            messageDigest.reset();
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i9 = 0; i9 < charArray.length; i9++) {
                bArr[i9] = (byte) charArray[i9];
            }
            byte[] bArrDigest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b9 : bArrDigest) {
                int i10 = b9 & 255;
                if (i10 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i10));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] e(String str) {
        try {
            return a(str.getBytes());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String f(String str) {
        try {
            MessageDigest messageDigest = f9561a.get();
            if (messageDigest == null) {
                messageDigest = MessageDigest.getInstance(t.f9545a);
            }
            messageDigest.reset();
            byte[] bArrDigest = messageDigest.digest(str.getBytes("utf-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b9 : bArrDigest) {
                int i9 = b9 & 255;
                if (i9 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i9));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            cn.jiguang.x.f.c("StringUtils", "Get hash error");
            return "";
        }
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int iIndexOf = str.indexOf(Constants.COLON_SEPARATOR);
        if (iIndexOf >= 0) {
            if (iIndexOf != str.lastIndexOf(Constants.COLON_SEPARATOR)) {
                return false;
            }
            str = str.substring(0, iIndexOf);
        }
        return f9564d.matcher(str).matches();
    }

    public static boolean h(String str) {
        int iIndexOf;
        return (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf(Constants.COLON_SEPARATOR)) == -1 || str.lastIndexOf(Constants.COLON_SEPARATOR) == iIndexOf) ? false : true;
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Pattern.compile("[\\x20-\\x7E]+").matcher(str).matches();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static byte[] j(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (Throwable th) {
            cn.jiguang.x.f.m("StringUtils", "stringToUtf8Bytes error:" + th.getMessage());
            return str.getBytes();
        }
    }

    public static String k(String str) {
        if (str != null && !"".equals(str)) {
            try {
                MessageDigest messageDigest = f9561a.get();
                if (messageDigest == null) {
                    messageDigest = MessageDigest.getInstance(t.f9545a);
                }
                messageDigest.reset();
                messageDigest.update(str.getBytes());
                return b(messageDigest.digest());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String l(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return c(str.getBytes("utf-8"));
        } catch (Throwable unused) {
            return str;
        }
    }

    public static JSONObject a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objA = bundle.get(str);
                try {
                    if (!(objA instanceof String) && !(objA instanceof Integer) && !(objA instanceof Boolean) && !(objA instanceof Double) && !(objA instanceof Float) && !(objA instanceof Long)) {
                        objA = objA instanceof Bundle ? a((Bundle) objA) : String.valueOf(objA);
                    }
                    jSONObject.put(str, objA);
                } catch (Exception unused) {
                }
            }
        }
        return jSONObject;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b9 : bArr) {
            a(stringBuffer, b9);
        }
        return stringBuffer.toString();
    }

    public static byte[] c(String str) {
        try {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i9 = 0; i9 < charArray.length; i9++) {
                bArr[i9] = (byte) charArray[i9];
            }
            MessageDigest messageDigest = f9561a.get();
            if (messageDigest == null) {
                messageDigest = MessageDigest.getInstance(t.f9545a);
            }
            messageDigest.reset();
            return messageDigest.digest(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String d(byte[] bArr) {
        try {
            MessageDigest messageDigest = f9561a.get();
            if (messageDigest == null) {
                messageDigest = MessageDigest.getInstance(t.f9545a);
            }
            messageDigest.reset();
            byte[] bArrDigest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b9 : bArrDigest) {
                int i9 = b9 & 255;
                if (i9 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i9));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            cn.jiguang.x.f.c("StringUtils", "Get Hash error");
            return "";
        }
    }

    public static void a(Context context, List<String> list) {
        if (!b.e(context) || list == null || list.size() < 2 || list.get(0).contains("ipv6")) {
            return;
        }
        Collections.swap(list, 0, 1);
    }

    public static HashMap<String, Object> b(Bundle bundle) {
        HashMap<String, Object> map = new HashMap<>();
        if (bundle != null) {
            try {
                for (String str : bundle.keySet()) {
                    map.put(str, bundle.get(str));
                }
            } catch (Throwable unused) {
            }
        }
        return map;
    }

    private static void a(StringBuffer stringBuffer, byte b9) {
        stringBuffer.append("0123456789ABCDEF".charAt((b9 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b9 & 15));
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    public static byte[] a(byte[] bArr) {
        try {
            MessageDigest messageDigest = f9563c.get();
            if (messageDigest == null) {
                messageDigest = MessageDigest.getInstance(t.f9547c);
            }
            messageDigest.reset();
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }
}
