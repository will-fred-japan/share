package com.google.android.gms.location;

import S4.C0375f;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import b5.c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zze;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;
import p011b4.h;
import p056h5.x;
import p071j5.C0615g;
import p171w.a;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new C0615g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f12726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f12728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f12729h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f12730i;
    public final int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f12731k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f12732l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final WorkSource f12733m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final zze f12734n;

    @Deprecated
    public LocationRequest() {
        this(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, 3600000L, 0, 0, false, new WorkSource(), null);
    }

    public static String e(long j) {
        String string;
        if (j == Long.MAX_VALUE) {
            return "∞";
        }
        StringBuilder sb = x.f19082b;
        synchronized (sb) {
            sb.setLength(0);
            x.a(j, sb);
            string = sb.toString();
        }
        return string;
    }

    @Pure
    public final boolean d() {
        long j = this.f12725d;
        return j > 0 && (j >> 1) >= this.f12723b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        int i9 = this.f12722a;
        if (i9 != locationRequest.f12722a) {
            return false;
        }
        if ((i9 == 105 || this.f12723b == locationRequest.f12723b) && this.f12724c == locationRequest.f12724c && d() == locationRequest.d()) {
            return (!d() || this.f12725d == locationRequest.f12725d) && this.f12726e == locationRequest.f12726e && this.f12727f == locationRequest.f12727f && this.f12728g == locationRequest.f12728g && this.f12729h == locationRequest.f12729h && this.j == locationRequest.j && this.f12731k == locationRequest.f12731k && this.f12732l == locationRequest.f12732l && this.f12733m.equals(locationRequest.f12733m) && C0375f.a(this.f12734n, locationRequest.f12734n);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12722a), Long.valueOf(this.f12723b), Long.valueOf(this.f12724c), this.f12733m});
    }

    public final String toString() {
        String str;
        StringBuilder sbB = a.b("Request[");
        int i9 = this.f12722a;
        boolean z8 = i9 == 105;
        long j = this.f12725d;
        if (z8) {
            sbB.append(h.J(i9));
            if (j > 0) {
                sbB.append("/");
                x.a(j, sbB);
            }
        } else {
            sbB.append("@");
            if (d()) {
                x.a(this.f12723b, sbB);
                sbB.append("/");
                x.a(j, sbB);
            } else {
                x.a(this.f12723b, sbB);
            }
            sbB.append(" ");
            sbB.append(h.J(this.f12722a));
        }
        if (this.f12722a == 105 || this.f12724c != this.f12723b) {
            sbB.append(", minUpdateInterval=");
            sbB.append(e(this.f12724c));
        }
        if (this.f12728g > 0.0d) {
            sbB.append(", minUpdateDistance=");
            sbB.append(this.f12728g);
        }
        if (!(this.f12722a == 105) ? this.f12730i != this.f12723b : this.f12730i != Long.MAX_VALUE) {
            sbB.append(", maxUpdateAge=");
            sbB.append(e(this.f12730i));
        }
        long j8 = this.f12726e;
        if (j8 != Long.MAX_VALUE) {
            sbB.append(", duration=");
            x.a(j8, sbB);
        }
        int i10 = this.f12727f;
        if (i10 != Integer.MAX_VALUE) {
            sbB.append(", maxUpdates=");
            sbB.append(i10);
        }
        int i11 = this.f12731k;
        if (i11 != 0) {
            sbB.append(", ");
            if (i11 == 0) {
                str = "THROTTLE_BACKGROUND";
            } else if (i11 == 1) {
                str = "THROTTLE_ALWAYS";
            } else {
                if (i11 != 2) {
                    throw new IllegalArgumentException();
                }
                str = "THROTTLE_NEVER";
            }
            sbB.append(str);
        }
        int i12 = this.j;
        if (i12 != 0) {
            sbB.append(", ");
            sbB.append(p027d5.a.E(i12));
        }
        if (this.f12729h) {
            sbB.append(", waitForAccurateLocation");
        }
        if (this.f12732l) {
            sbB.append(", bypass");
        }
        WorkSource workSource = this.f12733m;
        if (!c.a(workSource)) {
            sbB.append(", ");
            sbB.append(workSource);
        }
        zze zzeVar = this.f12734n;
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
        int i10 = this.f12722a;
        b.W(parcel, 1, 4);
        parcel.writeInt(i10);
        long j = this.f12723b;
        b.W(parcel, 2, 8);
        parcel.writeLong(j);
        long j8 = this.f12724c;
        b.W(parcel, 3, 8);
        parcel.writeLong(j8);
        b.W(parcel, 6, 4);
        parcel.writeInt(this.f12727f);
        float f6 = this.f12728g;
        b.W(parcel, 7, 4);
        parcel.writeFloat(f6);
        b.W(parcel, 8, 8);
        parcel.writeLong(this.f12725d);
        b.W(parcel, 9, 4);
        parcel.writeInt(this.f12729h ? 1 : 0);
        b.W(parcel, 10, 8);
        parcel.writeLong(this.f12726e);
        long j9 = this.f12730i;
        b.W(parcel, 11, 8);
        parcel.writeLong(j9);
        b.W(parcel, 12, 4);
        parcel.writeInt(this.j);
        b.W(parcel, 13, 4);
        parcel.writeInt(this.f12731k);
        b.W(parcel, 15, 4);
        parcel.writeInt(this.f12732l ? 1 : 0);
        b.P(parcel, 16, this.f12733m, i9);
        b.P(parcel, 17, this.f12734n, i9);
        b.V(parcel, iU);
    }

    public LocationRequest(int i9, long j, long j8, long j9, long j10, long j11, int i10, float f6, boolean z8, long j12, int i11, int i12, boolean z9, WorkSource workSource, zze zzeVar) {
        this.f12722a = i9;
        if (i9 == 105) {
            this.f12723b = Long.MAX_VALUE;
        } else {
            this.f12723b = j;
        }
        this.f12724c = j8;
        this.f12725d = j9;
        this.f12726e = j10 == Long.MAX_VALUE ? j11 : Math.min(Math.max(1L, j10 - SystemClock.elapsedRealtime()), j11);
        this.f12727f = i10;
        this.f12728g = f6;
        this.f12729h = z8;
        this.f12730i = j12 != -1 ? j12 : j;
        this.j = i11;
        this.f12731k = i12;
        this.f12732l = z9;
        this.f12733m = workSource;
        this.f12734n = zzeVar;
    }
}
