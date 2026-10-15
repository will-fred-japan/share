package com.google.android.gms.location;

import S4.C0375f;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import b5.c;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zze;
import java.util.Arrays;
import p011b4.h;
import p071j5.x;
import p171w.a;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class CurrentLocationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CurrentLocationRequest> CREATOR = new x();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WorkSource f12697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final zze f12698h;

    public CurrentLocationRequest(long j, int i9, int i10, long j8, boolean z8, int i11, WorkSource workSource, zze zzeVar) {
        this.f12691a = j;
        this.f12692b = i9;
        this.f12693c = i10;
        this.f12694d = j8;
        this.f12695e = z8;
        this.f12696f = i11;
        this.f12697g = workSource;
        this.f12698h = zzeVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CurrentLocationRequest)) {
            return false;
        }
        CurrentLocationRequest currentLocationRequest = (CurrentLocationRequest) obj;
        return this.f12691a == currentLocationRequest.f12691a && this.f12692b == currentLocationRequest.f12692b && this.f12693c == currentLocationRequest.f12693c && this.f12694d == currentLocationRequest.f12694d && this.f12695e == currentLocationRequest.f12695e && this.f12696f == currentLocationRequest.f12696f && C0375f.a(this.f12697g, currentLocationRequest.f12697g) && C0375f.a(this.f12698h, currentLocationRequest.f12698h);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f12691a), Integer.valueOf(this.f12692b), Integer.valueOf(this.f12693c), Long.valueOf(this.f12694d)});
    }

    public final String toString() {
        String str;
        StringBuilder sbB = a.b("CurrentLocationRequest[");
        sbB.append(h.J(this.f12693c));
        long j = this.f12691a;
        if (j != Long.MAX_VALUE) {
            sbB.append(", maxAge=");
            p056h5.x.a(j, sbB);
        }
        long j8 = this.f12694d;
        if (j8 != Long.MAX_VALUE) {
            sbB.append(", duration=");
            sbB.append(j8);
            sbB.append("ms");
        }
        int i9 = this.f12692b;
        if (i9 != 0) {
            sbB.append(", ");
            sbB.append(p027d5.a.E(i9));
        }
        if (this.f12695e) {
            sbB.append(", bypass");
        }
        int i10 = this.f12696f;
        if (i10 != 0) {
            sbB.append(", ");
            if (i10 == 0) {
                str = "THROTTLE_BACKGROUND";
            } else if (i10 == 1) {
                str = "THROTTLE_ALWAYS";
            } else {
                if (i10 != 2) {
                    throw new IllegalArgumentException();
                }
                str = "THROTTLE_NEVER";
            }
            sbB.append(str);
        }
        WorkSource workSource = this.f12697g;
        if (!c.a(workSource)) {
            sbB.append(", workSource=");
            sbB.append(workSource);
        }
        zze zzeVar = this.f12698h;
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
        parcel.writeLong(this.f12691a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12692b);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12693c);
        b.W(parcel, 4, 8);
        parcel.writeLong(this.f12694d);
        b.W(parcel, 5, 4);
        parcel.writeInt(this.f12695e ? 1 : 0);
        b.P(parcel, 6, this.f12697g, i9);
        b.W(parcel, 7, 4);
        parcel.writeInt(this.f12696f);
        b.P(parcel, 9, this.f12698h, i9);
        b.V(parcel, iU);
    }
}
