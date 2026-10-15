package p086l5;

import T4.a;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.signin.internal.zaa;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        Intent intent = null;
        int iN = 0;
        int iN2 = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = a.n(parcel, i9);
            } else if (c5 == 2) {
                iN2 = a.n(parcel, i9);
            } else if (c5 != 3) {
                a.r(parcel, i9);
            } else {
                intent = (Intent) a.e(parcel, i9, Intent.CREATOR);
            }
        }
        a.j(parcel, iS);
        return new zaa(iN, iN2, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zaa[i9];
    }
}
