package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FastJsonResponse.Field f12601c;

    public zam(int i9, String str, FastJsonResponse.Field field) {
        this.f12599a = i9;
        this.f12600b = str;
        this.f12601c = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12599a);
        p199z2.b.Q(parcel, 2, this.f12600b);
        p199z2.b.P(parcel, 3, this.f12601c, i9);
        p199z2.b.V(parcel, iU);
    }

    public zam(String str, FastJsonResponse.Field field) {
        this.f12599a = 1;
        this.f12600b = str;
        this.f12601c = field;
    }
}
