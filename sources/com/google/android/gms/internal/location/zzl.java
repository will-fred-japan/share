package com.google.android.gms.internal.location;

import P4.h;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p056h5.I;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzl extends AbstractSafeParcelable implements h {
    public static final Parcelable.Creator<zzl> CREATOR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f12673a;

    static {
        new zzl(Status.f12465e);
        CREATOR = new I();
    }

    public zzl(Status status) {
        this.f12673a = status;
    }

    @Override // P4.h
    public final Status b() {
        return this.f12673a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.P(parcel, 1, this.f12673a, i9);
        b.V(parcel, iU);
    }
}
