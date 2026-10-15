package com.google.android.gms.common.moduleinstall;

import V4.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class ModuleInstallResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12558b;

    public ModuleInstallResponse(int i9, boolean z8) {
        this.f12557a = i9;
        this.f12558b = z8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12557a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12558b ? 1 : 0);
        b.V(parcel, iU);
    }
}
