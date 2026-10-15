package p056h5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.internal.location.zzh;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class G implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        DeviceOrientationRequest deviceOrientationRequest = zzh.f12665e;
        List listI = zzh.f12664d;
        String strF = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                deviceOrientationRequest = (DeviceOrientationRequest) a.e(parcel, i9, DeviceOrientationRequest.CREATOR);
            } else if (c5 == 2) {
                listI = a.i(parcel, i9, ClientIdentity.CREATOR);
            } else if (c5 != 3) {
                a.r(parcel, i9);
            } else {
                strF = a.f(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new zzh(deviceOrientationRequest, listI, strF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzh[i9];
    }
}
