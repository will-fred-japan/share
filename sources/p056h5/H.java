package p056h5;

import T4.a;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzh;
import com.google.android.gms.internal.location.zzj;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class H implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        zzh zzhVar = null;
        IBinder iBinderM = null;
        IBinder iBinderM2 = null;
        int iN = 1;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = a.n(parcel, i9);
            } else if (c5 == 2) {
                zzhVar = (zzh) a.e(parcel, i9, zzh.CREATOR);
            } else if (c5 == 3) {
                iBinderM = a.m(parcel, i9);
            } else if (c5 != 4) {
                a.r(parcel, i9);
            } else {
                iBinderM2 = a.m(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new zzj(iN, zzhVar, iBinderM, iBinderM2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzj[i9];
    }
}
