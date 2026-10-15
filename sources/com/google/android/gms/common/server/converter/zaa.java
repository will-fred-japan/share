package com.google.android.gms.common.server.converter;

import Y4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringToIntConverter f12575b;

    public zaa(int i9, StringToIntConverter stringToIntConverter) {
        this.f12574a = i9;
        this.f12575b = stringToIntConverter;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12574a);
        b.P(parcel, 2, this.f12575b, i9);
        b.V(parcel, iU);
    }

    public zaa(StringToIntConverter stringToIntConverter) {
        this.f12574a = 1;
        this.f12575b = stringToIntConverter;
    }
}
