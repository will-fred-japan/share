package com.google.android.gms.common.internal;

import S4.v;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public final Scope[] f12548d;

    public zax(int i9, int i10, int i11, Scope[] scopeArr) {
        this.f12545a = i9;
        this.f12546b = i10;
        this.f12547c = i11;
        this.f12548d = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12545a);
        p199z2.b.W(parcel, 2, 4);
        parcel.writeInt(this.f12546b);
        p199z2.b.W(parcel, 3, 4);
        parcel.writeInt(this.f12547c);
        p199z2.b.S(parcel, 4, this.f12548d, i9);
        p199z2.b.V(parcel, iU);
    }
}
