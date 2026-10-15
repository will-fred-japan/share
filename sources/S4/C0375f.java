package S4;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;

/* JADX INFO: renamed from: S4.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0375f {

    /* JADX INFO: renamed from: S4.f$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f4189a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f4190b;

        public final void a(Object obj, String str) {
            this.f4189a.add(p171w.a.a(str, ContainerUtils.KEY_VALUE_DELIMITER, String.valueOf(obj)));
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f4190b.getClass().getSimpleName());
            sb.append('{');
            ArrayList arrayList = this.f4189a;
            int size = arrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                sb.append((String) arrayList.get(i9));
                if (i9 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
