package O4;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzs;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        boolean zK = false;
        String strF = null;
        IBinder iBinderM = null;
        boolean zK2 = false;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                strF = T4.a.f(parcel, i9);
            } else if (c5 == 2) {
                iBinderM = T4.a.m(parcel, i9);
            } else if (c5 == 3) {
                zK = T4.a.k(parcel, i9);
            } else if (c5 != 4) {
                T4.a.r(parcel, i9);
            } else {
                zK2 = T4.a.k(parcel, i9);
            }
        }
        T4.a.j(parcel, iS);
        return new zzs(strF, iBinderM, zK, zK2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzs[i9];
    }
}
