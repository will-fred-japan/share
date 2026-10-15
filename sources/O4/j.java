package O4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        long jO = -1;
        int iN = 0;
        String strF = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                strF = T4.a.f(parcel, i9);
            } else if (c5 == 2) {
                iN = T4.a.n(parcel, i9);
            } else if (c5 != 3) {
                T4.a.r(parcel, i9);
            } else {
                jO = T4.a.o(parcel, i9);
            }
        }
        T4.a.j(parcel, iS);
        return new Feature(strF, iN, jO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new Feature[i9];
    }
}
