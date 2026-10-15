package com.google.android.gms.common.moduleinstall;

import V4.d;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f12561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f12562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12563e;

    public ModuleInstallStatusUpdate(int i9, int i10, Long l8, Long l9, int i11) {
        this.f12559a = i9;
        this.f12560b = i10;
        this.f12561c = l8;
        this.f12562d = l9;
        this.f12563e = i11;
        if (l8 != null && l9 != null && l9.longValue() != 0 && l9.longValue() == 0) {
            throw new IllegalArgumentException("Given Long is zero");
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12559a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12560b);
        Long l8 = this.f12561c;
        if (l8 != null) {
            b.W(parcel, 3, 8);
            parcel.writeLong(l8.longValue());
        }
        Long l9 = this.f12562d;
        if (l9 != null) {
            b.W(parcel, 4, 8);
            parcel.writeLong(l9.longValue());
        }
        b.W(parcel, 5, 4);
        parcel.writeInt(this.f12563e);
        b.V(parcel, iU);
    }
}
