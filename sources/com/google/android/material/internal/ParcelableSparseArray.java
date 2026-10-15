package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = new a();

    public class a implements Parcelable.ClassLoaderCreator<ParcelableSparseArray> {
        @Override // android.os.Parcelable.ClassLoaderCreator
        public final ParcelableSparseArray createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ParcelableSparseArray(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i9) {
            return new ParcelableSparseArray[i9];
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return new ParcelableSparseArray(parcel, null);
        }
    }

    public ParcelableSparseArray() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = keyAt(i10);
            parcelableArr[i10] = valueAt(i10);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i9);
    }

    public ParcelableSparseArray(Parcel parcel, ClassLoader classLoader) {
        int i9 = parcel.readInt();
        int[] iArr = new int[i9];
        parcel.readIntArray(iArr);
        Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        for (int i10 = 0; i10 < i9; i10++) {
            put(iArr[i10], parcelableArray[i10]);
        }
    }
}
