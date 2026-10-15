package com.huawei.hms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class DataHolderCreator implements Parcelable.Creator<DataHolder> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final DataHolder createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        String[] strArrCreateStringArray = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundleCreateBundle = null;
        while (i9 <= iValidateObjectHeader && parcel.dataPosition() < iValidateObjectHeader) {
            i9++;
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1000) {
                i10 = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 1) {
                strArrCreateStringArray = SafeParcelReader.createStringArray(parcel, header);
            } else if (fieldId == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.createTypedArray(parcel, header, CursorWindow.CREATOR);
            } else if (fieldId == 3) {
                i11 = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                bundleCreateBundle = SafeParcelReader.createBundle(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new DataHolder(i10, strArrCreateStringArray, cursorWindowArr, i11, bundleCreateBundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final DataHolder[] newArray(int i9) {
        return new DataHolder[i9];
    }
}
