package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import p181x0.b;
import p181x0.c;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8402a;

    public static class a implements Parcelable.Creator<ParcelImpl> {
        @Override // android.os.Parcelable.Creator
        public final ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelImpl[] newArray(int i9) {
            return new ParcelImpl[i9];
        }
    }

    public ParcelImpl(Parcel parcel) {
        this.f8402a = new b(parcel).m();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        new b(parcel).v(this.f8402a);
    }
}
