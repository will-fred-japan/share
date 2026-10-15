package S4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class M implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArrD = null;
        int[] iArrD2 = null;
        boolean zK = false;
        boolean zK2 = false;
        int iN = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) T4.a.e(parcel, i9, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    zK = T4.a.k(parcel, i9);
                    break;
                case 3:
                    zK2 = T4.a.k(parcel, i9);
                    break;
                case 4:
                    iArrD = T4.a.d(parcel, i9);
                    break;
                case 5:
                    iN = T4.a.n(parcel, i9);
                    break;
                case 6:
                    iArrD2 = T4.a.d(parcel, i9);
                    break;
                default:
                    T4.a.r(parcel, i9);
                    break;
            }
        }
        T4.a.j(parcel, iS);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zK, zK2, iArrD, iN, iArrD2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new ConnectionTelemetryConfiguration[i9];
    }
}
