package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f13259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f13260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f13257c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f13258d = new b();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new c();

    public class a implements d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public final int a() {
            return 1;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public final boolean b(ArrayList arrayList, long j) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
                if (dateValidator != null && dateValidator.i(j)) {
                    return true;
                }
            }
            return false;
        }
    }

    public class b implements d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public final int a() {
            return 2;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public final boolean b(ArrayList arrayList, long j) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
                if (dateValidator != null && !dateValidator.i(j)) {
                    return false;
                }
            }
            return true;
        }
    }

    public class c implements Parcelable.Creator<CompositeDateValidator> {
        @Override // android.os.Parcelable.Creator
        public final CompositeDateValidator createFromParcel(Parcel parcel) {
            ArrayList arrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int i9 = parcel.readInt();
            d dVar = CompositeDateValidator.f13258d;
            if (i9 != 2 && i9 == 1) {
                dVar = CompositeDateValidator.f13257c;
            }
            arrayList.getClass();
            return new CompositeDateValidator(arrayList, dVar);
        }

        @Override // android.os.Parcelable.Creator
        public final CompositeDateValidator[] newArray(int i9) {
            return new CompositeDateValidator[i9];
        }
    }

    public interface d {
        int a();

        boolean b(ArrayList arrayList, long j);
    }

    public CompositeDateValidator() {
        throw null;
    }

    public CompositeDateValidator(ArrayList arrayList, d dVar) {
        this.f13260b = arrayList;
        this.f13259a = dVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.f13260b.equals(compositeDateValidator.f13260b) && this.f13259a.a() == compositeDateValidator.f13259a.a();
    }

    public final int hashCode() {
        return this.f13260b.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public final boolean i(long j) {
        return this.f13259a.b(this.f13260b, j);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeList(this.f13260b);
        parcel.writeInt(this.f13259a.a());
    }
}
