package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zzas;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        int iN = 0;
        ArrayList arrayListI = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                arrayListI = a.i(parcel, i9, zzas.CREATOR);
            } else if (c5 != 2) {
                a.r(parcel, i9);
            } else {
                iN = a.n(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new SleepSegmentRequest(iN, arrayListI);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new SleepSegmentRequest[i9];
    }
}
