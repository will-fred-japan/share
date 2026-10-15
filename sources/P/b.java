package P;

import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: BundleCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: compiled from: BundleCompat.java */
    public static class a {
        public static <T> T a(Bundle bundle, String str, Class<T> cls) {
            return (T) bundle.getParcelable(str, cls);
        }

        public static ArrayList b(Bundle bundle, String str) {
            return bundle.getParcelableArrayList(str, Bundle.class);
        }
    }

    public static <T> T a(Bundle bundle, String str, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (T) a.a(bundle, str, cls);
        }
        T t = (T) bundle.getParcelable(str);
        if (cls.isInstance(t)) {
            return t;
        }
        return null;
    }
}
