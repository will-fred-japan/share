package p035e5;

import android.os.IBinder;
import android.os.IInterface;
import p048g5.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: e5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public static abstract class AbstractBinderC0196a extends b implements a {
        public static a P(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new d(iBinder, "com.google.android.gms.dynamic.IObjectWrapper", 0);
        }
    }
}
