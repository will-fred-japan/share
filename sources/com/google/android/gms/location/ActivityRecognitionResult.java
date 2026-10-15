package com.google.android.gms.location;

import S4.C0375f;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import p071j5.s;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f12674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f12678e;

    public static boolean d(Bundle bundle, Bundle bundle2) {
        int length;
        if (bundle == null) {
            return bundle2 == null;
        }
        if (bundle2 == null || bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (obj instanceof Bundle) {
                if (!d(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else {
                if (obj.getClass().isArray()) {
                    if (obj2 != null && obj2.getClass().isArray() && (length = Array.getLength(obj)) == Array.getLength(obj2)) {
                        for (int i9 = 0; i9 < length; i9++) {
                            if (C0375f.a(Array.get(obj, i9), Array.get(obj2, i9))) {
                            }
                        }
                    }
                    return false;
                }
                if (!obj.equals(obj2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
        return this.f12675b == activityRecognitionResult.f12675b && this.f12676c == activityRecognitionResult.f12676c && this.f12677d == activityRecognitionResult.f12677d && C0375f.a(this.f12674a, activityRecognitionResult.f12674a) && d(this.f12678e, activityRecognitionResult.f12678e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f12675b), Long.valueOf(this.f12676c), Integer.valueOf(this.f12677d), this.f12674a, this.f12678e});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f12674a);
        int length = strValueOf.length();
        long j = this.f12675b;
        int length2 = String.valueOf(j).length();
        long j8 = this.f12676c;
        StringBuilder sb = new StringBuilder(length + 59 + length2 + 24 + String.valueOf(j8).length() + 1);
        sb.append("ActivityRecognitionResult [probableActivities=");
        sb.append(strValueOf);
        sb.append(", timeMillis=");
        sb.append(j);
        sb.append(", elapsedRealtimeMillis=");
        sb.append(j8);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.T(parcel, 1, this.f12674a);
        b.W(parcel, 2, 8);
        parcel.writeLong(this.f12675b);
        b.W(parcel, 3, 8);
        parcel.writeLong(this.f12676c);
        b.W(parcel, 4, 4);
        parcel.writeInt(this.f12677d);
        b.M(parcel, 5, this.f12678e);
        b.V(parcel, iU);
    }
}
