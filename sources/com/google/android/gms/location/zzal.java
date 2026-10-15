package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p071j5.m;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12769d;

    public zzal(int i9, int i10, long j, long j8) {
        this.f12766a = i9;
        this.f12767b = i10;
        this.f12768c = j;
        this.f12769d = j8;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzal) {
            zzal zzalVar = (zzal) obj;
            if (this.f12766a == zzalVar.f12766a && this.f12767b == zzalVar.f12767b && this.f12768c == zzalVar.f12768c && this.f12769d == zzalVar.f12769d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12767b), Integer.valueOf(this.f12766a), Long.valueOf(this.f12769d), Long.valueOf(this.f12768c)});
    }

    public final String toString() {
        int i9 = this.f12766a;
        int length = String.valueOf(i9).length();
        int i10 = this.f12767b;
        int length2 = String.valueOf(i10).length();
        long j = this.f12769d;
        int length3 = String.valueOf(j).length();
        long j8 = this.f12768c;
        StringBuilder sb = new StringBuilder(length + 50 + length2 + 18 + length3 + 17 + String.valueOf(j8).length());
        sb.append("NetworkLocationStatus: Wifi status: ");
        sb.append(i9);
        sb.append(" Cell status: ");
        sb.append(i10);
        sb.append(" elapsed time NS: ");
        sb.append(j);
        sb.append(" system time ms: ");
        sb.append(j8);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12766a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12767b);
        b.W(parcel, 3, 8);
        parcel.writeLong(this.f12768c);
        b.W(parcel, 4, 8);
        parcel.writeLong(this.f12769d);
        b.V(parcel, iU);
    }
}
