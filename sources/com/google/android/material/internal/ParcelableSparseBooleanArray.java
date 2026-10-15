package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new a();

    public class a implements Parcelable.Creator<ParcelableSparseBooleanArray> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableSparseBooleanArray createFromParcel(Parcel parcel) {
            int i9 = parcel.readInt();
            ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(i9);
            int[] iArr = new int[i9];
            boolean[] zArr = new boolean[i9];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            for (int i10 = 0; i10 < i9; i10++) {
                parcelableSparseBooleanArray.put(iArr[i10], zArr[i10]);
            }
            return parcelableSparseBooleanArray;
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableSparseBooleanArray[] newArray(int i9) {
            return new ParcelableSparseBooleanArray[i9];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        for (int i10 = 0; i10 < size(); i10++) {
            iArr[i10] = keyAt(i10);
            zArr[i10] = valueAt(i10);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeBooleanArray(zArr);
    }
}
