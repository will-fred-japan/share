package b5;

import S4.C0376g;
import android.os.Build;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f8590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f8591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f8592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f8593d;

    static {
        Method method;
        Method method2;
        Method method3;
        Class cls = Integer.TYPE;
        Process.myUid();
        Method method4 = null;
        try {
            method = WorkSource.class.getMethod("add", cls);
        } catch (Exception unused) {
            method = null;
        }
        f8590a = method;
        try {
            method2 = WorkSource.class.getMethod("add", cls, String.class);
        } catch (Exception unused2) {
            method2 = null;
        }
        f8591b = method2;
        try {
            method3 = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused3) {
            method3 = null;
        }
        f8592c = method3;
        try {
            WorkSource.class.getMethod("get", cls);
        } catch (Exception unused4) {
        }
        try {
            WorkSource.class.getMethod("getName", cls);
        } catch (Exception unused5) {
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e9) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e9);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", cls, String.class);
            } catch (Exception e10) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e10);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                method4 = WorkSource.class.getMethod("isEmpty", new Class[0]);
                method4.setAccessible(true);
            } catch (Exception unused6) {
            }
        }
        f8593d = method4;
    }

    public static boolean a(WorkSource workSource) {
        int iIntValue;
        Method method = f8593d;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(workSource, new Object[0]);
                C0376g.e(objInvoke);
                return ((Boolean) objInvoke).booleanValue();
            } catch (Exception e9) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e9);
            }
        }
        Method method2 = f8592c;
        if (method2 != null) {
            try {
                Object objInvoke2 = method2.invoke(workSource, new Object[0]);
                C0376g.e(objInvoke2);
                iIntValue = ((Integer) objInvoke2).intValue();
            } catch (Exception e10) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
                iIntValue = 0;
            }
        } else {
            iIntValue = 0;
        }
        return iIntValue == 0;
    }
}
