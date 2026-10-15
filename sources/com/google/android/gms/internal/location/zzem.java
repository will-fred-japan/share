package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import p056h5.B;
import p056h5.D;
import p056h5.E;
import p056h5.w;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzem> CREATOR = new w();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D f12661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f12662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12663c;

    public zzem(ArrayList arrayList, PendingIntent pendingIntent, String str) {
        D dO;
        if (arrayList == null) {
            B b9 = D.f19051b;
            dO = E.f19052e;
        } else {
            dO = D.o(arrayList);
        }
        this.f12661a = dO;
        this.f12662b = pendingIntent;
        this.f12663c = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.R(parcel, 1, this.f12661a);
        b.P(parcel, 2, this.f12662b, i9);
        b.Q(parcel, 3, this.f12663c);
        b.V(parcel, iU);
    }
}
