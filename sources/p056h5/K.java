package p056h5;

import android.os.Parcel;
import com.google.android.gms.internal.location.zzl;
import p048g5.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class K extends b implements L {
    public K() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback", 1);
    }

    @Override // p048g5.b
    public final boolean O(Parcel parcel, int i9) {
        if (i9 != 1) {
            if (i9 != 2) {
                return false;
            }
            s();
            return true;
        }
        zzl zzlVar = (zzl) C0599f.a(parcel, zzl.CREATOR);
        C0599f.b(parcel);
        I(zzlVar);
        return true;
    }
}
