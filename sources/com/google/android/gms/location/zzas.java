package com.google.android.gms.location;

import S4.C0376g;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p071j5.q;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzas> CREATOR = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12773d;

    public zzas(int i9, int i10, int i11, int i12) {
        C0376g.g("Start hour must be in range [0, 23].", i9 >= 0 && i9 <= 23);
        C0376g.g("Start minute must be in range [0, 59].", i10 >= 0 && i10 <= 59);
        C0376g.g("End hour must be in range [0, 23].", i11 >= 0 && i11 <= 23);
        C0376g.g("End minute must be in range [0, 59].", i12 >= 0 && i12 <= 59);
        C0376g.g("Parameters can't be all 0.", ((i9 + i10) + i11) + i12 > 0);
        this.f12770a = i9;
        this.f12771b = i10;
        this.f12772c = i11;
        this.f12773d = i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        zzas zzasVar = (zzas) obj;
        return this.f12770a == zzasVar.f12770a && this.f12771b == zzasVar.f12771b && this.f12772c == zzasVar.f12772c && this.f12773d == zzasVar.f12773d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12770a), Integer.valueOf(this.f12771b), Integer.valueOf(this.f12772c), Integer.valueOf(this.f12773d)});
    }

    public final String toString() {
        int i9 = this.f12770a;
        int length = String.valueOf(i9).length();
        int i10 = this.f12771b;
        int length2 = String.valueOf(i10).length();
        int i11 = this.f12772c;
        int length3 = String.valueOf(i11).length();
        int i12 = this.f12773d;
        StringBuilder sb = new StringBuilder(length + 50 + length2 + 10 + length3 + 12 + String.valueOf(i12).length() + 1);
        sb.append("UserPreferredSleepWindow [startHour=");
        sb.append(i9);
        sb.append(", startMinute=");
        sb.append(i10);
        sb.append(", endHour=");
        sb.append(i11);
        sb.append(", endMinute=");
        sb.append(i12);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        C0376g.e(parcel);
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12770a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12771b);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12772c);
        b.W(parcel, 4, 4);
        parcel.writeInt(this.f12773d);
        b.V(parcel, iU);
    }
}
