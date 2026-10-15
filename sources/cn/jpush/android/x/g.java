package cn.jpush.android.x;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import cn.jpush.android.helper.Logger;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("jpush_notification_icon", "drawable", context.getPackageName());
        if (identifier == 0) {
            try {
                identifier = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).icon;
                Logger.i("ResourceHelper", "JPush.mPackageInconId == 0 ?, get icon from application info.");
                return identifier;
            } catch (Throwable th) {
                Logger.ee("ResourceHelper", "failed to get application info and icon.", th);
            }
        }
        return identifier;
    }

    public static Icon b(Context context, String str) {
        if (context == null || str == null || str.isEmpty()) {
            Logger.w("ResourceHelper", "getIconFromLocalResource: context or path is null or empty");
            return null;
        }
        try {
            String strB = b(str);
            if (strB.startsWith("assets/")) {
                Bitmap bitmapE = e(context, strB.substring(7));
                if (bitmapE != null) {
                    return Icon.createWithBitmap(bitmapE);
                }
                return null;
            }
            Icon iconA = a(strB);
            if (iconA != null) {
                Logger.d("ResourceHelper", "getIconFromLocalResource success with file path: ".concat(strB));
                return iconA;
            }
            int iC = c(context, strB);
            if (iC == 0) {
                Logger.d("ResourceHelper", "getIconFromLocalResource: resource not found - ".concat(strB));
                return null;
            }
            Icon iconCreateWithResource = Icon.createWithResource(context, iC);
            Logger.d("ResourceHelper", "getIconFromLocalResource success with resId: " + iC);
            return iconCreateWithResource;
        } catch (Throwable th) {
            Logger.w("ResourceHelper", "getIconFromLocalResource failed: " + str, th);
        }
    }

    public static int c(Context context, String str) {
        if (context == null || str == null || str.isEmpty()) {
            Logger.w("ResourceHelper", "getResIdFromResource: context or path is null or empty");
            return 0;
        }
        try {
            String strB = b(str);
            if (strB.startsWith("res/")) {
                strB = strB.substring(4);
            }
            if (!strB.contains("/")) {
                return a(context, strB.contains(".") ? strB.substring(0, strB.lastIndexOf(".")) : strB, "drawable");
            }
            String[] strArrSplit = strB.split("/", 2);
            if (strArrSplit.length != 2) {
                Logger.w("ResourceHelper", "getResIdFromResource: invalid path format: ".concat(strB));
                return 0;
            }
            String lowerCase = strArrSplit[0].toLowerCase();
            String strSubstring = strArrSplit[1];
            if (strSubstring.contains("/")) {
                Logger.w("ResourceHelper", "getResIdFromResource: resourceName is a path, not a file name: ".concat(strSubstring));
                return 0;
            }
            if (strSubstring.contains(".")) {
                strSubstring = strSubstring.substring(0, strSubstring.lastIndexOf("."));
            }
            if ("assets".equals(lowerCase)) {
                Logger.w("ResourceHelper", "getResIdFromResource: assets resource does not have resId: ".concat(strB));
                return 0;
            }
            if (lowerCase.startsWith("drawable")) {
                return a(context, strSubstring, "drawable");
            }
            if (lowerCase.startsWith("mipmap")) {
                return a(context, strSubstring, "mipmap");
            }
            if ("raw".equals(lowerCase)) {
                return a(context, strSubstring, "raw");
            }
            Logger.w("ResourceHelper", "getResIdFromResource: unsupported prefix: ".concat(lowerCase));
            return 0;
        } catch (Throwable th) {
            Logger.ee("ResourceHelper", "getResIdFromResource failed: " + str, th);
            return 0;
        }
    }

    public static int d(Context context, String str) {
        if (context == null || str == null || str.isEmpty()) {
            Logger.w("ResourceHelper", "getResIdFromDrawable: context or path is null or empty");
            return 0;
        }
        try {
            String strB = b(str);
            if (strB.startsWith("res/")) {
                strB = strB.substring(4);
            }
            if (!strB.contains("/")) {
                return a(context, strB.contains(".") ? strB.substring(0, strB.lastIndexOf(".")) : strB, "drawable");
            }
            String[] strArrSplit = strB.split("/", 2);
            if (strArrSplit.length != 2) {
                Logger.w("ResourceHelper", "getResIdFromDrawable: invalid path format: ".concat(strB));
                return 0;
            }
            String lowerCase = strArrSplit[0].toLowerCase();
            String strSubstring = strArrSplit[1];
            if (strSubstring.contains("/")) {
                Logger.w("ResourceHelper", "getResIdFromDrawable: resourceName is a path, not a file name: ".concat(strSubstring));
                return 0;
            }
            if (strSubstring.contains(".")) {
                strSubstring = strSubstring.substring(0, strSubstring.lastIndexOf("."));
            }
            if (lowerCase.startsWith("drawable")) {
                return a(context, strSubstring, "drawable");
            }
            Logger.w("ResourceHelper", "getResIdFromDrawable: unsupported prefix: ".concat(lowerCase));
            return 0;
        } catch (Throwable th) {
            Logger.ee("ResourceHelper", "getResIdFromDrawable failed: " + str, th);
            return 0;
        }
    }

    private static Bitmap e(Context context, String str) {
        InputStream inputStreamOpen;
        try {
            inputStreamOpen = context.getResources().getAssets().open(str);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                Logger.d("ResourceHelper", "getBitmapFromAssets success: " + str);
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                        return bitmapDecodeStream;
                    } catch (Throwable th) {
                        Logger.w("ResourceHelper", "close InputStream failed", th);
                    }
                }
                return bitmapDecodeStream;
            } catch (Throwable th2) {
                th = th2;
                try {
                    Logger.w("ResourceHelper", "getBitmapFromAssets failed: " + str, th);
                    return null;
                } finally {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (Throwable th3) {
                            Logger.w("ResourceHelper", "close InputStream failed", th3);
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamOpen = null;
        }
    }

    private static int a(Context context, String str, String str2) {
        try {
            int identifier = context.getResources().getIdentifier(str, str2, context.getPackageName());
            if (identifier == 0) {
                Logger.w("ResourceHelper", "getResIdFromResourceType: resource not found - " + str2 + "/" + str);
                return identifier;
            }
            Logger.d("ResourceHelper", "getResIdFromResourceType success: " + str2 + "/" + str + ", resId: " + identifier);
            return identifier;
        } catch (Throwable th) {
            Logger.ee("ResourceHelper", "getResIdFromResourceType failed: " + str2 + "/" + str, th);
            return 0;
        }
    }

    private static String b(String str) {
        if (str == null || str.isEmpty() || str.charAt(0) != '/') {
            return str;
        }
        return (str.startsWith("/assets/") || str.startsWith("/res/") || str.startsWith("/raw/")) ? str.substring(1) : str;
    }

    public static Bitmap a(Context context, int i9) {
        try {
            if (i9 != 0) {
                return BitmapFactory.decodeResource(context.getResources(), i9);
            }
            Logger.w("ResourceHelper", "getBitmap: resId is 0");
            return null;
        } catch (Throwable th) {
            Logger.w("ResourceHelper", "getBitmap failed: resId=" + i9, th);
            return null;
        }
    }

    public static Bitmap a(Context context, String str) {
        if (context == null || str == null || str.isEmpty()) {
            Logger.w("ResourceHelper", "getBitmapFromLocalResource: context or path is null or empty");
            return null;
        }
        try {
            String strB = b(str);
            if (strB.startsWith("assets/")) {
                return e(context, strB.substring(7));
            }
            int iC = c(context, strB);
            if (iC == 0) {
                Logger.w("ResourceHelper", "getBitmapFromLocalResource: resource not found - ".concat(strB));
                return null;
            }
            Bitmap bitmapA = a(context, iC);
            if (bitmapA == null) {
                Logger.w("ResourceHelper", "getBitmapFromLocalResource: decodeResource returned null for resId: " + iC);
                return bitmapA;
            }
            Logger.d("ResourceHelper", "getBitmapFromLocalResource success: " + strB + ", resId: " + iC);
            return bitmapA;
        } catch (Throwable th) {
            Logger.ee("ResourceHelper", "getBitmapFromLocalResource failed: " + str, th);
            return null;
        }
    }

    @TargetApi(23)
    public static Icon a(String str) {
        try {
            if (new File(str).exists()) {
                return Icon.createWithFilePath(str);
            }
            Logger.w("ResourceHelper", "icon file doesn't exist, path=" + str);
            return null;
        } catch (Throwable th) {
            defpackage.f.o("createIcon err:", "ResourceHelper", th);
            return null;
        }
    }
}
