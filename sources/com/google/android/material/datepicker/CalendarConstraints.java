package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Month f13247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Month f13248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DateValidator f13249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Month f13250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f13252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13253g;

    public interface DateValidator extends Parcelable {
        boolean i(long j);
    }

    public class a implements Parcelable.Creator<CalendarConstraints> {
        @Override // android.os.Parcelable.Creator
        public final CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final CalendarConstraints[] newArray(int i9) {
            return new CalendarConstraints[i9];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f13254c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f13255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DateValidator f13256b;

        static {
            G.a(Month.a(1900, 0).f13274f);
            G.a(Month.a(2100, 11).f13274f);
        }
    }

    public CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i9) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.f13247a = month;
        this.f13248b = month2;
        this.f13250d = month3;
        this.f13251e = i9;
        this.f13249c = dateValidator;
        if (month3 != null && month.f13269a.compareTo(month3.f13269a) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.f13269a.compareTo(month2.f13269a) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i9 < 0 || i9 > G.g(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f13253g = month.d(month2) + 1;
        this.f13252f = (month2.f13271c - month.f13271c) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f13247a.equals(calendarConstraints.f13247a) && this.f13248b.equals(calendarConstraints.f13248b) && Objects.equals(this.f13250d, calendarConstraints.f13250d) && this.f13251e == calendarConstraints.f13251e && this.f13249c.equals(calendarConstraints.f13249c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f13247a, this.f13248b, this.f13250d, Integer.valueOf(this.f13251e), this.f13249c});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeParcelable(this.f13247a, 0);
        parcel.writeParcelable(this.f13248b, 0);
        parcel.writeParcelable(this.f13250d, 0);
        parcel.writeParcelable(this.f13249c, 0);
        parcel.writeInt(this.f13251e);
    }
}
