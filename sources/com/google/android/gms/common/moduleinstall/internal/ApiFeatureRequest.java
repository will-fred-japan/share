package com.google.android.gms.common.moduleinstall.internal;

import S4.C0375f;
import S4.C0376g;
import W4.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class ApiFeatureRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f12564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12567d;

    public ApiFeatureRequest(ArrayList arrayList, String str, String str2, boolean z8) {
        C0376g.e(arrayList);
        this.f12564a = arrayList;
        this.f12565b = z8;
        this.f12566c = str;
        this.f12567d = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        return this.f12565b == apiFeatureRequest.f12565b && C0375f.a(this.f12564a, apiFeatureRequest.f12564a) && C0375f.a(this.f12566c, apiFeatureRequest.f12566c) && C0375f.a(this.f12567d, apiFeatureRequest.f12567d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f12565b), this.f12564a, this.f12566c, this.f12567d});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.T(parcel, 1, this.f12564a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12565b ? 1 : 0);
        b.Q(parcel, 3, this.f12566c);
        b.Q(parcel, 4, this.f12567d);
        b.V(parcel, iU);
    }
}
