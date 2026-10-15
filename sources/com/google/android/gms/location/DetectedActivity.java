package com.google.android.gms.location;

import S4.C0376g;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Arrays;
import p071j5.y;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class DetectedActivity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12700b;

    public DetectedActivity(int i9, int i10) {
        this.f12699a = i9;
        this.f12700b = i10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof DetectedActivity) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.f12699a == detectedActivity.f12699a && this.f12700b == detectedActivity.f12700b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12699a), Integer.valueOf(this.f12700b)});
    }

    public final String toString() {
        String string;
        int i9 = this.f12699a;
        if (i9 > 22 || i9 < 0) {
            i9 = 4;
        }
        if (i9 == 0) {
            string = "IN_VEHICLE";
        } else if (i9 == 1) {
            string = "ON_BICYCLE";
        } else if (i9 == 2) {
            string = "ON_FOOT";
        } else if (i9 == 3) {
            string = "STILL";
        } else if (i9 == 4) {
            string = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        } else if (i9 == 5) {
            string = "TILTING";
        } else if (i9 == 7) {
            string = "WALKING";
        } else if (i9 == 8) {
            string = "RUNNING";
        } else if (i9 != 16) {
            string = i9 != 17 ? Integer.toString(i9) : "IN_RAIL_VEHICLE";
        } else {
            string = "IN_ROAD_VEHICLE";
        }
        int length = String.valueOf(string).length();
        int i10 = this.f12700b;
        StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + length + 36 + 1);
        sb.append("DetectedActivity [type=");
        sb.append(string);
        sb.append(", confidence=");
        sb.append(i10);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        C0376g.e(parcel);
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12699a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12700b);
        b.V(parcel, iU);
    }
}
