package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        String strF = null;
        int iN = 0;
        FastJsonResponse.Field field = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = T4.a.n(parcel, i9);
            } else if (c5 == 2) {
                strF = T4.a.f(parcel, i9);
            } else if (c5 != 3) {
                T4.a.r(parcel, i9);
            } else {
                field = (FastJsonResponse.Field) T4.a.e(parcel, i9, FastJsonResponse.Field.CREATOR);
            }
        }
        T4.a.j(parcel, iS);
        return new zam(iN, strF, field);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zam[i9];
    }
}
