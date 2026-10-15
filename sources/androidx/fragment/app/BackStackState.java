package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f7440b;

    public class a implements Parcelable.Creator<BackStackState> {
        @Override // android.os.Parcelable.Creator
        public final BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final BackStackState[] newArray(int i9) {
            return new BackStackState[i9];
        }
    }

    public BackStackState(Parcel parcel) {
        this.f7439a = parcel.createStringArrayList();
        this.f7440b = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeStringList(this.f7439a);
        parcel.writeTypedList(this.f7440b);
    }
}
