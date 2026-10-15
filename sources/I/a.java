package I;

import G.y;
import J.g;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ContextCompat.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class a {

    /* JADX INFO: renamed from: I.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ContextCompat.java */
    public static class C0022a {
        public static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    public static int a(Context context, String str) {
        if (str == null) {
            throw new NullPointerException("permission must be non-null");
        }
        if (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        return new y(context).f2193b.areNotificationsEnabled() ? 0 : -1;
    }

    public static ColorStateList b(Context context, int i9) {
        ColorStateList colorStateListA;
        ColorStateList colorStateList;
        g.a aVar;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        g.b bVar = new g.b(resources, theme);
        synchronized (g.f2625c) {
            try {
                SparseArray<g.a> sparseArray = g.f2624b.get(bVar);
                colorStateListA = null;
                if (sparseArray == null || sparseArray.size() <= 0 || (aVar = sparseArray.get(i9)) == null) {
                    colorStateList = null;
                } else {
                    if (aVar.f2627b.equals(resources.getConfiguration())) {
                        if (theme != null || aVar.f2628c != 0) {
                            if (theme == null || aVar.f2628c != theme.hashCode()) {
                            }
                        }
                        colorStateList = aVar.f2626a;
                    }
                    sparseArray.remove(i9);
                    colorStateList = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ThreadLocal<TypedValue> threadLocal = g.f2623a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        resources.getValue(i9, typedValue, true);
        int i10 = typedValue.type;
        if (i10 < 28 || i10 > 31) {
            try {
                colorStateListA = J.c.a(resources, resources.getXml(i9), theme);
            } catch (Exception e9) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e9);
            }
        }
        if (colorStateListA == null) {
            return resources.getColorStateList(i9, theme);
        }
        synchronized (g.f2625c) {
            try {
                WeakHashMap<g.b, SparseArray<g.a>> weakHashMap = g.f2624b;
                SparseArray<g.a> sparseArray2 = weakHashMap.get(bVar);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray<>();
                    weakHashMap.put(bVar, sparseArray2);
                }
                sparseArray2.append(i9, new g.a(colorStateListA, bVar.f2629a.getConfiguration(), theme));
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return colorStateListA;
    }

    public static void c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(broadcastReceiver, intentFilter, null, null, 2);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter, null, null, 0);
        }
    }
}
