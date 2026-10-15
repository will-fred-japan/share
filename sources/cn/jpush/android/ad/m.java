package cn.jpush.android.ad;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class m {
    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) throws Exception {
        Object objInvoke;
        if ((objArr != null ? objArr.length : 0) != (clsArr != null ? clsArr.length : 0)) {
            throw new IllegalArgumentException("argClasses' size is not equal to args' size");
        }
        Method method = obj.getClass().getMethod(str, clsArr);
        boolean zIsAccessible = method.isAccessible();
        if (!zIsAccessible) {
            method.setAccessible(true);
        }
        Exception exc = null;
        try {
            objInvoke = method.invoke(obj, objArr);
        } catch (Exception e9) {
            exc = e9;
            objInvoke = null;
        }
        if (!zIsAccessible) {
            method.setAccessible(false);
        }
        if (exc == null) {
            return objInvoke;
        }
        throw exc;
    }
}
