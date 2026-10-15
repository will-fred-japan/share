package S4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        int iN = 0;
        boolean zK = false;
        boolean zK2 = false;
        int iN2 = 0;
        int iN3 = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = T4.a.n(parcel, i9);
            } else if (c5 == 2) {
                zK = T4.a.k(parcel, i9);
            } else if (c5 == 3) {
                zK2 = T4.a.k(parcel, i9);
            } else if (c5 == 4) {
                iN2 = T4.a.n(parcel, i9);
            } else if (c5 != 5) {
                T4.a.r(parcel, i9);
            } else {
                iN3 = T4.a.n(parcel, i9);
            }
        }
        T4.a.j(parcel, iS);
        return new RootTelemetryConfiguration(iN, zK, zK2, iN2, iN3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new RootTelemetryConfiguration[i9];
    }
}
