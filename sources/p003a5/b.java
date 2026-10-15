package p003a5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        int iN = 0;
        int iN2 = 0;
        int iN3 = 0;
        int iN4 = 0;
        boolean zK = false;
        String strF = null;
        ArrayList<String> arrayListG = null;
        String strF2 = null;
        String strF3 = null;
        String strF4 = null;
        String strF5 = null;
        long jO = 0;
        long jO2 = 0;
        long jO3 = 0;
        float fL = 0.0f;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    iN = a.n(parcel, i9);
                    break;
                case 2:
                    jO = a.o(parcel, i9);
                    break;
                case 3:
                case 7:
                case '\t':
                default:
                    a.r(parcel, i9);
                    break;
                case 4:
                    strF = a.f(parcel, i9);
                    break;
                case 5:
                    iN3 = a.n(parcel, i9);
                    break;
                case 6:
                    arrayListG = a.g(parcel, i9);
                    break;
                case '\b':
                    jO2 = a.o(parcel, i9);
                    break;
                case '\n':
                    strF3 = a.f(parcel, i9);
                    break;
                case 11:
                    iN2 = a.n(parcel, i9);
                    break;
                case '\f':
                    strF2 = a.f(parcel, i9);
                    break;
                case '\r':
                    strF4 = a.f(parcel, i9);
                    break;
                case 14:
                    iN4 = a.n(parcel, i9);
                    break;
                case 15:
                    fL = a.l(parcel, i9);
                    break;
                case 16:
                    jO3 = a.o(parcel, i9);
                    break;
                case 17:
                    strF5 = a.f(parcel, i9);
                    break;
                case 18:
                    zK = a.k(parcel, i9);
                    break;
            }
        }
        a.j(parcel, iS);
        return new WakeLockEvent(iN, jO, iN2, strF, iN3, arrayListG, strF2, jO2, iN4, strF3, strF4, fL, jO3, strF5, zK);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new WakeLockEvent[i9];
    }
}
