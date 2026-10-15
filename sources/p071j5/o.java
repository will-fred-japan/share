package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.SleepSegmentEvent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        int iN = 0;
        int iN2 = 0;
        int iN3 = 0;
        long jO = 0;
        long jO2 = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                jO = a.o(parcel, i9);
            } else if (c5 == 2) {
                jO2 = a.o(parcel, i9);
            } else if (c5 == 3) {
                iN = a.n(parcel, i9);
            } else if (c5 == 4) {
                iN2 = a.n(parcel, i9);
            } else if (c5 != 5) {
                a.r(parcel, i9);
            } else {
                iN3 = a.n(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new SleepSegmentEvent(jO, jO2, iN, iN2, iN3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new SleepSegmentEvent[i9];
    }
}
