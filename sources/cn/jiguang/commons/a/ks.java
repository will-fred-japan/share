package cn.jiguang.commons.a;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f10381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f10382b;

    public static String a(Object obj) {
        if (obj == null) {
            return "null";
        }
        if ((obj instanceof CharSequence) || (obj instanceof Number) || (obj instanceof Boolean)) {
            return String.valueOf(obj);
        }
        return "obj(" + obj.getClass().getSimpleName() + ")";
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : Pattern.compile("[^\\w#$@\\-一-龥]+").matcher(str).replaceAll("");
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Pattern.compile("([A-Fa-f0-9]{2}[-:]){5,}[A-Fa-f0-9]{2}").matcher(str).matches();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i9 = 0; i9 < charArray.length; i9++) {
            charArray[i9] = (char) (charArray[i9] ^ 24538);
        }
        return new String(charArray);
    }

    public static String b(String str, boolean z8) {
        try {
            byte[] bArrA = a(str.getBytes("UTF-8"));
            String str2 = f.f10031c;
            return Base64.encodeToString(km.a(bArrA, str2, str2, true), 2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(String str, String str2) {
        try {
            if (f10381a == null) {
                f10381a = Class.forName("android.os.SystemProperties");
            }
            if (f10382b == null) {
                f10382b = f10381a.getMethod("get", String.class, String.class);
            }
            return (String) f10382b.invoke(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Collection) {
            return !((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return !((Map) obj).isEmpty();
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).length() > 0;
        }
        if (obj instanceof JSONArray) {
            return ((JSONArray) obj).length() > 0;
        }
        if (obj instanceof String) {
            return !TextUtils.isEmpty((String) obj);
        }
        if (obj.getClass().isArray()) {
            if (obj instanceof Object[]) {
                return ((Object[]) obj).length > 0;
            }
            if (obj instanceof int[]) {
                return ((int[]) obj).length > 0;
            }
            if (obj instanceof long[]) {
                return ((long[]) obj).length > 0;
            }
            if (obj instanceof double[]) {
                return ((double[]) obj).length > 0;
            }
            if (obj instanceof float[]) {
                return ((float[]) obj).length > 0;
            }
            if (obj instanceof boolean[]) {
                return ((boolean[]) obj).length > 0;
            }
            if (obj instanceof byte[]) {
                return ((byte[]) obj).length > 0;
            }
            if (obj instanceof char[]) {
                return ((char[]) obj).length > 0;
            }
            return !(obj instanceof short[]) || ((short[]) obj).length > 0;
        }
        return true;
    }

    public static String a(String str, boolean z8) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bArrB = b(Base64.decode(str, 2));
            String str2 = f.f10031c;
            return new String(km.a(bArrB, str2, str2, false));
        } catch (Throwable unused) {
            return "";
        }
    }

    private static byte[] b(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int i9 = gZIPInputStream.read(bArr2);
                    if (i9 < 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        a((Closeable) byteArrayOutputStream);
                        a((Closeable) byteArrayInputStream);
                        a((Closeable) gZIPInputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i9);
                }
            } catch (Throwable th2) {
                th = th2;
                a((Closeable) byteArrayOutputStream);
                a((Closeable) byteArrayInputStream);
                a((Closeable) gZIPInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            gZIPInputStream = null;
            th = th3;
        }
    }

    public static ArrayList<JSONArray> a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                ArrayList<JSONArray> arrayList = new ArrayList<>();
                int i9 = 0;
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                        int length = jSONObjectOptJSONObject.toString().getBytes("UTF-8").length;
                        i9 += length;
                        if (i9 > 102400) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            jSONArray2 = new JSONArray();
                            jSONArray2.put(jSONObjectOptJSONObject);
                            i9 = length;
                        } else {
                            jSONArray2.put(jSONObjectOptJSONObject);
                        }
                    }
                }
                if (jSONArray2.length() > 0) {
                    arrayList.add(jSONArray2);
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, (String) jSONObject.get(next));
            }
        } catch (JSONException unused) {
        }
        return map;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static byte[] a(byte[] bArr) throws Throwable {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a((Closeable) byteArrayOutputStream);
                a((Closeable) gZIPOutputStream2);
                return byteArray;
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                a((Closeable) byteArrayOutputStream);
                a((Closeable) gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
