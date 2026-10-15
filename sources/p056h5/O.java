package p056h5;

import Q4.C0359o;
import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import p048g5.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class O extends b {
    @Override // p048g5.b
    public final boolean O(Parcel parcel, int i9) {
        if (i9 != 1) {
            return false;
        }
        Status status = (Status) C0599f.a(parcel, Status.CREATOR);
        Location location = (Location) C0599f.a(parcel, Location.CREATOR);
        C0599f.b(parcel);
        C0359o.a(status, location, ((BinderC0604k) this).f19072b);
        return true;
    }
}
