package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new a();

    public class a implements Parcelable.Creator<ParcelableSparseIntArray> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableSparseIntArray createFromParcel(Parcel parcel) {
            int i9 = parcel.readInt();
            ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(i9);
            int[] iArr = new int[i9];
            int[] iArr2 = new int[i9];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i10 = 0; i10 < i9; i10++) {
                parcelableSparseIntArray.put(iArr[i10], iArr2[i10]);
            }
            return parcelableSparseIntArray;
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableSparseIntArray[] newArray(int i9) {
            return new ParcelableSparseIntArray[i9];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i10 = 0; i10 < size(); i10++) {
            iArr[i10] = keyAt(i10);
            iArr2[i10] = valueAt(i10);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }
}
