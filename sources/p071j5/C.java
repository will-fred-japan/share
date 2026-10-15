package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzek;
import com.google.android.gms.location.GeofencingRequest;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        ArrayList arrayListI = null;
        int iN = 0;
        String strF = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                arrayListI = a.i(parcel, i9, zzek.CREATOR);
            } else if (c5 == 2) {
                iN = a.n(parcel, i9);
            } else if (c5 != 4) {
                a.r(parcel, i9);
            } else {
                strF = a.f(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new GeofencingRequest(iN, strF, arrayListI);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new GeofencingRequest[i9];
    }
}
