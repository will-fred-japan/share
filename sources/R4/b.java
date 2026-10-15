package R4;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundleB = null;
        int iN = 0;
        int iN2 = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                int iQ = T4.a.q(parcel, i9);
                int iDataPosition = parcel.dataPosition();
                if (iQ == 0) {
                    strArr = null;
                } else {
                    String[] strArrCreateStringArray = parcel.createStringArray();
                    parcel.setDataPosition(iDataPosition + iQ);
                    strArr = strArrCreateStringArray;
                }
            } else if (c5 == 2) {
                cursorWindowArr = (CursorWindow[]) T4.a.h(parcel, i9, CursorWindow.CREATOR);
            } else if (c5 == 3) {
                iN2 = T4.a.n(parcel, i9);
            } else if (c5 == 4) {
                bundleB = T4.a.b(parcel, i9);
            } else if (c5 != 1000) {
                T4.a.r(parcel, i9);
            } else {
                iN = T4.a.n(parcel, i9);
            }
        }
        T4.a.j(parcel, iS);
        DataHolder dataHolder = new DataHolder(iN, strArr, cursorWindowArr, iN2, bundleB);
        dataHolder.f12482c = new Bundle();
        int i10 = 0;
        while (true) {
            String[] strArr2 = dataHolder.f12481b;
            if (i10 >= strArr2.length) {
                break;
            }
            dataHolder.f12482c.putInt(strArr2[i10], i10);
            i10++;
        }
        CursorWindow[] cursorWindowArr2 = dataHolder.f12483d;
        dataHolder.f12486g = new int[cursorWindowArr2.length];
        int numRows = 0;
        for (int i11 = 0; i11 < cursorWindowArr2.length; i11++) {
            dataHolder.f12486g[i11] = numRows;
            numRows += cursorWindowArr2[i11].getNumRows() - (numRows - cursorWindowArr2[i11].getStartPosition());
        }
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new DataHolder[i9];
    }
}
