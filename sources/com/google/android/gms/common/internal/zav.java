package com.google.android.gms.common.internal;

import S4.C0375f;
import S4.u;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBinder f12541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConnectionResult f12542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12544e;

    public zav(int i9, IBinder iBinder, ConnectionResult connectionResult, boolean z8, boolean z9) {
        this.f12540a = i9;
        this.f12541b = iBinder;
        this.f12542c = connectionResult;
        this.f12543d = z8;
        this.f12544e = z9;
    }

    public final boolean equals(Object obj) {
        Object cVar;
        if (obj != null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof zav) {
                zav zavVar = (zav) obj;
                if (this.f12542c.equals(zavVar.f12542c)) {
                    Object cVar2 = null;
                    IBinder iBinder = this.f12541b;
                    if (iBinder == null) {
                        cVar = null;
                    } else {
                        int i9 = b.a.f12535b;
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                        cVar = iInterfaceQueryLocalInterface instanceof b ? (b) iInterfaceQueryLocalInterface : new c(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 0);
                    }
                    IBinder iBinder2 = zavVar.f12541b;
                    if (iBinder2 != null) {
                        int i10 = b.a.f12535b;
                        IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                        cVar2 = iInterfaceQueryLocalInterface2 instanceof b ? (b) iInterfaceQueryLocalInterface2 : new c(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor", 0);
                    }
                    if (C0375f.a(cVar, cVar2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12540a);
        p199z2.b.N(parcel, 2, this.f12541b);
        p199z2.b.P(parcel, 3, this.f12542c, i9);
        p199z2.b.W(parcel, 4, 4);
        parcel.writeInt(this.f12543d ? 1 : 0);
        p199z2.b.W(parcel, 5, 4);
        parcel.writeInt(this.f12544e ? 1 : 0);
        p199z2.b.V(parcel, iU);
    }
}
