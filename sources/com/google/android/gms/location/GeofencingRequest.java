package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import p071j5.C;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new C();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f12710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12712c;

    public GeofencingRequest(int i9, String str, ArrayList arrayList) {
        this.f12710a = arrayList;
        this.f12711b = i9;
        this.f12712c = str;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f12710a);
        int length = strValueOf.length();
        int i9 = this.f12711b;
        StringBuilder sb = new StringBuilder(length + 45 + String.valueOf(i9).length() + 1);
        sb.append("GeofencingRequest[geofences=");
        sb.append(strValueOf);
        sb.append(", initialTrigger=");
        sb.append(i9);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.T(parcel, 1, this.f12710a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12711b);
        b.Q(parcel, 4, this.f12712c);
        b.V(parcel, iU);
    }
}
