package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.internal.location.zze;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: renamed from: j5.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0615g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        WorkSource workSource = new WorkSource();
        zze zzeVar = null;
        boolean zK = false;
        int iN = 0;
        int iN2 = 0;
        boolean zK2 = false;
        long jO = -1;
        float fL = 0.0f;
        int iN3 = Integer.MAX_VALUE;
        long jO2 = Long.MAX_VALUE;
        long jO3 = Long.MAX_VALUE;
        long jO4 = 0;
        long jO5 = 600000;
        long jO6 = 3600000;
        int iN4 = 102;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    iN4 = a.n(parcel, i9);
                    break;
                case 2:
                    jO6 = a.o(parcel, i9);
                    break;
                case 3:
                    jO5 = a.o(parcel, i9);
                    break;
                case 4:
                case 14:
                default:
                    a.r(parcel, i9);
                    break;
                case 5:
                    jO2 = a.o(parcel, i9);
                    break;
                case 6:
                    iN3 = a.n(parcel, i9);
                    break;
                case 7:
                    fL = a.l(parcel, i9);
                    break;
                case '\b':
                    jO4 = a.o(parcel, i9);
                    break;
                case '\t':
                    zK = a.k(parcel, i9);
                    break;
                case '\n':
                    jO3 = a.o(parcel, i9);
                    break;
                case 11:
                    jO = a.o(parcel, i9);
                    break;
                case '\f':
                    iN = a.n(parcel, i9);
                    break;
                case '\r':
                    iN2 = a.n(parcel, i9);
                    break;
                case 15:
                    zK2 = a.k(parcel, i9);
                    break;
                case 16:
                    workSource = (WorkSource) a.e(parcel, i9, WorkSource.CREATOR);
                    break;
                case 17:
                    zzeVar = (zze) a.e(parcel, i9, zze.CREATOR);
                    break;
            }
        }
        a.j(parcel, iS);
        return new LocationRequest(iN4, jO6, jO5, jO4, jO2, jO3, iN3, fL, zK, jO, iN, iN2, zK2, workSource, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new LocationRequest[i9];
    }
}
