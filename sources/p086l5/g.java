package p086l5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.signin.internal.zai;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        zat zatVar = null;
        int iN = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = a.n(parcel, i9);
            } else if (c5 != 2) {
                a.r(parcel, i9);
            } else {
                zatVar = (zat) a.e(parcel, i9, zat.CREATOR);
            }
        }
        a.j(parcel, iS);
        return new zai(iN, zatVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zai[i9];
    }
}
