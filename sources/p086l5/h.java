package p086l5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        ConnectionResult connectionResult = null;
        int iN = 0;
        zav zavVar = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = a.n(parcel, i9);
            } else if (c5 == 2) {
                connectionResult = (ConnectionResult) a.e(parcel, i9, ConnectionResult.CREATOR);
            } else if (c5 != 3) {
                a.r(parcel, i9);
            } else {
                zavVar = (zav) a.e(parcel, i9, zav.CREATOR);
            }
        }
        a.j(parcel, iS);
        return new zak(iN, connectionResult, zavVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zak[i9];
    }
}
