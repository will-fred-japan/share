package K;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: TypefaceCompatApi21Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f2754a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Constructor<?> f2755b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f2756c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f2757d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f2758e = false;

    public static boolean e(Object obj, String str, int i9, boolean z8) {
        f();
        try {
            return ((Boolean) f2756c.invoke(obj, str, Integer.valueOf(i9), Boolean.valueOf(z8))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e9) {
            throw new RuntimeException(e9);
        }
    }

    public static void f() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        if (f2758e) {
            return;
        }
        f2758e = true;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e9) {
            Log.e("TypefaceCompatApi21Impl", e9.getClass().getName(), e9);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f2755b = constructor;
        f2754a = cls;
        f2756c = method2;
        f2757d = method;
    }

    @Override // K.j
    public Typeface a(Context context, J.e.b bVar, Resources resources, int i9) {
        f();
        try {
            Object objNewInstance = f2755b.newInstance(new Object[0]);
            for (J.e.c cVar : bVar.f2610a) {
                File fileC = k.c(context);
                if (fileC == null) {
                    return null;
                }
                try {
                    if (!k.a(fileC, resources, cVar.f2616f)) {
                        return null;
                    }
                    if (!e(objNewInstance, fileC.getPath(), cVar.f2612b, cVar.f2613c)) {
                        return null;
                    }
                    fileC.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    fileC.delete();
                }
            }
            f();
            try {
                Object objNewInstance2 = Array.newInstance(f2754a, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) f2757d.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e9) {
                throw new RuntimeException(e9);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }
}
