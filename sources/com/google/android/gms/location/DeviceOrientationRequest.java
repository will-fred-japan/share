package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p071j5.A;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class DeviceOrientationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceOrientationRequest> CREATOR = new A();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12709b;

    public DeviceOrientationRequest(long j, boolean z8) {
        this.f12708a = j;
        this.f12709b = z8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceOrientationRequest)) {
            return false;
        }
        DeviceOrientationRequest deviceOrientationRequest = (DeviceOrientationRequest) obj;
        return this.f12708a == deviceOrientationRequest.f12708a && this.f12709b == deviceOrientationRequest.f12709b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f12708a), Boolean.valueOf(this.f12709b)});
    }

    public final String toString() {
        long j = this.f12708a;
        int length = String.valueOf(j).length();
        String str = true != this.f12709b ? "" : ", withVelocity";
        StringBuilder sb = new StringBuilder(str.length() + length + 46 + 1);
        sb.append("DeviceOrientationRequest[samplingPeriodMicros=");
        sb.append(j);
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 2, 8);
        parcel.writeLong(this.f12708a);
        b.W(parcel, 6, 4);
        parcel.writeInt(this.f12709b ? 1 : 0);
        b.V(parcel, iU);
    }
}
