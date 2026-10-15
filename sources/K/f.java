package K;

import Q.m;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.huawei.agconnect.exception.AGCServerException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: TypefaceCompatApi26Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<?> f2759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Constructor<?> f2760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Method f2761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Method f2762i;
    public final Method j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Method f2763k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Method f2764l;

    public f() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method methodL;
        Method method2;
        Method method3;
        Method methodM;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            methodL = l(cls);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
            method3 = cls.getMethod("freeze", new Class[0]);
            method = cls.getMethod("abortCreation", new Class[0]);
            methodM = m(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e9) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e9.getClass().getName()), e9);
            cls = null;
            method = null;
            constructor = null;
            methodL = null;
            method2 = null;
            method3 = null;
            methodM = null;
        }
        this.f2759f = cls;
        this.f2760g = constructor;
        this.f2761h = methodL;
        this.f2762i = method2;
        this.j = method3;
        this.f2763k = method;
        this.f2764l = methodM;
    }

    public static Method l(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    @Override // K.e, K.j
    public final Typeface a(Context context, J.e.b bVar, Resources resources, int i9) {
        Method method = this.f2761h;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.a(context, bVar, resources, i9);
        }
        Object objK = k();
        if (objK != null) {
            J.e.c[] cVarArr = bVar.f2610a;
            int length = cVarArr.length;
            int i10 = 0;
            while (i10 < length) {
                J.e.c cVar = cVarArr[i10];
                String str = cVar.f2611a;
                FontVariationAxis[] fontVariationAxisArrFromFontVariationSettings = FontVariationAxis.fromFontVariationSettings(cVar.f2614d);
                Context context2 = context;
                if (!h(context2, objK, str, cVar.f2615e, cVar.f2612b, cVar.f2613c ? 1 : 0, fontVariationAxisArrFromFontVariationSettings)) {
                    g(objK);
                    return null;
                }
                i10++;
                context = context2;
            }
            if (j(objK)) {
                return i(objK);
            }
        }
        return null;
    }

    @Override // K.j
    public final Typeface b(Context context, m[] mVarArr, int i9) {
        Typeface typefaceI;
        boolean zBooleanValue;
        if (mVarArr.length >= 1) {
            Method method = this.f2761h;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            if (method != null) {
                HashMap map = new HashMap();
                for (m mVar : mVarArr) {
                    if (mVar.f3686f == 0) {
                        Uri uri = mVar.f3681a;
                        if (!map.containsKey(uri)) {
                            map.put(uri, k.d(context, uri));
                        }
                    }
                }
                Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                Object objK = k();
                if (objK != null) {
                    int length = mVarArr.length;
                    int i10 = 0;
                    boolean z8 = false;
                    while (i10 < length) {
                        m mVar2 = mVarArr[i10];
                        ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(mVar2.f3681a);
                        if (byteBuffer != null) {
                            try {
                                zBooleanValue = ((Boolean) this.f2762i.invoke(objK, byteBuffer, Integer.valueOf(mVar2.f3682b), null, Integer.valueOf(mVar2.f3683c), Integer.valueOf(mVar2.f3684d ? 1 : 0))).booleanValue();
                            } catch (IllegalAccessException | InvocationTargetException unused) {
                                zBooleanValue = false;
                            }
                            if (!zBooleanValue) {
                                g(objK);
                                return null;
                            }
                            z8 = true;
                        }
                        i10++;
                        z8 = z8;
                    }
                    if (!z8) {
                        g(objK);
                        return null;
                    }
                    if (j(objK) && (typefaceI = i(objK)) != null) {
                        return Typeface.create(typefaceI, i9);
                    }
                }
            } else {
                int i11 = (i9 & 1) == 0 ? AGCServerException.AUTHENTICATION_INVALID : 700;
                boolean z9 = (i9 & 2) != 0;
                m mVar3 = null;
                int i12 = Integer.MAX_VALUE;
                for (m mVar4 : mVarArr) {
                    int iAbs = (Math.abs(mVar4.f3683c - i11) * 2) + (mVar4.f3684d == z9 ? 0 : 1);
                    if (mVar3 == null || i12 > iAbs) {
                        mVar3 = mVar4;
                        i12 = iAbs;
                    }
                }
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(mVar3.f3681a, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(mVar3.f3683c).setItalic(mVar3.f3684d).build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            return typefaceBuild;
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return null;
                    }
                } catch (IOException unused2) {
                }
            }
        }
        return null;
    }

    @Override // K.j
    public final Typeface d(Context context, Resources resources, int i9, String str, int i10) {
        Method method = this.f2761h;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.d(context, resources, i9, str, i10);
        }
        Object objK = k();
        if (objK != null) {
            if (!h(context, objK, str, 0, -1, -1, null)) {
                g(objK);
                return null;
            }
            if (j(objK)) {
                return i(objK);
            }
        }
        return null;
    }

    public final void g(Object obj) {
        try {
            this.f2763k.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean h(Context context, Object obj, String str, int i9, int i10, int i11, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f2761h.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface i(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.f2759f, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f2764l.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean j(Object obj) {
        try {
            return ((Boolean) this.j.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final Object k() {
        try {
            return this.f2760g.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method m(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance(cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
