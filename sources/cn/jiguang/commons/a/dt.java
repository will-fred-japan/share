package cn.jiguang.commons.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f9912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f9913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f9914c;

    private static Class<?> a(Context context, String str) throws ClassNotFoundException {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z8 = context != null;
        if (z8 && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException e9) {
                ee.d("IdProvider", "loadClass error, " + e9.getMessage());
            }
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            ee.d("IdProvider", "loadClass fail hasContext= " + z8 + ", errMsg = " + e10.getLocalizedMessage());
            throw new ClassNotFoundException("loadClass fail ", e10);
        }
    }

    public static String a(Context context) {
        try {
            if (f9913b == null) {
                String str = f.f10031c;
                Class<?> clsA = a(context, km.b("KIHhQylffktk79IAY9r8iabG5YlYSM/WswW6fWtc2r2WbTdKR65l5atPPp2u96wd", str));
                Object objInvoke = clsA.getMethod(km.b("Oi3ZFT8+schQHSyFZbsdUg==", str), Context.class).invoke(clsA.newInstance(), context);
                if ((objInvoke instanceof String) && !TextUtils.isEmpty((String) objInvoke)) {
                    f9913b = (String) objInvoke;
                }
            }
            return TextUtils.isEmpty(f9913b) ? "" : f9913b;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("getIds failed:"), "IdProvider");
            return "";
        }
    }
}
