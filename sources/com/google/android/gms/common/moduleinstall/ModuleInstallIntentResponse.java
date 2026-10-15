package com.google.android.gms.common.moduleinstall;

import V4.b;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class ModuleInstallIntentResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallIntentResponse> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f12556a;

    public ModuleInstallIntentResponse(PendingIntent pendingIntent) {
        this.f12556a = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.P(parcel, 1, this.f12556a, i9);
        p199z2.b.V(parcel, iU);
    }
}
