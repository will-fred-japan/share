package p086l5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.signin.internal.zag;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        ArrayList<String> arrayListG = null;
        String strF = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                arrayListG = a.g(parcel, i9);
            } else if (c5 != 2) {
                a.r(parcel, i9);
            } else {
                strF = a.f(parcel, i9);
            }
        }
        a.j(parcel, iS);
        return new zag(strF, arrayListG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zag[i9];
    }
}
