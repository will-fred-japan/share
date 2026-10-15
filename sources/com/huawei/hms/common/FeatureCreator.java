package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureCreator implements Parcelable.Creator<Feature> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final Feature createFromParcel(Parcel parcel) {
        String strCreateString = null;
        if (parcel == null) {
            return null;
        }
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i9 = 0;
        long j = -1;
        int i10 = 0;
        while (i9 <= iValidateObjectHeader && parcel.dataPosition() < iValidateObjectHeader) {
            i9++;
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 2) {
                i10 = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                j = SafeParcelReader.readLong(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new Feature(strCreateString, i10, j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final Feature[] newArray(int i9) {
        return new Feature[i9];
    }
}
