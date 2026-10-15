package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import p155u.g;

/* JADX INFO: loaded from: classes.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g<String, Bundle> f13713c;

    public class a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        @Override // android.os.Parcelable.ClassLoaderCreator
        public final ExtendableSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i9) {
            return new ExtendableSavedState[i9];
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return new ExtendableSavedState(parcel, null);
        }
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.f13713c = new g<>();
    }

    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f13713c + "}";
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        g<String, Bundle> gVar = this.f13713c;
        int i10 = gVar.f21660c;
        parcel.writeInt(i10);
        String[] strArr = new String[i10];
        Bundle[] bundleArr = new Bundle[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            strArr[i11] = gVar.f(i11);
            bundleArr[i11] = gVar.i(i11);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i9 = parcel.readInt();
        String[] strArr = new String[i9];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i9];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f13713c = new g<>(i9);
        for (int i10 = 0; i10 < i9; i10++) {
            this.f13713c.put(strArr[i10], bundleArr[i10]);
        }
    }
}
