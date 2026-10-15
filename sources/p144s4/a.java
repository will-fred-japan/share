package p144s4;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.util.List;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONException;
import org.json.JSONObject;
import p159u4.d;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21229a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f21230b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f21231c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f21232d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f21233e = false;

    public static long a(int i9) {
        if (i9 < 0) {
            return 0L;
        }
        return ((long) i9) * RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    }

    public static void b(Context context, JSONObject jSONObject) {
        try {
            c(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(MTCommonConstants.Lifecycle.KEY_ACTIVITY);
            if (activityManager != null) {
                f(jSONObject, activityManager);
            }
            d(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    public static void c(JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", a(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", a(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", a(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", a(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", a(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", a(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", a(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", a(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        try {
            String memoryStat = memoryInfo.getMemoryStat("summary.graphics");
            if (!TextUtils.isEmpty(memoryStat)) {
                jSONObject2.put("summary.graphics", a(Integer.parseInt(memoryStat)));
            }
        } catch (Throwable unused) {
        }
        jSONObject2.put("totalPrivateClean", memoryInfo.getTotalPrivateClean());
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", a(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", memoryInfo.getTotalSharedClean());
        jSONObject2.put("totalSharedDirty", a(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", a(memoryInfo.getTotalSwappablePss()));
        jSONObject.put("memory_info", jSONObject2);
    }

    public static void d(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        h4.a.i(jSONObject, "filters", "native_heap_leak", String.valueOf(Debug.getNativeHeapAllocatedSize() > 209715200));
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        long jMaxMemory = runtime.maxMemory();
        long jFreeMemory = runtime.freeMemory();
        long j = runtime.totalMemory();
        jSONObject2.put("max_memory", jMaxMemory);
        jSONObject2.put("free_memory", jFreeMemory);
        jSONObject2.put("total_memory", j);
        h4.a.i(jSONObject, "filters", "java_heap_leak", String.valueOf(((float) (j - jFreeMemory)) > ((float) jMaxMemory) * 0.95f));
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    public static boolean e(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        if (context == null) {
            return d.c().f21703p;
        }
        if (!d.c().f21703p) {
            String packageName = context.getPackageName();
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(MTCommonConstants.Lifecycle.KEY_ACTIVITY);
                if (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public static void f(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", memoryInfo.totalMem);
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    public static boolean g(Context context) {
        String strH = h();
        if (strH != null && strH.contains(Constants.COLON_SEPARATOR)) {
            return false;
        }
        if (strH == null || !strH.equals(context.getPackageName())) {
            return strH != null && strH.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    public static String h() {
        if (!TextUtils.isEmpty(f21229a)) {
            return f21229a;
        }
        try {
            f21229a = A4.d.a();
        } catch (Throwable unused) {
        }
        String str = f21229a;
        return str == null ? "" : str;
    }

    public static Class<?> i(Context context) {
        if (f21230b == null && !f21233e) {
            try {
                f21230b = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            f21233e = true;
        }
        return f21230b;
    }
}
