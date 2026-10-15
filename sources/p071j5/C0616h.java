package p071j5;

import T4.a;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationResult;
import java.util.List;

/* JADX INFO: renamed from: j5.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0616h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        List listI = LocationResult.f12735b;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            if (((char) i9) != 1) {
                a.r(parcel, i9);
            } else {
                listI = a.i(parcel, i9, Location.CREATOR);
            }
        }
        a.j(parcel, iS);
        return new LocationResult(listI);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new LocationResult[i9];
    }
}
