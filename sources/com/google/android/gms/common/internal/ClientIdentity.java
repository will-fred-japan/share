package com.google.android.gms.common.internal;

import S4.C0375f;
import S4.C0379j;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new C0379j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12496b;

    public ClientIdentity(int i9, String str) {
        this.f12495a = i9;
        this.f12496b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f12495a == this.f12495a && C0375f.a(clientIdentity.f12496b, this.f12496b);
    }

    public final int hashCode() {
        return this.f12495a;
    }

    public final String toString() {
        return this.f12495a + Constants.COLON_SEPARATOR + this.f12496b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12495a);
        p199z2.b.Q(parcel, 2, this.f12496b);
        p199z2.b.V(parcel, iU);
    }
}
