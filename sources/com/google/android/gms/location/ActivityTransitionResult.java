package com.google.android.gms.location;

import S4.C0376g;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p071j5.w;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class ActivityTransitionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new w();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f12689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f12690b;

    public ActivityTransitionResult() {
        throw null;
    }

    public ActivityTransitionResult(ArrayList arrayList, Bundle bundle) {
        this.f12690b = null;
        C0376g.f(arrayList, "transitionEvents list can't be null.");
        if (!arrayList.isEmpty()) {
            for (int i9 = 1; i9 < arrayList.size(); i9++) {
                int i10 = i9 - 1;
                C0376g.b(((ActivityTransitionEvent) arrayList.get(i9)).f12683c >= ((ActivityTransitionEvent) arrayList.get(i10)).f12683c, "Transition out of order: ts1=%d, ts2=%d", Long.valueOf(((ActivityTransitionEvent) arrayList.get(i9)).f12683c), Long.valueOf(((ActivityTransitionEvent) arrayList.get(i10)).f12683c));
            }
        }
        this.f12689a = Collections.unmodifiableList(arrayList);
        this.f12690b = bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f12689a.equals(((ActivityTransitionResult) obj).f12689a);
    }

    public final int hashCode() {
        return this.f12689a.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        C0376g.e(parcel);
        int iU = b.U(parcel, 20293);
        b.T(parcel, 1, this.f12689a);
        b.M(parcel, 2, this.f12690b);
        b.V(parcel, iU);
    }
}
