package cn.jiguang.aw;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, HashMap<Integer, PackageInfo>> f9539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f9540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap<Integer, PackageInfo> f9541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f9542d;

    static {
        HashMap<String, HashMap<Integer, PackageInfo>> map = new HashMap<>();
        f9539a = map;
        map.put("com.huawei.hwid", null);
        f9540b = "";
        f9541c = new HashMap<>();
        f9542d = 0;
    }

    public static PackageInfo a(Context context, int i9) {
        return a(context, a(context), i9);
    }

    public static PackageInfo a(Context context, String str, int i9) {
        return cn.jiguang.g.b.a(str, i9);
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f9540b)) {
            return f9540b;
        }
        String packageName = context.getPackageName();
        f9540b = packageName;
        return packageName;
    }
}
