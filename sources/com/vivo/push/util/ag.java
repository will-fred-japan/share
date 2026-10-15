package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SharePreferenceManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class ag extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ag f16828b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.vivo.push.f.a f16829d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, byte[]> f16830c = new ConcurrentHashMap();

    private synchronized void b(Context context) {
        try {
            if (!b("data_clear") && context != null) {
                Iterator<Map.Entry<String, ?>> it = a().getAll().entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (!TextUtils.isEmpty(key) && (key.contains("_sub_") || key.contains("_cache_"))) {
                        c(key);
                    }
                }
                w.c("SharePreferenceManager", " old data clear ");
                a("data_clear");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized ag c() {
        try {
            if (f16828b == null) {
                f16828b = new ag();
            }
            if (f16829d == null) {
                f16829d = new com.vivo.push.f.a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f16828b;
    }

    public final synchronized void a(Context context) {
        try {
            if (this.f16858a == null) {
                this.f16858a = context;
                a(context, "com.vivo.push_preferences");
                List<String> listE = e("local_iv");
                if (listE == null || listE.size() < 4) {
                    w.a("SharePreferenceManager", " initSecureCode error list is null ");
                } else {
                    this.f16830c.put("com.vivo.push.a", d(listE.get(1)));
                    this.f16830c.put("com.vivo.push.b", d(listE.get(2)));
                    this.f16830c.put("com.vivo.push.c", d(listE.get(3)));
                    this.f16830c.put("com.vivo.push.d", d(listE.get(0)));
                }
                b(this.f16858a);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final byte[] d() {
        byte[] bArr = this.f16830c.get("com.vivo.push.c");
        return (bArr == null || bArr.length <= 0) ? f16829d.a(this.f16858a) : bArr;
    }

    public final byte[] e() {
        byte[] bArr = this.f16830c.get("com.vivo.push.d");
        return (bArr == null || bArr.length <= 0) ? f16829d.b(this.f16858a) : bArr;
    }

    private static byte[] d(String str) {
        int length;
        byte[] bArr = null;
        try {
            String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (strArrSplit.length > 0) {
                bArr = new byte[strArrSplit.length];
                length = strArrSplit.length;
            } else {
                length = 0;
            }
            for (int i9 = 0; i9 < length; i9++) {
                bArr[i9] = Byte.parseByte(strArrSplit[i9].trim());
            }
            return bArr;
        } catch (Exception e9) {
            A.f.m(e9, new StringBuilder("getCodeBytes error:"), "SharePreferenceManager");
            return bArr;
        }
    }

    private List<String> e(String str) {
        String[] strArrSplit;
        if (this.f16858a == null) {
            w.c("SharePreferenceManager", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Context context = this.f16858a;
            Object objA = ak.a(context, context.getPackageName(), str);
            if (objA == null) {
                return null;
            }
            String str2 = new String(Base64.decode(objA.toString(), 2));
            if (!TextUtils.isEmpty(str2) && (strArrSplit = str2.split(",#@")) != null && strArrSplit.length >= 4) {
                for (String str3 : strArrSplit) {
                    arrayList.add(str3.replace(",#@", ""));
                }
                if (arrayList.size() < 4) {
                }
            }
            return null;
        } catch (Exception e9) {
            w.c("SharePreferenceManager", " parsLocalIv error e =" + e9.getMessage());
        }
        return arrayList;
    }
}
