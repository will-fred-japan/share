package com.google.android.gms.common.internal;

import S4.C0380k;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class TelemetryData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TelemetryData> CREATOR = new C0380k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f12533b;

    public TelemetryData(int i9, List list) {
        this.f12532a = i9;
        this.f12533b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12532a);
        p199z2.b.T(parcel, 2, this.f12533b);
        p199z2.b.V(parcel, iU);
    }
}
