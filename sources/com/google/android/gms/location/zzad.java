package com.google.android.gms.location;

import S4.C0375f;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zze;
import java.util.Arrays;
import p071j5.C0614f;
import p171w.a;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new C0614f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zze f12765b;

    public zzad(boolean z8, zze zzeVar) {
        this.f12764a = z8;
        this.f12765b = zzeVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzad)) {
            return false;
        }
        zzad zzadVar = (zzad) obj;
        return this.f12764a == zzadVar.f12764a && C0375f.a(this.f12765b, zzadVar.f12765b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f12764a)});
    }

    public final String toString() {
        StringBuilder sbB = a.b("LocationAvailabilityRequest[");
        if (this.f12764a) {
            sbB.append("bypass, ");
        }
        zze zzeVar = this.f12765b;
        if (zzeVar != null) {
            sbB.append("impersonation=");
            sbB.append(zzeVar);
            sbB.append(", ");
        }
        sbB.setLength(sbB.length() - 2);
        sbB.append(']');
        return sbB.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12764a ? 1 : 0);
        b.P(parcel, 2, this.f12765b, i9);
        b.V(parcel, iU);
    }
}
