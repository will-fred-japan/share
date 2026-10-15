package com.google.android.gms.common.internal;

import S4.C0387s;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new C0387s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f12522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f12524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f12525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12526i;

    public MethodInvocation(int i9, int i10, int i11, long j, long j8, String str, String str2, int i12, int i13) {
        this.f12518a = i9;
        this.f12519b = i10;
        this.f12520c = i11;
        this.f12521d = j;
        this.f12522e = j8;
        this.f12523f = str;
        this.f12524g = str2;
        this.f12525h = i12;
        this.f12526i = i13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12518a);
        p199z2.b.W(parcel, 2, 4);
        parcel.writeInt(this.f12519b);
        p199z2.b.W(parcel, 3, 4);
        parcel.writeInt(this.f12520c);
        p199z2.b.W(parcel, 4, 8);
        parcel.writeLong(this.f12521d);
        p199z2.b.W(parcel, 5, 8);
        parcel.writeLong(this.f12522e);
        p199z2.b.Q(parcel, 6, this.f12523f);
        p199z2.b.Q(parcel, 7, this.f12524g);
        p199z2.b.W(parcel, 8, 4);
        parcel.writeInt(this.f12525h);
        p199z2.b.W(parcel, 9, 4);
        parcel.writeInt(this.f12526i);
        p199z2.b.V(parcel, iU);
    }
}
