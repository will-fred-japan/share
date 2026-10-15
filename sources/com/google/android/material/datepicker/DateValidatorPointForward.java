package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13262a;

    public class a implements Parcelable.Creator<DateValidatorPointForward> {
        @Override // android.os.Parcelable.Creator
        public final DateValidatorPointForward createFromParcel(Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final DateValidatorPointForward[] newArray(int i9) {
            return new DateValidatorPointForward[i9];
        }
    }

    public DateValidatorPointForward(long j) {
        this.f13262a = j;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f13262a == ((DateValidatorPointForward) obj).f13262a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f13262a)});
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public final boolean i(long j) {
        return j >= this.f13262a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeLong(this.f13262a);
    }
}
