package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.location.zzb;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        WorkSource workSource = null;
        String strF = null;
        int[] iArrD = null;
        String strF2 = null;
        String strF3 = null;
        long jO = 0;
        long jO2 = 0;
        boolean zK = false;
        boolean zK2 = false;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    jO = a.o(parcel, i9);
                    break;
                case 2:
                    zK = a.k(parcel, i9);
                    break;
                case 3:
                    workSource = (WorkSource) a.e(parcel, i9, WorkSource.CREATOR);
                    break;
                case 4:
                    strF = a.f(parcel, i9);
                    break;
                case 5:
                    iArrD = a.d(parcel, i9);
                    break;
                case 6:
                    zK2 = a.k(parcel, i9);
                    break;
                case 7:
                    strF2 = a.f(parcel, i9);
                    break;
                case '\b':
                    jO2 = a.o(parcel, i9);
                    break;
                case '\t':
                    strF3 = a.f(parcel, i9);
                    break;
                default:
                    a.r(parcel, i9);
                    break;
            }
        }
        a.j(parcel, iS);
        return new zzb(jO, zK, workSource, strF, iArrD, zK2, strF2, jO2, strF3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzb[i9];
    }
}
