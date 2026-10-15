package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p056h5.u;
import p071j5.G;
import p071j5.H;
import p071j5.I;
import p071j5.J;
import p071j5.K;
import p071j5.L;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzei extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzei> CREATOR = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzeg f12646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final L f12647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final I f12648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PendingIntent f12649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p056h5.L f12650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f12651g;

    public zzei(int i9, zzeg zzegVar, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        L j;
        I g4;
        this.f12645a = i9;
        this.f12646b = zzegVar;
        p056h5.L j8 = null;
        if (iBinder != null) {
            int i10 = K.f19863b;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            j = iInterfaceQueryLocalInterface instanceof L ? (L) iInterfaceQueryLocalInterface : new J(iBinder, "com.google.android.gms.location.ILocationListener", 1);
        } else {
            j = null;
        }
        this.f12647c = j;
        this.f12649e = pendingIntent;
        if (iBinder2 != null) {
            int i11 = H.f19862b;
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
            g4 = iInterfaceQueryLocalInterface2 instanceof I ? (I) iInterfaceQueryLocalInterface2 : new G(iBinder2, "com.google.android.gms.location.ILocationCallback", 1);
        } else {
            g4 = null;
        }
        this.f12648d = g4;
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            j8 = iInterfaceQueryLocalInterface3 instanceof p056h5.L ? (p056h5.L) iInterfaceQueryLocalInterface3 : new p056h5.J(iBinder3);
        }
        this.f12650f = j8;
        this.f12651g = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12645a);
        b.P(parcel, 2, this.f12646b, i9);
        L l8 = this.f12647c;
        b.N(parcel, 3, l8 == null ? null : l8.asBinder());
        b.P(parcel, 4, this.f12649e, i9);
        I i10 = this.f12648d;
        b.N(parcel, 5, i10 == null ? null : i10.asBinder());
        p056h5.L l9 = this.f12650f;
        b.N(parcel, 6, l9 != null ? l9.asBinder() : null);
        b.Q(parcel, 8, this.f12651g);
        b.V(parcel, iU);
    }
}
