package com.google.android.gms.common.internal;

import S4.D;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzak> CREATOR = new D();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12549a;

    public zzak(int i9) {
        this.f12549a = i9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12549a);
        p199z2.b.V(parcel, iU);
    }
}
