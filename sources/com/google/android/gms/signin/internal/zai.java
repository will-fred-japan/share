package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zat;
import p086l5.g;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zat f12789b;

    public zai(int i9, zat zatVar) {
        this.f12788a = i9;
        this.f12789b = zatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12788a);
        b.P(parcel, 2, this.f12789b, i9);
        b.V(parcel, iU);
    }
}
