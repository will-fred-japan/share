package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.zzal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        long jO = -1;
        long jO2 = -1;
        int iN = 1;
        int iN2 = 1;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = a.n(parcel, i9);
            } else if (c5 == 2) {
                iN2 = a.n(parcel, i9);
            } else if (c5 == 3) {
                jO = a.o(parcel, i9);
            } else if (c5 != 4) {
                a.r(parcel, i9);
            } else {
                jO2 = a.o(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new zzal(iN, iN2, jO, jO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzal[i9];
    }
}
