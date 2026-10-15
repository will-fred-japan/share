package K;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: TypefaceCompatApi28Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends f {
    @Override // K.f
    public final Typeface i(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.f2759f, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f2764l.invoke(null, objNewInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e9) {
            throw new RuntimeException(e9);
        }
    }

    @Override // K.f
    public final Method m(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance(cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, String.class, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
