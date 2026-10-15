package cn.jpush.android.y;

import W5.e;
import android.util.Log;
import dalvik.system.DexClassLoader;

/* JADX INFO: loaded from: classes.dex */
public class b extends DexClassLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ClassLoader f11797a;

    public b(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, DexClassLoader.class.getClassLoader());
        this.f11797a = classLoader;
        Log.d("PushDexClassLoader", "init jpush cl...");
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        try {
            try {
                return super.loadClass(str);
            } catch (ClassNotFoundException unused) {
                return this.f11797a.loadClass(str);
            }
        } catch (Throwable unused2) {
            throw new ClassNotFoundException(e.l("jpush not found ", str));
        }
    }
}
