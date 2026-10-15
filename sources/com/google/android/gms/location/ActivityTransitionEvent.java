package com.google.android.gms.location;

import S4.C0376g;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p071j5.u;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class ActivityTransitionEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12683c;

    public ActivityTransitionEvent(int i9, int i10, long j) {
        boolean z8 = false;
        if (i10 >= 0 && i10 <= 1) {
            z8 = true;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 30);
        sb.append("Transition type ");
        sb.append(i10);
        sb.append(" is not valid.");
        C0376g.a(sb.toString(), z8);
        this.f12681a = i9;
        this.f12682b = i10;
        this.f12683c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        return this.f12681a == activityTransitionEvent.f12681a && this.f12682b == activityTransitionEvent.f12682b && this.f12683c == activityTransitionEvent.f12683c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12681a), Integer.valueOf(this.f12682b), Long.valueOf(this.f12683c)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i9 = this.f12681a;
        StringBuilder sb2 = new StringBuilder(String.valueOf(i9).length() + 13);
        sb2.append("ActivityType ");
        sb2.append(i9);
        sb.append(sb2.toString());
        sb.append(" ");
        int i10 = this.f12682b;
        StringBuilder sb3 = new StringBuilder(String.valueOf(i10).length() + 15);
        sb3.append("TransitionType ");
        sb3.append(i10);
        sb.append(sb3.toString());
        sb.append(" ");
        long j = this.f12683c;
        StringBuilder sb4 = new StringBuilder(String.valueOf(j).length() + 21);
        sb4.append("ElapsedRealTimeNanos ");
        sb4.append(j);
        sb.append(sb4.toString());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        C0376g.e(parcel);
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12681a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12682b);
        b.W(parcel, 3, 8);
        parcel.writeLong(this.f12683c);
        b.V(parcel, iU);
    }
}
