package cn.jiguang.v;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Long f10805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f10806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f10807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f10808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile Class<?> f10809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile Method f10810f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Boolean f10812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile Class<?> f10813i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static LinkedList<String> f10814k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f10811g = new Object();
    private static final Object j = new Object();

    public static long a(Context context) {
        Long l8 = f10805a;
        if (l8 != null) {
            return l8.longValue();
        }
        Object objA = a(context, null, 20, null, null, new Object[0]);
        if (objA instanceof Long) {
            Long l9 = (Long) objA;
            if (l9.longValue() > 0) {
                f10805a = l9;
                return l9.longValue();
            }
        }
        return 0L;
    }

    public static int b() {
        try {
            Field declaredField = f().getDeclaredField("SDK_VERSION_INT");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        } catch (Throwable th) {
            cn.jiguang.u.b.b("JCoreBridge", "error occured when getJCoreSDKVersion." + th.getMessage());
            return 0;
        }
    }

    public static String c() {
        try {
            Field declaredField = f().getDeclaredField("APP_KEY");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            return obj instanceof String ? (String) obj : "";
        } catch (Throwable th) {
            cn.jiguang.u.b.b("JCoreBridge", "error occured when getJCoreSDKVersion." + th.getMessage());
            return "";
        }
    }

    public static String d(Context context) {
        String str = f10808d;
        if (str != null) {
            return str;
        }
        Object objA = a(context, null, 6, null, null, new Object[0]);
        if (!(objA instanceof String)) {
            return null;
        }
        String str2 = (String) objA;
        f10808d = str2;
        return str2;
    }

    public static LinkedList<String> e() {
        try {
            LinkedList<String> linkedList = f10814k;
            if (linkedList != null && linkedList.size() > 0) {
                return f10814k;
            }
            Field declaredField = f().getDeclaredField("TUU");
            declaredField.setAccessible(true);
            LinkedList<String> linkedList2 = (LinkedList) declaredField.get(null);
            f10814k = linkedList2;
            return linkedList2;
        } catch (Throwable th) {
            cn.jiguang.u.b.b("JCoreBridge", "error occured when isDebugModel." + th.getMessage());
            return null;
        }
    }

    private static Class<?> f() {
        try {
            if (f10813i == null) {
                synchronized (j) {
                    try {
                        if (f10813i == null) {
                            String str = JConstants.APP_KEY;
                            f10813i = JConstants.class;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.u.b.e("JCoreBridge", "error occured when getJConstants." + th2.getMessage());
        }
        return f10813i;
    }

    public static PackageInfo a(Context context, Object... objArr) {
        Object objA = a(context, null, 98, null, null, objArr);
        if (objA instanceof PackageInfo) {
            return (PackageInfo) objA;
        }
        return null;
    }

    public static boolean b(Context context) {
        Boolean bool = f10806b;
        if (bool != null) {
            return bool.booleanValue();
        }
        Object objA = a(context, null, 123, null, null, new Object[0]);
        if (!(objA instanceof Boolean)) {
            return false;
        }
        Boolean bool2 = (Boolean) objA;
        f10806b = bool2;
        return bool2.booleanValue();
    }

    public static boolean c(Context context) {
        Boolean bool = f10807c;
        if (bool != null) {
            return bool.booleanValue();
        }
        Object objA = a(context, null, 121, null, null, new Object[0]);
        if (!(objA instanceof Boolean)) {
            return false;
        }
        Boolean bool2 = (Boolean) objA;
        f10807c = bool2;
        return bool2.booleanValue();
    }

    public static boolean d() {
        try {
            Boolean bool = f10812h;
            if (bool == null) {
                Field field = f().getField("INTERNAL_USE");
                field.setAccessible(true);
                Object obj = field.get(null);
                if (obj instanceof Boolean) {
                    Boolean bool2 = (Boolean) obj;
                    bool2.booleanValue();
                    f10812h = bool2;
                }
                bool = f10812h;
            }
            return bool.booleanValue();
        } catch (Throwable th) {
            cn.jiguang.u.b.b("JCoreBridge", "error occured when isInternalUse." + th.getMessage());
            return false;
        }
    }

    public static Object a(Context context, String str, int i9, String str2, Bundle bundle, Object... objArr) {
        try {
            if (f10809e == null) {
                synchronized (f10811g) {
                    try {
                        if (f10809e == null) {
                            int i10 = JCoreManager.f9369a;
                            f10809e = JCoreManager.class;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (f10810f == null) {
                f10810f = f10809e.getDeclaredMethod("onEvent", Context.class, String.class, Integer.TYPE, String.class, Bundle.class, Object[].class);
            }
            if (f10810f != null) {
                return f10810f.invoke(null, context, str, Integer.valueOf(i9), str2, bundle, objArr);
            }
        } catch (Throwable th2) {
            cn.jiguang.u.b.b("JCoreBridge", "error occured when invokeOnEvent." + th2.getMessage());
        }
        return null;
    }

    public static Map<Integer, Bundle> a() {
        try {
            int i9 = ActionManager.f10551a;
            Object objInvoke = ActionManager.class.getDeclaredMethod("loadPInfo", new Class[0]).invoke(ActionManager.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (objInvoke instanceof Map) {
                return (Map) objInvoke;
            }
        } catch (Throwable th) {
            cn.jiguang.u.b.b("JCoreBridge", "error occured when getUid." + th.getMessage());
        }
        return null;
    }

    public static void a(Context context, String str, long j8, int i9) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteMessageConst.Notification.URL, str);
        bundle.putString("type", "dy");
        bundle.putLong(HiAnalyticsConstant.Direction.REQUEST, j8);
        bundle.putLong("res", i9);
        a(context, null, 122, null, bundle, new Object[0]);
    }
}
