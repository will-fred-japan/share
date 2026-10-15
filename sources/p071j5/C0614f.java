package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zze;
import com.google.android.gms.location.zzad;

/* JADX INFO: renamed from: j5.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0614f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        zze zzeVar = null;
        boolean zK = false;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                zK = a.k(parcel, i9);
            } else if (c5 != 2) {
                a.r(parcel, i9);
            } else {
                zzeVar = (zze) a.e(parcel, i9, zze.CREATOR);
            }
        }
        a.j(parcel, iS);
        return new zzad(zK, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzad[i9];
    }
}
