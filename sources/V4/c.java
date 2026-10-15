package V4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        int iN = 0;
        boolean zK = false;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = T4.a.n(parcel, i9);
            } else if (c5 != 2) {
                T4.a.r(parcel, i9);
            } else {
                zK = T4.a.k(parcel, i9);
            }
        }
        T4.a.j(parcel, iS);
        return new ModuleInstallResponse(iN, zK);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new ModuleInstallResponse[i9];
    }
}
