package com.hihonor.push.sdk;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.sdk.common.RequestHeader;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static e a(Bundle bundle, e eVar) throws IllegalAccessException, InstantiationException {
        if (bundle != null && eVar != null) {
            bundle.setClassLoader(eVar.getClass().getClassLoader());
            for (Class<?> superclass = eVar.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                for (Field field : superclass.getDeclaredFields()) {
                    if (field.isAnnotationPresent(i.class)) {
                        try {
                            a(eVar, field, bundle);
                        } catch (IllegalAccessException | IllegalArgumentException unused) {
                            Log.e("MessageCodec", "decode, set value of the field exception, field name:" + field.getName());
                        }
                    }
                }
            }
        }
        return eVar;
    }

    public static String b(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16) {
            return "";
        }
        try {
            byte[] bArrA = a(12);
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArrA));
            byte[] bArrDoFinal = cipher.doFinal(bytes);
            if (bArrDoFinal == null || bArrDoFinal.length == 0) {
                return "";
            }
            return a(bArrA) + a(bArrDoFinal);
        } catch (GeneralSecurityException e9) {
            Log.e("AesGcm", "GCM encrypt data error" + e9.getMessage());
            return "";
        }
    }

    public static String a(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16) {
            return "";
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            String strSubstring = str.substring(0, 24);
            String strSubstring2 = str.substring(24);
            if (TextUtils.isEmpty(strSubstring) || TextUtils.isEmpty(strSubstring2)) {
                return "";
            }
            cipher.init(2, secretKeySpec, new GCMParameterSpec(128, a(strSubstring)));
            return new String(cipher.doFinal(a(strSubstring2)), StandardCharsets.UTF_8);
        } catch (Exception e9) {
            H2.a.h(e9, new StringBuilder("GCM decrypt data exception: "), "AesGcm");
            return "";
        }
    }

    public static <TResult> TResult b(d1 d1Var) throws ExecutionException {
        Exception exc;
        if (d1Var.c()) {
            return (TResult) d1Var.b();
        }
        synchronized (d1Var.f14474a) {
            exc = d1Var.f14477d;
        }
        throw new ExecutionException(exc);
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public static a b(Context context) {
        a aVar = new a();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("android", "com.hihonor.android.pushagentproxy.HiPushService"));
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (listQueryIntentServices.size() > 0) {
            Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                String str = next.serviceInfo.applicationInfo.packageName;
                a(context, str);
                aVar.f14446a = str;
                aVar.f14447b = next.serviceInfo.name;
            }
        }
        return aVar;
    }

    public static String a(byte[] bArr) {
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b9 : bArr) {
            String hexString = Integer.toHexString(b9 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static List<Object> a(Type type, Bundle bundle) throws IllegalAccessException, InstantiationException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            bundle = bundle.getBundle("_next_item_");
            if (bundle == null) {
                return arrayList;
            }
            Object objA = bundle.get("_value_");
            if (!objA.getClass().isPrimitive() && !(objA instanceof Serializable)) {
                if (objA instanceof Bundle) {
                    Bundle bundle2 = (Bundle) objA;
                    int i9 = bundle2.getInt("_packed_type_", -1);
                    if (i9 == 1) {
                        throw new InstantiationException("Nested List can not be supported");
                    }
                    if (i9 != 0) {
                        throw new InstantiationException("Unknown type can not be supported");
                    }
                    objA = a(bundle2, (e) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance());
                } else {
                    continue;
                }
            }
            arrayList.add(objA);
        }
    }

    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e9) {
            m.a("DeflateUtil", "close", e9);
        }
    }

    public static void a(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }

    public static <TResult> TResult a(d1 d1Var) throws InterruptedException {
        boolean z8;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (d1Var.f14474a) {
                z8 = d1Var.f14475b;
            }
            if (!z8) {
                b1 b1Var = new b1();
                d1Var.a(new z0(b1Var));
                b1Var.f14457a.await();
            }
            return (TResult) b(d1Var);
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public static RequestHeader a(Context context) throws j {
        String string;
        String strValueOf = null;
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("com.hihonor.push.app_id");
            if (obj != null) {
                strValueOf = String.valueOf(obj);
            }
        } catch (PackageManager.NameNotFoundException e9) {
            m.a("ConfigUtils", "getPushAppId", e9);
        }
        if (!TextUtils.isEmpty(strValueOf)) {
            String strA = a(context, context.getPackageName());
            if (!TextUtils.isEmpty(strA)) {
                RequestHeader requestHeader = new RequestHeader();
                requestHeader.setPackageName(context.getPackageName());
                requestHeader.setAppId(strValueOf);
                requestHeader.setCertificateFingerprint(strA);
                n nVar = n.f14536b;
                requestHeader.setPushToken(nVar.b(context));
                synchronized (nVar) {
                    nVar.a(context);
                    SharedPreferences sharedPreferences = n.f14535a.f14529a;
                    string = sharedPreferences != null ? sharedPreferences.getString("key_aaid", "") : "";
                    if (TextUtils.isEmpty(string)) {
                        string = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                        n.f14535a.a("key_aaid", string);
                    }
                }
                requestHeader.setAAID(string);
                requestHeader.setSdkVersion(100013305);
                return requestHeader;
            }
            m.a("checkPushConfig Parameter is missing.");
            throw k.ERROR_CERT_FINGERPRINT_EMPTY.a();
        }
        m.a("checkPushConfig Parameter is missing");
        throw k.ERROR_NO_APPID.a();
    }

    public static Bundle a(e eVar, Bundle bundle) {
        if (eVar != null) {
            for (Class<?> superclass = eVar.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                for (Field field : superclass.getDeclaredFields()) {
                    if (field.isAnnotationPresent(i.class)) {
                        try {
                            boolean zIsAccessible = field.isAccessible();
                            field.setAccessible(true);
                            a(field.getName(), field.get(eVar), bundle);
                            field.setAccessible(zIsAccessible);
                        } catch (IllegalAccessException | IllegalArgumentException unused) {
                            Log.e("MessageCodec", "encode, get value of the field exception, field name: " + field.getName());
                        }
                    }
                }
            }
        }
        return bundle;
    }

    public static byte[] a(int i9) {
        SecureRandom secureRandom;
        try {
            byte[] bArr = new byte[i9];
            synchronized (h.class) {
                try {
                    secureRandom = SecureRandom.getInstance("NativePRNGNonBlocking");
                } catch (NoSuchAlgorithmException unused) {
                    Log.w("SecureRandomUtil", "platform not support secure random NativePRNGNonBlocking");
                    try {
                        secureRandom = SecureRandom.getInstanceStrong();
                    } catch (NoSuchAlgorithmException unused2) {
                        Log.w("SecureRandomUtil", "platform not support secure random strongAlgorithms");
                        secureRandom = new SecureRandom();
                    }
                }
            }
            secureRandom.nextBytes(bArr);
            return bArr;
        } catch (Exception unused3) {
            return new byte[0];
        }
    }

    public static String a(Context context, String str) {
        Signature[] apkContentsSigners;
        String string;
        String str2;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo != null) {
                apkContentsSigners = packageInfo.signatures;
            } else {
                Log.e("ConfigUtils", "Package Info is null");
                apkContentsSigners = null;
            }
            if (apkContentsSigners == null) {
                try {
                    if (Build.VERSION.SDK_INT < 30) {
                        apkContentsSigners = null;
                    } else {
                        PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 134217728);
                        if (packageInfo2 != null) {
                            SigningInfo signingInfo = packageInfo2.signingInfo;
                            if (signingInfo != null) {
                                apkContentsSigners = signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
                            } else {
                                str2 = "Package signingInfo is null";
                            }
                        } else {
                            str2 = "Package info is null";
                        }
                        Log.e("ConfigUtils", str2);
                        apkContentsSigners = null;
                    }
                } catch (PackageManager.NameNotFoundException e9) {
                    e = e9;
                    m.a("ConfigUtils", "getCertFingerprint", e);
                }
            }
        } catch (PackageManager.NameNotFoundException e10) {
            e = e10;
            apkContentsSigners = null;
        }
        if (apkContentsSigners == null || apkContentsSigners.length <= 0) {
            Log.e("ConfigUtils", "Package no signatures");
        } else {
            for (Signature signature : apkContentsSigners) {
                try {
                    byte[] bArrDigest = MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
                    StringBuilder sb = new StringBuilder();
                    for (byte b9 : bArrDigest) {
                        String upperCase = Integer.toHexString(b9 & 255).toUpperCase(Locale.ENGLISH);
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                    }
                    string = sb.toString();
                } catch (NoSuchAlgorithmException e11) {
                    m.a("ConfigUtils", "signatureToString", e11);
                    string = null;
                }
                if (string != null) {
                    arrayList.add(string);
                    break;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String) arrayList.get(0);
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes(StandardCharsets.UTF_8);
            for (int i9 = 0; i9 < length; i9++) {
                StringBuilder sb = new StringBuilder();
                sb.append("0x");
                int i10 = i9 * 2;
                byte[] bArr2 = {bytes[i10]};
                Charset charset = StandardCharsets.UTF_8;
                sb.append(new String(bArr2, charset));
                bArr[i9] = (byte) (((byte) (Byte.decode(sb.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i10 + 1]}, charset)).byteValue());
            }
        } catch (NumberFormatException e9) {
            Log.e("HexUtils", "hex string 2 byte array exception : " + e9.getMessage());
        }
        return bArr;
    }

    public static int a(Context context, a aVar) {
        h0 h0Var;
        if (!new File("/system/framework/hipush.jar").exists()) {
            Log.i("HonorApiAvailability", "hipush.jar is not exit");
            return 8002008;
        }
        String str = aVar.f14446a;
        if (TextUtils.isEmpty(str)) {
            h0Var = h0.NOT_INSTALLED;
        } else {
            try {
                h0Var = context.getPackageManager().getApplicationInfo(str, 0).enabled ? h0.ENABLED : h0.DISABLED;
            } catch (PackageManager.NameNotFoundException unused) {
                h0Var = h0.NOT_INSTALLED;
            }
        }
        if (h0.NOT_INSTALLED.equals(h0Var)) {
            Log.i("HonorApiAvailability", "push service is not installed");
            return 8002008;
        }
        if (h0.DISABLED.equals(h0Var)) {
            Log.i("HonorApiAvailability", "push service is disabled");
            return 8002007;
        }
        if (!TextUtils.equals(str, "android")) {
            return 8002006;
        }
        k kVar = k.SUCCESS;
        return 0;
    }

    public static void a(e eVar, Field field, Bundle bundle) throws IllegalAccessException, InstantiationException {
        String name = field.getName();
        Object objA = bundle.get(name);
        if (objA instanceof Bundle) {
            try {
                Bundle bundle2 = (Bundle) objA;
                int i9 = bundle2.getInt("_packed_type_", -1);
                if (i9 == 1) {
                    objA = a(field.getGenericType(), bundle2);
                } else if (i9 == 0) {
                    objA = a((Bundle) objA, (e) field.getType().newInstance());
                }
            } catch (Exception unused) {
                Log.e("MessageCodec", "decode, read value of the field exception, field name: " + name);
                objA = null;
            }
        }
        if (objA != null) {
            boolean zIsAccessible = field.isAccessible();
            field.setAccessible(true);
            field.set(eVar, objA);
            field.setAccessible(zIsAccessible);
        }
    }

    public static void a(String str, Object obj, Bundle bundle) {
        if (obj != null) {
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
                return;
            }
            if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Short) {
                bundle.putShort(str, ((Short) obj).shortValue());
                return;
            }
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Float) {
                bundle.putFloat(str, ((Float) obj).floatValue());
                return;
            }
            if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
                return;
            }
            if (!(obj instanceof Boolean)) {
                if (obj instanceof CharSequence) {
                    bundle.putCharSequence(str, (CharSequence) obj);
                    return;
                }
                if (obj instanceof Parcelable) {
                    bundle.putParcelable(str, (Parcelable) obj);
                    return;
                }
                if (obj instanceof byte[]) {
                    bundle.putByteArray(str, (byte[]) obj);
                    return;
                }
                if (obj instanceof List) {
                    Bundle bundle2 = null;
                    for (Object obj2 : (List) obj) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                            bundle.putBundle(str, bundle2);
                            bundle2.putInt("_packed_type_", 1);
                        }
                        Bundle bundle3 = new Bundle();
                        a("_value_", obj2, bundle3);
                        bundle2.putBundle("_next_item_", bundle3);
                        bundle2 = bundle3;
                    }
                    return;
                }
                if (obj instanceof Serializable) {
                    bundle.putSerializable(str, (Serializable) obj);
                    return;
                }
                if (!(obj instanceof e)) {
                    Log.e("MessageCodec", "cannot support type, " + str);
                    return;
                }
                Bundle bundleA = a((e) obj, new Bundle());
                bundleA.putInt("_packed_type_", 0);
                bundle.putBundle(str, bundleA);
                return;
            }
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }
}
