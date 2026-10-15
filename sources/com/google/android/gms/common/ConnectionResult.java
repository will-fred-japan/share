package com.google.android.gms.common;

import O4.i;
import S4.C0375f;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import defpackage.f;
import java.util.Arrays;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f12452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConnectionResult f12449e = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new i();

    public ConnectionResult(int i9, int i10, PendingIntent pendingIntent, String str) {
        this.f12450a = i9;
        this.f12451b = i10;
        this.f12452c = pendingIntent;
        this.f12453d = str;
    }

    public static String d(int i9) {
        if (i9 == 99) {
            return "UNFINISHED";
        }
        if (i9 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i9) {
            case -1:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i9) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return f.b(i9, "UNKNOWN_ERROR_CODE(", ")");
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f12451b == connectionResult.f12451b && C0375f.a(this.f12452c, connectionResult.f12452c) && C0375f.a(this.f12453d, connectionResult.f12453d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12451b), this.f12452c, this.f12453d});
    }

    public final String toString() {
        C0375f.a aVar = new C0375f.a(this);
        aVar.a(d(this.f12451b), HiAnalyticsConstant.HaKey.BI_KEY_RESULT);
        aVar.a(this.f12452c, CommonCode.MapKey.HAS_RESOLUTION);
        aVar.a(this.f12453d, "message");
        return aVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12450a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12451b);
        b.P(parcel, 3, this.f12452c, i9);
        b.Q(parcel, 4, this.f12453d);
        b.V(parcel, iU);
    }

    public ConnectionResult(int i9) {
        this(1, i9, null, null);
    }

    public ConnectionResult(int i9, PendingIntent pendingIntent) {
        this(1, i9, pendingIntent, null);
    }
}
