package com.google.android.gms.signin.internal;

import P4.h;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p086l5.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable implements h {
    public static final Parcelable.Creator<zaa> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Intent f12785c;

    public zaa() {
        this(2, 0, null);
    }

    @Override // P4.h
    public final Status b() {
        return this.f12784b == 0 ? Status.f12465e : Status.f12467g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12783a);
        p199z2.b.W(parcel, 2, 4);
        parcel.writeInt(this.f12784b);
        p199z2.b.P(parcel, 3, this.f12785c, i9);
        p199z2.b.V(parcel, iU);
    }

    public zaa(int i9, int i10, Intent intent) {
        this.f12783a = i9;
        this.f12784b = i10;
        this.f12785c = intent;
    }
}
