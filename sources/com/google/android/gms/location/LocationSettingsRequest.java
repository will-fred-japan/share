package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import p071j5.C0617i;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new C0617i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f12737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12739c;

    public LocationSettingsRequest(ArrayList arrayList, boolean z8, boolean z9) {
        this.f12737a = arrayList;
        this.f12738b = z8;
        this.f12739c = z9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.T(parcel, 1, Collections.unmodifiableList(this.f12737a));
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12738b ? 1 : 0);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12739c ? 1 : 0);
        b.V(parcel, iU);
    }
}
