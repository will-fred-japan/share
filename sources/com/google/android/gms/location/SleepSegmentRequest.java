package com.google.android.gms.location;

import S4.C0375f;
import S4.C0376g;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import p071j5.p;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class SleepSegmentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SleepSegmentRequest> CREATOR = new p();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f12762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12763b;

    public SleepSegmentRequest(int i9, ArrayList arrayList) {
        this.f12762a = arrayList;
        this.f12763b = i9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepSegmentRequest)) {
            return false;
        }
        SleepSegmentRequest sleepSegmentRequest = (SleepSegmentRequest) obj;
        return C0375f.a(this.f12762a, sleepSegmentRequest.f12762a) && this.f12763b == sleepSegmentRequest.f12763b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f12762a, Integer.valueOf(this.f12763b)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        C0376g.e(parcel);
        int iU = b.U(parcel, 20293);
        b.T(parcel, 1, this.f12762a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12763b);
        b.V(parcel, iU);
    }
}
