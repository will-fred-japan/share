package com.google.android.gms.common.server.converter;

import Y4.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12578c;

    public zac(int i9, String str, int i10) {
        this.f12576a = i9;
        this.f12577b = str;
        this.f12578c = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12576a);
        b.Q(parcel, 2, this.f12577b);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12578c);
        b.V(parcel, iU);
    }

    public zac(String str, int i9) {
        this.f12576a = 1;
        this.f12577b = str;
        this.f12578c = i9;
    }
}
