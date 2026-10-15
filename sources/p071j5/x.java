package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.internal.location.zze;
import com.google.android.gms.location.CurrentLocationRequest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        WorkSource workSource = new WorkSource();
        zze zzeVar = null;
        int iN = 0;
        boolean zK = false;
        int iN2 = 0;
        long jO = Long.MAX_VALUE;
        long jO2 = Long.MAX_VALUE;
        int iN3 = 102;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    jO = a.o(parcel, i9);
                    break;
                case 2:
                    iN = a.n(parcel, i9);
                    break;
                case 3:
                    iN3 = a.n(parcel, i9);
                    break;
                case 4:
                    jO2 = a.o(parcel, i9);
                    break;
                case 5:
                    zK = a.k(parcel, i9);
                    break;
                case 6:
                    workSource = (WorkSource) a.e(parcel, i9, WorkSource.CREATOR);
                    break;
                case 7:
                    iN2 = a.n(parcel, i9);
                    break;
                case '\b':
                default:
                    a.r(parcel, i9);
                    break;
                case '\t':
                    zzeVar = (zze) a.e(parcel, i9, zze.CREATOR);
                    break;
            }
        }
        a.j(parcel, iS);
        return new CurrentLocationRequest(jO, iN, iN3, jO2, zK, iN2, workSource, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new CurrentLocationRequest[i9];
    }
}
