package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.j;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class NavigationBarPresenter implements j {

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ParcelableSparseArray f13603b;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                SavedState savedState = new SavedState();
                savedState.f13602a = parcel.readInt();
                savedState.f13603b = (ParcelableSparseArray) parcel.readParcelable(SavedState.class.getClassLoader());
                return savedState;
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i9) {
                return new SavedState[i9];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            parcel.writeInt(this.f13602a);
            parcel.writeParcelable(this.f13603b, 0);
        }
    }
}
