package com.google.android.gms.internal.location;

import H2.a;
import S4.C0375f;
import W5.f;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.Collections;
import java.util.List;
import p056h5.G;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f12664d = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DeviceOrientationRequest f12665e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DeviceOrientationRequest f12666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f12667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12668c;

    static {
        new StringBuilder(String.valueOf(20000L).length() + 102).append("Invalid interval: 20000 should be greater than or equal to 0. Note: Long.MAX_VALUE is not a valid interval.");
        f12665e = new DeviceOrientationRequest(20000L, false);
        CREATOR = new G();
    }

    public zzh(DeviceOrientationRequest deviceOrientationRequest, List list, String str) {
        this.f12666a = deviceOrientationRequest;
        this.f12667b = list;
        this.f12668c = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzhVar = (zzh) obj;
        return C0375f.a(this.f12666a, zzhVar.f12666a) && C0375f.a(this.f12667b, zzhVar.f12667b) && C0375f.a(this.f12668c, zzhVar.f12668c);
    }

    public final int hashCode() {
        return this.f12666a.hashCode();
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f12666a);
        String strValueOf2 = String.valueOf(this.f12667b);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        String str = this.f12668c;
        StringBuilder sb = new StringBuilder(length + 68 + length2 + 7 + String.valueOf(str).length() + 2);
        a.j(sb, "DeviceOrientationRequestInternal[deviceOrientationRequest=", strValueOf, ", clients=", strValueOf2);
        return f.k(sb, ", tag='", str, "']");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.P(parcel, 1, this.f12666a, i9);
        b.T(parcel, 2, this.f12667b);
        b.Q(parcel, 3, this.f12668c);
        b.V(parcel, iU);
    }
}
