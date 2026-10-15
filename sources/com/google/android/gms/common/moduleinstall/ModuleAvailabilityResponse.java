package com.google.android.gms.common.moduleinstall;

import V4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class ModuleAvailabilityResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleAvailabilityResponse> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12555b;

    public ModuleAvailabilityResponse(boolean z8, int i9) {
        this.f12554a = z8;
        this.f12555b = i9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12554a ? 1 : 0);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12555b);
        b.V(parcel, iU);
    }
}
