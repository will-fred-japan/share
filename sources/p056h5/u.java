package p056h5;

import T4.a;
import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzeg;
import com.google.android.gms.internal.location.zzei;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        zzeg zzegVar = null;
        IBinder iBinderM = null;
        IBinder iBinderM2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinderM3 = null;
        String strF = null;
        int iN = 1;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    iN = a.n(parcel, i9);
                    break;
                case 2:
                    zzegVar = (zzeg) a.e(parcel, i9, zzeg.CREATOR);
                    break;
                case 3:
                    iBinderM = a.m(parcel, i9);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) a.e(parcel, i9, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinderM2 = a.m(parcel, i9);
                    break;
                case 6:
                    iBinderM3 = a.m(parcel, i9);
                    break;
                case 7:
                default:
                    a.r(parcel, i9);
                    break;
                case '\b':
                    strF = a.f(parcel, i9);
                    break;
            }
        }
        a.j(parcel, iS);
        return new zzei(iN, zzegVar, iBinderM, iBinderM2, pendingIntent, iBinderM3, strF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzei[i9];
    }
}
