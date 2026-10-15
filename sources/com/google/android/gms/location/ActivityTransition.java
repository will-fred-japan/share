package com.google.android.gms.location;

import S4.C0376g;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p071j5.t;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class ActivityTransition extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12680b;

    public ActivityTransition(int i9, int i10) {
        this.f12679a = i9;
        this.f12680b = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        return this.f12679a == activityTransition.f12679a && this.f12680b == activityTransition.f12680b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12679a), Integer.valueOf(this.f12680b)});
    }

    public final String toString() {
        int i9 = this.f12679a;
        int length = String.valueOf(i9).length();
        int i10 = this.f12680b;
        StringBuilder sb = new StringBuilder(length + 52 + String.valueOf(i10).length() + 1);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i9);
        sb.append(", mTransitionType=");
        sb.append(i10);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        C0376g.e(parcel);
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12679a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12680b);
        b.V(parcel, iU);
    }
}
