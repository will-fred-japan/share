package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f13269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f13274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f13275g;

    public class a implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        public final Month createFromParcel(Parcel parcel) {
            return Month.a(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final Month[] newArray(int i9) {
            return new Month[i9];
        }
    }

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarC = G.c(calendar);
        this.f13269a = calendarC;
        this.f13270b = calendarC.get(2);
        this.f13271c = calendarC.get(1);
        this.f13272d = calendarC.getMaximum(7);
        this.f13273e = calendarC.getActualMaximum(5);
        this.f13274f = calendarC.getTimeInMillis();
    }

    public static Month a(int i9, int i10) {
        Calendar calendarG = G.g(null);
        calendarG.set(1, i9);
        calendarG.set(2, i10);
        return new Month(calendarG);
    }

    public static Month b(long j) {
        Calendar calendarG = G.g(null);
        calendarG.setTimeInMillis(j);
        return new Month(calendarG);
    }

    public final String c() {
        if (this.f13275g == null) {
            this.f13275g = G.b("yMMMM", Locale.getDefault()).format(new Date(this.f13269a.getTimeInMillis()));
        }
        return this.f13275g;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Month month) {
        return this.f13269a.compareTo(month.f13269a);
    }

    public final int d(Month month) {
        if (!(this.f13269a instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (month.f13270b - this.f13270b) + ((month.f13271c - this.f13271c) * 12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f13270b == month.f13270b && this.f13271c == month.f13271c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f13270b), Integer.valueOf(this.f13271c)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f13271c);
        parcel.writeInt(this.f13270b);
    }
}
