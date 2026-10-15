package p056h5;

import Q4.C0359o;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import p048g5.b;
import p071j5.C0611c;

/* JADX INFO: renamed from: h5.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC0594a extends b {
    @Override // p048g5.b
    public final boolean O(Parcel parcel, int i9) {
        if (i9 != 1) {
            return false;
        }
        LocationSettingsResult locationSettingsResult = (LocationSettingsResult) C0599f.a(parcel, LocationSettingsResult.CREATOR);
        C0599f.b(parcel);
        Status status = locationSettingsResult.f12740a;
        C0611c c0611c = new C0611c();
        c0611c.f19865a = locationSettingsResult;
        C0359o.a(status, c0611c, ((BinderC0602i) this).f19069b);
        return true;
    }
}
