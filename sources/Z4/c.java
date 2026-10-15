package Z4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.zan;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        int iN = 0;
        Parcel parcel2 = null;
        zan zanVar = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = T4.a.n(parcel, i9);
            } else if (c5 == 2) {
                int iQ = T4.a.q(parcel, i9);
                int iDataPosition = parcel.dataPosition();
                if (iQ == 0) {
                    parcel2 = null;
                } else {
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.appendFrom(parcel, iDataPosition, iQ);
                    parcel.setDataPosition(iDataPosition + iQ);
                    parcel2 = parcelObtain;
                }
            } else if (c5 != 3) {
                T4.a.r(parcel, i9);
            } else {
                zanVar = (zan) T4.a.e(parcel, i9, zan.CREATOR);
            }
        }
        T4.a.j(parcel, iS);
        return new SafeParcelResponse(iN, parcel2, zanVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new SafeParcelResponse[i9];
    }
}
