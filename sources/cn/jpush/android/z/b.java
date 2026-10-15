package cn.jpush.android.z;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static byte[] a(int i9) {
        d dVar = new d(128);
        dVar.a(i9);
        return dVar.a();
    }

    public static byte[] b(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (Throwable th) {
            Logger.ee("PushPackage", "stringToUtf8Bytes error:" + th.getMessage());
            return str.getBytes();
        }
    }

    public static byte[] c(String str) {
        d dVar = new d(8192);
        dVar.a(b(str));
        return dVar.a();
    }

    public static byte[] a(int i9, byte b9, long j, String str) {
        d dVar = new d(128);
        dVar.b(i9);
        dVar.a((int) b9);
        dVar.a(j);
        if (!TextUtils.isEmpty(str)) {
            dVar.a(b(str));
        }
        return dVar.a();
    }

    public static byte[] a(int i9, String str) {
        d dVar = new d(8192);
        dVar.a(i9);
        dVar.a(str);
        return dVar.a();
    }

    public static byte[] a(String str) {
        d dVar = new d(128);
        dVar.a(7);
        dVar.a(1);
        dVar.a(str != null ? b(str) : new byte[0]);
        return dVar.a();
    }

    public static byte[] a(String str, byte b9, boolean z8, int i9) {
        d dVar = new d(8192);
        dVar.a(TextUtils.isEmpty(str) ? new byte[0] : b(str));
        dVar.a((int) b9);
        dVar.a(!z8 ? 1 : 0);
        dVar.a(i9);
        return dVar.a();
    }

    public static byte[] a(String str, int i9, String str2) {
        d dVar = new d(8192);
        if (i9 == 10) {
            dVar.a(b(str));
        }
        dVar.a(b(str2));
        return dVar.a();
    }
}
