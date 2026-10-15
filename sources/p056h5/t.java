package p056h5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.internal.location.zzeg;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        long jO = Long.MAX_VALUE;
        LocationRequest locationRequest = null;
        ArrayList arrayListI = null;
        boolean zK = false;
        boolean zK2 = false;
        boolean zK3 = false;
        boolean zK4 = false;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                locationRequest = (LocationRequest) a.e(parcel, i9, LocationRequest.CREATOR);
            } else if (c5 == 5) {
                arrayListI = a.i(parcel, i9, ClientIdentity.CREATOR);
            } else if (c5 == '\b') {
                zK = a.k(parcel, i9);
            } else if (c5 != '\t') {
                switch (c5) {
                    case 11:
                        zK3 = a.k(parcel, i9);
                        break;
                    case '\f':
                        zK4 = a.k(parcel, i9);
                        break;
                    case '\r':
                        a.f(parcel, i9);
                        break;
                    case 14:
                        jO = a.o(parcel, i9);
                        break;
                    default:
                        a.r(parcel, i9);
                        break;
                }
            } else {
                zK2 = a.k(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new zzeg(locationRequest, arrayListI, zK, zK2, zK3, zK4, jO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzeg[i9];
    }
}
