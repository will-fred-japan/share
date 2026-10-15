package com.google.android.gms.signin.internal;

import P4.h;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import p086l5.f;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zag extends AbstractSafeParcelable implements h {
    public static final Parcelable.Creator<zag> CREATOR = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f12786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12787b;

    public zag(String str, ArrayList arrayList) {
        this.f12786a = arrayList;
        this.f12787b = str;
    }

    @Override // P4.h
    public final Status b() {
        return this.f12787b != null ? Status.f12465e : Status.f12467g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.R(parcel, 1, this.f12786a);
        b.Q(parcel, 2, this.f12787b);
        b.V(parcel, iU);
    }
}
