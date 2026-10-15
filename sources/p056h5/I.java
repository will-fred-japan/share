package p056h5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.location.zzl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class I implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        Status status = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            if (((char) i9) != 1) {
                a.r(parcel, i9);
            } else {
                status = (Status) a.e(parcel, i9, Status.CREATOR);
            }
        }
        a.j(parcel, iS);
        return new zzl(status);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzl[i9];
    }
}
