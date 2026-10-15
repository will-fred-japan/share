package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResourceLoaderUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f15656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f15657b;

    public static int getAnimId(String str) {
        Context context = f15656a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "anim", f15657b);
    }

    public static int getColorId(String str) {
        Context context = f15656a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, RemoteMessageConst.Notification.COLOR, f15657b);
    }

    public static int getDimenId(String str) {
        Context context = f15656a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "dimen", f15657b);
    }

    public static Drawable getDrawable(String str) {
        Context context = f15656a;
        if (context == null) {
            return null;
        }
        return context.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        Context context = f15656a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "drawable", f15657b);
    }

    public static int getIdId(String str) {
        Context context = f15656a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "id", f15657b);
    }

    public static int getLayoutId(String str) {
        Context context = f15656a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "layout", f15657b);
    }

    public static String getString(String str) {
        Context context = f15656a;
        return context == null ? "" : context.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        Context context = f15656a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "string", f15657b);
    }

    public static int getStyleId(String str) {
        Context context = f15656a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "style", f15657b);
    }

    public static Context getmContext() {
        return f15656a;
    }

    public static void setmContext(Context context) {
        f15656a = context;
        if (context != null) {
            f15657b = context.getPackageName();
        } else {
            f15657b = null;
            HMSLog.e("ResourceLoaderUtil", "context is null");
        }
    }

    public static String getString(String str, Object... objArr) {
        Context context = f15656a;
        if (context == null) {
            return "";
        }
        return context.getResources().getString(getStringId(str), objArr);
    }
}
