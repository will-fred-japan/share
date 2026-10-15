package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;

/* JADX INFO: renamed from: j5.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0618j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        Status status = null;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                status = (Status) a.e(parcel, i9, Status.CREATOR);
            } else if (c5 != 2) {
                a.r(parcel, i9);
            } else {
                locationSettingsStates = (LocationSettingsStates) a.e(parcel, i9, LocationSettingsStates.CREATOR);
            }
        }
        a.j(parcel, iS);
        return new LocationSettingsResult(status, locationSettingsStates);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new LocationSettingsResult[i9];
    }
}
