package p008b1;

import android.annotation.SuppressLint;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: FlippedV1Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b {
    @Override // p008b1.b
    @SuppressLint({"DiscouragedPrivateApi"})
    public final void invokeHiddenApiRestrictions() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod.invoke(cls, "getRuntime", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, new Object[0]);
            Method method2 = (Method) declaredMethod.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            method2.setAccessible(true);
            method2.invoke(objInvoke, new String[]{"L"});
            Log.e("FlippedV1Impl", "V1 invokeHiddenApiRestrictions success.");
        } catch (Exception e9) {
            Log.e("FlippedV1Impl", "V1 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e9));
        }
    }
}
