package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zav;
import p086l5.h;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectionResult f12791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zav f12792c;

    public zak(int i9, ConnectionResult connectionResult, zav zavVar) {
        this.f12790a = i9;
        this.f12791b = connectionResult;
        this.f12792c = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12790a);
        b.P(parcel, 2, this.f12791b, i9);
        b.P(parcel, 3, this.f12792c, i9);
        b.V(parcel, iU);
    }
}
