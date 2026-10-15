package V4;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            if (((char) i9) != 1) {
                T4.a.r(parcel, i9);
            } else {
                pendingIntent = (PendingIntent) T4.a.e(parcel, i9, PendingIntent.CREATOR);
            }
        }
        T4.a.j(parcel, iS);
        return new ModuleInstallIntentResponse(pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new ModuleInstallIntentResponse[i9];
    }
}
