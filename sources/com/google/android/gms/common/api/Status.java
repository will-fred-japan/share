package com.google.android.gms.common.api;

import P4.h;
import P4.l;
import S4.C0375f;
import W5.e;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Arrays;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements h, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Status f12465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Status f12466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Status f12467g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f12470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConnectionResult f12471d;

    static {
        new Status(-1, null, null, null);
        f12465e = new Status(0, null, null, null);
        new Status(14, null, null, null);
        new Status(8, null, null, null);
        f12466f = new Status(15, null, null, null);
        f12467g = new Status(16, null, null, null);
        new Status(17, null, null, null);
        new Status(18, null, null, null);
        CREATOR = new l();
    }

    public Status(int i9, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f12468a = i9;
        this.f12469b = str;
        this.f12470c = pendingIntent;
        this.f12471d = connectionResult;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f12468a == status.f12468a && C0375f.a(this.f12469b, status.f12469b) && C0375f.a(this.f12470c, status.f12470c) && C0375f.a(this.f12471d, status.f12471d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12468a), this.f12469b, this.f12470c, this.f12471d});
    }

    public final String toString() {
        C0375f.a aVar = new C0375f.a(this);
        String strI = this.f12469b;
        if (strI == null) {
            int i9 = this.f12468a;
            switch (i9) {
                case -1:
                    strI = "SUCCESS_CACHE";
                    break;
                case 0:
                    strI = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    strI = e.i(i9, "unknown status code: ");
                    break;
                case 2:
                    strI = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    strI = "SERVICE_DISABLED";
                    break;
                case 4:
                    strI = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    strI = "INVALID_ACCOUNT";
                    break;
                case 6:
                    strI = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    strI = "NETWORK_ERROR";
                    break;
                case 8:
                    strI = "INTERNAL_ERROR";
                    break;
                case 10:
                    strI = "DEVELOPER_ERROR";
                    break;
                case 13:
                    strI = "ERROR";
                    break;
                case 14:
                    strI = "INTERRUPTED";
                    break;
                case 15:
                    strI = "TIMEOUT";
                    break;
                case 16:
                    strI = "CANCELED";
                    break;
                case 17:
                    strI = "API_NOT_CONNECTED";
                    break;
                case 18:
                    strI = "DEAD_CLIENT";
                    break;
                case 19:
                    strI = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    strI = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    strI = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    strI = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        aVar.a(strI, HiAnalyticsConstant.HaKey.BI_KEY_RESULT);
        aVar.a(this.f12470c, CommonCode.MapKey.HAS_RESOLUTION);
        return aVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12468a);
        b.Q(parcel, 2, this.f12469b);
        b.P(parcel, 3, this.f12470c, i9);
        b.P(parcel, 4, this.f12471d, i9);
        b.V(parcel, iU);
    }

    @Override // P4.h
    public final Status b() {
        return this;
    }
}
