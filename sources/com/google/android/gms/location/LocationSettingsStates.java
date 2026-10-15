package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p071j5.C0619k;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new C0619k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12747f;

    public LocationSettingsStates(boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f12742a = z8;
        this.f12743b = z9;
        this.f12744c = z10;
        this.f12745d = z11;
        this.f12746e = z12;
        this.f12747f = z13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12742a ? 1 : 0);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12743b ? 1 : 0);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12744c ? 1 : 0);
        b.W(parcel, 4, 4);
        parcel.writeInt(this.f12745d ? 1 : 0);
        b.W(parcel, 5, 4);
        parcel.writeInt(this.f12746e ? 1 : 0);
        b.W(parcel, 6, 4);
        parcel.writeInt(this.f12747f ? 1 : 0);
        b.V(parcel, iU);
    }
}
