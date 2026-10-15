package S4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.MethodInvocation;

/* JADX INFO: renamed from: S4.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0387s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        int iN = -1;
        int iN2 = 0;
        int iN3 = 0;
        int iN4 = 0;
        int iN5 = 0;
        String strF = null;
        String strF2 = null;
        long jO = 0;
        long jO2 = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    iN2 = T4.a.n(parcel, i9);
                    break;
                case 2:
                    iN3 = T4.a.n(parcel, i9);
                    break;
                case 3:
                    iN4 = T4.a.n(parcel, i9);
                    break;
                case 4:
                    jO = T4.a.o(parcel, i9);
                    break;
                case 5:
                    jO2 = T4.a.o(parcel, i9);
                    break;
                case 6:
                    strF = T4.a.f(parcel, i9);
                    break;
                case 7:
                    strF2 = T4.a.f(parcel, i9);
                    break;
                case '\b':
                    iN5 = T4.a.n(parcel, i9);
                    break;
                case '\t':
                    iN = T4.a.n(parcel, i9);
                    break;
                default:
                    T4.a.r(parcel, i9);
                    break;
            }
        }
        T4.a.j(parcel, iS);
        return new MethodInvocation(iN2, iN3, iN4, jO, jO2, strF, strF2, iN5, iN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new MethodInvocation[i9];
    }
}
