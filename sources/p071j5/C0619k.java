package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationSettingsStates;

/* JADX INFO: renamed from: j5.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0619k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        boolean zK = false;
        boolean zK2 = false;
        boolean zK3 = false;
        boolean zK4 = false;
        boolean zK5 = false;
        boolean zK6 = false;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    zK = a.k(parcel, i9);
                    break;
                case 2:
                    zK2 = a.k(parcel, i9);
                    break;
                case 3:
                    zK3 = a.k(parcel, i9);
                    break;
                case 4:
                    zK4 = a.k(parcel, i9);
                    break;
                case 5:
                    zK5 = a.k(parcel, i9);
                    break;
                case 6:
                    zK6 = a.k(parcel, i9);
                    break;
                default:
                    a.r(parcel, i9);
                    break;
            }
        }
        a.j(parcel, iS);
        return new LocationSettingsStates(zK, zK2, zK3, zK4, zK5, zK6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new LocationSettingsStates[i9];
    }
}
