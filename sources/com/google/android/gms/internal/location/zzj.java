package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p056h5.H;
import p056h5.J;
import p056h5.L;
import p071j5.D;
import p071j5.E;
import p071j5.F;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new H();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzh f12670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final F f12671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final L f12672d;

    public zzj(int i9, zzh zzhVar, IBinder iBinder, IBinder iBinder2) {
        F d9;
        this.f12669a = i9;
        this.f12670b = zzhVar;
        L j = null;
        if (iBinder == null) {
            d9 = null;
        } else {
            int i10 = E.f19861b;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
            d9 = iInterfaceQueryLocalInterface instanceof F ? (F) iInterfaceQueryLocalInterface : new D(iBinder, "com.google.android.gms.location.IDeviceOrientationListener", 1);
        }
        this.f12671c = d9;
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            j = iInterfaceQueryLocalInterface2 instanceof L ? (L) iInterfaceQueryLocalInterface2 : new J(iBinder2);
        }
        this.f12672d = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12669a);
        b.P(parcel, 2, this.f12670b, i9);
        F f6 = this.f12671c;
        b.N(parcel, 3, f6 == null ? null : f6.asBinder());
        L l8 = this.f12672d;
        b.N(parcel, 4, l8 != null ? l8.asBinder() : null);
        b.V(parcel, iU);
    }
}
