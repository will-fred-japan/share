package p056h5;

import T4.a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzem;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        String strF = "";
        ArrayList<String> arrayListG = null;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                arrayListG = a.g(parcel, i9);
            } else if (c5 == 2) {
                pendingIntent = (PendingIntent) a.e(parcel, i9, PendingIntent.CREATOR);
            } else if (c5 != 3) {
                a.r(parcel, i9);
            } else {
                strF = a.f(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new zzem(arrayListG, pendingIntent, strF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzem[i9];
    }
}
