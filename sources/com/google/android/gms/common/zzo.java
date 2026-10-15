package com.google.android.gms.common;

import O4.s;
import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p035e5.a;
import p035e5.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f12622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12624f;

    public zzo(String str, boolean z8, boolean z9, IBinder iBinder, boolean z10, boolean z11) {
        this.f12619a = str;
        this.f12620b = z8;
        this.f12621c = z9;
        this.f12622d = (Context) b.Q(a.AbstractBinderC0196a.P(iBinder));
        this.f12623e = z10;
        this.f12624f = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.Q(parcel, 1, this.f12619a);
        p199z2.b.W(parcel, 2, 4);
        parcel.writeInt(this.f12620b ? 1 : 0);
        p199z2.b.W(parcel, 3, 4);
        parcel.writeInt(this.f12621c ? 1 : 0);
        p199z2.b.N(parcel, 4, new b(this.f12622d));
        p199z2.b.W(parcel, 5, 4);
        parcel.writeInt(this.f12623e ? 1 : 0);
        p199z2.b.W(parcel, 6, 4);
        parcel.writeInt(this.f12624f ? 1 : 0);
        p199z2.b.V(parcel, iU);
    }
}
