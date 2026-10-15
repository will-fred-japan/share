package S4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.zzk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class L implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        Bundle bundleB = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int iN = 0;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                bundleB = T4.a.b(parcel, i9);
            } else if (c5 == 2) {
                featureArr = (Feature[]) T4.a.h(parcel, i9, Feature.CREATOR);
            } else if (c5 == 3) {
                iN = T4.a.n(parcel, i9);
            } else if (c5 != 4) {
                T4.a.r(parcel, i9);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) T4.a.e(parcel, i9, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        T4.a.j(parcel, iS);
        zzk zzkVar = new zzk();
        zzkVar.f12550a = bundleB;
        zzkVar.f12551b = featureArr;
        zzkVar.f12552c = iN;
        zzkVar.f12553d = connectionTelemetryConfiguration;
        return zzkVar;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzk[i9];
    }
}
