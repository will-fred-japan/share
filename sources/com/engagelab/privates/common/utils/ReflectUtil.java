package com.engagelab.privates.common.utils;

/* JADX INFO: loaded from: classes.dex */
public class ReflectUtil {
    private static void checkNull(Object obj) throws Exception {
        if (obj == null) {
            throw new Exception("owner can not be null");
        }
    }

    private static void checkNum(Class<?>[] clsArr, Object[] objArr) throws Exception {
        if ((objArr != null ? objArr.length : 0) != (clsArr != null ? clsArr.length : 0)) {
            throw new Exception("argClasses' size is not equal to args' size");
        }
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws Exception {
        checkNull(cls);
        checkNum(clsArr, objArr);
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class[] clsArr) throws Exception {
        checkNull(cls);
        checkNum(clsArr, objArr);
        return cls.getMethod(str, clsArr).invoke(cls, objArr);
    }
}
