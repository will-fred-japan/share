package p056h5;

import T4.a;
import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzee;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        IBinder iBinderM = null;
        IBinder iBinderM2 = null;
        PendingIntent pendingIntent = null;
        String strF = null;
        int iN = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = a.n(parcel, i9);
            } else if (c5 == 2) {
                iBinderM = a.m(parcel, i9);
            } else if (c5 == 3) {
                iBinderM2 = a.m(parcel, i9);
            } else if (c5 == 4) {
                pendingIntent = (PendingIntent) a.e(parcel, i9, PendingIntent.CREATOR);
            } else if (c5 != 6) {
                a.r(parcel, i9);
            } else {
                strF = a.f(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new zzee(iN, iBinderM, iBinderM2, pendingIntent, strF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzee[i9];
    }
}
