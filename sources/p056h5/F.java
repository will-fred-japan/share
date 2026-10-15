package p056h5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.location.zze;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class F implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        String strF = null;
        String strF2 = null;
        String strF3 = null;
        ArrayList arrayListI = null;
        zze zzeVar = null;
        int iN = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = a.n(parcel, i9);
            } else if (c5 == 3) {
                strF = a.f(parcel, i9);
            } else if (c5 == 4) {
                strF2 = a.f(parcel, i9);
            } else if (c5 == 6) {
                strF3 = a.f(parcel, i9);
            } else if (c5 == 7) {
                zzeVar = (zze) a.e(parcel, i9, zze.CREATOR);
            } else if (c5 != '\b') {
                a.r(parcel, i9);
            } else {
                arrayListI = a.i(parcel, i9, Feature.CREATOR);
            }
        }
        a.j(parcel, iS);
        return new zze(iN, strF, strF2, strF3, arrayListI, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zze[i9];
    }
}
