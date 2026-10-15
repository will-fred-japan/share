package N4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        Bundle bundleB = null;
        int iN = 0;
        int iN2 = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = T4.a.n(parcel, i9);
            } else if (c5 == 2) {
                iN2 = T4.a.n(parcel, i9);
            } else if (c5 != 3) {
                T4.a.r(parcel, i9);
            } else {
                bundleB = T4.a.b(parcel, i9);
            }
        }
        T4.a.j(parcel, iS);
        return new GoogleSignInOptionsExtensionParcelable(iN, iN2, bundleB);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new GoogleSignInOptionsExtensionParcelable[i9];
    }
}
