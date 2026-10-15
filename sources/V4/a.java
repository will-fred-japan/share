package V4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        boolean zK = false;
        int iN = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                zK = T4.a.k(parcel, i9);
            } else if (c5 != 2) {
                T4.a.r(parcel, i9);
            } else {
                iN = T4.a.n(parcel, i9);
            }
        }
        T4.a.j(parcel, iS);
        return new ModuleAvailabilityResponse(zK, iN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new ModuleAvailabilityResponse[i9];
    }
}
