package com.google.android.gms.common.internal;

import S4.M;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new M();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RootTelemetryConfiguration f12497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f12500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f12502f;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z8, boolean z9, int[] iArr, int i9, int[] iArr2) {
        this.f12497a = rootTelemetryConfiguration;
        this.f12498b = z8;
        this.f12499c = z9;
        this.f12500d = iArr;
        this.f12501e = i9;
        this.f12502f = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.P(parcel, 1, this.f12497a, i9);
        p199z2.b.W(parcel, 2, 4);
        parcel.writeInt(this.f12498b ? 1 : 0);
        p199z2.b.W(parcel, 3, 4);
        parcel.writeInt(this.f12499c ? 1 : 0);
        p199z2.b.O(parcel, 4, this.f12500d);
        p199z2.b.W(parcel, 5, 4);
        parcel.writeInt(this.f12501e);
        p199z2.b.O(parcel, 6, this.f12502f);
        p199z2.b.V(parcel, iU);
    }
}
