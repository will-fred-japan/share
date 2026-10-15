package cn.jpush.android.m;

import cn.jiguang.internal.JConstants;
import cn.jpush.android.local.JPushConstants;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f11447a = 610;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f11448b = "6.1.0";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f11449c = "re";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f11450d = "af5282e7";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11451e = JConstants.SDK_VERSION_INT;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f11452f = false;

    public static boolean a() {
        try {
            return JPushConstants.THIRD_ENABLE;
        } catch (Throwable unused) {
            return true;
        }
    }
}
