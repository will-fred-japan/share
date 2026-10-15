package com.google.android.gms.auth.api.signin.internal;

import N4.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f12448c;

    public GoogleSignInOptionsExtensionParcelable(int i9, int i10, Bundle bundle) {
        this.f12446a = i9;
        this.f12447b = i10;
        this.f12448c = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12446a);
        p199z2.b.W(parcel, 2, 4);
        parcel.writeInt(this.f12447b);
        p199z2.b.M(parcel, 3, this.f12448c);
        p199z2.b.V(parcel, iU);
    }
}
