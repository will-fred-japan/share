package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.zzal;

/* JADX INFO: renamed from: j5.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0613e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        zzal[] zzalVarArr = null;
        long jO = 0;
        int iN = 1;
        int iN2 = 1;
        int iN3 = 1000;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    iN = a.n(parcel, i9);
                    break;
                case 2:
                    iN2 = a.n(parcel, i9);
                    break;
                case 3:
                    jO = a.o(parcel, i9);
                    break;
                case 4:
                    iN3 = a.n(parcel, i9);
                    break;
                case 5:
                    zzalVarArr = (zzal[]) a.h(parcel, i9, zzal.CREATOR);
                    break;
                case 6:
                    a.k(parcel, i9);
                    break;
                default:
                    a.r(parcel, i9);
                    break;
            }
        }
        a.j(parcel, iS);
        return new LocationAvailability(iN3, iN, iN2, jO, zzalVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new LocationAvailability[i9];
    }
}
