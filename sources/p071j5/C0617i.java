package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import java.util.ArrayList;

/* JADX INFO: renamed from: j5.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0617i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        boolean zK = false;
        ArrayList arrayListI = null;
        boolean zK2 = false;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                arrayListI = a.i(parcel, i9, LocationRequest.CREATOR);
            } else if (c5 == 2) {
                zK = a.k(parcel, i9);
            } else if (c5 != 3) {
                a.r(parcel, i9);
            } else {
                zK2 = a.k(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new LocationSettingsRequest(arrayListI, zK, zK2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new LocationSettingsRequest[i9];
    }
}
