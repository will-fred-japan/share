package p181x0;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VersionedParcel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p155u.a<String, Method> f22263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p155u.a<String, Method> f22264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p155u.a<String, Class> f22265c;

    public a(p155u.a<String, Method> aVar, p155u.a<String, Method> aVar2, p155u.a<String, Class> aVar3) {
        this.f22263a = aVar;
        this.f22264b = aVar2;
        this.f22265c = aVar3;
    }

    public abstract b a();

    public final Class b(Class<? extends c> cls) throws ClassNotFoundException {
        String name = cls.getName();
        p155u.a<String, Class> aVar = this.f22265c;
        Class cls2 = aVar.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        aVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) throws NoSuchMethodException {
        p155u.a<String, Method> aVar = this.f22263a;
        Method method = aVar.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        aVar.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        p155u.a<String, Method> aVar = this.f22264b;
        Method method = aVar.get(name);
        if (method != null) {
            return method;
        }
        Class clsB = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsB.getDeclaredMethod("write", cls, a.class);
        aVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e();

    public abstract byte[] f();

    public abstract CharSequence g();

    public abstract boolean h(int i9);

    public abstract int i();

    public final int j(int i9, int i10) {
        return !h(i10) ? i9 : i();
    }

    public abstract <T extends Parcelable> T k();

    public abstract String l();

    public final <T extends c> T m() {
        String strL = l();
        if (strL == null) {
            return null;
        }
        try {
            return (T) c(strL).invoke(null, a());
        } catch (ClassNotFoundException e9) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e9);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e10);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e11);
        } catch (InvocationTargetException e12) {
            if (e12.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e12.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e12);
        }
    }

    public abstract void n(int i9);

    public abstract void o(boolean z8);

    public abstract void p(byte[] bArr);

    public abstract void q(CharSequence charSequence);

    public abstract void r(int i9);

    public final void s(int i9, int i10) {
        n(i10);
        r(i9);
    }

    public abstract void t(Parcelable parcelable);

    public abstract void u(String str);

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(c cVar) {
        if (cVar == null) {
            u(null);
            return;
        }
        try {
            u(b(cVar.getClass()).getName());
            b bVarA = a();
            try {
                d(cVar.getClass()).invoke(null, cVar, bVarA);
                bVarA.w();
            } catch (ClassNotFoundException e9) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e9);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e10);
            } catch (NoSuchMethodException e11) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e11);
            } catch (InvocationTargetException e12) {
                if (!(e12.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e12);
                }
                throw ((RuntimeException) e12.getCause());
            }
        } catch (ClassNotFoundException e13) {
            throw new RuntimeException(cVar.getClass().getSimpleName().concat(" does not have a Parcelizer"), e13);
        }
    }
}
