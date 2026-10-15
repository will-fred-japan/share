package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p056h5.s;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzee extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzee> CREATOR = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBinder f12640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBinder f12641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PendingIntent f12642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12643e;

    public zzee(int i9, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str) {
        this.f12639a = i9;
        this.f12640b = iBinder;
        this.f12641c = iBinder2;
        this.f12642d = pendingIntent;
        this.f12643e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12639a);
        b.N(parcel, 2, this.f12640b);
        b.N(parcel, 3, this.f12641c);
        b.P(parcel, 4, this.f12642d, i9);
        b.Q(parcel, 6, this.f12643e);
        b.V(parcel, iU);
    }
}
