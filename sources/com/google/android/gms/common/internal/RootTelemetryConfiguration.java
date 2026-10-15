package com.google.android.gms.common.internal;

import S4.C;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new C();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12531e;

    public RootTelemetryConfiguration(int i9, boolean z8, boolean z9, int i10, int i11) {
        this.f12527a = i9;
        this.f12528b = z8;
        this.f12529c = z9;
        this.f12530d = i10;
        this.f12531e = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12527a);
        p199z2.b.W(parcel, 2, 4);
        parcel.writeInt(this.f12528b ? 1 : 0);
        p199z2.b.W(parcel, 3, 4);
        parcel.writeInt(this.f12529c ? 1 : 0);
        p199z2.b.W(parcel, 4, 4);
        parcel.writeInt(this.f12530d);
        p199z2.b.W(parcel, 5, 4);
        parcel.writeInt(this.f12531e);
        p199z2.b.V(parcel, iU);
    }
}
