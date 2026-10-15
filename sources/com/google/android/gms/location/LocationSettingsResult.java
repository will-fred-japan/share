package com.google.android.gms.location;

import P4.h;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p071j5.C0618j;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsResult extends AbstractSafeParcelable implements h {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new C0618j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f12740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocationSettingsStates f12741b;

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.f12740a = status;
        this.f12741b = locationSettingsStates;
    }

    @Override // P4.h
    public final Status b() {
        return this.f12740a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.P(parcel, 1, this.f12740a, i9);
        b.P(parcel, 2, this.f12741b, i9);
        b.V(parcel, iU);
    }
}
