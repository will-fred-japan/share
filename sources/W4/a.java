package W4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        ArrayList arrayListI = null;
        String strF = null;
        boolean zK = false;
        String strF2 = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                arrayListI = T4.a.i(parcel, i9, Feature.CREATOR);
            } else if (c5 == 2) {
                zK = T4.a.k(parcel, i9);
            } else if (c5 == 3) {
                strF2 = T4.a.f(parcel, i9);
            } else if (c5 != 4) {
                T4.a.r(parcel, i9);
            } else {
                strF = T4.a.f(parcel, i9);
            }
        }
        T4.a.j(parcel, iS);
        return new ApiFeatureRequest(arrayListI, strF2, strF, zK);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new ApiFeatureRequest[i9];
    }
}
