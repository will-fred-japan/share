package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13978d;

    public class a implements Parcelable.Creator<TimeModel> {
        @Override // android.os.Parcelable.Creator
        public final TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final TimeModel[] newArray(int i9) {
            return new TimeModel[i9];
        }
    }

    public TimeModel() {
        this(0, 0, 10, 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f13976b == timeModel.f13976b && this.f13977c == timeModel.f13977c && this.f13975a == timeModel.f13975a && this.f13978d == timeModel.f13978d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f13975a), Integer.valueOf(this.f13976b), Integer.valueOf(this.f13977c), Integer.valueOf(this.f13978d)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f13976b);
        parcel.writeInt(this.f13977c);
        parcel.writeInt(this.f13978d);
        parcel.writeInt(this.f13975a);
    }

    public TimeModel(int i9, int i10, int i11, int i12) {
        this.f13976b = i9;
        this.f13977c = i10;
        this.f13978d = i11;
        this.f13975a = i12;
    }
}
