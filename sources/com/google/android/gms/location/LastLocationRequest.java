package com.google.android.gms.location;

import S4.C0375f;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zze;
import java.util.Arrays;
import p056h5.x;
import p071j5.C0612d;
import p171w.a;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class LastLocationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LastLocationRequest> CREATOR = new C0612d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zze f12716d;

    public LastLocationRequest(long j, int i9, boolean z8, zze zzeVar) {
        this.f12713a = j;
        this.f12714b = i9;
        this.f12715c = z8;
        this.f12716d = zzeVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LastLocationRequest)) {
            return false;
        }
        LastLocationRequest lastLocationRequest = (LastLocationRequest) obj;
        return this.f12713a == lastLocationRequest.f12713a && this.f12714b == lastLocationRequest.f12714b && this.f12715c == lastLocationRequest.f12715c && C0375f.a(this.f12716d, lastLocationRequest.f12716d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f12713a), Integer.valueOf(this.f12714b), Boolean.valueOf(this.f12715c)});
    }

    public final String toString() {
        StringBuilder sbB = a.b("LastLocationRequest[");
        long j = this.f12713a;
        if (j != Long.MAX_VALUE) {
            sbB.append("maxAge=");
            x.a(j, sbB);
        }
        int i9 = this.f12714b;
        if (i9 != 0) {
            sbB.append(", ");
            sbB.append(p027d5.a.E(i9));
        }
        if (this.f12715c) {
            sbB.append(", bypass");
        }
        zze zzeVar = this.f12716d;
        if (zzeVar != null) {
            sbB.append(", impersonation=");
            sbB.append(zzeVar);
        }
        sbB.append(']');
        return sbB.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 8);
        parcel.writeLong(this.f12713a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12714b);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12715c ? 1 : 0);
        b.P(parcel, 5, this.f12716d, i9);
        b.V(parcel, iU);
    }
}
