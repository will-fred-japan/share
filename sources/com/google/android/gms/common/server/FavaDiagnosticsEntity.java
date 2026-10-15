package com.google.android.gms.common.server;

import X4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12570c;

    public FavaDiagnosticsEntity(int i9, String str, int i10) {
        this.f12568a = i9;
        this.f12569b = str;
        this.f12570c = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12568a);
        b.Q(parcel, 2, this.f12569b);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12570c);
        b.V(parcel, iU);
    }
}
