package com.google.android.gms.common;

import O4.n;
import O4.o;
import O4.u;
import S4.T;
import S4.y;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p035e5.a;
import p035e5.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f12630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12632d;

    public zzs(String str, IBinder iBinder, boolean z8, boolean z9) {
        this.f12629a = str;
        o oVar = null;
        if (iBinder != null) {
            try {
                int i9 = n.f3485c;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
                a aVarK = (iInterfaceQueryLocalInterface instanceof y ? (y) iInterfaceQueryLocalInterface : new T(iBinder, "com.google.android.gms.common.internal.ICertData", 0)).k();
                byte[] bArr = aVarK == null ? null : (byte[]) b.Q(aVarK);
                if (bArr != null) {
                    oVar = new o(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e9) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e9);
            }
        }
        this.f12630b = oVar;
        this.f12631c = z8;
        this.f12632d = z9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.Q(parcel, 1, this.f12629a);
        o oVar = this.f12630b;
        if (oVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            oVar = null;
        }
        p199z2.b.N(parcel, 2, oVar);
        p199z2.b.W(parcel, 3, 4);
        parcel.writeInt(this.f12631c ? 1 : 0);
        p199z2.b.W(parcel, 4, 4);
        parcel.writeInt(this.f12632d ? 1 : 0);
        p199z2.b.V(parcel, iU);
    }
}
