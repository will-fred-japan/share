package O4;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        boolean zK = false;
        boolean zK2 = false;
        boolean zK3 = false;
        boolean zK4 = false;
        String strF = null;
        IBinder iBinderM = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    strF = T4.a.f(parcel, i9);
                    break;
                case 2:
                    zK = T4.a.k(parcel, i9);
                    break;
                case 3:
                    zK2 = T4.a.k(parcel, i9);
                    break;
                case 4:
                    iBinderM = T4.a.m(parcel, i9);
                    break;
                case 5:
                    zK3 = T4.a.k(parcel, i9);
                    break;
                case 6:
                    zK4 = T4.a.k(parcel, i9);
                    break;
                default:
                    T4.a.r(parcel, i9);
                    break;
            }
        }
        T4.a.j(parcel, iS);
        return new zzo(strF, zK, zK2, iBinderM, zK3, zK4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzo[i9];
    }
}
