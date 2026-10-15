package O4;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        PendingIntent pendingIntent = null;
        int iN = 0;
        int iN2 = 0;
        String strF = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = T4.a.n(parcel, i9);
            } else if (c5 == 2) {
                iN2 = T4.a.n(parcel, i9);
            } else if (c5 == 3) {
                pendingIntent = (PendingIntent) T4.a.e(parcel, i9, PendingIntent.CREATOR);
            } else if (c5 != 4) {
                T4.a.r(parcel, i9);
            } else {
                strF = T4.a.f(parcel, i9);
            }
        }
        T4.a.j(parcel, iS);
        return new ConnectionResult(iN, iN2, pendingIntent, strF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new ConnectionResult[i9];
    }
}
