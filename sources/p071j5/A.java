package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.DeviceOrientationRequest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class A implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        boolean zK = false;
        long jO = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 2) {
                jO = a.o(parcel, i9);
            } else if (c5 != 6) {
                a.r(parcel, i9);
            } else {
                zK = a.k(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new DeviceOrientationRequest(jO, zK);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new DeviceOrientationRequest[i9];
    }
}
