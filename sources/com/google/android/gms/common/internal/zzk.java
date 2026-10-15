package com.google.android.gms.common.internal;

import S4.L;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new L();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f12550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Feature[] f12551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConnectionTelemetryConfiguration f12553d;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.M(parcel, 1, this.f12550a);
        p199z2.b.S(parcel, 2, this.f12551b, i9);
        p199z2.b.W(parcel, 3, 4);
        parcel.writeInt(this.f12552c);
        p199z2.b.P(parcel, 4, this.f12553d, i9);
        p199z2.b.V(parcel, iU);
    }
}
