package D3;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: SystemProperties.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f1910a;

    static {
        try {
            for (Method method : Class.forName("android.os.SystemProperties").getMethods()) {
                String name = method.getName();
                if (name.equals("get")) {
                    f1910a = method;
                } else if (!name.equals("set") && !name.equals("getLong")) {
                    name.equals("getInt");
                }
            }
        } catch (ClassNotFoundException e9) {
            e9.printStackTrace();
        }
    }
}
