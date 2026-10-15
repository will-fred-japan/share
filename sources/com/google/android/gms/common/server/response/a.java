package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.converter.zaa;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        String strF = null;
        String strF2 = null;
        zaa zaaVar = null;
        int iN = 0;
        int iN2 = 0;
        boolean zK = false;
        int iN3 = 0;
        boolean zK2 = false;
        int iN4 = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    iN = T4.a.n(parcel, i9);
                    break;
                case 2:
                    iN2 = T4.a.n(parcel, i9);
                    break;
                case 3:
                    zK = T4.a.k(parcel, i9);
                    break;
                case 4:
                    iN3 = T4.a.n(parcel, i9);
                    break;
                case 5:
                    zK2 = T4.a.k(parcel, i9);
                    break;
                case 6:
                    strF = T4.a.f(parcel, i9);
                    break;
                case 7:
                    iN4 = T4.a.n(parcel, i9);
                    break;
                case '\b':
                    strF2 = T4.a.f(parcel, i9);
                    break;
                case '\t':
                    zaaVar = (zaa) T4.a.e(parcel, i9, zaa.CREATOR);
                    break;
                default:
                    T4.a.r(parcel, i9);
                    break;
            }
        }
        T4.a.j(parcel, iS);
        return new FastJsonResponse.Field(iN, iN2, zK, iN3, zK2, strF, iN4, strF2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new FastJsonResponse.Field[i9];
    }
}
