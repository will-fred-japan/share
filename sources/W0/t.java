package W0;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: XiaomiOppoImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class t implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f5038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f5039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f5040c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f5039b = cls;
            f5038a = cls.newInstance();
            f5040c = cls.getMethod("getOAID", Context.class);
        } catch (Exception e9) {
            String str = k.f5004i;
            p027d5.a.f("Api#static reflect exception! ").append(e9.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001b  */
    @Override // W0.l
    public final l.a a(Context context) {
        String str;
        try {
            l.a aVar = new l.a();
            Method method = f5040c;
            Object obj = f5038a;
            if (obj == null || method == null) {
                str = null;
            } else {
                try {
                    Object objInvoke = method.invoke(obj, context);
                    if (objInvoke != null) {
                        str = (String) objInvoke;
                    } else {
                        str = null;
                    }
                } catch (Exception unused) {
                }
            }
            aVar.f5014a = str;
            return aVar;
        } catch (Exception e9) {
            e9.printStackTrace();
            return null;
        }
    }

    @Override // W0.l
    public final boolean b(Context context) {
        return (f5039b == null || f5038a == null || f5040c == null) ? false : true;
    }
}
