package p056h5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzek;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        int iN = -1;
        int iN2 = 0;
        short s8 = 0;
        int iN3 = 0;
        long jO = 0;
        float fL = 0.0f;
        double d9 = 0.0d;
        double d10 = 0.0d;
        String strF = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    strF = a.f(parcel, i9);
                    break;
                case 2:
                    jO = a.o(parcel, i9);
                    break;
                case 3:
                    a.t(parcel, i9, 4);
                    s8 = (short) parcel.readInt();
                    break;
                case 4:
                    a.t(parcel, i9, 8);
                    d9 = parcel.readDouble();
                    break;
                case 5:
                    a.t(parcel, i9, 8);
                    d10 = parcel.readDouble();
                    break;
                case 6:
                    fL = a.l(parcel, i9);
                    break;
                case 7:
                    iN2 = a.n(parcel, i9);
                    break;
                case '\b':
                    iN3 = a.n(parcel, i9);
                    break;
                case '\t':
                    iN = a.n(parcel, i9);
                    break;
                default:
                    a.r(parcel, i9);
                    break;
            }
        }
        a.j(parcel, iS);
        return new zzek(strF, iN2, s8, d9, d10, fL, jO, iN3, iN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zzek[i9];
    }
}
