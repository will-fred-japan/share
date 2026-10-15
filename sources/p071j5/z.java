package p071j5;

import T4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.DeviceOrientation;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        float fL = 0.0f;
        float fL2 = 0.0f;
        float fL3 = 0.0f;
        float fL4 = 0.0f;
        byte b9 = 0;
        long jO = 0;
        while (true) {
            float[] fArr = null;
            while (true) {
                if (parcel.dataPosition() >= iS) {
                    a.j(parcel, iS);
                    return new DeviceOrientation(fArr, fL, fL2, jO, b9, fL3, fL4);
                }
                int i9 = parcel.readInt();
                char c5 = (char) i9;
                if (c5 != 1) {
                    switch (c5) {
                        case 4:
                            fL = a.l(parcel, i9);
                            break;
                        case 5:
                            fL2 = a.l(parcel, i9);
                            break;
                        case 6:
                            jO = a.o(parcel, i9);
                            break;
                        case 7:
                            a.t(parcel, i9, 4);
                            b9 = (byte) parcel.readInt();
                            break;
                        case '\b':
                            fL3 = a.l(parcel, i9);
                            break;
                        case '\t':
                            fL4 = a.l(parcel, i9);
                            break;
                        default:
                            a.r(parcel, i9);
                            break;
                    }
                } else {
                    int iQ = a.q(parcel, i9);
                    int iDataPosition = parcel.dataPosition();
                    if (iQ == 0) {
                        break;
                    }
                    float[] fArrCreateFloatArray = parcel.createFloatArray();
                    parcel.setDataPosition(iDataPosition + iQ);
                    fArr = fArrCreateFloatArray;
                }
            }
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new DeviceOrientation[i9];
    }
}
