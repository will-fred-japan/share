package Z4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.response.zal;
import com.google.android.gms.common.server.response.zan;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        ArrayList arrayListI = null;
        int iN = 0;
        String strF = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = T4.a.n(parcel, i9);
            } else if (c5 == 2) {
                arrayListI = T4.a.i(parcel, i9, zal.CREATOR);
            } else if (c5 != 3) {
                T4.a.r(parcel, i9);
            } else {
                strF = T4.a.f(parcel, i9);
            }
        }
        T4.a.j(parcel, iS);
        return new zan(iN, strF, arrayListI);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zan[i9];
    }
}
