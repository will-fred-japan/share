package com.google.android.gms.location;

import S4.C0376g;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p071j5.r;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WorkSource f12776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f12778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f12780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f12781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f12782i;

    public zzb(long j, boolean z8, WorkSource workSource, String str, int[] iArr, boolean z9, String str2, long j8, String str3) {
        this.f12774a = j;
        this.f12775b = z8;
        this.f12776c = workSource;
        this.f12777d = str;
        this.f12778e = iArr;
        this.f12779f = z9;
        this.f12780g = str2;
        this.f12781h = j8;
        this.f12782i = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        C0376g.e(parcel);
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 8);
        parcel.writeLong(this.f12774a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12775b ? 1 : 0);
        b.P(parcel, 3, this.f12776c, i9);
        b.Q(parcel, 4, this.f12777d);
        b.O(parcel, 5, this.f12778e);
        b.W(parcel, 6, 4);
        parcel.writeInt(this.f12779f ? 1 : 0);
        b.Q(parcel, 7, this.f12780g);
        b.W(parcel, 8, 8);
        parcel.writeLong(this.f12781h);
        b.Q(parcel, 9, this.f12782i);
        b.V(parcel, iU);
    }
}
