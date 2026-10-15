package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.location.ActivityTransition;
import com.google.android.gms.location.ActivityTransitionRequest;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        ArrayList arrayListI = null;
        String strF = null;
        ArrayList arrayListI2 = null;
        String strF2 = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                arrayListI = a.i(parcel, i9, ActivityTransition.CREATOR);
            } else if (c5 == 2) {
                strF = a.f(parcel, i9);
            } else if (c5 == 3) {
                arrayListI2 = a.i(parcel, i9, ClientIdentity.CREATOR);
            } else if (c5 != 4) {
                a.r(parcel, i9);
            } else {
                strF2 = a.f(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new ActivityTransitionRequest(arrayListI, strF, arrayListI2, strF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new ActivityTransitionRequest[i9];
    }
}
