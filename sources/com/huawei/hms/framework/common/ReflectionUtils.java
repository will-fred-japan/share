package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes.dex */
public class ReflectionUtils {
    private static final int DISABLE = 1;
    private static final int ENABLE = 2;
    private static final String TAG = "ReflectionUtils";
    private static final int UNCHECK = 0;
    private static int abtestStatus;

    public static boolean checkCompatible(String str) {
        try {
            tryLoadClass(str);
            return true;
        } catch (Exception unused) {
            Logger.w(TAG, str + "ClassNotFoundException");
            return false;
        }
    }

    private static Class<?> getClass(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Field getField(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                final Field declaredField = obj.getClass().getDeclaredField(str);
                AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.2
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        declaredField.setAccessible(true);
                        return null;
                    }
                });
                return declaredField;
            } catch (IllegalArgumentException e9) {
                Logger.e(TAG, "Exception in getField :: IllegalArgumentException:", e9);
            } catch (NoSuchFieldException e10) {
                Logger.e(TAG, "Exception in getField :: NoSuchFieldException:", e10);
            } catch (SecurityException e11) {
                Logger.e(TAG, "not security int method getField,SecurityException:", e11);
            }
        }
        return null;
    }

    public static Object getFieldObj(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                final Field declaredField = obj.getClass().getDeclaredField(str);
                AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.1
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        declaredField.setAccessible(true);
                        return null;
                    }
                });
                return declaredField.get(obj);
            } catch (IllegalAccessException e9) {
                Logger.e(TAG, "Exception in getFieldObj :: IllegalAccessException:", e9);
            } catch (IllegalArgumentException e10) {
                Logger.e(TAG, "Exception in getFieldObj :: IllegalArgumentException:", e10);
            } catch (NoSuchFieldException e11) {
                Logger.e(TAG, "Exception in getFieldObj :: NoSuchFieldException:", e11);
            } catch (SecurityException e12) {
                Logger.e(TAG, "not security int method getFieldObj,SecurityException:", e12);
            }
        }
        return null;
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null || str == null) {
            Logger.w(TAG, "targetClass is  null pr name is null:");
            return null;
        }
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException e9) {
            Logger.e(TAG, "NoSuchMethodException:", e9);
            return null;
        } catch (SecurityException e10) {
            Logger.e(TAG, "SecurityException:", e10);
            return null;
        }
    }

    public static Object getStaticFieldObj(String str, String str2) {
        Class<?> cls;
        if (str != null && (cls = getClass(str)) != null && !TextUtils.isEmpty(str2)) {
            try {
                final Field declaredField = cls.getDeclaredField(str2);
                AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.3
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        declaredField.setAccessible(true);
                        return null;
                    }
                });
                return declaredField.get(cls);
            } catch (IllegalAccessException e9) {
                Logger.e(TAG, "Exception in getFieldObj :: IllegalAccessException:", e9);
            } catch (IllegalArgumentException e10) {
                Logger.e(TAG, "Exception in getFieldObj :: IllegalArgumentException:", e10);
            } catch (NoSuchFieldException e11) {
                Logger.e(TAG, "Exception in getFieldObj :: NoSuchFieldException:", e11);
            } catch (SecurityException e12) {
                Logger.e(TAG, "not security int method getStaticFieldObj,SecurityException:", e12);
            }
        }
        return null;
    }

    private static Object invoke(Object obj, Method method, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (RuntimeException e9) {
            Logger.e(TAG, "RuntimeException in invoke:", e9);
            return null;
        } catch (Exception e10) {
            Logger.e(TAG, "Exception in invoke:", e10);
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Object... objArr) {
        Class[] clsArr;
        if (str == null) {
            return null;
        }
        if (objArr != null) {
            int length = objArr.length;
            clsArr = new Class[length];
            for (int i9 = 0; i9 < length; i9++) {
                setClassType(clsArr, objArr[i9], i9);
            }
        } else {
            clsArr = null;
        }
        Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke(null, method, objArr);
    }

    public static boolean isAbTestEnable() {
        int i9 = abtestStatus;
        if (i9 != 0) {
            return i9 == 2;
        }
        boolean zCheckCompatible = checkCompatible("com.huawei.hms.network.abtest.ABHelper");
        abtestStatus = zCheckCompatible ? 2 : 1;
        return zCheckCompatible;
    }

    private static void setClassType(Class<?>[] clsArr, Object obj, int i9) {
        if (obj instanceof Integer) {
            clsArr[i9] = Integer.TYPE;
            return;
        }
        if (obj instanceof Long) {
            clsArr[i9] = Long.TYPE;
            return;
        }
        if (obj instanceof Double) {
            clsArr[i9] = Double.TYPE;
            return;
        }
        if (obj instanceof Float) {
            clsArr[i9] = Float.TYPE;
            return;
        }
        if (obj instanceof Boolean) {
            clsArr[i9] = Boolean.TYPE;
            return;
        }
        if (obj instanceof Character) {
            clsArr[i9] = Character.TYPE;
            return;
        }
        if (obj instanceof Byte) {
            clsArr[i9] = Byte.TYPE;
            return;
        }
        if (obj instanceof Void) {
            clsArr[i9] = Void.TYPE;
        } else if (obj instanceof Short) {
            clsArr[i9] = Short.TYPE;
        } else {
            clsArr[i9] = obj.getClass();
        }
    }

    private static void tryLoadClass(String str) throws ClassNotFoundException {
        ClassLoader classLoader = ReflectionUtils.class.getClassLoader();
        if (classLoader == null) {
            throw new ClassNotFoundException("not found classloader");
        }
        classLoader.loadClass(str);
    }

    public static boolean checkCompatible(String str, String str2, Class<?>... clsArr) {
        try {
            if (str != null && str2 != null) {
                Class.forName(str).getDeclaredMethod(str2, clsArr);
                Logger.v(TAG, "has method : ".concat(str2));
                return true;
            }
            Logger.w(TAG, "targetClass is  null or name is null:");
            return false;
        } catch (RuntimeException unused) {
            Logger.w(TAG, str + " RuntimeException");
            return false;
        } catch (Exception unused2) {
            Logger.w(TAG, str2 + " NoSuchMethodException");
            return false;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke(null, method, objArr);
    }
}
