package S4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zax;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        Scope[] scopeArr = null;
        int iN = 0;
        int iN2 = 0;
        int iN3 = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = T4.a.n(parcel, i9);
            } else if (c5 == 2) {
                iN2 = T4.a.n(parcel, i9);
            } else if (c5 == 3) {
                iN3 = T4.a.n(parcel, i9);
            } else if (c5 != 4) {
                T4.a.r(parcel, i9);
            } else {
                scopeArr = (Scope[]) T4.a.h(parcel, i9, Scope.CREATOR);
            }
        }
        T4.a.j(parcel, iS);
        return new zax(iN, iN2, iN3, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zax[i9];
    }
}
