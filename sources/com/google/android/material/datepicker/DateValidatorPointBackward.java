package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13261a;

    public class a implements Parcelable.Creator<DateValidatorPointBackward> {
        @Override // android.os.Parcelable.Creator
        public final DateValidatorPointBackward createFromParcel(Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final DateValidatorPointBackward[] newArray(int i9) {
            return new DateValidatorPointBackward[i9];
        }
    }

    public DateValidatorPointBackward(long j) {
        this.f13261a = j;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointBackward) && this.f13261a == ((DateValidatorPointBackward) obj).f13261a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f13261a)});
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public final boolean i(long j) {
        return j <= this.f13261a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeLong(this.f13261a);
    }
}
