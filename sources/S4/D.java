package S4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzak;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class D implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        int iN = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            if (((char) i9) != 1) {
                T4.a.r(parcel, i9);
            } else {
                iN = T4.a.n(parcel, i9);
            }
        }
        T4.a.j(parcel, iS);
        return new zzak(iN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzak[i9];
    }
}
