package S4;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zav;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        int iN = 0;
        boolean zK = false;
        boolean zK2 = false;
        IBinder iBinderM = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = T4.a.n(parcel, i9);
            } else if (c5 == 2) {
                iBinderM = T4.a.m(parcel, i9);
            } else if (c5 == 3) {
                connectionResult = (ConnectionResult) T4.a.e(parcel, i9, ConnectionResult.CREATOR);
            } else if (c5 == 4) {
                zK = T4.a.k(parcel, i9);
            } else if (c5 != 5) {
                T4.a.r(parcel, i9);
            } else {
                zK2 = T4.a.k(parcel, i9);
            }
        }
        T4.a.j(parcel, iS);
        return new zav(iN, iBinderM, connectionResult, zK, zK2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zav[i9];
    }
}
