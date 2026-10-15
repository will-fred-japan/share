package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Locale;
import p056h5.v;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzek extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzek> CREATOR = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f12654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f12655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f12656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f12657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f12658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f12659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12660i;

    public zzek(String str, int i9, short s8, double d9, double d10, float f6, long j, int i10, int i11) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: ".concat(String.valueOf(str)));
        }
        if (f6 <= 0.0f) {
            StringBuilder sb = new StringBuilder(String.valueOf(f6).length() + 16);
            sb.append("invalid radius: ");
            sb.append(f6);
            throw new IllegalArgumentException(sb.toString());
        }
        if (d9 > 90.0d || d9 < -90.0d) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(d9).length() + 18);
            sb2.append("invalid latitude: ");
            sb2.append(d9);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (d10 > 180.0d || d10 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(d10).length() + 19);
            sb3.append("invalid longitude: ");
            sb3.append(d10);
            throw new IllegalArgumentException(sb3.toString());
        }
        int i12 = i9 & 7;
        if (i12 == 0) {
            StringBuilder sb4 = new StringBuilder(String.valueOf(i9).length() + 35);
            sb4.append("No supported transition specified: ");
            sb4.append(i9);
            throw new IllegalArgumentException(sb4.toString());
        }
        this.f12654c = s8;
        this.f12652a = str;
        this.f12655d = d9;
        this.f12656e = d10;
        this.f12657f = f6;
        this.f12653b = j;
        this.f12658g = i12;
        this.f12659h = i10;
        this.f12660i = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzek) {
            zzek zzekVar = (zzek) obj;
            if (this.f12657f == zzekVar.f12657f && this.f12655d == zzekVar.f12655d && this.f12656e == zzekVar.f12656e && this.f12654c == zzekVar.f12654c && this.f12658g == zzekVar.f12658g) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f12655d);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f12656e);
        return ((((Float.floatToIntBits(this.f12657f) + ((((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31)) * 31) + this.f12654c) * 31) + this.f12658g;
    }

    public final String toString() {
        String str;
        Locale locale = Locale.US;
        short s8 = this.f12654c;
        if (s8 != -1) {
            str = s8 != 1 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "CIRCLE";
        } else {
            str = "INVALID";
        }
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", str, this.f12652a.replaceAll("\\p{C}", "?"), Integer.valueOf(this.f12658g), Double.valueOf(this.f12655d), Double.valueOf(this.f12656e), Float.valueOf(this.f12657f), Integer.valueOf(this.f12659h / 1000), Integer.valueOf(this.f12660i), Long.valueOf(this.f12653b));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.Q(parcel, 1, this.f12652a);
        b.W(parcel, 2, 8);
        parcel.writeLong(this.f12653b);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12654c);
        b.W(parcel, 4, 8);
        parcel.writeDouble(this.f12655d);
        b.W(parcel, 5, 8);
        parcel.writeDouble(this.f12656e);
        b.W(parcel, 6, 4);
        parcel.writeFloat(this.f12657f);
        b.W(parcel, 7, 4);
        parcel.writeInt(this.f12658g);
        b.W(parcel, 8, 4);
        parcel.writeInt(this.f12659h);
        b.W(parcel, 9, 4);
        parcel.writeInt(this.f12660i);
        b.V(parcel, iU);
    }
}
