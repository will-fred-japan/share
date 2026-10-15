package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.SleepClassifyEvent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        int iN = 0;
        int iN2 = 0;
        int iN3 = 0;
        int iN4 = 0;
        int iN5 = 0;
        int iN6 = 0;
        int iN7 = 0;
        boolean zK = false;
        int iN8 = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    iN = a.n(parcel, i9);
                    break;
                case 2:
                    iN2 = a.n(parcel, i9);
                    break;
                case 3:
                    iN3 = a.n(parcel, i9);
                    break;
                case 4:
                    iN4 = a.n(parcel, i9);
                    break;
                case 5:
                    iN5 = a.n(parcel, i9);
                    break;
                case 6:
                    iN6 = a.n(parcel, i9);
                    break;
                case 7:
                    iN7 = a.n(parcel, i9);
                    break;
                case '\b':
                    zK = a.k(parcel, i9);
                    break;
                case '\t':
                    iN8 = a.n(parcel, i9);
                    break;
                default:
                    a.r(parcel, i9);
                    break;
            }
        }
        a.j(parcel, iS);
        return new SleepClassifyEvent(iN, iN2, iN3, iN4, iN5, iN6, iN7, zK, iN8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new SleepClassifyEvent[i9];
    }
}
