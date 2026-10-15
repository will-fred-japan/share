package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p071j5.C0613e;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zzal[] f12721e;

    static {
        new LocationAvailability(0, 1, 1, 0L, null);
        new LocationAvailability(1000, 1, 1, 0L, null);
        CREATOR = new C0613e();
    }

    public LocationAvailability(int i9, int i10, int i11, long j, zzal[] zzalVarArr) {
        this.f12720d = i9 < 1000 ? 0 : 1000;
        this.f12717a = i10;
        this.f12718b = i11;
        this.f12719c = j;
        this.f12721e = zzalVarArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f12717a == locationAvailability.f12717a && this.f12718b == locationAvailability.f12718b && this.f12719c == locationAvailability.f12719c && this.f12720d == locationAvailability.f12720d && Arrays.equals(this.f12721e, locationAvailability.f12721e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12720d)});
    }

    public final String toString() {
        boolean z8 = this.f12720d < 1000;
        StringBuilder sb = new StringBuilder(String.valueOf(z8).length() + 22);
        sb.append("LocationAvailability[");
        sb.append(z8);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12717a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12718b);
        b.W(parcel, 3, 8);
        parcel.writeLong(this.f12719c);
        b.W(parcel, 4, 4);
        int i10 = this.f12720d;
        parcel.writeInt(i10);
        b.S(parcel, 5, this.f12721e, i9);
        int i11 = i10 >= 1000 ? 0 : 1;
        b.W(parcel, 6, 4);
        parcel.writeInt(i11);
        b.V(parcel, iU);
    }
}
