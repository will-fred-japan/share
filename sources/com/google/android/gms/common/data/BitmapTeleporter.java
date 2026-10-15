package com.google.android.gms.common.data;

import R4.a;
import S4.C0376g;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ParcelFileDescriptor f12478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12479c;

    public BitmapTeleporter(int i9, ParcelFileDescriptor parcelFileDescriptor, int i10) {
        this.f12477a = i9;
        this.f12478b = parcelFileDescriptor;
        this.f12479c = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        if (this.f12478b == null) {
            C0376g.e(null);
            throw null;
        }
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12477a);
        b.P(parcel, 2, this.f12478b, i9 | 1);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12479c);
        b.V(parcel, iU);
        this.f12478b = null;
    }
}
