package cn.jiguang.aw;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9545a = l.b(new byte[]{91, 85, 5});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9546b = l.b(new byte[]{99, 104, 88, 37, 39});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9547c = l.b(new byte[]{74, 64, 87, 60, 2, 21, 47});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9548d = l.b(new byte[]{87, 84, 99});

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9549e = l.b(new byte[]{73, 83, 66, 31, 99, 91, 75, 57, 65, 123, 99, 74, 61, 70, 112, 84, 68, 112, 102, 113});

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9550f = l.b(new byte[]{90, 69, 80, 31, 101, 90, 74, 57, 65, 123, 99, 74, 57, 70, 112, 84, 68, 112, 102, 113});

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ThreadLocal<Map<String, Cipher>> f9551g = new ThreadLocal<Map<String, Cipher>>() { // from class: cn.jiguang.aw.t.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<String, Cipher> initialValue() {
            return new HashMap();
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Map<String, RSAPublicKey> f9552h = new ConcurrentHashMap();

    public static class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static boolean f9553e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static boolean f9554f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static volatile boolean f9555g = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f9557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f9558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f9559d;

        private static SharedPreferences a(Context context) {
            if (context == null) {
                return null;
            }
            return context.getApplicationContext().getSharedPreferences("cn.jiguang.securekey_e_r", 0);
        }

        private static a b(Context context, String str, String str2, String str3) {
            if (str3 == null) {
                return null;
            }
            try {
                if (!f9553e) {
                    return null;
                }
                i.a aVarC = i.c(str3);
                if (aVarC == null) {
                    cn.jiguang.x.f.c("SecureKey", "Failed to generate ECC shared secret, fallback to next encryption method");
                    return null;
                }
                byte[] bArr = aVarC.f9516a;
                byte[] bytes = (str + str2).getBytes();
                byte[] bArr2 = new byte[bArr.length + bytes.length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                System.arraycopy(bytes, 0, bArr2, bArr.length, bytes.length);
                byte[] bArrA = a(v.a(bArr2));
                a aVar = new a();
                aVar.f9556a = 2;
                aVar.f9559d = aVarC.f9518c;
                aVar.f9558c = bArrA;
                aVar.f9557b = aVarC.f9517b;
                return aVar;
            } catch (Throwable th) {
                f9553e = false;
                c(context);
                cn.jiguang.x.f.b("SecureKey", "Exception in eccBody", th);
                return null;
            }
        }

        public String c() {
            return this.f9559d;
        }

        public int d() {
            return this.f9556a;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("SecureKey{type=");
            sb.append(this.f9556a);
            sb.append(", keyBody=");
            sb.append(Arrays.toString(this.f9557b));
            sb.append(", sha256Key=");
            sb.append(Arrays.toString(this.f9558c));
            sb.append(", randomKey='");
            return A.a.j(sb, this.f9559d, "'}");
        }

        private static a a(Context context, String str, String str2, String str3) {
            if (str3 == null) {
                return null;
            }
            try {
                if (!f9554f) {
                    return null;
                }
                String strB = v.b(u.b(16));
                byte[] bArrA = a(v.e(strB + str + str2));
                a aVar = new a();
                byte[] bArrC = t.c(strB, str3, t.f9550f);
                aVar.f9558c = bArrA;
                aVar.f9559d = strB;
                aVar.f9557b = bArrC;
                aVar.f9556a = 3;
                return aVar;
            } catch (Throwable th) {
                f9554f = false;
                c(context);
                cn.jiguang.x.f.b("SecureKey", "Exception in rsaBody", th);
                return null;
            }
        }

        private static void b(Context context) {
            SharedPreferences sharedPreferencesA;
            if (f9555g || (sharedPreferencesA = a(context)) == null) {
                return;
            }
            f9553e = sharedPreferencesA.getBoolean("sk_is_ecc", true);
            f9554f = sharedPreferencesA.getBoolean("sk_is_rsa", true);
            f9555g = true;
        }

        private static void c(Context context) {
            SharedPreferences sharedPreferencesA = a(context);
            if (sharedPreferencesA == null) {
                return;
            }
            sharedPreferencesA.edit().putBoolean("sk_is_ecc", f9553e).putBoolean("sk_is_rsa", f9554f).apply();
        }

        public static a a(Context context, String str, String str2, String str3, String str4, boolean z8) {
            if (str2 == null) {
                str2 = "";
            }
            try {
                b(context);
                if (z8) {
                    if (cn.jiguang.z.g.a()) {
                        a aVarB = b(context, str, str2, str3);
                        if (aVarB != null) {
                            return aVarB;
                        }
                    } else {
                        cn.jiguang.x.f.c("SecureKey", "ECC encryption is not forced");
                    }
                    a aVarA = a(context, str, str2, str4);
                    if (aVarA != null) {
                        return aVarA;
                    }
                }
                return a(str, str2);
            } catch (Throwable th) {
                cn.jiguang.x.f.b("SecureKey", "Exception in encryptReportData", th);
                return null;
            }
        }

        public byte[] b() {
            return this.f9558c;
        }

        private static a a(String str, String str2) {
            try {
                String strB = v.b(u.b(16));
                byte[] bArrA = a(v.e(strB + str + str2));
                a aVar = new a();
                aVar.f9556a = 1;
                aVar.f9559d = strB;
                aVar.f9558c = bArrA;
                aVar.f9557b = strB.getBytes();
                return aVar;
            } catch (Throwable th) {
                cn.jiguang.x.f.b("SecureKey", "Exception in aesBody", th);
                return null;
            }
        }

        public static void a(Context context, int i9) {
            if (i9 == 2) {
                f9553e = false;
            } else if (i9 == 3) {
                f9554f = false;
            }
            c(context);
        }

        public byte[] a() {
            return this.f9557b;
        }

        private static byte[] a(byte[] bArr) {
            return v.b(bArr).toLowerCase().substring(0, 32).getBytes();
        }
    }

    public static int a() {
        return Math.abs(new SecureRandom().nextInt()) & 16777215;
    }

    public static String b(String str, String str2) {
        try {
            return new String(a(str, str2, str2));
        } catch (Exception unused) {
            cn.jiguang.x.f.i("", "Unexpected - failed to AES decrypt.");
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

    private static <T> T a(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static String b(String str, String str2, String str3) {
        return new String(Base64.encode(a(str, b(str2), str3), 2), "UTF-8");
    }

    public static byte[] c(String str, String str2, String str3) {
        return a(str, b(str2), str3);
    }

    public static String a(long j) {
        long j8;
        long j9;
        switch ((int) (j % 10)) {
            case 1:
                j8 = 5 * j;
                j9 = 88;
                break;
            case 2:
                j8 = 23 * j;
                j9 = 15;
                break;
            case 3:
                j8 = 3 * j;
                j9 = 73;
                break;
            case 4:
                j8 = 13 * j;
                j9 = 96;
                break;
            case 5:
                j8 = 17 * j;
                j9 = 49;
                break;
            case 6:
                j8 = 7 * j;
                j9 = 68;
                break;
            case 7:
                j8 = 31 * j;
                j9 = 39;
                break;
            case 8:
                j8 = 29 * j;
                j9 = 41;
                break;
            case 9:
                j8 = 37 * j;
                j9 = 91;
                break;
            default:
                j8 = 8 * j;
                j9 = 74;
                break;
        }
        return v.d("JCKP" + ((j % j9) + j8));
    }

    private static RSAPublicKey b(String str) {
        Map<String, RSAPublicKey> map = f9552h;
        RSAPublicKey rSAPublicKey = map.get(str);
        if (rSAPublicKey != null) {
            return rSAPublicKey;
        }
        try {
            RSAPublicKey rSAPublicKey2 = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
            map.put(str, rSAPublicKey2);
            return rSAPublicKey2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        try {
            return a(str.getBytes(), str2, str2);
        } catch (Exception unused) {
            cn.jiguang.x.f.i("", "Unexpected - failed to AES encrypt.");
            return "";
        }
    }

    public static String a(byte[] bArr, String str, String str2) {
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    private static Cipher a(String str) {
        Map<String, Cipher> map = f9551g.get();
        Cipher cipher = map != null ? map.get(str) : null;
        if (cipher == null) {
            try {
                cipher = Cipher.getInstance(str);
                map.put(str, cipher);
                return cipher;
            } catch (Exception e9) {
                cn.jiguang.x.f.i("Secure", "Failed to create Cipher: " + e9.getMessage());
            }
        }
        return cipher;
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
        Cipher cipherA;
        try {
            cipherA = a(str2);
            if (cipherA == null) {
                cipherA = Cipher.getInstance(str2);
            }
            cipherA.init(1, rSAPublicKey);
        } catch (Throwable th) {
            throw th;
        }
        return cipherA.doFinal(str.getBytes());
    }

    public static synchronized byte[] a(byte[] bArr, String str, String str2, boolean z8) {
        if (str == null) {
            return null;
        }
        return a(bArr, c(str, "UTF-8"), str2, z8);
    }

    public static synchronized byte[] a(byte[] bArr, byte[] bArr2, String str, boolean z8) {
        Cipher cipherA;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f9548d);
            IvParameterSpec ivParameterSpecA = a(str.getBytes("UTF-8"));
            String str2 = f9549e;
            cipherA = a(str2);
            if (cipherA == null) {
                cipherA = Cipher.getInstance(str2);
            }
            cipherA.init(z8 ? 1 : 2, secretKeySpec, ivParameterSpecA);
        } catch (Throwable th) {
            throw th;
        }
        return cipherA.doFinal(bArr);
    }
}
